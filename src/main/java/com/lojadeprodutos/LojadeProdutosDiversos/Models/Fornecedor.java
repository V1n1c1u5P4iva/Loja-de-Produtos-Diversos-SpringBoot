package com.lojadeprodutos.LojadeProdutosDiversos.Models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Column(nullable = false, unique = true)
    private String cnpj;
    private String telefone;
    private String endereco;

    @OneToMany(mappedBy = "fornecedor", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("fornecedor")
    private List<Produto> produtos;

}
