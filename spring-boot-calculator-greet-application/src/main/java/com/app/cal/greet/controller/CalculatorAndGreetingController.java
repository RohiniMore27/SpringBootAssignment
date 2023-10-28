package com.app.cal.greet.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorAndGreetingController {
	@GetMapping("/greetapi/v1/hello")
	public String greetUserByName(@RequestParam(defaultValue = "World") String name) {
		return "Hello " + name + " !!";
	}

	@GetMapping("/calculatorapi/v1/{operation}")
	public Map<String, Object> performOperation(@PathVariable String operation, @RequestParam Double number1,
			@RequestParam Double number2) {
		Map<String, Object> resp = new HashMap<>();		
		Double result = 0.0;

		Character ch;
		if (operation.equals("addition")) {
			ch = '+';
			result = number1 + number2;
		} else if (operation.equals("substraction")) {
			ch = '-';
			result = number1 - number2;
		} else if (operation.equals("multiplication")) {
			ch = '*';
			result = number1 * number2;
		} else if (operation.equals("division")) {
			ch = '/';
			if (number2 == 0) {
				throw new ArithmeticException("Division by zero is not allowed.");
			}
			result = number1 / number2;
		} else {
			throw new IllegalArgumentException("Invalid operation: " + operation);
		}
		resp.put("answer", result);
		resp.put("detail", number1.toString() + ch + number2.toString() + "=" + result);
		return resp;
	}

	@GetMapping("/calculatorapi/v1/square/{number1}")
	public Map<String, Object> findSquare(@PathVariable Double number1) {
		Double result = 0.0;
		Map<String, Object> resp = new HashMap<>();
		result = number1 * number1;
		// result=Math.pow(number1, 2);
		resp.put("answer", result);
		resp.put("detail", "square of " + number1 + " = " + result);
		return resp;
	}

	@GetMapping("/calculatorapi/v1/squareroot/{number1}")
	public Map<String, Object> findSquareRoot(@PathVariable Double number1) {
		Double result = 0.0;
		Map<String, Object> resp = new HashMap<>();
		result = (Double) Math.sqrt(number1);
		resp.put("answer", result);
		resp.put("detail", "squareroot of " + number1 + " = " + result);
		return resp;
	}

	@GetMapping("/calculatorapi/v1/factorial/{number1}")
	public Map<String, Object> findFactorial(@PathVariable Integer number1) {
		Map<String, Object> resp = new HashMap<>();
		Integer result1 = getFactorial(number1);
		resp.put("answer", result1);
		resp.put("detail", number1 + "! =" + result1);	
		return resp;
	}

	private Integer getFactorial(Integer number1) {
		if (number1 == 0)
			return 1;
		else
			return (number1 * getFactorial(number1 - 1));
	}
	
	@PostMapping("/calculatorapi/v1/min-max")
	public Map<String, Object> findMinMaxNo(@RequestBody ArrayList<Integer> numbers) {
		Map<String, Object> resp = new HashMap<>();
		int min=Collections.min(numbers);
		int max=Collections.max(numbers);
		resp.put("min", min);
		resp.put("max", max);
		return resp;
	}
}
