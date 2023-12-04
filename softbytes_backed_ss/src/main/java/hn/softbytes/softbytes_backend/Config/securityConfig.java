package hn.softbytes.softbytes_backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true)
public class securityConfig {

     //Endpoint level authorities


     //matcher
     //anyRequest
     //requestMatcher
     //requestMatcher with HttpMethod

     //reglas de autorizacion
     //1. permitAll
     //2. DenyAll
     //3. Authenticted
     //4. HasRole
     //5. HasAuthority
     //6. Access (SpEL) spring expressions lengauge

     @Bean
     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
          return http
                    .httpBasic()
                    .and().authorizeHttpRequests()

                    //Usuario
                    .requestMatchers(HttpMethod.POST, "/auth/user/**").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/auth/user/actualizar").authenticated()
                    .requestMatchers(HttpMethod.GET, "/auth/user/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/auth/user/**").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/auth/user/**").authenticated()

                    //TipoUsuario
                    .requestMatchers(HttpMethod.GET, "/auth/userType/obtener").permitAll()
                    
                    //SubCartegoria
                    .requestMatchers(HttpMethod.GET, "/auth/subCategories/**").permitAll()

                    //Productos
                    .requestMatchers(HttpMethod.GET, "/auth/products/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/auth/products/obtener/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/products/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/auth/products/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/auth/products/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "/auth/products/actualizar/**").hasRole("ADMIN")

                     //Estado Pedido
                    .requestMatchers(HttpMethod.GET, "/auth/orderStatus/**").authenticated()
                    .requestMatchers(HttpMethod.GET, "/auth/orderStatus/obtener/**").authenticated()

                    //Ventas
                    .requestMatchers(HttpMethod.POST, "/auth/sales/**").authenticated()
                    .requestMatchers(HttpMethod.PUT, "/auth/sales/**").authenticated()
                    .requestMatchers(HttpMethod.GET, "/auth/sales/**").authenticated()
                    .requestMatchers(HttpMethod.DELETE, "/auth/sales/**").authenticated()

                    //DetallePedido
                    .requestMatchers(HttpMethod.POST, "/auth/orderDetails/**").authenticated()
                    .requestMatchers(HttpMethod.PUT, "/auth/orderDetails/actualizar/**").authenticated()
                    .requestMatchers(HttpMethod.GET, "/auth/orderDetails/**").authenticated()
                    .requestMatchers(HttpMethod.DELETE, "/auth/orderDetails/**").authenticated()

                    //Pedido
                    .requestMatchers(HttpMethod.POST, "/auth/order/**").authenticated()
                    .requestMatchers(HttpMethod.PUT, "/auth/order/**").authenticated()
                    .requestMatchers(HttpMethod.GET, "/auth/order/**").authenticated()
                    .requestMatchers(HttpMethod.DELETE, "/auth/order/**").authenticated()
                    .requestMatchers(HttpMethod.GET, "/auth/order/obtener/**").authenticated()
                    .requestMatchers(HttpMethod.GET, "/auth/order/obtener/estado/**").authenticated()

                    //Departamento
                    .requestMatchers(HttpMethod.GET, "/auth/departamento/**").permitAll()

                    //Pais
                    .requestMatchers(HttpMethod.GET, "/auth/pais/**").permitAll()

                    //Ciudad
                    .requestMatchers(HttpMethod.GET, "/auth/ciudad/**").permitAll()

                    //Categoria
                    .requestMatchers(HttpMethod.GET, "/auth/categoria/**").permitAll()

                    //Direccion
                    .requestMatchers(HttpMethod.POST, "/auth/direccion/**").authenticated()
                    .requestMatchers(HttpMethod.PUT, "/auth/direccion/**").authenticated()
                    .requestMatchers(HttpMethod.GET, "/auth/direccion/**").authenticated()
                    .requestMatchers(HttpMethod.GET, "/auth/direccion/obtener/direccion/**").authenticated()
                    .requestMatchers(HttpMethod.DELETE, "/auth/direccion/**").authenticated()
                    .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                    .and()
                    .csrf().disable()
                    .build();
     }

     @Bean
     public PasswordEncoder passwordEncoder(){
          return new BCryptPasswordEncoder();
     }

}
