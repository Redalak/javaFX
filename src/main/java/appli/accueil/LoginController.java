package appli.accueil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button boutonInvisible;


    @FXML
    private TextField email;

    @FXML
    private PasswordField motDePasse;

    @FXML
    void boutonValider(ActionEvent event) {
        String emaill = email.getText();
        String motDePassee = motDePasse.getText();
        if (emaill.equals("reda@a")&& motDePassee.equals("123")) {
            System.out.println("Vous etes connecte");
        }else System.out.println("mot de passe incorect");


    }

    @FXML
    void boutonMotDePasseOublie(ActionEvent event) {
        boutonInvisible.setVisible(false);
        String  emaill = email.getText();
        String motDePassee = motDePasse.getText();
        if (email.equals("reda@a")&& motDePasse.equals("123")) {
            System.out.println("");
        }//else boutonInvisible.setVisible(true);


    }

    @FXML
    void boutonPasDeCompte(ActionEvent event) {


    }



}
