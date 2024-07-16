package ccnu.mb.internship0703.uitls;

import ccnu.mb.internship0703.pojo.User;
import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class TokenUtils {
    private static long time = 1000*60*60*24;
    public static String getToken(User user){
        String token = "";
        JwtBuilder jwtBuilder = Jwts.builder();
        token = jwtBuilder
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                .claim("username",user.getUsername())
                .claim("age",user.getAge())
                .setId(UUID.randomUUID().toString().replace("-",""))
                .setExpiration(new Date(System.currentTimeMillis()+time))
                .signWith(SignatureAlgorithm.HS256,"huashi")
                .compact();
        return token;

    }
    public static boolean checkToken(String token){
        JwtParser jwtParser =Jwts.parser();
        try{
            Jws<Claims> claimsJws = jwtParser.setSigningKey("huashi").parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            System.out.println(claims.getExpiration());
            System.out.println(claims.get("name"));
            System.out.println(claims.getId());
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
