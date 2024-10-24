package br.com.listadetarefas.dto;

import br.com.listadetarefas.enums.PrioridadeEnum;
import br.com.listadetarefas.enums.StatusEnum;
import lombok.Data;

@Data
public class TarefasDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String dataVencimento;
    private PrioridadeEnum prioridade;
    private StatusEnum status;
}
