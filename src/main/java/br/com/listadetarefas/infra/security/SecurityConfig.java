package br.com.listadetarefas.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // para desabilitar proteção contra csrf, pois o token já protege
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // não guarda sessão
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .anyRequest().authenticated())
                        //chama primeiro nosso filtro, onde o token está sendo passado, para dps chamar o filtro do spring
                        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();
    }
   @Bean
   public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
   }

   @Bean
   public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();// Bcrypt algorítimo de hash de senha
   }
}
