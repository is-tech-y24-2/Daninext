package ru.itmo.data.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "cats")
public class Cat {
    public enum color_type {
        black, white, grey, brown
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "breed")
    private String breed;

    @ManyToMany
    @JoinTable (
            name = "cat_friends",
            joinColumns = @JoinColumn(name = "cat_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<Cat> friends;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private color_type color;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Cat() { }

    public Cat(String name, Date birthday, String breed, color_type color, Owner owner) {
        this.name = name;
        this.birthday = birthday;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBreed() {
        return breed;
    }

    public color_type getColor() {
        return color;
    }

    public List<Cat> getFriends() {
        return Collections.unmodifiableList(friends);
    }

    public Owner getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}