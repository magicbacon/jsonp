package com.yuandong.jsonp;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.yuandong.jsonp.vo.MyVO;

public class JacksonThreeMuniteTutorial {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonSource = "{\"k11\":\"v11\",\"k12\":\"v12\",\"k13\":\"v13\"}";
		String jsonSource2 = "[\"k11\", \"v11\", \"k12\", \"v12\", \"k13\", \"v13\"]";
		String jsonSource3 = "{\"customer\":{\"name\":\"Bob\", \"age\":13}}";
		
		Map<String, Integer> map = null;
		List<String> list = null;
		try {
			map = mapper.readValue(jsonSource, Map.class);
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				System.out.println("key: " + entry.getKey() + "\tvalue: " + entry.getValue());
			}
			
			System.out.println("\n");
			
			list = mapper.readValue(jsonSource2, List.class);
			for (String s : list) {
				System.out.println("list item: " + s);
			}
			
			System.out.println("\n");
			
			Map<String, MyVO> results = mapper.readValue(jsonSource3, new TypeReference<Map<String, MyVO>>() { });
			// why extra work? Java Type Erasure will prevent type detection otherwise
			for (Map.Entry<String, MyVO> entry : results.entrySet()) {
				System.out.println("key: " + entry.getKey() + "\tvalue: name: " + entry.getValue().getName() + ", age: " + entry.getValue().getAge());
			}
			
			System.out.println("\n");
			
			// can be read as generic JsonNode, if it can be Object or Array; or,
			// if known to be Object, as ObjectNode, if array, ArrayNode etc:
			ObjectNode root = (ObjectNode) mapper.readTree("{\"name\" : \"Bob\", \"age\" : 13}");
			String name = root.get("name").asText();
			int age = root.get("age").asInt();
			
			System.out.println("read tree: name: " + name + ", age: " + age);
			
			// can modify as well: this adds child Object as property 'other', set property 'type'
			root.with("other").put("type", "student");
			String json = mapper.writeValueAsString(root);
			
			System.out.println("json: " + json);

			// with above, we end up with something like as 'json' String:
			// {
			//   "name" : "Bob", "age" : 13,
			//   "other" : {
			//	 	 "type" : "student"
			//   {
			// }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
