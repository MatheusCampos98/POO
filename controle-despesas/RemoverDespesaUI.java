import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;
import java.util.List;

@Route("remover-despesa")
public class RemoverDespesaUI extends FormLayout {
    private DespesaDAO despesaDAO;

    public RemoverDespesaUI(DespesaDAO despesaDAO) {
        this.despesaDAO = despesaDAO;

        H2 titulo = new H2("Remover Despesa");

        Grid<Despesa> grid = new Grid<>(Despesa.class);
        List<Despesa> despesas;
        try {
            despesas = despesaDAO.listarDespesas();
            grid.setItems(despesas);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Button removerButton = new Button("Remover");
        removerButton.addClickListener(event -> {
            Despesa despesaSelecionada = grid.asSingleSelect().getValue();
            if (despesaSelecionada != null) {
                try {
                    despesaDAO.removerDespesa(despesaSelecionada.getId());
                    grid.setItems(despesaDAO.listarDespesas());
                    Notification.show("Despesa removida com sucesso!");
                } catch (SQLException e) {
                    e.printStackTrace();
                    Notification.show("Erro ao remover a despesa.");
                }
            } else {
                Notification.show("Selecione uma despesa para remover.");
            }
        });

        add(titulo, grid, removerButton);
    }
}
