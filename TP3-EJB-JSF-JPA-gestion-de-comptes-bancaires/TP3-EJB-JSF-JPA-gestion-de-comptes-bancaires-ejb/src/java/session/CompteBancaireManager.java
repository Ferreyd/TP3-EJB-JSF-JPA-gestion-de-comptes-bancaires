/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.CompteBancaire;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author nicolas
 */
@Stateless
@LocalBean
public class CompteBancaireManager {

    @PersistenceContext(unitName = "TP3-EJB-JSF-JPA-gestion-de-comptes-bancaires-ejbPU")
    private EntityManager em;

    public void creerCompteTest() {
        creerCompte(new CompteBancaire("John Lennon", 150000));
        creerCompte(new CompteBancaire("Paul McCartney", 950000));
        creerCompte(new CompteBancaire("Ringo Starr", 20000));
        creerCompte(new CompteBancaire("Georges Harrisson", 100000));
    }

    /**
     * Ajoute un compte bancaire dans la base de données
     *
     * @param compteBancaire le compte bancaire à ajouter
     */
    public void creerCompte(CompteBancaire compteBancaire) {
        em.persist(compteBancaire);
    }

    /**
     * Ajoute un compte bancaire dans la base de données
     *
     * @param nom Nom du titulaire du compte
     * @param montant Montant à mettre sur le compte
     */
    public void creerCompte(String nom, long montant) {
        em.persist(new CompteBancaire(nom, montant));
    }

    /**
     * Retourne une <List> de tout les comptes bancaires
     *
     * @return une <List> de tout les comptes bancaires
     */
    public List<CompteBancaire> getAllComptes() {
        Query query = em.createQuery("select c from CompteBancaire c");
        return query.getResultList();
    }

    public CompteBancaire getCompte(long id) {
        return em.find(CompteBancaire.class, id);
    }

    public CompteBancaire update(CompteBancaire compteBancaire) {
        return em.merge(compteBancaire);
    }
    
    public void SupprimerCompte(CompteBancaire compteBancaire)
    {
        
        em.remove(em.find(CompteBancaire.class, compteBancaire.getId()));
    }
    
    public void transfert(Long id1, Long id2, int montant)
    {
        CompteBancaire cb1 = em.find(CompteBancaire.class, id1);
        CompteBancaire cb2 = em.find(CompteBancaire.class, id2);
        cb1.retirerTransfert(montant);
        cb2.deposer(montant);
    }
}
