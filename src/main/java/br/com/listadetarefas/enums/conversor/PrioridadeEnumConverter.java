package br.com.listadetarefas.enums.conversor;

import br.com.listadetarefas.enums.PrioridadeEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

//Classe para salvar o valor da mensagem do enum diretamente no banco de dados
@Converter(autoApply = true)
public class PrioridadeEnumConverter implements AttributeConverter<PrioridadeEnum, String> {
    @Override
    public String convertToDatabaseColumn(PrioridadeEnum prioridade) {
        return prioridade != null ? prioridade.getMensagem() : null;
    }

    @Override
    public PrioridadeEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        for (PrioridadeEnum prioridade : PrioridadeEnum.values()) {
            if (prioridade.getMensagem().equals(dbData)) {
                return prioridade;
            }
        }

        throw new IllegalArgumentException("Valor desconhecido: " + dbData);
    }

}
