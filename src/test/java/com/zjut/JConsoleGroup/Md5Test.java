package com.zjut.JConsoleGroup;

import com.zjut.util.Md5Utils;

public class Md5Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string = "123456";
		String reString = Md5Utils.Md5Encode(string, true);
		System.out.println("md5:" + reString);
	}

}
