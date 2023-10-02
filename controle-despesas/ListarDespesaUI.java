import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;
import java.util.List;

@Route("listar-despesas")
public class ListarDespesasUI extends VerticalLayout {
    private DespesaDAO despesaDAO;

    public ListarDespesasUI(DespesaDAO despesaDAO) {
        this.despesaDAO = despesaDAO;

        Grid<Despesa> grid = new Grid<>(Despesa.class);
        try {
            List<Despesa> despesas = despesaDAO.listarDespesas();
            grid.setItems(despesas);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        add(grid);
    }
}
