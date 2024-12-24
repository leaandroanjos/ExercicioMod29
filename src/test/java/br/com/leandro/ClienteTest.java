package br.com.leandro;

import br.com.dao.ClienteDAO;
import br.com.dao.IClienteDAO;
import br.com.leandro.domain.Cliente;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void cadastrarTest() throws Exception {
        IClienteDAO dao = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("01");
        cliente.setNome("Leandro");

        Integer qtd = dao.cadastrar(cliente);
        assertTrue(qtd == 1);

        Cliente cliente2 = new Cliente();
        cliente2.setCodigo("02");
        cliente2.setNome("Luccas");

        Integer qtd2 = dao.cadastrar(cliente2);
        assertTrue(qtd2 == 1);

        List<Cliente> lista_de_clientes = dao.consultarTodos();
        assertNotNull(lista_de_clientes);
        lista_de_clientes.forEach(cliente_lista -> {
            System.out.println(cliente_lista.getNome());
        });


        Cliente clienteBD = dao.consultar(cliente.getCodigo());
        assertNotNull(clienteBD);
        assertEquals(clienteBD.getCodigo(), cliente.getCodigo());

        Integer qtdDel = dao.excluir(cliente);
        assertNotNull(qtdDel);
        assertTrue(qtdDel == 1);

        Integer qtd2Del = dao.excluir(cliente2);
        assertNotNull(qtd2Del);
        assertTrue(qtd2Del == 1);
    }

}
