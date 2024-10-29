package br.com.listadetarefas.infra.security;

import lombok.Data;

@Data
public class DadosTokenJWT {

    private String token;

    public DadosTokenJWT(String token) {
        this.token = token;
    }
}
