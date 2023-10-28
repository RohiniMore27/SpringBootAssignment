package com.app.cal.greet.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorAndGreetingControllerTest {

	@InjectMocks
	private CalculatorAndGreetingController calgreetController;
	
	@Test
	public void greetUserByNameTestSuccess()
	{
		String res=calgreetController.greetUserByName("User");
		assertEquals("Hello User !!", res);
	}
	
	@Test
	public void performAdditionOperationTest()
	{
		Map<String, Object> res=calgreetController.performOperation("addition", 4.0,5.0);
		assertEquals(9.0, res.get("answer"));
	}
	
	@Test
	public void performSubstractionOperationTest()
	{
		Map<String, Object> res=calgreetController.performOperation("substraction", 9.0,3.0);
		assertEquals(6.0, res.get("answer"));
	}
	
	@Test
	public void performMultiplicationOperationTest()
	{
		Map<String, Object> res=calgreetController.performOperation("multiplication", 9.0,3.0);
		assertEquals(27.0, res.get("answer"));
	}
	
	@Test
	public void performDivisionOperationTest()
	{
		Map<String, Object> res=calgreetController.performOperation("division", 27.0,3.0);
		assertEquals(9.0, res.get("answer"));
	}
	
	@Test
	public void performDivisionOperationExceptionTest()
	{
		
	  Assertions.assertThrows(ArithmeticException.class, () -> {
		  calgreetController.performOperation("division", 27.0,0.0);
      });
	}
	
	@Test
	public void performOperationInvalidOperationTest()
	{		
	  Assertions.assertThrows(IllegalArgumentException.class, () -> {
		  calgreetController.performOperation("abc", 27.0,4.0);
      });
	}
	
	@Test
	public void findSquareTest()
	{
		Map<String, Object> res=calgreetController.findSquare(5.0);
		assertEquals(25.0, res.get("answer"));
	}
	
	@Test
	public void findSquareRootTest()
	{
		Map<String, Object> res=calgreetController.findSquareRoot(25.0);
		assertEquals(5.0, res.get("answer"));
	}
	
	@Test
	public void findFactorialTest()
	{
		Map<String, Object> res=calgreetController.findFactorial(5);
		assertEquals(120, res.get("answer"));
	}
	
	@Test
	public void findMinMaxTest()
	{
		ArrayList<Integer> numbers= new ArrayList<>(Arrays.asList(10,-5,7,15,-7,-6,16,19,-15,9,77,-28,27));
		Map<String, Object> res=calgreetController.findMinMaxNo(numbers);
		assertEquals(-28, res.get("min"));
		assertEquals(77, res.get("max"));
	}
}
