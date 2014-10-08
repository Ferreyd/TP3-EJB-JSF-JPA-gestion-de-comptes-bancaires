/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 * Classe qui permet d ajouter des donnees a la construction de la BD
 * @author nicolas
 */
@Singleton
@LocalBean
@Startup
public class initBD {
    @EJB
    CompteBancaireManager g;
   
    @PostConstruct
    public void initBaseDeDonnees()
    {
        System.out.println("### INIT BD ###");
        g.creerCompteTest();
    }
}
