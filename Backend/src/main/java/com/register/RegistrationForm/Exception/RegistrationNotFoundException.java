package com.register.RegistrationForm.Exception;

public class RegistrationNotFoundException  extends RuntimeException{
    public RegistrationNotFoundException(String string){
        super("Could not found the user with id "+ string);
    }
    public RegistrationNotFoundException(Long id){
        super("Could not found the user with id "+ id);
    }
}