package com.example.todoapp.domain;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity(name = "Todo")
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Todo { // todo table과 관련이 있고 '@Id'
    @Id //primary key라는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //이 아이디는 자동 증가하는 값이다.(바로 위에 줄의 뜻 -> '@GeneratedValue')


    @NotNull
    private String todo;

    private String title;

    private String category;

    private boolean completed;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}