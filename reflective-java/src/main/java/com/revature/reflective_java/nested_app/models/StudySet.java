package com.revature.reflective_java.nested_app.models;

import com.revature.reflective_java.nested_app.util.Entity;

import java.util.List;

@Entity
public class StudySet {

    private int id;
    private String name;
    private List<Flashcard> cards;

    public StudySet() {
        super();
    }

    public StudySet(String name, List<Flashcard> cards) {
        this.name = name;
        this.cards = cards;
    }

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

    public List<Flashcard> getCards() {
        return cards;
    }

    public void setCards(List<Flashcard> cards) {
        this.cards = cards;
    }

}
