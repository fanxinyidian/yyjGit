package com.yyj.controller;
import java.io.File;  
import java.io.IOException;  
import java.util.Iterator;  
import java.util.List;  
import java.util.UUID;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  

/**
 * @author yyj
 * @description
 * uplodify文件上传-jsp版servlet支持
 */
@SuppressWarnings("serial")  
public class Upfile extends HttpServlet{
	
/**
 * 文件上传
 */
	  public void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {  
	    	String savePath = this.getServletConfig().getServletContext().getRealPath("");  
	        //savePath = "D:/newfile/";
	    	savePath = "D:/Workspaces/myeclipse/infodemo081801/myfile/";
	        File f1 = new File(savePath);  
	        System.out.println(savePath);  
	        if (!f1.exists()) {  
	            f1.mkdirs();  
	        }  
	        DiskFileItemFactory fac = new DiskFileItemFactory();  
	        ServletFileUpload upload = new ServletFileUpload(fac);  
	       // upload.setHeaderEncoding("utf-8");  
	        List fileList = null;  
	        try {  
	            fileList = upload.parseRequest(request);  
	        } catch (FileUploadException ex) {  
	            return;  
	        }  
	  
	        Iterator<FileItem> it = fileList.iterator();  
	        String name = "";  
	        String extName = "";  
	        while (it.hasNext()) {  
	            FileItem item = it.next();  
	            if (!item.isFormField()) {  
	                name = item.getName();  
	                long size = item.getSize();  
	                String type = item.getContentType();  
	                System.out.println(size + " " + type);  
	                if (name == null || name.trim().equals("")) {  
	                    continue;  
	                }  
	  
	                //扩展名格式：   
	                /*if (name.lastIndexOf(".") >= 0) {  
	                    extName = name.substring(name.lastIndexOf("."));  
	                } */ 
	  
	                File file = null;  
	                do {  
                     
	                    file = new File(savePath + name);  
	                } while (file.exists());  
	                File saveFile = new File(savePath + name); 
	                
	                try {  
	                    item.write(saveFile);  
	                } catch (Exception e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	        response.getWriter().print(name); 
	    }  
}
