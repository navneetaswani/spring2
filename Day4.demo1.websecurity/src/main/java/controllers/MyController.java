package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	
	@GetMapping(value="admin/m1")
	public String method1(){
		System.out.println("Inside Method 1");
		return "<h1>Method 1 Invocked</h1>";
	}
	
	@GetMapping(value="admin/m2")
	public String method2(){
		System.out.println("Inside Method 2");
		return "<h1>Method 2 Invocked</h1>";
	}

}
