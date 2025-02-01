package com.lojadeprodutos.LojadeProdutosDiversos.repository;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByEmail(String email);
}
