import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("despesa")
public class DespesaUI extends FormLayout {
    private DespesaDAO despesaDAO;

    public DespesaUI(DespesaDAO despesaDAO) {
        this.despesaDAO = despesaDAO;

        H2 titulo = new H2("Controle de Despesas");
        DatePicker dataField = new DatePicker("Data");
        TextField descricaoField = new TextField("Descrição");
        TextField valorField = new TextField("Valor");
        TextField categoriaField = new TextField("Categoria");

        Button inserirButton = new Button("Inserir");
        inserirButton.addClickListener(event -> {
            // Obtenha os valores dos campos e crie uma nova Despesa
            Despesa novaDespesa = new Despesa();
            novaDespesa.setData(dataField.getValue());
            novaDespesa.setDescricao(descricaoField.getValue());
            novaDespesa.setValor(Double.parseDouble(valorField.getValue()));
            novaDespesa.setCategoria(categoriaField.getValue());

            try {
                // Insira a nova despesa no banco de dados
                despesaDAO.inserirDespesa(novaDespesa);
                Notification.show("Despesa inserida com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
                Notification.show("Erro ao inserir a despesa.");
            }
        });

        // Adicione os componentes ao layout
        add(titulo, dataField, descricaoField, valorField, categoriaField, inserirButton);
    }
}
