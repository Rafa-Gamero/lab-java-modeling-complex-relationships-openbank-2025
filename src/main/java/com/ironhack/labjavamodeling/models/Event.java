package com.ironhack.labjavamodeling.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Event {
    @Id
    private Long id;

    private LocalDate date;
    private String duration;
    private String location;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "event_guest",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<Guest> guests;

    // Constructores
    public Event() {
    }

    public Event(LocalDate date, String duration, String location, String title, List<Guest> guests) {
        this.date = date;
        this.duration = duration;
        this.location = location;
        this.title = title;
        this.guests = guests;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    // Método para agregar un invitado al evento
    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + date +
                ", duration='" + duration + '\'' +
                ", location='" + location + '\'' +
                ", title='" + title + '\'' +
                ", guests=" + (guests != null ? guests.size() : 0) +
                '}';
    }
}