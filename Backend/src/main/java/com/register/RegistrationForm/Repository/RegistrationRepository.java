/**
 * 
 */
package com.register.RegistrationForm.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.register.RegistrationForm.Model.Registration;

/**
 * 
 */
public interface RegistrationRepository extends JpaRepository<Registration,Long>{

}
