package br.com.listadetarefas.service;

import br.com.listadetarefas.model.Tarefas;
import br.com.listadetarefas.repository.TarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefasService {

    @Autowired
    private TarefasRepository repository;

    public Tarefas save(Tarefas tarefas){
        return repository.save(tarefas);
    }

}
