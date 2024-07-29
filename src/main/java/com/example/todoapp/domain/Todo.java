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
    @Column
    private String todo;

    @Column
    private String title;

    @Column
    private String category;

    @Column
    private boolean completed;

    @Column
    private Long category_id;

}