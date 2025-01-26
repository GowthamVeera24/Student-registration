package com.example.student.service;
import com.example.student.Repository.Jpstu;
import com.example.student.model.Login;
import com.example.student.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class
Studentservice {

    @Autowired
    private Jpstu jpa;


    public Registration addData(Registration regi) {
        return jpa.save(regi);
    }


    public List<Registration> getalldata() {

        return this.jpa.findAll();
    }

    public Optional<Registration> getid(String id) {

        return this.jpa.findById(id);
    }

    public Registration deletedata(String id) {
        Optional<Registration> existingregi = jpa.findById(id);
        if (existingregi.isPresent()) {
            jpa.deleteById(id);
            return existingregi.get(); // Return the deleted record
        } else {
            throw new RuntimeException("Record not found with ID: " + id);
        }
    }

    public Registration updateData(String id, Registration updatedRegi) {
        Optional<Registration> existingRegi = jpa.findById(id);
        if (existingRegi.isPresent()) {
            Registration regi = existingRegi.get();
            regi.setName(updatedRegi.getName()); // Update name
            regi.setAddress(updatedRegi.getAddress()); // Update address
            regi.setGmail(updatedRegi.getGmail()); // Update Gmail
            regi.setPassword(updatedRegi.getPassword()); // Update password
            return jpa.save(regi); // Save updated record
        } else {
            throw new RuntimeException("Record not found with ID: " + id);
        }
    }

    public Registration loginint(Login loginRequest) {
        String gmail = loginRequest.getGmail(); // Get Gmail from login request
        String enteredPassword = loginRequest.getPassword(); // Get password from login request

        // Find the user by Gmail
        Registration exist = jpa.findByGmail(gmail); // Use the correct field for finding

        if (exist == null) {
            throw new RuntimeException("User not found with email: " + gmail);
        }

        // Check if password matches
        if (!exist.getPassword().equals(enteredPassword)) {
            throw new RuntimeException("Invalid password for email: " + gmail);
        }

        return exist; // Return the existing user if login is successful
    }

}