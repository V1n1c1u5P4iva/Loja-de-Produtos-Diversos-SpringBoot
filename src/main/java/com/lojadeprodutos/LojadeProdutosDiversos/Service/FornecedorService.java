package com.lojadeprodutos.LojadeProdutosDiversos.Service;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Fornecedor;
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
            throw new RuntimeException("Erro! "+e.getMessage());
        }
    }


}
