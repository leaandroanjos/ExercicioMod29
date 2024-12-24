package br.com.dao;

import br.com.leandro.domain.Produto;

import java.sql.SQLException;
import java.util.List;

public interface IProdutoDAO {

    Integer cadastrar(Produto produto) throws SQLException;
    Produto consultar(String codigo) throws SQLException;
    public Integer excluir(String codigo) throws SQLException;
    public List<Produto> consultarTodos() throws SQLException;

}
