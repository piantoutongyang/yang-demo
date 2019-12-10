import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTDemo {
    public static void main(String args[]){
        String secret = "1ba871b5c77cb133x5ww01sa7bee25179";

        Algorithm algorithm = Algorithm.HMAC256(secret);
        String token = JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);

        System.out.println("token="+token);

    }
}
