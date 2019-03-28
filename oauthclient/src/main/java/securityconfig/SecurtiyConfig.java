package securityconfig;



import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;


//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
@EnableWebSecurity
@Component
public class SecurtiyConfig extends WebSecurityConfigurerAdapter {	
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/admin/**").authorizeRequests()
		.anyRequest().authenticated()
		.and().logout().logoutUrl("/admin/logout").permitAll()
		.logoutSuccessUrl("/");
		
	}
}