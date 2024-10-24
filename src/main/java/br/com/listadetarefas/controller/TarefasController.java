package br.com.listadetarefas.controller;

import br.com.listadetarefas.model.Tarefas;
import br.com.listadetarefas.service.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = ("/api/listaDeTarefas"))
public class TarefasController {

    @Autowired
    private TarefasService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefas criarTarefa(@RequestBody Tarefas tarefas){
        return service.save(tarefas);
    }
}
