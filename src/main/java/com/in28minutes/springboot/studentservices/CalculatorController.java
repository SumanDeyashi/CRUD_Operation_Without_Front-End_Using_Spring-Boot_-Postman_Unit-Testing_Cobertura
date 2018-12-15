package com.in28minutes.springboot.studentservices;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CalculatorController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics()
	{
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id)
	{
		return topicService.getTopic(id);
	}
	
	
  //INPUT: GET request to http://localhost:8080/square?num=12
  //Output: Square of 12 is 144
	
	@RequestMapping("/square")
	public String calculateSquare(@RequestParam int num){
		String output = "square of  "+"  " + num + "is  "+"  " + (num * num);
		return output;
	}
	
	//INPUT: POST request to http://localhost:8080/sum?num1=12&num2=12
	//Output: Add of 12 is 24
	
	@RequestMapping(value="/sum",method = RequestMethod.POST)
	public int calculateSum(@RequestParam("num1") int number1, @RequestParam("num2") int number2)
	{
		return number1 + number2;
	}
	
	//INPUT: PUT/UPDATE request
	
	@RequestMapping(value="/topics/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id)
	{
		
		topicService.updateTopic(id, topic);
		return "Updated Succesfully";
		
	}
	
	//INPUT: DELETE request
	
		@RequestMapping(value="/topics/{id}", method = RequestMethod.DELETE)
		public void deleteTopic(@PathVariable String id)
		{
			 topicService.deleteTopic(id);
		}
}
