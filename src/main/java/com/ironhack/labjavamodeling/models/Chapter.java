package com.ironhack.labjavamodeling.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Chapter {
    @Id
    private Long id;

    private String name;
    private String district;

    @OneToOne
    private Member president;

    @OneToMany(mappedBy = "chapter")
    private List<Member> members;

    // Constructores
    public Chapter() {
    }

    public Chapter(String name, String district, Member president, List<Member> members) {
        this.name = name;
        this.district = district;
        this.president = president;
        this.members = members;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Member getPresident() {
        return president;
    }

    public void setPresident(Member president) {
        this.president = president;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    // Método para agregar un miembro al capítulo
    public void addMember(Member member) {
        this.members.add(member);
        member.setChapter(this);
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", president=" + (president != null ? president.getName() : "null") +
                ", members=" + (members != null ? members.size() : 0) +
                '}';
    }
}