package com.in28minutes.springboot.studentservices;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class StudentServiceTest {
	
	private static java.lang.String id;
	private static final String str = id ;
	@InjectMocks
	private TopicService topicService;
	
	@Before
    public void setup(){
    MockitoAnnotations.initMocks(this);
    }

	@Test
    public void testFindAll(){
        List<Topic> topics = new ArrayList<Topic> ();
        topics.add (new Topic ("Spring", "Spring Framework", "Spring Framework Description"));
        topics.add (new Topic ("CoreJava", "CoreJava Framework", "CoreJava Framework Description"));
        topics.add (new Topic ("JavaScript", "JavaScript Framework", "JavaScript Framework Description"));

       //when(topicService.getAllTopics()).thenReturn(topics);
        List<Topic> result =topicService.getAllTopics();
        assertEquals(3, result.size());
    }
    
   @Test
    public void updateTopic(){
        Topic topics = new Topic ("Html","Html Framework","Html Framework Description");
        //when(topicService.save(topics)).thenReturn(topics);
        Topic result = (Topic) topicService.save(topics);
        assertEquals("Html", result.getId ());
        assertEquals("Html Framework", result.getName());
        assertEquals("Html Framework Description", result.getDescription());
    }
    	
    @Test
    public void getTopic() {
        Topic topics = new Topic ("Spring","Spring Framework","Spring Framework Description");
        //when (topicService.findOne(topics)).thenReturn (topics);
        Topic result = (Topic) topicService.stream(topics);
        assertEquals ("Spring", result.getId ());
        assertEquals ("Spring Framework", result.getName());
        assertEquals ("Spring Framework Description", result.getDescription ());
    }
    
    @Test
    public void deleteTopic(){
    new Topic ("Spring","Spring Framework","Spring Framework Description");
    topicService.deleteTopic(str);
    //verify(topicService, times("Spring")).deleteTopic(topics);
    }
}
