package com.lojadeprodutos.LojadeProdutosDiversos.Controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Venda;
import com.lojadeprodutos.LojadeProdutosDiversos.Service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {

    private final VendaService service;

    public VendaController(VendaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Venda> salvarVenda(@RequestBody Venda venda) {
        try {
            Venda novaVenda = service.criarVenda(venda);
            return new ResponseEntity<>(novaVenda, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<String> removerVenda(@PathVariable Long id) {
        try {
            service.removerVenda(id);
            return new ResponseEntity<>("Venda removida com sucesso!", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Venda> buscaVenda(@PathVariable Long id) {
        Optional<Venda> venda = service.buscaVenda(id);
        return venda.map(ResponseEntity::ok)
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}