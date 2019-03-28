package demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import services.MyService;

@SpringBootApplication(scanBasePackages={"controllers","services","securityconfig"})
public class Application {

	public static void main(String[] args) {
	 ConfigurableApplicationContext ctx	=SpringApplication.run(Application.class, args);
	 SecurityContext secctx = 	new SecurityContextImpl();
	 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
	 
	 List<GrantedAuthority> grantedAuths = new  ;
	 
	 System.out.println(" encripted for pass4"+ encoder.encode("pass4"));
	 System.out.println(" encripted for pass5"+ encoder.encode("pass5"));
	 Authentication auth = new UsernamePasswordAuthenticationToken("Navneet", encoder.encode("pass1"));
	 secctx.setAuthentication(auth);
	 SecurityContextHolder.setContext(secctx);
	 MyService service = ctx.getBean("myService",MyService.class);
	 
	 try {
		service.method1();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 try {
		service.method2();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	}

}
