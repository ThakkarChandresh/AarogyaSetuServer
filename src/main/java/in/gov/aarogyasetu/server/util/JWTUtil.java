package in.gov.aarogyasetu.server.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;


public class JWTUtil
{

    private final static String SECRET = "qrtbSFS34wfsdfsdfSDBH67dfsddDDerQSNCK34SOWEK5354fdgdf3";

    private final static int EXPIRATION_TIME = 2 * 60 * 1000;

    private static final Key HMAC_KEY = new SecretKeySpec(Base64.getDecoder().decode(SECRET), SignatureAlgorithm.HS256.getJcaName());

    public static String getJWT(String userID)
    {

        return Jwts.builder().claim("userID", userID).setSubject("loginToken").setIssuer("io.gov.aarogyasetu").setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)).signWith(HMAC_KEY).compact();
    }

    public static String validateToken(String token)
    {

        return Jwts.parserBuilder().setSigningKey(HMAC_KEY).build().parseClaimsJws(token).getBody().get("userID").toString();


    }

}
