package me.abebe.demo.config;

import me.abebe.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private SSUserDetailsService userDetailsService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new SSUserDetailsService(userRepository);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http
                .authorizeRequests()
                .antMatchers("/h2-console/**","/register/**","/","/images","/css/**","/addjob","/addqualification/**",
                        "/qualififcationadd/**","/qualificationadd/**","/desired/**","/desiredprocess/**","/desiredskill/**",
                        "/desiredskills/**","/vendor/**","/scss/**","/js/**").permitAll()
                .antMatchers("/postp","/poste","/postw","/posts","/summary","/refernce")
                .access("hasAuthority('APPLICANT') ")
                .antMatchers("/displayresume","/coverletter","/addjobs/**","/alljobs/**",
                        "/job/organization/**","/jobsearch/**","/sayhi","/addskill/**","/index/**").access("hasAuthority('APPLICANT') or hasAuthority('EMPLOYER')")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").permitAll().permitAll()
                .and()
                .httpBasic();


        http
                .csrf()
                .disable();
        http
                .headers().frameOptions().disable();



    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("password").authorities("USER")
                .and()
                .withUser("admin").password("password").authorities("ADMIN");
        auth
                .userDetailsService(userDetailsServiceBean());
    }

}
