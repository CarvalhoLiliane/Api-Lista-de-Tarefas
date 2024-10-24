package br.com.listadetarefas.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PrioridadeEnum {
    BAIXA("Baixa"),
    MEDIA("Média"),
    ALTA("Alta");

    final String mensagem;

    PrioridadeEnum(String mensagem) {
        this.mensagem = mensagem;
    }

    @JsonValue
    public String getMensagem(){
        return mensagem;
    }

    @JsonCreator
    public PrioridadeEnum fromMensagem(String mensagem){
        for(PrioridadeEnum prioridade : PrioridadeEnum.values()){
            if(prioridade.mensagem.equalsIgnoreCase(mensagem)){
                return prioridade;
            }
        }
        throw new IllegalArgumentException("Prioridade desconhecida: " + mensagem);
    }
}
