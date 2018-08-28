package com.ctcc.xfxt2.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

//import org.apache.log4j.Logger;

public class SmsSender {

	//private static final Logger logger = Logger.getLogger("SMSLOG");
	protected Socket socket = null;
	protected InputStream input = null;
	protected OutputStream output = null;
	public static int seq = 0;

	public SmsSender() {
		socket = new Socket();
	}

	public void connect(String host, int port) throws IOException {
		if (!socket.isConnected()) {
			SocketAddress endpoint = new InetSocketAddress(host, port);
			socket.connect(endpoint, 10000);
		}
	}

	public void connect() throws IOException {
		if (!socket.isConnected()) {
			SocketAddress endpoint = new InetSocketAddress(ipAddress, port);
			socket.connect(endpoint, 10000);
		}
	}

	public void disconnect() throws IOException {
		if (!socket.isClosed()) {
			socket.close();
		}
	}

	public void forceDisconnect() throws IOException {
		socket.close();
	}

	public boolean anthenMsg() throws IOException {
		return msgRequest(username, password);
	}

	public boolean msgRequest(String account, String verifyCode) throws IOException {
		short[] Pattern = MsgConst.NET_HEAD_REQ.clone();
		byte[] usrBuf = account.getBytes();
		byte[] pwdBuf = NetMd5.GetByteMD5((account + verifyCode));
		short length = 0;
		length = (short) (length + 6);
		short a_length = (short) (4 + usrBuf.length);
		short v_length = (short) (4 + pwdBuf.length);
		length = (short) (length + a_length + v_length);
		Pattern[1] = length;
		ByteBuffer byteBuf = ByteBuffer.allocate(length);
		for (int i = 0; i < Pattern.length; i++) {
			byteBuf.putShort(Pattern[i]);
		}
		byteBuf.putShort(MsgConst.NET_BODY_TYPE_ACCOUNT);
		byteBuf.putShort(a_length);
		byteBuf.put(usrBuf);
		byteBuf.putShort(MsgConst.NET_BODY_TYPE_VERIFY);
		byteBuf.putShort(v_length);
		byteBuf.put(pwdBuf);
		return checkResponse(send(byteBuf.array(), 14));
	}

	public int record(int sendType, String recPhone, String msg) throws IOException {
		short[] Pattern = MsgConst.NET_HEAD_BODY_REQ.clone();
		byte[] recPhoneBuf = recPhone.getBytes();
		byte[] msgBuf = msg.getBytes();
		short length = 0;
		int seq = getSeq();
		length = (short) (length + 6);
		short a_length = (short) (4 + 4);
		short b_length = (short) (4 + 4);
		short c_length = (short) (4 + recPhoneBuf.length);
		short d_length = (short) (4 + msgBuf.length);
		length = (short) (length + a_length + b_length + c_length + d_length);
		Pattern[1] = length;
		ByteBuffer byteBuf = ByteBuffer.allocate(length);
		for (int i = 0; i < Pattern.length; i++) {
			byteBuf.putShort(Pattern[i]);
		}
		byteBuf.putShort(MsgConst.NET_BODY_TYPE_SEQ);
		byteBuf.putShort(a_length);
		byteBuf.putInt(seq);
		byteBuf.putShort(MsgConst.NET_BODY_TYPE_SENDTYPE);
		byteBuf.putShort(b_length);
		byteBuf.putInt(sendType);
		byteBuf.putShort(MsgConst.NET_BODY_TYPE_RECCODE);
		byteBuf.putShort(c_length);
		byteBuf.put(recPhoneBuf);
		byteBuf.putShort(MsgConst.NET_BODY_TYPE_MSG);
		byteBuf.putShort(d_length);
		byteBuf.put(msgBuf);
		return checkBodyResponse(send(byteBuf.array(), 22));
	}

	public synchronized int getSeq() {
		seq++;
		return seq;
	}

	public byte[] ints2bytes(short[] num) {
		int len = num.length * 4;
		byte[] b = new byte[len];
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < 4; j++) {
				b[i * 4 + j] = (byte) (num[i] >>> (24 - j * 8));
			}
		}
		return b;
	}

	protected byte[] send(byte[] data, int rep_size) throws IOException {
		if (input == null) {
			input = new DataInputStream(socket.getInputStream());
		}
		if (output == null) {
			output = new DataOutputStream(socket.getOutputStream());
		}
		output.write(data);
		output.flush();
		byte[] rep = new byte[rep_size];
		int Timeout = 15000;
		while ((input.available() < rep_size) && (Timeout > 0)) {
			try {
				Thread.sleep(5);
				Timeout -= 5;
			} catch (InterruptedException e) {
				break;
			}
		}
		input.read(rep);
		return rep;
	}

	private String ipAddress;
	private int port;
	private String username;
	private String password;

	public void initParameters(String ipAddress, int port, String username, String password) {
		this.ipAddress = ipAddress;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	public int checkHeadResponse(byte[] rep) {
		int ret = -1;
		ByteBuffer buf = ByteBuffer.wrap(rep);
		buf.getShort();
		buf.getShort();
		short headType = buf.getShort();
		if (headType == MsgConst.NET_HEAD_RSP[2]) {
			buf.getShort();
			buf.getShort();
			ret = buf.getInt();
		}
		return ret;
	}

	public int checkBodyResponse(byte[] rep) {
		int ret = -1;
		ByteBuffer buf = ByteBuffer.wrap(rep);
		buf.getShort();
		buf.getShort();
		short headType = buf.getShort();
		if (headType == MsgConst.NET_HEAD_BODY_RSP[2]) {
			short type, length;
			while (buf.remaining() > 0) {
				type = buf.getShort();
				if (type == MsgConst.NET_BODY_TYPE_STATUS) {
					buf.getShort();
					ret = buf.getInt();
				} else {
					length = buf.getShort();
					buf.position(buf.position() + length - 4);
				}
			}
		}
		return ret;
	}

	public boolean checkResponse(byte[] rep) {
		ByteBuffer buf = ByteBuffer.wrap(rep);
		buf.getShort();
		buf.getShort();
		buf.getShort();
		buf.getShort();
		buf.getShort();
		int ret = buf.getInt();
		return (ret == 0);
	}
	/**
	public static void main(String[] args) {
		SmsSender client = new SmsSender();
		try {
			client.connect("218.94.58.243", 9001);
			boolean result = client.msgRequest("jessa10", "FK_0123!");
			if (result)
				if (logger.isInfoEnabled()) {
					logger.info("connect success");
				} else if (logger.isInfoEnabled()) {
					logger.error("connect fail");
				}
			int rep = 0;
			String msg = "oooo";
			rep = client.record(MsgConst.SEND_TYPE_QUICK, "13645185053", msg);
			client.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				client.forceDisconnect();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				client.forceDisconnect();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	*/

}
