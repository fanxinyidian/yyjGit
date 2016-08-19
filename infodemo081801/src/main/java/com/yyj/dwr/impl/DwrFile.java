package com.yyj.dwr.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.hibernate.SessionFactory;

import com.yyj.model.TextFile;

/**
 * @author yyj
 * @description
 * 文件上传下载-事件处理
 */
@RemoteProxy(name="dwrFile")
public class DwrFile {
	
	private SessionFactory sessionFactory;
	
/**
 *@return
 *获取指定路径下文件--路径和+文件名
 */
	@RemoteMethod
	public List<TextFile> getFile(){
		//String path="D:/newfile/";
		String path = "D:/Workspaces/myeclipse/infodemo081801/myfile/";
		File file = new File(path);
		File[] tempList=file.listFiles();
		
		List<TextFile> lstfile=new ArrayList<TextFile>();
		
		for(int i=0;i<tempList.length;i++){
			File file1=new File(tempList[i].getPath());
			lstfile.add(new TextFile(file1.getName(),file1.getPath()));
		}
		
		return lstfile;
	}
	
/**
 *@return
 *获取指定路径下文件名
 */
	@RemoteMethod
	public List<String> getFileName(){
		String path="D:/";
		File file = new File(path);
		File[] tempList=file.listFiles();
		List<String> lst=new ArrayList<String>();
		for(int i=0;i<tempList.length;i++){
			File file1=new File(tempList[i].getPath());
			lst.add(file1.getName());
		}
		return lst;
	}
		
/*** 
* 下载-复制单个文件  
*/
	@RemoteMethod
	public void copyFile(String oldPath, String newPath) { 
		try { 
			int bytesum = 0; 
			int byteread = 0; 
			File oldfile = new File(oldPath); 
			if (oldfile.exists()) { 
				InputStream inStream = new FileInputStream(oldPath);
				FileOutputStream fs = new FileOutputStream(newPath); 
				byte[] buffer = new byte[1444]; 
				int length; 
				while ( (byteread = inStream.read(buffer)) != -1) { 
					bytesum += byteread; //字节数 文件大小 
					System.out.println(bytesum); 
					fs.write(buffer, 0, byteread); 
				} 
				inStream.close(); 
			} 
		} 
		catch (Exception e) { 
			System.out.println("复制单个文件操作出错"); 
			e.printStackTrace(); 
	
		} 

	} 
	
/**
 * dwr文件上传-试例
 */
	@RemoteMethod
	public String uploadFile(InputStream is, String filename) throws IOException{
		String str=FilenameUtils.getName(filename);
		FileUtils.copyInputStreamToFile(is, new File("D:/Workspaces/myeclipse/infodemo081402/myfile"+str));
		return str;
	}
	@RemoteMethod
	public List<String> list(){
		List<String> lst =new ArrayList<String>();
		lst.add("yyj");
		lst.add("ly");
		return lst;
	}
}
