/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionetudiant;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import metier.Service;
import model.Classe;
import model.Etudiant;

/**
 * FXML Controller class
 *
 * @author Fatima
 */
public class VclasseController implements Initializable {

    /*mes attributs
    
    */
    
    private Service metier;
    //observable liste
    ObservableList<Classe>obClasse;
    ObservableList<Etudiant>obEtudiants;
    
    
    
    
    
    
    
    
    
    
    @FXML
    private Button handleCreerClasse;
    @FXML
     private TextField txtLibelle;
    @FXML
    private TextField txtNbre;
    
    @FXML
    private TableView<Classe> tblvClasse;
    @FXML
    private TableColumn<Classe,String> tblcId;
    @FXML
    private TableColumn<Classe,String> tblcLibelle;
    @FXML
    private TableColumn<Classe,String> tblcNbre;
    @FXML
    private TableView<Etudiant> tblvEtudiant;
    @FXML
    private TableColumn<Etudiant, String> tblcEtuId;
    @FXML
    private TableColumn<Etudiant, String> tblcNomPrenom;
    @FXML
    private TableColumn<Etudiant, String> tblcTuteur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        metier=new Service();
        obClasse=FXCollections.observableArrayList(
                metier.listerClasse()
                
                
         );   
    
                //construction des cellules de table
                 tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
     tblcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
      tblcNbre.setCellValueFactory(new PropertyValueFactory<>("nbre"));
   
    }
    @FXML
    private void handleCreerClasse(ActionEvent event) {
         String libelle=txtLibelle.getText();
        int nbre=Integer.parseInt(txtNbre.getText());
        Classe cl=new Classe(libelle, nbre);
        if(metier.creerClasse(cl)){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Classe ajoutée avec succés");
            alert.setTitle("Information");
            alert.show();
            //mettre a jour la table View
            obClasse.add(cl);
            
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Erreur Insertion");
            alert.setTitle("Erreur");
            alert.show();
        }
    }

    @FXML
    private void handleShowEtudiant(MouseEvent event) {
        Classe classeSelected=tblvClasse.getSelectionModel().getSelectedItem();
        obEtudiants=FXCollections.
                observableArrayList(
                metier.listerEtudiantParClasse(classeSelected)
                );
        
        tblcId.setCellValueFactory(new PropertyValueFactory<>("id"));
     tblcNomPrenom.setCellValueFactory(new PropertyValueFactory<>("nomComplet"));
      tblcTuteur.setCellValueFactory(new PropertyValueFactory<>("tuteur"));
      tblvEtudiant.setItems(obEtudiants);
        
    }
    
}
