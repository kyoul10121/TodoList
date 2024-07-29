package com.example.todoapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Category")
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Category {
    @Id //primary key라는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //이 아이디는 자동 증가하는 값이다.(바로 위에 줄의 뜻 -> '@GeneratedValue')

    @Column
    private String category;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
}