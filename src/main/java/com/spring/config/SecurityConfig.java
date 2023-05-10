package com.spring.config;

import com.spring.Service.CustomUserDetailsService;
import com.spring.Service.UserDetailsServiceImpl;
import com.spring.component.JwtAuthenticationEntryPoint;
//import com.spring.component.JwtAuthenticationFilter;
import com.spring.component.JwtAuthenticationFilter;
import com.spring.component.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }

//    @Bean
//    public AuthenticationManager getAuthenticationManager(AuthenticationManagerBuilder auth) throws Exception {
//        return auth.build();
//    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.csrf().disable()
////                .sessionManagement()
////                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .authorizeHttpRequests()
////                // /login 엔드포인트에 대한 POST 요청은 보호되지 않음.
////                .requestMatchers(HttpMethod.POST, "/login").permitAll()
////                // 다른 모든 요청은 보호됨
////                .anyRequest().authenticated();
//
//        return http.build();
//    }



//    private final JwtProvider jwtProvider;

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//            // h2 DB 사용을 위한 frameOption() 비활성화
//            .headers()
//            .frameOptions().disable()
//            .and()
//            // ID, Password 문자열을 Base64로 인코딩하여 전달하는 구조
//            .httpBasic().disable()
//            // 쿠키 기반이 아닌 JWT 기반이므로 사용하지 않음.
//            .csrf().disable()
//            // CORS 설정
//            .cors(c -> {
//                CorsConfigurationSource source = request -> {
//                    // CORS 허용 패턴
//                    CorsConfiguration config = new CorsConfiguration();
//                    config.setAllowedOrigins(
//                            List.of("*")
//                    );
//                    config.setAllowedMethods(
//                            List.of("*")
//                    );
//                    return config;
//                };
//                c.configurationSource(source);
//            })
//            // Spring Security 세션 정책 : 세션을 생성 및 사용하지 않음
//            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            // 조건별로 요청 허용/제한 설정
//            .authorizeHttpRequests()
//            // 모든 사용자가 모든 주소에 접속 허용
//            .requestMatchers("/**").permitAll()
//            // 회원가입과 로그인은 모두 승인
//            .requestMatchers("/signup", "/login").permitAll()
//            // /admin으로 시작하는 요청은 ADMIN 권한이 있는 유저에게만 허용
//            .requestMatchers("/admin/**").hasRole("ADMIN")
//            // /user로 시작하는 요청은 USER 권한이 있는 유저에게만 허용
//            .requestMatchers("/user/**").hasRole("USER")
//            .requestMatchers("/h2-console/**").permitAll() // DB 확인용
//            .anyRequest().denyAll()
//            .and()
//            // JWT 인증 필터 적용
//            .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
//            // 에러 핸들링
//            .exceptionHandling()
//            .accessDeniedHandler(new AccessDeniedHandler() {
//                @Override
//                public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//                    // 권한 문제가 발생했을 때 이 부분을 호출함
//                    response.setStatus(403);
//                    response.setCharacterEncoding("utf-8");
//                    response.setContentType("text/html; charset=UTF-8");
//                    response.getWriter().write("권한이 없는 사용자입니다. (SecurityConfig)");
//                }
//            })
//            .authenticationEntryPoint(new AuthenticationEntryPoint() {
//                @Override
//                public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//                    // 인증 문제가 발생했을 때 이 부분을 호출함
//                    response.setStatus(401);
//                    response.setCharacterEncoding("utf-8");
//                    response.setContentType("text/html; charset=UTF-8");
//                    response.getWriter().write("인증되지 않은 사용자입니다. (SecurityConfig)");
//                }
//            });
//
//        return http.build();
//
//        // PasswordEncoder를 createDelegatingPasswordEncoder()로 설정하면
//        // {noop} asdf!@#asdfvz!@#... 처럼 password의 앞에 Encoding 방식이 붙은채로 저장되어 암호화 방식을 지정하여 저장할 수 있다.
//        // 참고 (https://velog.io/@junho5336/SpringBoot-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-with.-SpringSecurity-JWT)
//
//
////        return http.authorizeHttpRequests().requestMatchers(
////                        new AntPathRequestMatcher("/**")).permitAll()
////                .and()
////                // CSRF 비활성화 코드를 지우면 사용 가능
//////                .csrf().ignoringRequestMatchers(
//////                        new AntPathRequestMatcher("/h2-console/**"))
//////                .and()
////                .csrf().disable() // CSRF 비활성화
////                .headers()
////                .addHeaderWriter(new XFrameOptionsHeaderWriter(
////                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
////                .and() // 로그인 구현
////                .formLogin()
////                .loginPage("/login")
////                .defaultSuccessUrl("/") // 성공하면 home으로
////                .and().build();
//    }

//    @Bean
//    public static RequestMatcher h2ConsoleMatcher() {
//        return new OrRequestMatcher(
//                new AntPathRequestMatcher("/h2-console/**")
//        );
//    }
//
//    @Bean
//    public static RequestMatcher protectedEndpointMatcher() {
//        List<RequestMatcher> matchers = new ArrayList<>();
//
//        matchers.add(new AntPathRequestMatcher("/**"));
//    }

    @Bean
    PasswordEncoder passwordEncoder() { //패스워드를 bean으로
        return new BCryptPasswordEncoder();
    }

//    @Bean //스프링 시큐리티의 인증 담당
//    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
}