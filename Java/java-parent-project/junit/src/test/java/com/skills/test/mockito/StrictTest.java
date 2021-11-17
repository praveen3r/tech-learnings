package com.skills.test.mockito;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoJUnitRunner.StrictStubs;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;

import com.skills.junit.mockito.Arithmatic;

@RunWith(StrictStubs.class)
public class StrictTest {
	
	@Rule
	public MockitoRule rule=MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
	
	@Test
	public void testStrict(){
		Arithmatic arithmatic=mock(Arithmatic.class);
		//when(arithmatic.add(anyInt(), anyInt())).thenReturn(2);
		when(arithmatic.multiply(anyInt(), anyInt())).thenReturn(2);
		arithmatic.add(1, 1);
		arithmatic.multiply(1, 2);
	}

}
