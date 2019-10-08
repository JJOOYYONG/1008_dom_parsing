package com.exam;

import java.net.MalformedURLException;
import java.net.URL;

public class Ex1 {

	public static void main(String[] args) {
		//네트워크 연결 입출력
		
	// File 클래스 : 파일정보 가져올때 주로 사용
	// URL 클래스 : 인터넷상의 주소에 해당하는 자원 정보 가져올때 사용
	
		URL naverNews= null;
		URL itNews = null;
		
	try {
		//절대주소로 url 객체 생성
		 naverNews = new URL("https://news.naver.com:80");
		
		//상대경로 url 객체 생성
		 itNews = new URL(naverNews,"main/main.nhn?mode=LSD&mid=shm&sid1=105");
		
		
		
		
	} catch (MalformedURLException e) {
		e.printStackTrace();
	}
		
		
	System.out.println("protocol:"+itNews.getProtocol()); // 프로토콜
	System.out.println("host:"+itNews.getHost()); // 호스트
	System.out.println("port:"+itNews.getPort()); // 포트번호
	System.out.println("path:"+itNews.getPath()); // 경로부분
	System.out.println("filename:"+itNews.getFile());// 파일이름 출력
	
	
		
		
		
		

	}//main

}
