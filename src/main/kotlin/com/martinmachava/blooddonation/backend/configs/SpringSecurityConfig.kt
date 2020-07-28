package com.martinmachava.blooddonation.backend.configs

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
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
                .antMatchers("/user/get", "/user/add").authenticated()
                .antMatchers(HttpMethod.DELETE, "/user/delete").hasRole("ADMIN")
                .and().csrf().disable()
    }
}
