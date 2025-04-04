import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoDAO  implements IProdutoDAO{
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConexaoSQL.getConnection();
            String sql = "INSERT INTO TB_CLIENTE (ID, NOME, VALOR, COR) VALUES (nextval('SQ_CLIENTE'),?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setString(2, produto.getValor());
            stm.setString(3, produto.getCor());
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConexaoSQL.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adicionarParametrosUpdate(stm, produto);
            return stm.executeUpdate();
        } catch(Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    @Override
    public Produto buscar(String nome) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto = null;
        try {
            connection = ConexaoSQL.getConnection();
            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adicionarParametrosSelect(stm, nome); // Passar o nome para a busca
            rs = stm.executeQuery();

            if (rs.next()) {
                produto = new Produto();
                Long id = rs.getLong("ID");
                String nomeProduto = rs.getString("NOME");
                String valor = rs.getString("VALOR");
                String cor = rs.getString("COR");
                produto.setId(id);
                produto.setNome(nomeProduto);
                produto.setValor(valor);
                produto.setCor(cor);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, rs);
        }
        return produto;
    }







    private void adicionarParametrosSelect(PreparedStatement stm, String nome) throws SQLException {
        stm.setString(1, nome);  // Supondo que você quer buscar pelo nome.
    }


    private String getSqlSelect() {
        return "SELECT ID, NOME, VALOR, COR FROM TB_CLIENTE WHERE NOME = ?";
    }



    private void adicionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1, produto.getNome());   // Nome do produto
        stm.setString(2, produto.getValor());  // Valor do produto
        stm.setString(3, produto.getCor());    // Cor do produto
        stm.setLong(4, produto.getId());       // ID do produto (para a cláusula WHERE)
    }




    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE TB_CLIENTE ");
        sb.append("SET NOME = ?, VALOR = ?, COR = ? ");  // Corrigido: agora tem 3 parâmetros
        sb.append("WHERE ID = ?");
        return sb.toString();
    }


    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stm != null && !stm.isClosed()) {
                stm.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public Integer excluir(Long idProduto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = ConexaoSQL.getConnection();
            String sql = "DELETE FROM TB_CLIENTE WHERE ID = ?";
            stm = connection.prepareStatement(sql);
            stm.setLong(1, idProduto);  // Definindo o parâmetro ID do produto a ser excluído
            return stm.executeUpdate();  // Retorna o número de linhas afetadas
        } catch (Exception e) {
            throw e;
        } finally {
            closeConnection(connection, stm, null);
        }
    }

    }



