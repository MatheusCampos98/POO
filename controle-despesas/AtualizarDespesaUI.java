import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.sql.SQLException;
import java.util.List;

@Route("atualizar-despesa")
public class AtualizarDespesaUI extends FormLayout {
    private DespesaDAO despesaDAO;

    public AtualizarDespesaUI(DespesaDAO despesaDAO) {
        this.despesaDAO = despesaDAO;

        H2 titulo = new H2("Atualizar Despesa");

        Grid<Despesa> grid = new Grid<>(Despesa.class);
        List<Despesa> despesas;
        try {
            despesas = despesaDAO.listarDespesas();
            grid.setItems(despesas);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TextField valorField = new TextField("Novo Valor");
        Button atualizarButton = new Button("Atualizar");

        atualizarButton.addClickListener(event -> {
            Despesa despesaSelecionada = grid.asSingleSelect().getValue();
            if (despesaSelecionada != null) {
                double novoValor = Double.parseDouble(valorField.getValue());
                despesaSelecionada.setValor(novoValor);
                try {
                    despesaDAO.atualizarDespesa(despesaSelecionada);
                    grid.setItems(despesaDAO.listarDespesas());
                    Notification.show("Despesa atualizada com sucesso!");
                } catch (SQLException e) {
                    e.printStackTrace();
                    Notification.show("Erro ao atualizar a despesa.");
                }
            } else {
                Notification.show("Selecione uma despesa para atualizar.");
            }
        });

        add(titulo, grid, valorField, atualizarButton);
    }
}
