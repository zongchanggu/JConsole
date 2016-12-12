package com.zjut.time;

import java.net.Socket;
import java.io.*;
/**
 * 
 * <p>@author:zongchnaggu</p>
 * <p>@description:created by gu</p>
 * <p>@date:2016年12月11日</p>
 *
 */
public class Client {
	
	public Client() {
	}

	public static void main(String[] args) {
		Socket client = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			client = new Socket("star", 5100);
			client.setSoTimeout(10000);
			out = new DataOutputStream((client.getOutputStream()));

			String query = "GB";
			byte[] request = query.getBytes();
			out.write(request);
			out.flush();
			client.shutdownOutput();

			in = new DataInputStream(client.getInputStream());
			byte[] reply = new byte[40];
			in.read(reply);
			System.out.println("Time: " + new String(reply, "GBK"));

			in.close();
			out.close();
			client.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
