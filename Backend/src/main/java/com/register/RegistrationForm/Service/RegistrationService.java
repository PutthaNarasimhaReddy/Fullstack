package com.register.RegistrationForm.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.RegistrationForm.Exception.RegistrationNotFoundException;
import com.register.RegistrationForm.Model.Registration;
import com.register.RegistrationForm.Repository.RegistrationRepository;


@Service
public class RegistrationService {
@Autowired
    private RegistrationRepository registrationRepository;

    // Create or Update a Registration
    public Registration saveRegistration(Registration registration) {
        return registrationRepository.save(registration);
    }
    public Registration updateRegistration(Long id, Registration registrationDetails) {
        Optional<Registration> registrationOpt = registrationRepository.findById(id);
        if (registrationOpt.isPresent()) {
            Registration registration = registrationOpt.get();
            registration.setName(registrationDetails.getName());
            registration.setEmail(registrationDetails.getEmail());
            registration.setDateOfBirth(registrationDetails.getDateOfBirth());
            return registrationRepository.save(registration);
        } else {
            throw new RegistrationNotFoundException("Registration not found for this id: " + id);
        }
    }

    // Read Registration by ID
    public Optional<Registration> getRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }

    // Delete a Registration
    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }
}
