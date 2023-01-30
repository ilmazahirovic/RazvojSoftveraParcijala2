package ptf.rs.parcijala2.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import ptf.rs.parcijala2.Config;
import ptf.rs.parcijala2.models.Person;
import ptf.rs.parcijala2.repository.PersonRepository;
import ptf.rs.parcijala2.utils.Utils;
import ptf.rs.parcijala2.utils.Validators;

import java.net.URL;
import java.util.ResourceBundle;

public class FormaController implements Initializable {
    public TextField imeField;
    public TextField prezimeField;
    public TextField emailField;
    public TextArea komentarArea;
    public TextField telefonField;
    public ComboBox<Person.Tip> tipBox;
    public CheckBox resetCheck;

    private final PersonRepository personRepository;

    public FormaController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public FormaController() {
        this(Config.personRepository);
    }

    public void kreirajKorisnika(ActionEvent actionEvent) {
        try {
            Validators.checkRequiredField(imeField.getText(), "Ime");
            Validators.checkRequiredField(prezimeField.getText(), "Prezime");

            Validators.checkMaxLength(imeField.getText(), 30, "Ime");
            Validators.checkMaxLength(prezimeField.getText(), 50, "Prezime");
            Validators.checkMinLength(telefonField.getText(), 9, "Telefon");
            Validators.checkValidEmailAddress(emailField.getText(), "Email adresa");

            Person person = new Person();
            person.setIme(imeField.getText());
            person.setPrezime(prezimeField.getText());
            person.setEmail(emailField.getText());
            person.setTip(tipBox.getSelectionModel().getSelectedItem());
            person.setTelefon(telefonField.getText());
            person.setKomentar(komentarArea.getText());

            personRepository.addPerson(person);
            resetujPolja(null);
        } catch (Exception e) {
            Utils.displayAlert(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void resetujPolja(ActionEvent actionEvent) {
        imeField.setText("");
        prezimeField.setText("");
        emailField.setText("");
        komentarArea.setText("");
        telefonField.setText("");
        tipBox.getSelectionModel().selectFirst();
        resetCheck.setSelected(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        resetujPolja(null);
        tipBox.setItems(FXCollections.observableArrayList(Person.Tip.values()));
        tipBox.getSelectionModel().selectFirst();
    }
}
