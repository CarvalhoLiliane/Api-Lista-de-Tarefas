package br.com.listadetarefas.service;

import br.com.listadetarefas.dto.TarefasDTO;
import br.com.listadetarefas.model.Tarefas;
import br.com.listadetarefas.repository.TarefasRepository;
import br.com.listadetarefas.util.TarefasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository repository;

    public Tarefas save(TarefasDTO tarefasDTO){
        Tarefas tarefas = TarefasMapper.paraModel(tarefasDTO);
        return repository.save(tarefas);
    }

    public TarefasDTO getById(Long id){
        Tarefas tarefas = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id informado não encontrado"));
        return TarefasMapper.paraDto(tarefas);
    }

    public List<TarefasDTO> getAll(){
        List<Tarefas> listaTarefas = repository.findAll();
        List<TarefasDTO> tarefasDTOList = new ArrayList<>();
        for(Tarefas tarefas : listaTarefas){
            tarefasDTOList.add(TarefasMapper.paraDto(tarefas));
        }
        return tarefasDTOList;
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }


}
