package br.com.listadetarefas.controller;

import br.com.listadetarefas.dto.TarefasDTO;
import br.com.listadetarefas.model.Tarefas;
import br.com.listadetarefas.service.TarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = ("/api/listaDeTarefas"))
public class TarefasController {

    @Autowired
    private TarefasService service;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefas criarTarefa(@RequestBody TarefasDTO tarefasDTO){
        return service.save(tarefasDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TarefasDTO buscarPorId(@PathVariable Long id){
        return service.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TarefasDTO> listarTarefas(){
        return service.getAll();
    }
}
