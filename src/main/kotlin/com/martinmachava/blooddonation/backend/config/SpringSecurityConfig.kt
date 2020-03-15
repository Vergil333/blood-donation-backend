package com.martinmachava.blooddonation.backend.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@EnableWebSecurity
@Configuration
open class SpringSecurityConfig: WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("demoUSER").password("{noop}demoPASSWORD").roles("USER")
                .and()
                .withUser("adminUSER").password("{noop}adminPASSWORD").roles("ADMIN")
    }

    override fun configure(http: HttpSecurity) {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/donor").authenticated()
                .antMatchers(HttpMethod.POST, "/donor").authenticated()
                .antMatchers(HttpMethod.DELETE, "/donor").hasRole("ADMIN")
                .and().csrf().disable()
    }
}