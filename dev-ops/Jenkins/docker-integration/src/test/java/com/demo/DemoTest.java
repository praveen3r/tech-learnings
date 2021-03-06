package com.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class DemoTest {

	 @Test
	 public void testMock() {
		 List<String> mockList = mock(List.class);
			mockList.add("test");
			mockList.size();
			verify(mockList, times(1)).size();
			
	 }
}
