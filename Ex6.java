package com.exam;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ex6 {

	public static void main(String[] args) {
		
		List<CompanyVO> companyList = new ArrayList<CompanyVO>();
		//DOM 파서로 파싱하기2
		
		try {
			
			URL url = new URL("http://kobis.or.kr/kobisopenapi/webservice/rest/company/searchCompanyList.xml?key=430156241533f1d058c603178cc3ca0e");
			
			//파싱을 위한 dom 파서 객체 준비하기
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder =factory.newDocumentBuilder();
			//파싱 수행 완류 후 document 생성
			Document document= builder.parse(url.openStream());
			
			
			System.out.println("파싱후 document 객체 생성 완료");
			
			
			//company 태그를 기준으로 노드리스트 가져오기
			
			NodeList nodeList = document.getElementsByTagName("company");
			
			for(int i = 0; i <nodeList.getLength();i++) {
				CompanyVO companyVO = new CompanyVO();
				
				Node node = nodeList.item(i); // company node
				
			NodeList childNodeList = node.getChildNodes();
			for(int j =0; j<childNodeList.getLength();j++) {
				 Node childNode = childNodeList.item(j);
				 
				 if(childNode.getNodeName().equals("companyCd")) {
					
					 companyVO.setCompanyCd(Long.parseLong(childNode.getFirstChild().getNodeValue()));
					 
				 }else if(childNode.getNodeName().equals("companyNm")) {
					 
					 companyVO.setCompanyNm(childNode.getFirstChild().getNodeValue());
					 
				 }else if (childNode.getNodeName().equals("filmoNames")) {
					 
					 if(childNode.getFirstChild() != null) {
						 companyVO.setFilmoNames(childNode.getFirstChild().getNodeValue());
					    }
					 
				    }
				
			    }//inner for
			
					//다 채워진 VO를리스트에 추가
					companyList.add(companyVO);
			
			}//outer for
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("companyList 생성완료");
		
		for(CompanyVO companyVO : companyList){
			System.out.println(companyVO);
		}
		
		
		
		
		
		
		
		
		
		

	}//main

}
