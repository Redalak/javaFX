package appli.accueil;

import appli.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import model.Utilisateur;
import repository.UtilisateurRepository;

import java.io.IOException;

public class InscriptionController {
    private UtilisateurRepository UtilisateurRepository = new UtilisateurRepository();

    @FXML
    private TextField emailInscription;

    @FXML
    private Label erreurIn;

    @FXML
    private PasswordField mdpConfirmationInscription;

    @FXML
    private PasswordField mdpInscription;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    void btnInscription(ActionEvent event) throws IOException{
        UtilisateurRepository userepo = new UtilisateurRepository();
        Utilisateur user = userepo.recupererUserParEmail(emailInscription.getText());
        if (emailInscription.getText().equals(user.getEmail()){
            erreurIn.setText("email deja utilise");
        } else if (prenom.getText().isEmpty() || nom.getText().isEmpty() || mdpInscription.getText().isEmpty() || mdpConfirmationInscription.getText().isEmpty() || mdpInscription.getText().isEmpty() || emailInscription.getText().isEmpty()) {
            erreurIn.setText("Veuillez remplir tous les champs");
        } else if (!mdpConfirmationInscription.getText().equals(mdpInscription.getText())) {
            erreurIn.setText("Les mots de passe ne correspondent pas");
        } else if (mdpConfirmationInscription.getText().equals(mdpInscription.getText())) {
            Utilisateur user = new Utilisateur(nom.getText(), prenom.getText(), emailInscription.getText(), mdpInscription.getText(), "user");
            UtilisateurRepository.inscription(user);
            StartApplication.changeScene("accueil/Login", "Connexion");
        }


    }


    @FXML
    void btnRedirectionConnexion(ActionEvent event) throws IOException {
        StartApplication.changeScene("accueil/Login", "Connexion");
    }
}


