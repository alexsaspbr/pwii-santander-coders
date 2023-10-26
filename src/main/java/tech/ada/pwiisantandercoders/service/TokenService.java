package tech.ada.pwiisantandercoders.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import tech.ada.pwiisantandercoders.exception.TokenInvalidoException;
import tech.ada.pwiisantandercoders.model.Usuario;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public static final String ISSUER = "auth-api-produtos";
    @Value("${jwt-secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        String token = JWT.create()
                .withIssuer(ISSUER)
                .withSubject(usuario.getLogin())
                .withExpiresAt(getExpiresAt())
                .sign(algorithm);

        return token;
    }

    public String validarToken(String token) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception e) {
            throw new TokenInvalidoException();
        }

    }

    private static Instant getExpiresAt() {
        return LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00"));
    }

}
