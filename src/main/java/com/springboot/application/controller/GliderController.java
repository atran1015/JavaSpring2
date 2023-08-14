package com.springboot.application.model;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GliderController {


    @GetMapping("/api/glider")

    @PostMapping("/api/glider")

    @Putmapping("api/glider/[id]")

    @DeleteMapping("api/glider/[id]")
}