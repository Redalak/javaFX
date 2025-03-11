package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField email;

    @FXML
    private PasswordField motDePasse;

    @FXML
    void boutonMotDePasseOublie(ActionEvent event) {
        String email = email.getText();
        String motDePasse = motDePasse.getText();

    }

    @FXML
    void boutonPasDeCompte(ActionEvent event) {

    }

    @FXML
    void boutonValider(ActionEvent event) {

    }

}
