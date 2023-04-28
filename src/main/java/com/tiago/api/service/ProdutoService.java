package com.tiago.api.service;

import com.tiago.api.model.Produto;
import com.tiago.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository protudoRepository;

    public List<Produto>obterTodos(){
        return protudoRepository.obterTodos();
    }
    public Optional<Produto>obterPorId(Integer id){
        return protudoRepository.obterPorId(id);
    }
    public  Produto adicionar(Produto produto){
        return  protudoRepository.adcionar(produto);
    }
    public  void deletar(Integer id){
        protudoRepository.deletar(id);
    }
    public  Produto atualizar(Integer id, Produto produto){
        produto.setId(id);
        return protudoRepository.atualizar(produto);
    }
}
