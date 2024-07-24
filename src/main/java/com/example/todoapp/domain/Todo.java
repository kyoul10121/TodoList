package com.example.todoapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity(name = "Todo")
@Table(name = "todo")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
// todo table과 관련이 있고 '@Id'
public class Todo {
    @Id //primary key라는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //이 아이디는 자동 증가하는 값이다.(바로 위에 줄의 뜻 -> '@GeneratedValue')

    @NotNull
    private String todo;

    private String title;
    private boolean completed;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}
