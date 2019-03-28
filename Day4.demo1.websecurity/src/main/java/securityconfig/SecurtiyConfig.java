package securityconfig;



import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true,prePostEnabled=true)
@EnableWebSecurity
public class SecurtiyConfig extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	public DataSource ds(){		
		return new DriverManagerDataSource("jdbc:hsqldb:hsql://localhost/","SA","");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//		ATHENTICATION THROUGH JDBC FROM DATABASE
		auth.jdbcAuthentication().passwordEncoder(encoder)
		.dataSource(ds())
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username, role from roles  where username=?");
		
		
		
//		IN MEMORY AUTHENTICATION 
		
		/*auth.inMemoryAuthentication().passwordEncoder(encoder)
		.withUser("Navneet").password(encoder.encode("pass1")).roles("adm")
		.and()
		.withUser("user2").password(encoder.encode("pass2")).roles("usr")
		.and()
		.withUser("user3").password(encoder.encode("pass3")).roles("adm","usr");		*/
	}
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/admin/m1").hasRole("adm")
		.antMatchers("/admin/m2").hasRole("usr")
		.and().httpBasic();
	}
}