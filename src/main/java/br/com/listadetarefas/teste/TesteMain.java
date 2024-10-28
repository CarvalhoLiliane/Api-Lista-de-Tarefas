package br.com.listadetarefas.teste;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteMain {

    public static String generateToken(String token) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(token);
    }

    public static void main(String[] args) {
        String token = generateToken("12345678");
        System.out.println("Token Bcrypt: " + token);
    }
}
