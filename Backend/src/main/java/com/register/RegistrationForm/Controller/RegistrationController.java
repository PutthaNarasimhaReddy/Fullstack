package com.register.RegistrationForm.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.RegistrationForm.Model.Registration;
import com.register.RegistrationForm.Service.RegistrationService;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin("http://localhost:3000")
public class RegistrationController {



    @Autowired
    private RegistrationService registrationService;

    // Create 
    @PostMapping
    public ResponseEntity<Registration> createRegistration(@Validated @RequestBody Registration registration) {
        return ResponseEntity.ok(registrationService.saveRegistration(registration));
    }
    //update
    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateRegistration(@PathVariable Long id,
        @RequestBody Registration registrationDetails) {
    Registration updatedRegistration = registrationService.updateRegistration(id, registrationDetails);
    return ResponseEntity.ok(updatedRegistration);
    }
    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Registration> getRegistrationById(@PathVariable Long id) {
        Optional<Registration> registration = registrationService.getRegistrationById(id);
        return registration.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
        registrationService.deleteRegistration(id);
        return ResponseEntity.noContent().build();
    }
}
