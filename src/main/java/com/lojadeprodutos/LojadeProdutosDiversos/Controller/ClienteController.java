package com.lojadeprodutos.LojadeProdutosDiversos.Controller;

import java.util.List;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Cliente;
import com.lojadeprodutos.LojadeProdutosDiversos.Service.ClienteService;
import com.lojadeprodutos.LojadeProdutosDiversos.exception.ClientesException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<?> salvar(@RequestBody Cliente cliente) {
        try {
            Cliente clienteSalvo = service.salvar(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
        } catch (ClientesException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    @GetMapping("{email}")
    public Cliente mostrarCliente(@PathVariable String email) {
        return service.bucarPorEmail(email);
    }

    @GetMapping("/lista")
    public List<Cliente> listarClientes() {

        return service.listaClistes();

    }

    @PutMapping("{id}")
    public Cliente atualizar(@PathVariable Long id,
            @RequestBody Cliente cliente) {
        cliente.setId(id);
        return service.atualizar(cliente);
    }

    @DeleteMapping("{id}")
    public String deletarCliente(@PathVariable Long id) {
        return service.remover(id);
    }

}
