/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import entity.CompteBancaire;
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
public class ComptesMBean {
    @EJB
    private CompteBancaireManager compteBancaireManager;
    
    List<CompteBancaire> comptes;
    
    /**
     * Creates a new instance of ComptesMBean
     */
    public ComptesMBean() {
    }
    
    
    
    
    
    
}