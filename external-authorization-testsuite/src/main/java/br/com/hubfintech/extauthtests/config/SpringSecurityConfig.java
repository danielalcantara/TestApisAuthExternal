package br.com.hubfintech.extauthtests.config;

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig /*extends WebSecurityConfigurerAdapter*/ {
	
	/*@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')").
		antMatchers("/javax.faces.resource/**").
        permitAll().anyRequest().authenticated().
		and().formLogin().  //login configuration
            loginPage("/pages/login.xhtml").
            loginProcessingUrl("/appLogin").
            usernameParameter("username").
            passwordParameter("password").
            defaultSuccessUrl("/pages/processTests.xhtml").	
		and().logout().    //logout configuration
			logoutUrl("/appLogout"). 
			logoutSuccessUrl("/pages/login.xhtml");
		
		 // require all requests to be authenticated except for the resources
	    http.authorizeRequests().antMatchers("/javax.faces.resource/**")
	        .permitAll().anyRequest().authenticated();
	    // login
	    http.formLogin().loginPage("/pages/login.xhtml")
	    	.permitAll().usernameParameter("username")
	    	.passwordParameter("password")
	    	.defaultSuccessUrl("/pages/processTests.xhtml")
	        .failureUrl("/pages/login.xhtml?error=true");
	    // logout
	    http.logout().logoutSuccessUrl("/pages/login.xhtml");
	    // not needed as JSF 2.2 is implicitly protected against CSRF
	    http.csrf().disable();

	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("teste").password("teste123").roles("ADMIN");
	}	*/

}
