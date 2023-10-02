import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {
    private Connection connection;

    // Construtor que recebe a conexão com o banco de dados

    public void inserirDespesa(Despesa despesa) throws SQLException {
        // Implemente a lógica para inserir uma despesa no banco de dados
    }

    public List<Despesa> listarDespesas() throws SQLException {
        // Implemente a lógica para listar todas as despesas do banco de dados
    }

    public void removerDespesa(int id) throws SQLException {
        // Implemente a lógica para remover uma despesa do banco de dados
    }

    public void atualizarDespesa(Despesa despesa) throws SQLException {
        // Implemente a lógica para atualizar uma despesa no banco de dados
    }
}
