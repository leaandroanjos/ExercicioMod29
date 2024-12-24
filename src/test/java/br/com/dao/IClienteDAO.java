package br.com.dao;

import br.com.leandro.domain.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface IClienteDAO {

    public Integer cadastrar(Cliente cliente) throws Exception;

    public Cliente consultar(String codigo) throws Exception;

    public Integer excluir(Cliente cliente) throws Exception;

    public List<Cliente> consultarTodos() throws SQLException;
}
