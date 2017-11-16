package com.mycompany.Mini_projet;

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
@Table(name = "option")
public class option
{
    
    @Id
    private int id;

   
    private String name;
    @ManyToOne
    @JoinColumn(name = "Chambre_id", foreignKey = @ForeignKey(name = "Chambre_ID_FK"))
    private Chambre Chambre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Chambre getChambre() {
        return Chambre;
    }

    public void setChambre(Chambre Chambre) {
        this.Chambre = Chambre;
    }


    
    
    
}