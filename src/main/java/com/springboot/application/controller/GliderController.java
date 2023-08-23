package com.springboot.application.model;
import com.springboot.application.model.Glider;
import com.springboot.application.service.GliderService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
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
    @GetMapping("{tailNumber}") // singleton resource - full access to url would be http://localhost:8080/api/v1/gliders/1abc
    public ResponseEntity<?> getOneGlider (@PathVariable("tailNumber") String tailNumber) {
        try {
            gliderService.getOneGlider(tailNumber);
        } catch (NullPointerException e) { // Controller is handling error thrown by service
            // Returns string
            return new ResponseEntity<>("Glider with this tail number, " + tailNumber + ", does not exist.  Not found", HttpStatus.NOT_FOUND);
        }
        // Returns a glider object
        return new ResponseEntity<>(gliderService.getOneGlider(tailNumber), HttpStatus.OK);
    }


    // For POST method
    @PostMapping
    public ResponseEntity<String> createGlider(@RequestBody Glider glider) {
        try {
            gliderService.createGlider(glider.getTailNumber(), glider.getNumberOfWheels(), glider.getLength(), glider.getTowPlaneName());
        } catch (NullPointerException e) {
            return new ResponseEntity<>("Glider can't be created", HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>("Glider has been created", HttpStatus.CREATED);
    }

    // for DELETE method
    @DeleteMapping("{tailNumber}") // full access to url would be http://localhost:8080/api/v1/gliders/1abc
    public ResponseEntity<String> deleteGlider(@PathVariable("tailNumber") String tailNumber) {

        var isRemoved = gliderService.deleteGlider(tailNumber);
        // if glider is not deleted, do this:
        if (!isRemoved) {
            return new ResponseEntity<>("Glider with this tail number, " + tailNumber + ", does not exist.  Cannot delete.", HttpStatus.NOT_FOUND);
        }
        // else, do this:
        return new ResponseEntity<>("Glider with this tail number, " + tailNumber + ", has been deleted.", HttpStatus.OK);
    }

    // for UPDATE method
    @PutMapping("{tailNumber}") // full access to url would be http://localhost:8080/api/v1/gliders/1abc
    public ResponseEntity<String> updateGlider(@PathVariable("tailNumber") String tailNumber, @RequestBody Glider newGliderDetails) {
        try {
            var gliderExists = gliderService.updateGlider(tailNumber, newGliderDetails);

            if (!gliderExists) {
                return new ResponseEntity<>("Glider with this tail number, " + tailNumber + ", does not exist.  Cannot modify.", HttpStatus.BAD_REQUEST);
            }
        } catch (NullPointerException e) {
            return new ResponseEntity<>("Glider can't be modified", HttpStatus.BAD_REQUEST);
        }
        
        // Any bad data update would be handled by DefaultHandlerExceptionResolver
        return new ResponseEntity<>("Glider with this tail number, " + tailNumber + ", has been modified", HttpStatus.OK);
    }


}