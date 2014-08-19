package com.yuandong.jsonp;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yuandong.jsonp.vo.MyVO;

public class JacksonOneMuniteTutorial {
	
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		MyVO myVO = null;
		try {
			myVO = mapper.readValue("{\"name\":\"Bob\", \"age\":13}", MyVO.class);
			System.out.println("name: " + myVO.getName() + ", age: " + myVO.getAge());
			
			String jsonString = mapper.writeValueAsString(myVO);
			System.out.println("json: " + jsonString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
