package com.jokerbase.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class FileUpload {
	public static String upLoadFile(String savePath,String fileName, byte[] bytes){
//		String extFileName = fileName.substring(fileName.lastIndexOf("."));//取文件后缀
		//通过getRndFileName获取时间戳
		String dateFileName = getRndFileName();
		//重定义文件存储路径
		String saveFilePath = savePath + File.separator + dateFileName + File.separator;
		//加载
		File file = new File(saveFilePath);
		//判断路径是否存在
		if(!file.exists()){
			//创建
			file.mkdirs();
		}
		try {
			//加载文件
			FileOutputStream fileOutputStream = new FileOutputStream(file + File.separator +  fileName);
			//输出
			fileOutputStream.write(bytes);
			//关闭
			fileOutputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateFileName + File.separator + fileName;
	}
	
	//获取时间戳方法
	public static String getRndFileName(){
		//Calendar nowTime=Calendar.getInstance();
		String reqStr = "";
		Date date=new Date();
		String formatStr="yyyyMMddHHmmss";
		try {
			Random random = new Random();
			java.text.DateFormat df = new java.text.SimpleDateFormat(formatStr);
			reqStr = df.format(date);
			reqStr+="_"+Math.abs(random.nextInt());
		} catch (Exception ex) {
		}
		return reqStr;
	}
}
