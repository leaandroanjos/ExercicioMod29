package br.com.dao;

import br.com.dao.jdbc.ConnectionFactory;
import br.com.leandro.domain.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements IProdutoDAO {

    @Override
    public Integer cadastrar(Produto produto) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = "INSERT INTO tb_produto_2 (ID, CODIGO, NOME, PRECO) VALUES (nextval('sq_cliente_id'), ?, ?, ?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getCodigo());
            stm.setString(2, produto.getNome());
            stm.setFloat(3, produto.getPreco());
            return stm.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if (stm != null && !stm.isClosed()){
                stm.close();
            }
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        return null;
    }

    @Override
    public Produto consultar(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = new Produto();
        try{
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO_2 WHERE codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            rs = stm.executeQuery();
            if (rs.next()){
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getFloat("preco"));
            }
            return produto;
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if (stm != null && !stm.isClosed()){
                stm.close();
            }
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        return null;
    }


    @Override
    public Integer excluir(String codigo) throws SQLException {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection = ConnectionFactory.getConnection();
            String sql = "DELETE FROM TB_PRODUTO_2 WHERE codigo = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, codigo);
            return stm.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if (stm != null && !stm.isClosed()){
                stm.close();
            }
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        return null;
    }

    @Override
    public List<Produto> consultarTodos() throws SQLException {

        List<Produto> list_de_produtos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = new Produto();
        try{
            connection = ConnectionFactory.getConnection();
            String sql = "SELECT * FROM TB_PRODUTO_2";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()){
                produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setCodigo(rs.getString("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getFloat("preco"));
                list_de_produtos.add(produto);
            }
            return list_de_produtos;
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            if (stm != null && !stm.isClosed()){
                stm.close();
            }
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        return null;
    }
}
