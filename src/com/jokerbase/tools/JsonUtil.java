package com.jokerbase.tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	public static String write(Map<String,Object> map) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(map);
	}
	
//	public static String write(List<Object> list) throws JsonGenerationException, JsonMappingException, IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		return mapper.writeValueAsString(list);
//	}
	
	public static void main(String [] args){
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("error", 1);
		map.put("url", "www.baidu.com");
		try {
			System.out.println(mapper.writeValueAsString(map));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
