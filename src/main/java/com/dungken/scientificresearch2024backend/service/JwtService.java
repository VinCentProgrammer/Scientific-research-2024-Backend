package com.dungken.scientificresearch2024backend.service;

import com.dungken.scientificresearch2024backend.entity.Role;
import com.dungken.scientificresearch2024backend.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {
    public static final String SERECT = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    @Autowired
    private UserService userService;

    // Tạo JWT dựa trên tên đang nhập
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        User user = userService.findByUsername(username);

        boolean isAdmin = false;
        boolean isStaff = false;
        boolean isUser = false;
        if (user != null && user.getRoles().size() > 0) {
            List<Role> list = user.getRoles();
            for (Role q : list) {
                if (q.getRoleName().equals("ADMIN")) {
                    isAdmin = true;
                }
                if (q.getRoleName().equals("STAFF")) {
                    isStaff = true;
                }
                if (q.getRoleName().equals("USER")) {
                    isUser = true;
                }
            }
        }

        claims.put("isAdmin", isAdmin);
        claims.put("isStaff", isStaff);
        claims.put("isUser", isUser);

        return createToken(claims, username);
    }

    private  String createToken(Map<String, Object> claims, String username){
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+30*60*1000)) // JWT hết hạn sau 30 phút
//                .signWith(SignatureAlgorithm.ES256,getSigneKey())
                .signWith(Keys.hmacShaKeyFor(SERECT.getBytes()), SignatureAlgorithm.HS256)
                .compact();
    }

    // Lấy serect key
    private Key getSigneKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SERECT);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Trích xuất thông tin
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(getSigneKey()).parseClaimsJws(token).getBody();
    }

    // Trích xuất thông tin cho 1 claim
    public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction){
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    // Kiểm tra thời gian hết hạn từ JWT
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    // Kiểm tra tời gian hết hạn từ JWT
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    // Kiểm tra cái JWT đã hết hạn
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    // Kiểm tra tính hợp lệ
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        System.out.println(username);
        return (username.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }
}