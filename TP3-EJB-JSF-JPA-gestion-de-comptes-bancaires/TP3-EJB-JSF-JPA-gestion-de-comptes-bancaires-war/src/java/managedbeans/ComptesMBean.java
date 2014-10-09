/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entity.CompteBancaire;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.CompteBancaireManager;

/**
 *
 * @author nicolas
 */
@Named(value = "comptesMBean")
@ViewScoped
public class ComptesMBean implements Serializable {

    @EJB
    private CompteBancaireManager compteBancaireManager;

    List<CompteBancaire> comptes;

    /**
     * Creates a new instance of ComptesMBean
     */
    private CompteBancaire compte;

    /**
     * Get the value of compte
     *
     * @return the value of compte
     */
    public CompteBancaire getCompte() {
        return compte;
    }

    /**
     * Set the value of compte
     *
     * @param compte new value of compte
     */
    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public ComptesMBean() {
    }

    public List<CompteBancaire> getComptes() {
        System.out.println("### DANS GET COMPTES ###");
        comptes = compteBancaireManager.getAllComptes();
        return comptes;
    }

    public List<CompteBancaire> getComptes(int start, int nombreDeComptes) {
        System.out.println("### DANS GET COMPTES ###");
        comptes = compteBancaireManager.getAllComptes();
        return comptes;
    }

    public CompteBancaireManager getCompteBancaireManager() {
        return compteBancaireManager;
    }

    public void setComptes(List<CompteBancaire> comptes) {
        this.comptes = comptes;
    }

    public void setCompteBancaireManager(CompteBancaireManager compteBancaireManager) {
        this.compteBancaireManager = compteBancaireManager;
    }

    public String update() {
        System.out.println("###UPDATE###");
        compte = compteBancaireManager.update(compte);
        return "index";
    }

    public String creerCompte(CompteBancaire compteBancaire) {
        System.out.println("### CREATION COMPTE ###");
        compteBancaireManager.creerCompte(compteBancaire);
        return "index";
    }

}
