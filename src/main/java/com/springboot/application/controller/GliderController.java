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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path="api/v1/gliders") // gliders is a collection resource
public class GliderController {

    private final GliderService gliderService;

    // Constructor
    @Autowired // Instantiates the glider service first, then inject it into the constructor
    public GliderController(GliderService gliderService) {
        this.gliderService = gliderService;
    }

    // For GET method - retrieve ALL
    @GetMapping
    public List<Glider> getGliders() {
        return gliderService.getGliders();
    }

    // For GET method - retrieve ONE
    @GetMapping("{tailNumber}") //singleton resource - full access to url would be http://localhost:8080/api/v1/gliders/1abc
    public ResponseEntity<?> getOneGlider (@PathVariable("tailNumber") String tailNumber) {
        try {
            gliderService.getOneGlider(tailNumber);
        } catch (NullPointerException e) { // Controller is handling error thrown by service
            return new ResponseEntity<>("Glider with this tail number, " + tailNumber + ", does not exist.  Not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gliderService.getOneGlider(tailNumber), HttpStatus.OK);
    }


    // For POST method
    @PostMapping // TODO: what happens if a Jet object is being passed in?
    // TODO: what happens if I put in some extra param in the request body?
    // TODO: Create something with bad data
    //use try and catch statements in POST
    public void createGlider(@RequestBody Glider glider) {
        gliderService.createGlider(glider.getTailNumber(), glider.getNumberOfWheels(), glider.getLength(), glider.getTowPlaneName());
    }

    // for DELETE method
    @DeleteMapping("{tailNumber}") // full access to url would be http://localhost:8080/api/v1/gliders/1abc
    public ResponseEntity<String> deleteGlider(@PathVariable("tailNumber") String tailNumber) {

        var isRemoved = gliderService.deleteGlider(tailNumber);
        // if glider is not deleted, do this:
        if (!isRemoved) {
            return new ResponseEntity<>("Glider with this tail number, " + tailNumber + ", does not exist.  Can't delete.", HttpStatus.NOT_FOUND);
        }
        // else, do this:
        return new ResponseEntity<>(tailNumber, HttpStatus.OK);
    }

    // for UPDATE method
    // TODO: Update something with bad data
    @PutMapping("{tailNumber}") // full access to url would be http://localhost:8080/api/v1/gliders/1abc
    public ResponseEntity<String> updateGlider(@PathVariable("tailNumber") String tailNumber, @RequestBody Glider newGliderDetails) {
        gliderService.updateGlider(tailNumber, newGliderDetails);
        return ResponseEntity.ok("in progress");
    }


}