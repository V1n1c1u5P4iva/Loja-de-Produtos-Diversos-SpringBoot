package com.lojadeprodutos.LojadeProdutosDiversos.Controller;

import com.lojadeprodutos.LojadeProdutosDiversos.Models.ItemVenda;
import com.lojadeprodutos.LojadeProdutosDiversos.Service.ItemVendaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemVenda")
public class ItemVendaCont {

    private ItemVendaService service;

    public ItemVendaCont(ItemVendaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> salvarItemVenda(@RequestBody ItemVenda itemVenda) {
        try {
            ItemVenda itemSalvo = service.salvarItemVenda(itemVenda);
            if (itemSalvo != null) {
                return new ResponseEntity<>(itemSalvo, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Venda ou Produto não encontrado", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar item da venda: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerItemVenda(@PathVariable Long id) {
        try {
            boolean Item = service.removerItemVenda(id);
            if (Item) {
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("Erro! " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } 
        return null;
    }

}
