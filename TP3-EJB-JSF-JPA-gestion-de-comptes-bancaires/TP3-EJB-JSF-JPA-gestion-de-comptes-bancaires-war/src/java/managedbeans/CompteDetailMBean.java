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
public class CompteDetailMBean implements Serializable{

    @EJB
    private CompteBancaireManager compteBancaireManager;

    private Long idCompte;

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
    
    

}
