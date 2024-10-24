package br.com.listadetarefas.model;

import br.com.listadetarefas.enums.PrioridadeEnum;
import br.com.listadetarefas.enums.StatusEnum;
import br.com.listadetarefas.enums.conversor.PrioridadeEnumConverter;
import br.com.listadetarefas.enums.conversor.StatusEnumConverter;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tarefas {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String dataVencimento;

    @Convert(converter = PrioridadeEnumConverter.class)
    private PrioridadeEnum prioridade;

    @Convert(converter = StatusEnumConverter.class)
    private StatusEnum status;
}
