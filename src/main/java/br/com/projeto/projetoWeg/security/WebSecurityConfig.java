package br.com.projeto.projetoWeg.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

    private final ImplementsUserDetailsService implementsUserDetailsService;
    private final JWTRequestFilter jwtRequestFilter;

    private static final String[] AUTH_LIST_FUNC = {
            "/",
            "/funcionarios",
            "/funcionarios/*",
            "/projetos",
            "/projetos/*",
            "/centros_de_custos",
            "/centros_de_custos/*"
    };

    private static final String[] AUTH_LIST_GERENTE = {
            "/cargos"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.GET, AUTH_LIST_FUNC).permitAll()
//                .antMatchers(HttpMethod.POST, AUTH_LIST_FUNC).permitAll()
//                .antMatchers(HttpMethod.GET, AUTH_LIST_GERENTE).hasRole("GERENTE")
//                .antMatchers(HttpMethod.POST, AUTH_LIST_GERENTE).permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().permitAll()
//                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, AUTH_LIST_GERENTE).hasRole("GERENTE")
                .antMatchers("/authenticate").permitAll()
                .antMatchers(HttpMethod.GET, AUTH_LIST_FUNC).permitAll()
                .antMatchers(HttpMethod.POST, AUTH_LIST_FUNC).permitAll()
                .antMatchers(HttpMethod.PUT, AUTH_LIST_FUNC).permitAll()
                .antMatchers(HttpMethod.DELETE, AUTH_LIST_FUNC).permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("token").invalidateHttpSession(true);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("thomas")
//                .password("{noop}123456")
//                .roles("ADMIN");
        auth.userDetailsService(implementsUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/botstrap/**", "/style/**");
    }

}
