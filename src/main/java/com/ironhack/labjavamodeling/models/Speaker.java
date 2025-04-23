package com.ironhack.labjavamodeling.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String presentationDuration;

    @ManyToMany(mappedBy = "speakers")
    private List<Conference> conferences;

    // Constructores
    public Speaker() {
    }

    public Speaker(String name, String presentationDuration) {
        this.name = name;
        this.presentationDuration = presentationDuration;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresentationDuration() {
        return presentationDuration;
    }

    public void setPresentationDuration(String presentationDuration) {
        this.presentationDuration = presentationDuration;
    }

    public List<Conference> getConferences() {
        return conferences;
    }

    public void setConferences(List<Conference> conferences) {
        this.conferences = conferences;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", presentationDuration='" + presentationDuration + '\'' +
                '}';
    }
}
