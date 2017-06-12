package com.json.setpojo;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.json.model.User;
public class ReadJsonStringSetPojo {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			// Convert JSON string to Object
			String jsonInString = "{\"age\":33,\"messages\":[\"msg 1\",\"msg 2\"],\"name\":\"mkyong\"}";
			User user1 = mapper.readValue(jsonInString, User.class);
			System.out.println(user1);
			String jsonInString1 = mapper.writeValueAsString(user1);
			System.out.println(jsonInString1);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
