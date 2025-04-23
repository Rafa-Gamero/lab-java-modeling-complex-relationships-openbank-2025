package com.ironhack.labjavamodeling.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {
    @Id
    private Long id;

    private String name;
    private String status; // Puede ser "ACTIVE" o "LAPSED"
    private LocalDate renewalDate;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    private Chapter chapter;

    // Constructores
    public Member() {
    }

    public Member(String name, String status, LocalDate renewalDate) {
        this.name = name;
        this.status = status;
        this.renewalDate = renewalDate;
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

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", renewalDate=" + renewalDate +
                '}';
    }
}
