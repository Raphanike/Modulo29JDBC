

public interface IProdutoDAO {


    Integer cadastrar(Produto produto) throws Exception;

    public Integer atualizar(Produto produto) throws Exception;

    public Produto buscar(String produto) throws Exception;

    Integer excluir(Long idProduto) throws Exception;



}

    
    
