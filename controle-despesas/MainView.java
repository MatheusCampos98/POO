import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.RouteAlias;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@Theme(value = Lumo.class, variant = Lumo.LIGHT)
public class MainView extends VerticalLayout implements RouterLayout {

    public MainView() {
        Button listarDespesasButton = new Button("Listar Despesas", e -> UI.getCurrent().navigate(ListarDespesasUI.class));
        Button removerDespesaButton = new Button("Remover Despesa", e -> UI.getCurrent().navigate(RemoverDespesaUI.class));
        Button atualizarDespesaButton = new Button("Atualizar Despesa", e -> UI.getCurrent().navigate(AtualizarDespesaUI.class));

        add(listarDespesasButton, removerDespesaButton, atualizarDespesaButton);
    }
}
