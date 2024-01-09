package br.com.joaofigueiredo.sorteio;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/usuario/cadastro").permitAll()
		.antMatchers("/home/**").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/participante/novo").permitAll()
		.antMatchers("/participante/agracedimento").permitAll()
			.anyRequest().authenticated()
		.and()
		.formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/sorteio/home",true)
            .permitAll()
        )
		.logout(logout -> {
			logout.logoutUrl("/logout").logoutSuccessUrl("/");
		})
		.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		UserDetails user =
//				 User.builder()
//					.username("joao")
//					.password(encoder.encode("Teste@123"))
//					.roles("ADM")
//					.build();
//		UserDetails user =
//		 User.builder()
//			.username("maria")
//			.password(encoder.encode("Teste@123"))
//			.roles("ADM")
//			.build();		
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder);
		//.withUser(user);
		
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String rawPassword = "Teste@123";
		String encodedPassword = passwordEncoder.encode(rawPassword);
		
		System.out.println(encodedPassword);
	}
}
