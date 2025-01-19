package com.lojadeprodutos.LojadeProdutosDiversos.Controller;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Cliente;
import com.lojadeprodutos.LojadeProdutosDiversos.Service.ClienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public void salvar(@RequestBody Cliente cliente){
        service.salvar(cliente);
    }
}
