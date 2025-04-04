import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoDAOTest {

    private ProdutoDAO produtoDAO;

    @BeforeEach
    public void setUp() {
        produtoDAO = new ProdutoDAO();  // Inicializando a classe DAO antes de cada teste
    }

    @Test
    public void testCadastrarProduto() {

        Produto produtoInserir = new Produto();
        produtoInserir.setNome("Produto Teste");
        produtoInserir.setValor("100.00");
        produtoInserir.setCor("azul");

        try {

            Integer resultadoInserir = produtoDAO.cadastrar(produtoInserir);
            assertEquals(1, resultadoInserir, "Produto não inserido corretamente");


            Produto produtoBuscado = produtoDAO.buscar("Produto Teste");
            assertNotNull(produtoBuscado, "Produto não encontrado após inserção");
            assertEquals("Produto Teste", produtoBuscado.getNome(), "Nome do produto não é igual ao esperado");

        } catch (Exception e) {
            fail("Erro ao cadastrar o produto: " + e.getMessage());
        }
    }

    @Test
    public void testAtualizarProduto() {
        Produto produtoInserir = new Produto();
        produtoInserir.setNome("Produto Teste2");
        produtoInserir.setValor("100.00");
        produtoInserir.setCor("azul");

        try {

            produtoDAO.cadastrar(produtoInserir);


            Produto produtoBuscado = produtoDAO.buscar("Produto Teste2");
            produtoBuscado.setNome("Produto Teste Atualizado");
            produtoBuscado.setValor("200");
            produtoBuscado.setCor("verde");

            // Atualizando o produto
            Integer resultadoAtualizar = produtoDAO.atualizar(produtoBuscado);
            assertEquals(1, resultadoAtualizar, "Produto não foi atualizado corretamente");

            // Buscando o produto após atualização
            Produto produtoAtualizado = produtoDAO.buscar("Produto Teste Atualizado");
            assertNotNull(produtoAtualizado, "Produto não encontrado após atualização");
            assertEquals("Produto Teste Atualizado", produtoAtualizado.getNome(), "Nome do produto atualizado está incorreto");
            assertEquals("150", produtoAtualizado.getValor(), "Valor do produto atualizado está incorreto");
            assertEquals("Azul", produtoAtualizado.getCor(), "Cor do produto atualizado está incorreta");

        } catch (Exception e) {
            fail("Erro ao atualizar o produto: " + e.getMessage());
        }
    }

    @Test
    public void testExcluirProduto() {
        Produto produtoInserir = new Produto();
        produtoInserir.setNome("Produto Teste ");
        produtoInserir.setValor("100.00");
        produtoInserir.setCor("azul");

        try {

            produtoDAO.cadastrar(produtoInserir);


            Produto produtoBuscado = produtoDAO.buscar("Produto Teste");
            assertNotNull(produtoBuscado, "Produto não encontrado antes da exclusão");


            Integer resultadoExcluir = produtoDAO.excluir(produtoBuscado.getId());
            assertEquals(1, resultadoExcluir, "Produto não foi excluído corretamente");


            Produto produtoExcluido = produtoDAO.buscar("Produto Teste ");
            assertNull(produtoExcluido, "Produto encontrado após exclusão");

        } catch (Exception e) {
            fail("Erro ao excluir o produto: " + e.getMessage());
        }
    }
}
