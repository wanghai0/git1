package com.ctcc.xfxt2.util;

import java.io.IOException;

public class SmsRun implements Runnable {

	private String phone;
	private String pwd;

	public SmsRun(String phone, String pwd) {
		this.phone = phone;
		this.pwd = pwd;
	}

	public void run() {
		SmsSender client = new SmsSender();
		try {
			int i = 6;
			client.connect("202.102.41.101", 9005);
			if (!client.msgRequest("jseea0" + i, "FK_0123!")) {
				System.out.println("连接短信失败: jseea0" + i);
			} else {
				System.out.println("连接短信成功: jseea0" + i);
			}
			client.record(1, this.phone, "管理系统动态登录口令：【 " + this.pwd + "】，此口令15分钟内有效，请尽快登录。");
			client.disconnect();
		} catch (Exception e) {
			System.out.println("连接短信服务器失败！");
			e.printStackTrace();
		} finally {
			try {
				client.forceDisconnect();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}