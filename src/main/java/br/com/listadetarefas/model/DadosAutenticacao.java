package br.com.listadetarefas.model;

import lombok.Data;
@Data
public class DadosAutenticacao {

    private String login;
    private String senha;

    public String login() {
        return login;
    }

    public String senha(){
        return senha;
    }
}
