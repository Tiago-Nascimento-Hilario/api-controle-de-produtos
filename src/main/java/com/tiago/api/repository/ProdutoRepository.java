package com.tiago.api.repository;

import com.tiago.api.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository {
    private final List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    /***
     * Método para retorna uma lista de produtos
     * @return Lista de produtos
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /***
     * Método que retorna o produto encontrado pelo seu id
     * @param id do produto que será localizado
     * @return um produto caso seja encontrado
     */
    public Optional <Produto> obterPorId(Integer id){
        return produtos
                .stream()
                .filter(produto -> produto.getId().equals(id)).findFirst();
    }

    /***
     * Método para adicionar um produto na lista
     * @param produto que será adicionado
     * @return Retorna o produto que foi adcionado na lista
     */
    public Produto adcionar(Produto produto){
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /***
     * Método para deletar um produto por id
     * @param id produto a ser deletado
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId().equals(id));
    }

    /***
     * Método para atualizar produto na lista
     * @param produto que será atualizado
     * @return produto atulaizado
     */
    public Produto atualizar(Produto produto){
        // Encontrando um produto
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()){
            throw  new InputMismatchException("Produto não encontrado");
        }
        // Remover produto antigo da lista
        deletar(produto.getId());

        // Adicionar produto na lista
        produtos.add(produto);

        return produto;
    }

}
