package com.example.todoapp.repository;

import com.example.todoapp.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long> /*<엔티티 클래스, 엔티티 클래스가 갖고있는 id 타입>*/{//todo라는 entity를 객체를 이용해서 CRUD가 가능하게 해주는 인터페이스
}
