package com.cmx.test.junit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class Login {
	
	
	 public static boolean ClientEduSystem()throws Exception{  
		 	String secrateCodeUrl = "http://jwgl1.hznu.edu.cn/CheckCode.aspx";
		 	
		 	HttpClient httpclient1 = new DefaultHttpClient(new PoolingClientConnectionManager());
		 	HttpGet secretCodeGet = new HttpGet(secrateCodeUrl);
		 	HttpResponse execute = null;
			try {
				execute = httpclient1.execute(secretCodeGet);
				HttpEntity entity = execute.getEntity();
				byte[] byteArray = EntityUtils.toByteArray(entity);
				File f = new File("C:\\Users\\Administrator\\Desktop\\img\\secret.jpg");
				OutputStream output = new FileOutputStream(f);
				output.write(byteArray);
				output.flush();
				output.close();
			} catch (ClientProtocolException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    
			//Scanner s = new Scanner(System.in);
			//String code = s.nextLine();
			//System.out.println("my:" + code);
		     // 获取返回的Cookie
		    String Cookie = execute.getFirstHeader("Content-Type").toString();
		    System.out.println("getCookie:" + Cookie);
		    System.exit(0);
	        HttpClient httpclient = new DefaultHttpClient();  
	        HttpPost httpost = new HttpPost("http://jwgl1.hznu.edu.cn/"); 
	        httpost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko Core/1.53.3368.400 QQBrowser/9.6.11974.400");  
	        // 用逗号分隔显示可以同时接受多种编码  
	        //Cookie = s.nextLine();
	        //System.out.println("my:" + Cookie);
	        httpost.setHeader("Cookie", "ASP.NET_SessionId=ybn10f4521jpfj45dtbprj45;insert_cookie=89314150");
	        //httpost.setHeader("Accept-Language", "zh-cn,zh;q=0.5");  
	        //httpost.setHeader("Accept-Charset", "GB2312,utf-8;q=0.7,*;q=0.7");
	        /*填充需要提交的表单*/  
	        List <NameValuePair> nvps = new ArrayList <NameValuePair>();  
	        nvps.add(new BasicNameValuePair("__VIEWSTATE", "dDwyMDg1MjUwNTQ4Ozs+4cw89MNv3aHcxdI5z5VrmfjbUEY=")); //xxx表示要提交的内容，需要自己获取  
	        //nvps.add(new BasicNameValuePair("__VIEWSTATEGENERATOR", "92719903"));
	        nvps.add(new BasicNameValuePair("txtUserName", "2013212972"));  
	        nvps.add(new BasicNameValuePair("TextBox2","cmx16885885"));  
	        nvps.add(new BasicNameValuePair("txtSecretCode", "kquw"));  
	        nvps.add(new BasicNameValuePair("RadioButtonList1", "学生"));  
	        nvps.add(new BasicNameValuePair("Button1", ""));
	        nvps.add(new BasicNameValuePair("hidPdrs", ""));
	        nvps.add(new BasicNameValuePair("hidsc", ""));
	        UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(
	        		nvps, "GB2312");
	        httpost.setEntity(entity1);
	        /*设置字符*/  
	        //httpost.setEntity(new UrlEncodedFormEntity(nvps, Consts.UTF_8));  
	        /*尝试登陆*/  
	        HttpResponse response;  
	        try {     
	            response = httpclient.execute(httpost);  
	            /*判断是否登陆成功，根据登陆成功后会返回302跳转*/  
	            String result = response.getStatusLine().toString(); 
	            //HttpEntity entity = response.getEntity();
	            System.out.println(result);
	            HttpEntity entity = response.getEntity();
	            byte[] bytes = EntityUtils.toByteArray(entity);  
	            String charSet = "";  
	              
	            // 如果头部Content-Type中包含了编码信息，那么我们可以直接在此处获取  
	             charSet = EntityUtils.getContentCharSet(entity);  
	     
	            System.out.println("In header: " + charSet);
	            System.out.println("Encoding string is: " + new String(bytes, charSet)); 
	            if(result.equals("HTTP/1.1 302 Found")){  
	                return true;  
	            }else{  
	                return false;  
	            }  
	        } catch (ClientProtocolException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        return false;  
	    } 
	 
	 public static void main(String[] arg){
		 boolean clientEduSystem;
		try {
			clientEduSystem = ClientEduSystem();
			System.out.println(clientEduSystem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

}
