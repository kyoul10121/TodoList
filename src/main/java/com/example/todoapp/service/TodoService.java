//package com.example.todoapp.service;
//
//import com.example.todoapp.domain.Todo;
//import com.example.todoapp.repository.TodoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TodoService {
//    @Autowired
//    private TodoRepository todoRepository;
//
//    public List<Todo> findAll() {
//        return todoRepository.findAll();
//    }
//
//    public Optional<Todo> findById(Long id) {
//        return todoRepository.findById(id);
//    }
//
//    public Todo save(Todo todo) {
//        return todoRepository.save(todo);
//    }
//
//
////    public void delete(Todo todo) {
////        todoRepository.delete(todo);
////    }
//}

package com.example.todoapp.service;

import com.example.todoapp.domain.Category;
import com.example.todoapp.domain.Todo;
import com.example.todoapp.repository.CategoryRepository;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }
    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public List<String> findAllCategories() {
        return categoryRepository.findAll().stream()
                .map(Category::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }

    public Optional<Category> findByIdCategory(Long id) {
        return categoryRepository.findById(id);
    }
}
