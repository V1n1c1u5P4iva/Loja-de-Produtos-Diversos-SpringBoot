package com.lojadeprodutos.LojadeProdutosDiversos.repository;

import java.util.List;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %?1%")
    List<Produto> buscarPorNome(String nome);

}
