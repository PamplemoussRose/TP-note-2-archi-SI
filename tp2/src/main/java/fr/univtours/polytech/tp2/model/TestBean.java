package fr.univtours.polytech.tp2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class TestBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String TITLE;
    private Integer NOTE;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTITLE() {
        return TITLE;
    }
    public void setTITLE(String tITLE) {
        TITLE = tITLE;
    }
    public Integer getNOTE() {
        return NOTE;
    }
    public void setNOTE(Integer nOTE) {
        NOTE = nOTE;
    }

    
}
