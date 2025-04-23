package com.ironhack.labjavamodeling.models;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CONFERENCE")
public class Conference extends Event {
    @ManyToMany
    @JoinTable(
            name = "conference_speaker",
            joinColumns = @JoinColumn(name = "conference_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id")
    )
    private List<Speaker> speakers;

    // Constructores
    public Conference() {
    }

    public Conference(LocalDate date, String duration, String location, String title, List<Guest> guests, List<Speaker> speakers) {
        super(date, duration, location, title, guests);
        this.speakers = speakers;
    }

    // Getters y setters
    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    // Método para agregar un ponente a la conferencia
    public void addSpeaker(Speaker speaker) {
        this.speakers.add(speaker);
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + getId() +
                ", date=" + getDate() +
                ", duration='" + getDuration() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", guests=" + (getGuests() != null ? getGuests().size() : 0) +
                ", speakers=" + (speakers != null ? speakers.size() : 0) +
                '}';
    }
}
