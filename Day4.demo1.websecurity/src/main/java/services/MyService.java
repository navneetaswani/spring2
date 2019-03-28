package services;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Secured(value="adm")
	public void method1(){
		System.out.println("Inside Method 1");
	}
	
	@Secured(value="usr")
	public void method2(){
		System.out.println("Inside Method 2");
		
	}
	
}
