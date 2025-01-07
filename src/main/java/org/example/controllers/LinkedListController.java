package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.services.LinkedListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/linkedlist")
@RequiredArgsConstructor
public class LinkedListController {

    private final LinkedListService linkedListService;

    @GetMapping("/initialize")
    public String initializeAndDisplayList() {
        linkedListService.initializeAndManipulateList("text.txt");
        return linkedListService.display();
    }
}