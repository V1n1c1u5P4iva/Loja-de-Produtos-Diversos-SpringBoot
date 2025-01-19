package com.lojadeprodutos.LojadeProdutosDiversos.Service;

import java.util.List;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Cliente;
import com.lojadeprodutos.LojadeProdutosDiversos.repository.ClienteRepository;

import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }

    public Cliente atualizar(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }

    public Cliente bucarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Cliente> listaClistes(){
        return repository.findAll();
    }

}
