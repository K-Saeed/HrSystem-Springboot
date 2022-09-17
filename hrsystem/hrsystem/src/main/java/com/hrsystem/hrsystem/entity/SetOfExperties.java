package com.hrsystem.hrsystem.entity;

import javax.persistence.*;

@Entity
public class SetOfExperties {
    @Id
    @Column(name = "id")@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jopTitle ;
    private String lastJop ;
    private String eXperties ;

    public SetOfExperties() {
    }

    public SetOfExperties(String jopTitle, String lastJop, String eXperties) {
        this.jopTitle = jopTitle;
        this.lastJop = lastJop;
        this.eXperties = eXperties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJopTitle() {
        return jopTitle;
    }

    public void setJopTitle(String jopTitle) {
        this.jopTitle = jopTitle;
    }

    public String getLastJop() {
        return lastJop;
    }

    public void setLastJop(String lastJop) {
        this.lastJop = lastJop;
    }

    public String geteXperties() {
        return eXperties;
    }

    public void seteXperties(String eXperties) {
        this.eXperties = eXperties;
    }
}
