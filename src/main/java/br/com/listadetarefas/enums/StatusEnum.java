package br.com.listadetarefas.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {

    CONCLUIDO("Tarefa concluída"),
    EM_ANDAMENTO ("Tarefa em andamento"),
    INICIADA("Tarefa iniciada"),
    NAO_CONCLUIDO("Tarefa não concluída");

    final String mensagem;

    StatusEnum(String mensagem) {
        this.mensagem = mensagem;
    }
    @JsonValue// para serializar
    public String getMensagem(){
        return mensagem;
    }

    @JsonCreator// para desserializar
    public static StatusEnum fromMensagem(String mensagem){
        for(StatusEnum status: StatusEnum.values()){
            if(status.mensagem.equalsIgnoreCase(mensagem)){
                return status;
            }
        }
        throw new IllegalArgumentException("Status desconhecido: " + mensagem);
    }

}
