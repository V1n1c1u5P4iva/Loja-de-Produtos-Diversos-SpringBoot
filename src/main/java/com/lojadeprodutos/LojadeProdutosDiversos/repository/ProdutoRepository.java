package com.lojadeprodutos.LojadeProdutosDiversos.repository;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
