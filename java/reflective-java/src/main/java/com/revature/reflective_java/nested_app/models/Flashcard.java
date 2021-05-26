package com.revature.reflective_java.nested_app.models;


import com.revature.reflective_java.nested_app.models.enums.Category;
import com.revature.reflective_java.nested_app.util.Entity;

@Entity
public class Flashcard {

    private int id;
    private String question;
    private String answer;
    private Category category;

    public Flashcard() {
        super();
    }

    public Flashcard(String question, String answer, Category category) {
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
