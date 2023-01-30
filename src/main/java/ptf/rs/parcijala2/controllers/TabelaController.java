package ptf.rs.parcijala2.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ptf.rs.parcijala2.Config;
import ptf.rs.parcijala2.models.Person;
import ptf.rs.parcijala2.repository.PersonRepository;
import ptf.rs.parcijala2.utils.Utils;

import java.net.URL;
import java.util.ResourceBundle;

public class TabelaController  {
    public TableView<Person> tabela;

    private final PersonRepository personRepository;


    public TabelaController() {
        this.personRepository = Config.personRepository;
    }

    public void loadItems() {
        tabela.setItems(FXCollections.observableArrayList(personRepository.getAll()));
        tabela.refresh();
    }

    //oponaša dugme koje treba da navigira na narednu stranicu
    public void novaPrijava(ActionEvent actionEvent){
        }

    }