package hello;

import hello.User;

import java.io.IOException;
import java.io.StringReader;

import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/customers")
public class TestController {
	@RequestMapping(method = RequestMethod.POST, value = "/jsonMappingException", consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public ResponseEntity<Users> greeting(@RequestBody(required=false) String payload) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		HttpStatus httpStatus = HttpStatus.OK;
		Users users = null;
		
		try {
			StringReader val = new StringReader(payload);
			//Error occurs in the following line
			users = mapper.readValue(val,Users.class);
		} catch (JsonMappingException e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			users = new Users();
			User x = new User();
			x.user = e.getMessage();
			users.addUser(x);
		} catch(Exception e) {
			httpStatus = HttpStatus.BAD_REQUEST;
			users = new Users();
			User x = new User();
			x.user = e.getMessage();
			users.addUser(x);
		}
		
		return new ResponseEntity<Users>(users, httpStatus);
	}
}