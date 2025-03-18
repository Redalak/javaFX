package repository;

import database.Database;
import jdk.jshell.execution.Util;
import model.Utilisateur;
import model.UtilisateurListe;

import java.sql.*;
import java.util.ArrayList;

public class UtilisateurRepository {
    private Connection cnx;

    public UtilisateurRepository() {
        this.cnx = Database.getConnexion();
    }

    public void inscription(Utilisateur utilisateur) {
        String sql = "INSERT INTO utilisateur (nom, prenom, email, mdp) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.setString(5, utilisateur.getRole());
            stmt.executeUpdate();
            System.out.println("Utilisateur ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
    }


    public void recupererUserParEmail(String email) {
        String sql = "SELECT * FROM utilisateur WHERE email = ?";
        try {
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Utilisateur user = new Utilisateur(
                       rs.getInt("id_utilisateur"),
                       rs.getString("nom"),
                       rs.getString("prenom"),
                       rs.getString("email"),
                       rs.getString("mot_de_passe"),
                       rs.getString("role")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erreur");
        }
    }

    public Utilisateur connexion(Utilisateur user) {
        String sql = "SELECT * FROM utilisateur WHERE email = ? AND mot_de_passe = ?";
        try {
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getMdp());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Utilisateur userr= new Utilisateur(
                        rs.getInt("id_utilisateur"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("mot_de_passe"),
                        rs.getString("role")
                );

            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'utilisateur : " + e.getMessage());
        }
        return user;
    }



    public ArrayList<Utilisateur> getTousLesUtilisateurs()throws SQLException {
        String sql = "SELECT * FROM utilisateur";
            PreparedStatement stmt = cnx.prepareStatement(sql);
            ArrayList<Utilisateur> utilisateur = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Utilisateur user = new Utilisateur(

                rs.getInt("id_utilisateur"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("email"),
                rs.getString("mot_de_passe"),
                rs.getString("role"));
                 utilisateur.add(user);



        }

            return utilisateur;
    }


    public void supprimerUtilisateurParEmail(String email) throws SQLException {
        String sql = "DELETE FROM utilisateur WHERE email = ?";
        try {
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("erreur");
        }

    }

    public void mettreAJourUtilisateur(Utilisateur utilisateur) throws SQLException {
        String sql = "UPDATE utilisateurs SET nom = ?, prenom = ?, mdp = ?, role = ? WHERE email = ?";
        try{
            PreparedStatement stmt = cnx.prepareStatement(sql);
            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getPrenom());
            stmt.setString(3, utilisateur.getEmail());
            stmt.setString(4, utilisateur.getMdp());
            stmt.setString(5, utilisateur.getRole());
            stmt.setString(6, utilisateur.getEmail());
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.printf("Erreur : %s\n",e.getMessage());
        }

    }





    }




