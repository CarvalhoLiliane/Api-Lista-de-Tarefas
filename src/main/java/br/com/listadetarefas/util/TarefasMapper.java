package br.com.listadetarefas.util;

import br.com.listadetarefas.dto.TarefasDTO;
import br.com.listadetarefas.model.Tarefas;

public class TarefasMapper {

    public static TarefasDTO paraDto(Tarefas tarefas){
        TarefasDTO dto = new TarefasDTO();
        dto.setId(tarefas.getId());
        dto.setTitulo(tarefas.getTitulo());
        dto.setDescricao(tarefas.getDescricao());
        dto.setDataVencimento(tarefas.getDataVencimento());
        dto.setPrioridade(tarefas.getPrioridade());
        dto.setStatus(tarefas.getStatus());

        return dto;
    }

    public static Tarefas paraModel(TarefasDTO tarefasDTO){
        Tarefas tarefas = new Tarefas();
        tarefas.setTitulo(tarefasDTO.getTitulo());
        tarefas.setDescricao(tarefasDTO.getDescricao());
        tarefas.setDataVencimento(tarefasDTO.getDataVencimento());
        tarefas.setPrioridade(tarefasDTO.getPrioridade());
        tarefas.setStatus(tarefasDTO.getStatus());
        return  tarefas;
    }
}
