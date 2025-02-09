package com.lojadeprodutos.LojadeProdutosDiversos.Controller;

import java.util.List;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Produto;
import com.lojadeprodutos.LojadeProdutosDiversos.Service.ProdutoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> salvarProduto(@RequestBody Produto produto) {
        try {
            Produto produtoSalvo = service.salvarProduto(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar produto: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public List<Produto> listarProduto() {
        return service.listarProdutos();
    }

    @GetMapping("/buscar/{nome}")
    public List<Produto> buscarPorNome(@PathVariable String nome) {
        return service.buscarPorNome(nome); // Corrigido o nome do método
    }

}
