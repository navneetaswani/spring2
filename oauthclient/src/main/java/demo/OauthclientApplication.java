package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"controllers","services","securityconfig"})
public class OauthclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthclientApplication.class, args);
	}

}
