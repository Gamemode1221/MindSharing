package com.spring.component;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;

@Component
//@RequiredArgsConstructor
public class JwtProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpirationInMs;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder()
                .setSubject(userPrincipal.getName())
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(getSecretKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (SignatureException |
                 MalformedJwtException |
                 ExpiredJwtException |
                 UnsupportedJwtException |
                 IllegalArgumentException e) {
            e.printStackTrace();
        }

        return false;
    }

    // 참고 자료
    // https://velog.io/@junho5336/SpringBoot-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-with.-SpringSecurity-JWT

//    @Value("${jwt.secret}")
//    private String bread;
//
//    @Value("${jwt.expiration}")
//    private long expiration;
//
//    private Key secretKey;
//
//    private final JpaUserDetailsService userDetailsService;
//
//    @PostConstruct
//    protected void init() {
//        secretKey = Keys.hmacShaKeyFor(bread.getBytes(StandardCharsets.UTF_8));
//    }
//
//    // 토큰 생성
//    public String createToken(String account, List<Authority> roles) {
//        Claims claims = Jwts.claims().setSubject(account);
//        claims.put("roles", roles);
//        Date now = new Date();
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(new Date(now.getTime() + expiration))
////                .signWith(secretKey, SignatureAlgorithm.HS256) // 순서 바뀜
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
//
//    // 권한정보 획득
//    // Spring Security 인증 과정에서 권한확인을 위한 기능
//    public Authentication getAuthentication(String token) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getAccount(token));
//        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
//    }
//
//    // 토큰에 담겨있는 유저 account 획득
//    public String getAccount(String token) {
//        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
//    }
//
//    // Authorization Header를 통해 인증
//    public String resolveToken(HttpServletRequest request) {
//        return request.getHeader("Authorization");
//    }
//
//    // 토큰 검증
//    public boolean validateToken(String token) {
//        try {
//            // Bearer 검증
//            if (!token.substring(0, "BEARER ".length()).equalsIgnoreCase("BEARER ")) {
//                return false;
//            } else {
//                token = token.split(" ")[1].trim();
//            }
//            Jws<Claims> claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
//            // 만료되었을 시 false
//            return !claims.getBody().getExpiration().before(new Date());
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public UserDetails getUserDetailsFromToken(String token) {
//        // 토큰에서 사용자 계정(account)을 가져옵니다.
//        String account = getAccount(token);
//
//        // 사용자 계정으로부터 UserDetails를 가져옵니다.
//        UserDetails userDetails = userDetailsService.loadUserByUsername(account);
//
//        return userDetails;
//    }

}
