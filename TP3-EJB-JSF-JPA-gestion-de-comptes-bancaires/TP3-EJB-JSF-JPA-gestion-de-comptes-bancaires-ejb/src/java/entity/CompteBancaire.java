/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author nicolas
 */
@Entity
public class CompteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private long solde;

    public CompteBancaire() {
    }

    public CompteBancaire(String nom, long solde) {
        this.nom = nom;
        this.solde = solde;
    }

    /**
     * Get the value of nom
     *
     * @return the value of nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set the value of nom
     *
     * @param nom new value of nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Get the value of montant
     *
     * @return the value of montant
     */
    public long getMontant() {
        return solde;
    }

    /**
     * Set the value of montant
     *
     * @param montant new value of montant
     */
    public void setMontant(long montant) {
        this.solde = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp3.CompteBancaire[ id=" + id + " ]";
    }

    public void deposer(int montant) {
        System.out.println("### DEPOSER  = " + montant + "###");
        System.out.println("### ANCIEN SOLDE = " + solde + " ###");
        solde += montant;
        System.out.println("### NOUVEAU SOLDE = " + solde + " ###\n\n");
    }

    public int retirer(int montant) {
        System.out.println("### RETIRER  = " + montant + "###");
        System.out.println("### ANCIEN SOLDE = " + solde + " ###");
        if (montant < solde) {
            solde += montant;
            System.out.println("### NOUVEAU SOLDE = " + solde + " ###\n\n");
            return montant;
        } else {
            return 0;
        }

    }

    public int retirerTransfert(int montant) {
        System.out.println("### RETIRER  = " + montant + "###");
        System.out.println("### ANCIEN SOLDE = " + solde + " ###");
        if (montant < solde) {
            solde += montant;
            System.out.println("### NOUVEAU SOLDE = " + solde + " ###\n\n");
            return montant;
        } else {
            return 0;
        }

    }
}
