package jsonTutorial;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTester1 {
	public static void main(String args[]) {

		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

		// map json to student
		try {
			Student student = mapper.readValue(jsonString, Student.class);

			System.out.println(student);

			jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);

			System.out.println(jsonString);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
