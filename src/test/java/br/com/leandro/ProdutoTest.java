package br.com.leandro;

import br.com.dao.IProdutoDAO;
import br.com.dao.ProdutoDAO;
import br.com.leandro.domain.Cliente;
import br.com.leandro.domain.Produto;
import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    @Test
    public void daoTest() throws SQLException {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setNome("Detergente");
        produto.setCodigo("1");
        produto.setPreco(10.5F);

        Integer linhas = dao.cadastrar(produto);
        assertNotNull(linhas);
        assertTrue(linhas == 1);

        Produto produto2 = new Produto();
        produto2.setNome("Desinfetante");
        produto2.setCodigo("2");
        produto2.setPreco(22.5F);

        Integer linhas2 = dao.cadastrar(produto2);
        assertNotNull(linhas2);
        assertTrue(linhas2 == 1);

        System.out.println("Consulta Todos itens: ");
        List<Produto> lista_de_produtos = dao.consultarTodos();
        assertNotNull(lista_de_produtos);
        lista_de_produtos.forEach(produto_obj -> {
            System.out.println(produto_obj.getNome());
        });

        System.out.println("Consulta Individual: ");
        Produto produtoDB = dao.consultar(produto.getCodigo());
        assertNotNull(produtoDB);
        assertEquals(produto.getCodigo(), produtoDB.getCodigo());
        System.out.println(produtoDB.getNome());

        Integer qtd_excluir = dao.excluir(produto.getCodigo());
        assertNotNull(qtd_excluir);
        assertTrue(qtd_excluir == 1);

        Integer qtd_excluir2 = dao.excluir(produto2.getCodigo());
        assertNotNull(qtd_excluir2);
        assertTrue(qtd_excluir2 == 1);
    }

}
