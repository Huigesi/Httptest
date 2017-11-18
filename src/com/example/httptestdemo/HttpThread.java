package com.example.httptestdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.os.Handler;
import android.webkit.WebView;

public class HttpThread extends Thread{
	private WebView webView;
	private Handler handler;
	private String url;
	public HttpThread(WebView webView, Handler handler, String url) {
		
		this.webView = webView;
		this.handler = handler;
		this.url = url;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			URL httpurl=new URL(url);
			HttpsURLConnection conn=(HttpsURLConnection) httpurl.openConnection();
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			final StringBuffer sb=new StringBuffer();
			BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String str;
			while ((str=br.readLine())!=null) {
				sb.append(str);
			}
			handler.post(new Runnable() {
				
				@Override
				public void run() {
					webView.loadData(sb.toString(), "text/html;charset=utf-8", null);
					
				}
			});
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
