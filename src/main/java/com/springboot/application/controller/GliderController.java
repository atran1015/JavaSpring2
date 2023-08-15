package com.springboot.application.model;
import com.springboot.application.model.Glider;
import com.springboot.application.service.GliderService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path="api/v1/glider")
public class GliderController {

    private final GliderService gliderService;

    // Constructor
    @Autowired //instantiates the glider service first, then inject it into the constructor
    public GliderController(GliderService gliderService) {
        this.gliderService = gliderService;
    }

    @GetMapping
    public List<Glider> getGliders() {
        return gliderService.getGliders();
    }
}