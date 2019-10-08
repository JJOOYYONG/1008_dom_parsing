package com.exam;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Ex2 {

	public static void main(String[] args) {
		
		// URL 객체로 부터 바이트입력 스트림을 가져올 수 있다.
		
		BufferedReader reader = null;
		
		
		try {
			
			URL url = new URL("https://www.naver.com/");
			//openStream() : url 주소와 연결하여 입력받을 수 있게하는 inputStream객체 리턴
			InputStream is = url.openStream();
			
			reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
			
			String line = "";
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		
		

	}//main

}
