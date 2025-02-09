package com.lojadeprodutos.LojadeProdutosDiversos.Service;

import java.util.List;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Produto;
import com.lojadeprodutos.LojadeProdutosDiversos.repository.ProdutoRepository;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto salvarProduto(Produto produto) {
        try {
            repository.save(produto);
            return produto;
        } catch (Exception e) {
            throw new RuntimeException("Erro! " + e.getMessage());
        }
    }

    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    public String deleteProduto(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Produto removido";
        } else {
            return "Produto não encontrado";
        }
    }

    public List<Produto> buscarPorNome(String nome) {
        List<Produto> produtos = repository.buscarPorNome(nome); 
    
        if (produtos.isEmpty()) {
            return produtos; 
        }
    
        return produtos;
    }
}
