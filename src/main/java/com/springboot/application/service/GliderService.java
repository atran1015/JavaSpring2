package com.springboot.application.service;
import com.springboot.application.model.Glider;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GliderService {
    public List<Glider> getGliders() {
        return List.of(
            new Glider(
                "YX2000", 
                "Front", 
                "50 ft", 
                1, 
                30, 
                15, 
                "Beagle Husky"
            )
        );
    }
}
