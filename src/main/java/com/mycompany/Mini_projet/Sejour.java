package com.mycompany.Mini_projet;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Sejour")
public class Sejour
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
 int date_debut;
    int date_fin;

    @ManyToOne
    @JoinColumn(name = "Client_id", foreignKey = @ForeignKey(name = "CLIENT_ID_FK"))
    private Client Client;
    @ManyToOne
    @JoinColumn(name = "Chambre_id", foreignKey = @ForeignKey(name = "Chambre_ID_FK"))
    private Chambre Chambre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(int date_debut) {
        this.date_debut = date_debut;
    }

    public int getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(int date_fin) {
        this.date_fin = date_fin;
    }

    public Client getClient() {
        return Client;
    }

    public void setClient(Client Client) {
        this.Client = Client;
    }

    public Chambre getChambre() {
        return Chambre;
    }

    public void setChambre(Chambre Chambre) {
        this.Chambre = Chambre;
    }

   
    
}