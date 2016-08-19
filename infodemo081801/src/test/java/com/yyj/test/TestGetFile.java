package com.yyj.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.yyj.model.TextFile;

public class TestGetFile {
	//思路：1、先获取某个路径下文件或文件夹的路径
	//	   2、根据获取的路径返回该路径对应的文件名
		public static void main(String[] args){
			//System.out.println("hi");
			//String path="D:/testfile.txt";
			String path="D:/testfile";
			File file = new File(path);
			
			File[] tempList=file.listFiles();
			
			String s=file.getName();
			//获取该文件路径的文件名。
			 for (int i = 0; i < tempList.length; i++) {
				   if (tempList[i].isFile()) {
				    System.out.println("文     件："+tempList[i]);
				    //文件路径
				   }
				   if (tempList[i].isDirectory()) {
				    System.out.println("文件夹："+tempList[i]);
				    //文件夹路径
				   }
			 }
			System.out.println(tempList.length);
			//总的文件数
			System.out.println(s);
		}
		public List<TextFile> getFile(File file){
			
			List<TextFile> lst =new ArrayList<TextFile>();
			
			return lst;
		}
}
