package com.lojadeprodutos.LojadeProdutosDiversos.Service;

import java.util.List;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.Cliente;
import com.lojadeprodutos.LojadeProdutosDiversos.exception.ClientesException;
import com.lojadeprodutos.LojadeProdutosDiversos.repository.ClienteRepository;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente salvar(Cliente cliente) {
        try {
            return repository.save(cliente); 
        } catch (DataIntegrityViolationException e) {
            throw new ClientesException("E-mail já cadastrado: " + cliente.getEmail());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
        }
    }
    

    public Cliente atualizar(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }

    public Cliente bucarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    public List<Cliente> listaClistes() {
        return repository.findAll();
    }

    public String remover(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Cliente removido com sucesso";
        } else {
            return "Cliente não encontrado";
        }
    }

}
