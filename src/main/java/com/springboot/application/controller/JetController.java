package com.springboot.application.model;
import com.springboot.application.model.Jet;
import com.springboot.application.service.JetService;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path="api/v1/jets")
public class JetController {

    private final JetService jetService;

    // Constructor
    @Autowired // Instantiates the glider service first, then inject it into the constructor
    public JetController(JetService jetService) {
        this.jetService = jetService;
    }

    // For GET method
    @GetMapping
    public List<Jet> getJets() {
        return jetService.getJets();
    }

    @GetMapping("{tailNumber}") // singleton resource - full access to url would be http://localhost:8080/api/v1/gliders/1abc
    public ResponseEntity<?> getOneJet (@PathVariable("tailNumber") String tailNumber) {
        try {
            jetService.getOneJet(tailNumber);
        } catch (NullPointerException e) { // Controller is handling error thrown by service
            return new ResponseEntity<>("Jet with this tail number, " + tailNumber + ", does not exist.  Not found", HttpStatus.NOT_FOUND);
        }
        // Returns a glider object
        return new ResponseEntity<>(jetService.getOneJet(tailNumber), HttpStatus.OK);
    }

    // For POST method
    @PostMapping
    public ResponseEntity<?> createJet(@RequestBody Jet jet) {
        try {
            jetService.createJet(jet.getTailNumber(), jet.getNumberOfWheels(), jet.getLength(), jet.getFuel());
        } catch (NullPointerException e) {
            return new ResponseEntity<>("Jet can't be created", HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>("Jet has been created", HttpStatus.CREATED);
        
    }

    // for DELETE method
    @DeleteMapping("{tailNumber}") // full access to url would be http://localhost:8080/api/v1/jets/1abc
    public ResponseEntity<String> deleteJet(@PathVariable("tailNumber") String tailNumber) {

        var isRemoved = jetService.deleteJet(tailNumber);
        // if jet is not deleted, do this:
        if (!isRemoved) {
            return new ResponseEntity<>("Jet with this tail number, " + tailNumber + ", does not exist.  Cannot delete.", HttpStatus.NOT_FOUND);
        }
        // else, do this:
        return new ResponseEntity<>("Jet with this tail number, " + tailNumber + ", has been deleted.", HttpStatus.OK);
    }

    // for UPDATE method
    @PutMapping("{tailNumber}") // full access to url would be http://localhost:8080/api/v1/jets/1abc
    public ResponseEntity<String> updateJet(@PathVariable("tailNumber") String tailNumber, @RequestBody Jet newJetDetails) {

        var jetExists = jetService.updateJet(tailNumber, newJetDetails);
        if (!jetExists) {
            return new ResponseEntity<>("Jet with this tail number, " + tailNumber + ", does not exist.  Cannot modify.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Jet with this tail number, " + tailNumber + ", has been modified", HttpStatus.OK);
    }


}