package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;
import model.Utilisateur;
import repository.UtilisateurRepository;


import java.io.IOException;

public class LoginController {

    @FXML
    private TextField emailCo;

    @FXML
    private Label erreurCo;

    @FXML
    private PasswordField mdpCo;
    @FXML
    private Hyperlink redirection;

    @FXML


    void btnConnexion(ActionEvent event) {
        UtilisateurRepository userRepo = new UtilisateurRepository();
        Utilisateur info = userRepo.recupererUserParEmail(emailCo.getText()); // pour recup les info d'un select tu donnes le nom du model(souvent table) et = puis tu met le nom de la methode
        if(info.getMdp().equals(mdpCo.getText())) {
            System.out.println("vous etes connecte");
            System.out.println(info.getNom());
            System.out.println(info.getPrenom());
            System.out.println(info.getEmail());
            System.out.println(info.getRole());
        }
        String email = emailCo.getText();
        String mdp = mdpCo.getText();
        if(email.isEmpty() || mdp.isEmpty()) {
            erreurCo.setText("Veuillez remplir tous les champs");
        }




    }

    @FXML
    void btnRedirectionInscription(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Inscription", "Inscription");
    }

}
