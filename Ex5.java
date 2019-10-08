package com.exam;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ex5 {

	public static void main(String[] args) {
		//파싱
		
		List<PersonVO>personList = new ArrayList<PersonVO>();
		//XML 파서 : DOM파서 종류 2가지 : DOM파서, SAX 파서
		
		
		
		
		
		
		try {

			URL url = Ex5.class.getResource("personList.xml");
			InputStream is = url.openStream();
			
			
			// DOM파서로 파싱하기
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is); // 파싱수행 후 결과로 document객체 리턴
			
			System.out.println("파싱 후 Document 객체 생성완료!");
			
			//레코드 단위인 person 태그이름 기준으로 노드리스트로 가져오기
			NodeList nodeList = document.getElementsByTagName("person");
			
			for(int i = 0; i<nodeList.getLength(); i++) {
				PersonVO personVO = new PersonVO();
				Node node  = nodeList.item(i); // person 노드 한개씩 가지고 옴
				
				//속성(attribute) 가져오기
				NamedNodeMap nodeMap = node.getAttributes();
				
				for(int j =0; j<nodeMap.getLength();j++) {
					Node attrNode = nodeMap.item(j);
					if(attrNode.getNodeName().equals("id")) {
						String id = attrNode.getNodeValue();
						personVO.setId(Integer.parseInt(id));
						
						
		
					}
					
				}//inner for
				
				//person 노드의 자식요소들을 가져오기
				NodeList childNodeList = node.getChildNodes();
				for(int j =0; j<childNodeList.getLength();j++){
					Node childNode = childNodeList.item(j);
					
					if(childNode.getNodeName().equals("name")) {
						//String name = childNode.getChildNodes().item(0).getNodeValue();
						String name = childNode.getFirstChild().getNodeValue();
						personVO.setName(name);
						
					}else if (childNode.getNodeName().equals("company")) {
						String company = childNode.getFirstChild().getNodeValue();
						personVO.setCompany(company);
					}
					
					
				}//inner for
				
				//VO 세팅이 끝나면 리스트에 추가
				personList.add(personVO);
				
			}//outer for
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		
		System.out.println("PersonList 생성완료");
		
		for(PersonVO personVO:personList) {
			
			System.out.println(personVO); // 출력
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}//main

}
