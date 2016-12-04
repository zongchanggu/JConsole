package com.zjut.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testCon")
public class TestCon {

	@RequestMapping("getCon")
	public String getCon(){
		try {
			Socket s = new Socket("localhost", 8888);
			OutputStream os = s.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write("hi server");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "index";
	}
}
