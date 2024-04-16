// package pho.ma.security;

// import com.nimbusds.jose.jwk.source.ImmutableSecret;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.ProviderManager;
// import
// org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.Customizer;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import
// org.springframework.security.core.userdetails.UserDetailsPasswordService;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
// import org.springframework.security.oauth2.jwt.JwtDecoder;
// import org.springframework.security.oauth2.jwt.JwtEncoder;
// import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
// import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.server.SecurityWebFilterChain;

// import javax.crypto.spec.SecretKeySpec;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
// @Value("${jwt.secret}")
// private String secretKey;

// @Bean
// public InMemoryUserDetailsManager userDetailsService(PasswordEncoder
// passwordEncoder) {
// UserDetails user = User.withUsername("user")
// .password(passwordEncoder.encode("password"))
// .roles("USER")
// .build();

// UserDetails admin = User.withUsername("admin")
// .password(passwordEncoder.encode("admin"))
// .roles("USER", "ADMIN")
// .build();

// return new InMemoryUserDetailsManager(user, admin);
// }

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)
// throws Exception {
// return httpSecurity.sessionManagement(sm ->
// sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// .csrf(csrf -> csrf.disable())
// .authorizeHttpRequests(ar ->
// ar.requestMatchers("/auth/login/**").permitAll())
// .authorizeHttpRequests(ar -> ar.anyRequest().authenticated())
// // .httpBasic(Customizer.withDefaults())
// .oauth2ResourceServer(oa -> oa.jwt(Customizer.withDefaults()))
// .build();
// }

// @Bean
// public PasswordEncoder passwordEncoder() {
// PasswordEncoder encoder =
// PasswordEncoderFactories.createDelegatingPasswordEncoder();
// return encoder;
// }

// @Bean
// JwtEncoder jwtEncoder() {
// // String
// secretKey =
// "9faa372517ac1d389758d3758fc07acf00f542277f26fec1ce4593e93f64e338";
// return new NimbusJwtEncoder(new ImmutableSecret<>(secretKey.getBytes()));

// }

// @Bean
// JwtDecoder jwtDecoder() {
// // String
// secretKey =
// "9faa372517ac1d389758d3750fc07acf00f542277f26fec1ce4593e93f64e338";
// SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "RSA");

// return
// NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
// }

// @Bean
// public AuthenticationManager authenticationManager(UserDetailsService
// userDetailsService) {
// DaoAuthenticationProvider daoAuthenticationProvider = new
// DaoAuthenticationProvider();
// daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
// daoAuthenticationProvider.setUserDetailsService(userDetailsService);
// return new ProviderManager(daoAuthenticationProvider);
// }
// }