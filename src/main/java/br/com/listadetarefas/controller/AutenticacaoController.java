package br.com.listadetarefas.controller;

import br.com.listadetarefas.infra.security.DadosTokenJWT;
import br.com.listadetarefas.infra.security.TokenService;
import br.com.listadetarefas.model.DadosAutenticacao;
import br.com.listadetarefas.model.Usuario;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    private static final Logger logger = LoggerFactory.getLogger(AutenticacaoController.class);
    //classe que dispara o processo de autenticação
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        try{
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
            Authentication authenticate = manager.authenticate(authenticationToken);
            String tokenJWT = tokenService.gerarToken((Usuario) authenticate.getPrincipal());
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT)); // devolver um token no corpo da requisição
        }catch(Exception e){
            logger.info("Usuario inválido ou não encontrado");
            return ResponseEntity.badRequest().build();
        }

    }
}
