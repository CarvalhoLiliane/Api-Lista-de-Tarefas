package br.com.listadetarefas.enums.conversor;

import br.com.listadetarefas.enums.StatusEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
//Classe para salvar o valor da mensagem do enum diretamente no banco de dados
@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<StatusEnum, String> {
    @Override
    public String convertToDatabaseColumn(StatusEnum status) {
        return status != null ? status.getMensagem() : null;
    }

    @Override
    public StatusEnum convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }
        for(StatusEnum status: StatusEnum.values()){
            if(status.getMensagem().equals(dbData)){
                return status;
            }
        }
        throw new IllegalArgumentException("Valor desconhecido: " + dbData);
    }
}
