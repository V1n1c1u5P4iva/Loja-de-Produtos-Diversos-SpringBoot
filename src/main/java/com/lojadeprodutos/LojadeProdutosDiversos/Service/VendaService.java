package com.lojadeprodutos.LojadeProdutosDiversos.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Venda;
import com.lojadeprodutos.LojadeProdutosDiversos.repository.VendaRepository;

@Service
public class VendaService {

    private final VendaRepository repository;

    public VendaService(VendaRepository repository) {
        this.repository = repository;
    }

    public Venda criarVenda(Venda venda) {
        if (venda == null || venda.getCliente() == null) {
            throw new IllegalArgumentException("Dados da venda inválidos!");
        }
        return repository.save(venda);
    }

    public void removerVenda(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Venda não encontrada com o ID: " + id);
        }
        repository.deleteById(id);
    }

    public Optional<Venda> buscaVenda(Long id) {
        return repository.findById(id);
    }
}