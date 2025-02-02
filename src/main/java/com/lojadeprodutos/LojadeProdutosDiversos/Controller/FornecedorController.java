package com.lojadeprodutos.LojadeProdutosDiversos.Controller;

import java.util.List;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Fornecedor;
import com.lojadeprodutos.LojadeProdutosDiversos.Models.Produto;
import com.lojadeprodutos.LojadeProdutosDiversos.Service.FornecedorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    };

    @PostMapping
    public ResponseEntity<?> salvarFornecedor(@RequestBody Fornecedor fornecedor) {
        try {
            Fornecedor fornecedorSalvo = service.salvarFornecedor(fornecedor);
            return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    @PostMapping("/fornecedores")
    public ResponseEntity<?> salvarVariosFornecedores(@RequestBody List<Fornecedor> fornecedores) {
        try {
            List<Fornecedor> fornecedoresSalvos = service.salvarVariosFornecedores(fornecedores);
            return ResponseEntity.status(HttpStatus.CREATED).body(fornecedoresSalvos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar cliente: " + e.getMessage());
        }
    }

    @GetMapping("/lista")
    public List<Fornecedor> listaFornecedores() {
        return service.listarFornecedores();
    }

    @GetMapping("/produtos/{id}")
    public List<Produto> produtosDoFornecedor(@PathVariable Long id) {
        return service.produtosDoFornecedor(id);
    }

    @DeleteMapping("/deletar/{id}")
    public String deletarFornecedor(@PathVariable Long id) {
        return service.deletarFornecedor(id);
    }

}
