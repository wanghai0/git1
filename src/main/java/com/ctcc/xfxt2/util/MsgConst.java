package com.ctcc.xfxt2.util;

public class MsgConst {
	public final static short[] NET_HEAD_REQ = new short[] { 0x001, 0, 1 };
	public final static short[] NET_HEAD_RSP = new short[] { 0x001, 0, 2 };
	public final static short[] NET_HEAD_BODY_REQ = new short[] { 0x001, 0, 3 };
	public final static short[] NET_HEAD_BODY_RSP = new short[] { 0x001, 0, 4 };
	public final static short NET_BODY_TYPE_STATUS = 1;
	public final static short NET_BODY_TYPE_ACCOUNT = 2;
	public final static short NET_BODY_TYPE_VERIFY = 3;
	public final static short NET_BODY_TYPE_SEQ = 4;
	public final static short NET_BODY_TYPE_SENDTYPE = 5;
	public final static short NET_BODY_TYPE_RECCODE = 6;
	public final static short NET_BODY_TYPE_MSG = 7;
	public final static short NET_BODY_TYPE_SENDCODE = 8;
	public final static int SEND_TYPE_QUICK = 1;
	public final static int SEND_TYPE_UNQUICK = 0;
}