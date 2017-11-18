package com.example.httptestdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpThread1 extends Thread {
	String url;
	String name;
	String psw;
	String email;
	public HttpThread1(String url, String name, String psw, String email) {
		
		this.url = url;
		this.name = name;
		this.psw = psw;
		this.email = email;
	}
	public void doGet(){
		url=url+"?name="+name+"&psw="+psw+"&email="+email;
		try {
			URL httpurl=new URL(url);
			HttpURLConnection conn=(HttpURLConnection) httpurl.openConnection();
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb=new StringBuffer();
			String str; 
			while((str=reader.readLine())!=null){
				sb.append(str);
			}
			System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doPost(){
		try {
			URL httpurl=new URL(url);
			HttpURLConnection conn=(HttpURLConnection) httpurl.openConnection();
			conn.setReadTimeout(5000);
			conn.setRequestMethod("POST");
			OutputStream op=conn.getOutputStream();
			String content="name="+name+"&psw="+psw+"&email="+email;
			op.write(content.getBytes());
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb=new StringBuffer();
			String str; 
			while((str=reader.readLine())!=null){
				sb.append(str);
			}
			System.out.println(sb.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		//doGet();
		doPost();
	}
	
}
