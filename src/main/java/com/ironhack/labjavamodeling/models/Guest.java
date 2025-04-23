package com.ironhack.labjavamodeling.models;

import jakarta.persistence.*;

@Entity
public class Guest {
    @Id
    private Long id;

    private String name;
    private String status; // Puede ser "ATTENDING", "NOT_ATTENDING", o "NO_RESPONSE"

    @ManyToMany(mappedBy = "guests")
    private List<Event> events;

    // Constructores
    public Guest() {
    }

    public Guest(String name, String status) {
        this.name = name;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
