package com.springboot.application.model;
import com.springboot.application.model.Glider;
import com.springboot.application.service.GliderService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path="api/v1/gliders")
public class GliderController {

    private final GliderService gliderService;

    // Constructor
    @Autowired //instantiates the glider service first, then inject it into the constructor
    public GliderController(GliderService gliderService) {
        this.gliderService = gliderService;
    }

    // For GET method
    @GetMapping
    public List<Glider> getGliders() {
        return gliderService.getGliders();
    }

    // For POST method
    @PostMapping
    public void createGlider(@RequestBody Glider glider) {
        gliderService.createGlider(glider.getTailNumber(), glider.getCockpitLocation(), glider.getWingsSpan(), glider.getNumberOfWheels(), glider.getLength(), glider.getWidth(), glider.getTowPlaneName());
    }

    // TODO: currently not working
    @DeleteMapping(path = "{tailNumber}")
    public void deleteGlider(@PathVariable("tailNumber") String tailNumber) {
        gliderService.deleteGlider(tailNumber);
    }
}