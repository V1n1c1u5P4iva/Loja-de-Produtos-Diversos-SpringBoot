package com.lojadeprodutos.LojadeProdutosDiversos.Service;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.ItemVenda;
import com.lojadeprodutos.LojadeProdutosDiversos.repository.ItemVendaRepository;
import com.lojadeprodutos.LojadeProdutosDiversos.repository.ProdutoRepository;
import com.lojadeprodutos.LojadeProdutosDiversos.repository.VendaRepository;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ItemVendaService {

    private ItemVendaRepository repository;
    private VendaRepository vendaRepository;

    private ProdutoRepository produtoRepository;

    public ItemVendaService(ItemVendaRepository repository, VendaRepository vendaRepository,
            ProdutoRepository produtoRepository) {
        this.repository = repository;
        this.vendaRepository = vendaRepository;
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    public ItemVenda salvarItemVenda(ItemVenda itemVenda) {
        if (!vendaRepository.existsById(itemVenda.getVenda().getId())) {
            throw new RuntimeException("Venda não encontrada");
        }
        if (!produtoRepository.existsById(itemVenda.getProduto().getId())) {
            throw new RuntimeException("Produto não encontrado");
        }

        return repository.save(itemVenda);
    }

    @Transactional
    public boolean removerItemVenda(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Venda não encontrada");
        }

        repository.deleteById(id);
        return true;
    }

}
