package talk.clock;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestClass {
	
	@Test
	public void ifTimeIs12midnight(){
		
		ConverseClock talk = new ConverseClock(0, 0);
		assertEquals(talk.theTimeIs(), "the time is twelve midnight");
		
	}
	
	@Test
	public void ifTimeIs12noon(){
		
		ConverseClock talk = new ConverseClock(12, 0);
		assertEquals(talk.theTimeIs(), "the time is twelve noon");
		
	}
	
	@Test
	public void ifTimeIs1215pm(){
		
		ConverseClock talk = new ConverseClock(0, 15);
		assertEquals(talk.theTimeIs(), "the time is quarter past twelve (AM)");
		
	}
	
	@Test
	public void ifTimeIs0045am(){
		
		ConverseClock talk = new ConverseClock(0, 45);
		assertEquals(talk.theTimeIs(), "the time is quarter to one (AM)");
		
	}
	
	@Test
	public void ifTimeIs1546am(){
		
		ConverseClock talk = new ConverseClock(15, 46);
		assertEquals(talk.theTimeIs(), "the time is fourteen minutes to four (PM)");
		
	}

}
