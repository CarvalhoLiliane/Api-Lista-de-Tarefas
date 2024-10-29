package br.com.listadetarefas.infra.security;

import br.com.listadetarefas.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Lista de Tarefas")// quem ta gerando o token - nome da aplicação
                    .withSubject(usuario.getLogin()) // dono do token
                    .withExpiresAt(dataExpiracao())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("Erro ao gerar token jwt", exception);
        }
    }

    //método para validar token
    public String getSubject(String tokenJWT){
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API Lista de Tarefas")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();

        } catch (JWTVerificationException exception){
            throw new RuntimeException("Token JWT inválido ou expirado");
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(10).toInstant(ZoneOffset.of("-03:00"));
    }
}
