package com.example.todoapp.controller;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository toDoRepository;
    @GetMapping("/")
    public String index(Model model){
        List<Todo> todos = toDoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        //DB에 저장
        Todo toDo = new Todo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return "redirect:/"; //"/"로 자동으로 이동하라
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        toDoRepository.deleteById(id);
        return "redirect:/";
    }



}
