/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entity.CompteBancaire;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import session.CompteBancaireManager;

/**
 *
 * @author nicolas
 */
@Named(value = "compteDetailMBean")
@ViewScoped
public class CompteDetailMBean implements Serializable {

    @EJB
    private CompteBancaireManager compteBancaireManager;

    private Long idCompte;

    private int modifSolde;
    
    private String nom;
    
    private int montant;

    public int getModifSolde() {
        return modifSolde;
    }

    public void setModifSolde(int modifSolde) {
        this.modifSolde = modifSolde;
    }

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

    /**
     * Get the value of idCompte
     *
     * @return the value of idCompte
     */
    public Long getIdCompte() {
        return idCompte;
    }

    /**
     * Set the value of idCompte
     *
     * @param idCompte new value of idCompte
     */
    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    /**
     * Creates a new instance of CompteDetailMBean
     */
    public CompteDetailMBean() {
    }

    public void chargeCompte() {
        System.out.println("### CHARGE LE COMPTE N°" + idCompte);
        this.compte = compteBancaireManager.getCompte(idCompte);
    }

    public String update() {
        System.out.println("###UPDATE###");
        compte = compteBancaireManager.update(compte);
        return "index";
    }

    public String modifSolde() {
        System.out.println(" ### MODIF SOLDE DE  " + modifSolde + " ###");
        if (modifSolde <= 0) {
            System.out.println("### JE RETIRE CAR " + modifSolde + " QUI EST <= 0" + " ###");
            compte.retirer(modifSolde);
        }else
        {
            System.out.println("### JE DEPOSE CAR " + modifSolde + " QUI EST > 0" + " ###");
            compte.deposer(modifSolde);
        }
        
        compteBancaireManager.update(compte); //modification du compte
        return "index";
    }
    
    public String supprimer()
    {
        System.out.println("### SUPPRIMER COMPTE ###");
        compteBancaireManager.SupprimerCompte(compte);
        return "index";
    }
    
    public String creerCompte()
    {        
        System.out.println("CREATION D UN COMPTE = > " + this.nom + "  " + this.montant);
        compteBancaireManager.creerCompte(this.nom, this.montant);
        return "index";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    

}
