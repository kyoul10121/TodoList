package com.example.todoapp.controller;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Todo> todos = todoService.findAll();
        List<String> categories = todoService.findAllCategories();
        model.addAttribute("todos", todos);
        model.addAttribute("categories", categories);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo, @RequestParam("title") String title, @RequestParam("category") String category){
        //DB에 저장
        Todo newTodo = new Todo();
        newTodo.setTodo(todo);
        newTodo.setTitle(title);
        newTodo.setCategory(category);
        newTodo.setCompleted(false);
        todoService.save(newTodo);
        return "redirect:/"; //"/"로 자동으로 이동하라
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model) {
        Todo todo = todoService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
        model.addAttribute("todo", todo);
        return "editTodo";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, @RequestParam("todo") String todo, @RequestParam("title") String title,@RequestParam("category") String category) {
        Todo existingTodo = todoService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
        existingTodo.setTodo(todo);
        existingTodo.setTitle(title);
        existingTodo.setCategory(category);
        todoService.save(existingTodo);
        return "redirect:/";
    }

    @PostMapping("/complete/{id}")
    public String completeTodo(@PathVariable Long id) {
        Todo existingTodo = todoService.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
        existingTodo.setCompleted(!existingTodo.isCompleted());  // 완료 상태 토글
        todoService.save(existingTodo);
        return "redirect:/";
    }
}

//package com.example.todoapp.controller;
//
//import com.example.todoapp.domain.Todo;
//import com.example.todoapp.repository.TodoRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequiredArgsConstructor
//public class TodoController {
//    private final TodoRepository toDoRepository;
//    @GetMapping("/")
//    public String index(Model model){
//        List<Todo> todos = toDoRepository.findAll();
//        model.addAttribute("todos", todos);
//        return "todos";
//    }
//
//    @PostMapping("/addTodo")
//    public String addTodo(@RequestParam("todo") String todo, @RequestParam("title") String title, @RequestParam("category") String category){
//        //DB에 저장
//        Todo toDo = new Todo();
//        toDo.setTodo(todo);
//        toDo.setTitle(title);
//        toDo.setCategory(category);
//        toDo.setCompleted(false);
//        toDoRepository.save(toDo);
//        return "redirect:/"; //"/"로 자동으로 이동하라
//    }
//
//    // 삭제
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable Long id) {
//        toDoRepository.deleteById(id);
//        return "redirect:/";
//    }
//    // 수정
//    @GetMapping("/edit/{id}")
//    public String editTodoForm(@PathVariable Long id, Model model) {
//        Todo todo = toDoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
//        model.addAttribute("todo", todo);
//        return "editTodo";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateTodo(@PathVariable Long id, @RequestParam("todo") String todo, @RequestParam("title") String title) {
//        Todo toDo = toDoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
//        toDo.setTodo(todo);
//        toDo.setTitle(title);
//        toDoRepository.save(toDo);
//        return "redirect:/";
//    }
//    // 완료 처리
//    @PostMapping("/complete/{id}")
//    public String completeTodo(@PathVariable Long id) {
//        Todo toDo = toDoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo Id:" + id));
//        toDo.setCompleted(!toDo.isCompleted());  // 완료 상태 토글
//        toDoRepository.save(toDo);
//        return "redirect:/";
//    }
//
//}
//
