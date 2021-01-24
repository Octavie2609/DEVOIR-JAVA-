/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.List;
import models.Classe;

/**
 *
 * @author HP
 */
public class DaoClasse {
    private final String SQL_INSERT="INSERT INTO `classe` ( `Libelle`, `nbre_etudiant`) VALUES ( ?,?);";
    private final String SQL_SELECT_ALL="select * from classe"; 
    List<Classe> findAll;

    public DaoClasse() {
        this.lClasse = new Arraylist <> ();
    }
    
    public int insert (Classe classe){
        int nbreLigne=0;
        //insertion
        return nbreLigne;
    }
List<Classe> findAll () {

    /**
     *
     */
    public List<Classe>lClasse;

    private static class Arraylist {

        public Arraylist() {
        }
    }

}

