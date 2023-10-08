import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

public class JwtHandler {
    private static final String SECRET_KEY = "your-secret-key";
    @Deprecated
    public static String generateToken(String userId) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 86400000); // Thời hạn của token (1 ngày)

        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY.getBytes())
                .compact();
    }
    @Deprecated
    public static Claims decodeToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}



