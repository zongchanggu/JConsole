package com.zjut.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author chen-zhiqiang
 *
 * @version 创建时间：2017年1月9日下午8:21:00
 */
@Controller
@RequestMapping("/downloadAction")
public class DownloadFileAction {

	private static final String IMAGETYPE = "image";
	private static final String VIDEOTYPE = "video";
	
	@RequestMapping(value="/download")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response, String filePath, String fileType){
		String viewName = "/errorPage/error";
		String fileName = filePath.substring(filePath.lastIndexOf("/")+1);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ fileName);
		
		String realPath = "";
		if(IMAGETYPE.equals(fileType)){
			realPath = request.getServletContext().getRealPath("/images/ads/" + fileName);
		}else if(VIDEOTYPE.equals(fileType)){
			realPath = request.getServletContext().getRealPath("/videos/" + fileName);
		}
		InputStream inputStream = null;
		OutputStream oStream = null;
		try {
			inputStream = new FileInputStream(new File(realPath));
			oStream = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while((length = inputStream.read(b)) > 0){
				oStream.write(b, 0, length);
			}
			oStream.flush();
			
		} catch (FileNotFoundException e) {//inputStream
			e.printStackTrace();
			return viewName;
		} catch (IOException e) {//oStream
			e.printStackTrace();
			return viewName;
		} finally {
			if(oStream!=null || inputStream!=null)
				try {
					inputStream.close();
					oStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					return viewName;
				}
		}//end try catch
		return null;
	}
}
