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

    private int idCompte;

    private CompteBancaire TransfertCompte1;
    private CompteBancaire TransfertCompte2;

    @EJB
    private CompteBancaireManager compteBancaireManager;

    List<CompteBancaire> comptes;

    /**
     * Creates a new instance of ComptesMBean
     */
    private CompteBancaire compte;

    private int montantTransfert;

    public CompteBancaire getTransfertCompte1() {
        return TransfertCompte1;
    }

    public void setTransfertCompte1(CompteBancaire TransfertCompte1) {
        this.TransfertCompte1 = TransfertCompte1;
    }

    public CompteBancaire getTransfertCompte2() {
        return TransfertCompte2;
    }

    public void setTransfertCompte2(CompteBancaire TransfertCompte2) {
        this.TransfertCompte2 = TransfertCompte2;
    }

    public int getMontantTransfert() {
        return montantTransfert;
    }

    public void setMontantTransfert(int montantTransfert) {
        this.montantTransfert = montantTransfert;
    }

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

    public String creerCompte(CompteBancaire compteBancaire) {
        System.out.println("### CREATION COMPTE ###");
        compteBancaireManager.creerCompte(compteBancaire);
        return "index";
    }

    public String afficheDetails(Long id) {
        return "detail?idCompte=" + id;
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String transfert() {
        System.out.println("### TRANSFERT DE " + TransfertCompte1.toString() + " A " + TransfertCompte2.toString() + " POUR " + montantTransfert);
        compteBancaireManager.transfert(this.TransfertCompte1.getId(), this.TransfertCompte2.getId(), this.montantTransfert);
        return "index";
    }

}
