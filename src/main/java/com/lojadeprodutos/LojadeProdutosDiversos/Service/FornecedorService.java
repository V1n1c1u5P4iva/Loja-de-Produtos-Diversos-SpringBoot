package com.lojadeprodutos.LojadeProdutosDiversos.Service;

import java.util.List;
import java.util.Optional;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Fornecedor;
import com.lojadeprodutos.LojadeProdutosDiversos.Models.Produto;
import com.lojadeprodutos.LojadeProdutosDiversos.repository.FornecedorRepository;

public class FornecedorService {

    private FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        try {
            repository.save(fornecedor);
            return fornecedor;
        } catch (Exception e) {
            throw new RuntimeException("Erro! " + e.getMessage());
        }
    }

    public List<Fornecedor> listarFornecedor() {
        return repository.findAll();
    }

    public List<Produto> produtosDofornecedor(Long id) {
        Optional<Fornecedor> optionalFornecedor = repository.findById(id);

        if (optionalFornecedor.isPresent()) {
            return optionalFornecedor.get().getProdutos();
        } else {
            throw new IllegalArgumentException("Fornecedor não encontrado com o ID: " + id);
        }
    }

    public String deletarFornecedor(Long id) {

        boolean fornecedorExiste = repository.existsById(id);

        if (fornecedorExiste) {
            repository.deleteById(id);
            return "Fornecedor removido com sucesso!";
        } else {
            return "Fornecedor não encontrado!";
        }

    }

}
