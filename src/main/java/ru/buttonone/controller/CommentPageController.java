package ru.buttonone.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.buttonone.service.CommentService;

@Controller
@AllArgsConstructor
public class CommentPageController {
    private final CommentService commentService;

    @GetMapping("/books/{id}/comments")
    public String listPage(@PathVariable("id") String id, Model model) {
        return "comments-list";
    }


    @GetMapping("/books/{id}/comments/add")
    public String addPage(@PathVariable("id") String id, Model model) {
        return "comments-add";
    }
}
