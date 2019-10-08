package com.exam;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class Ex4 {

	public static void main(String[] args) {
		//http:// httpbin.org/get
		//http:// httpbin.org/post
		
		
		
		
		//get 방식 요청일 경우 쿼리스트링을 URL주소뒤에 붙여야함
		//URL url = new URL("http://httpbin.org/get?name=gildong&age=33");
		
		
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		
		//post방식 요청일 경우 쿼리스트링을 붙이지 않는다.
		try {
			
			URL url = new URL("http://httpbin.org/post");
			URLConnection con = url.openConnection();
			con.setDoOutput(true); //post 출력 모드 활성화
			
			//출력 스트림으로 request 보내기
			writer = new OutputStreamWriter(con.getOutputStream(), "utf-8");
			writer.write("name=gildong&age=33"); // 서버에 데이터 보내기
			writer.write("&addr= busan");
			writer.flush();// 버퍼를 비우는 메소드
			
			
			//입력스트림으로 response(응답) 받기
			
			reader = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));
			String line = "";
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		

	}//main

}
