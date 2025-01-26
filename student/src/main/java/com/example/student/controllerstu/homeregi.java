package com.example.student.controllerstu;

import com.example.student.model.Login;
import com.example.student.service.Studentservice;
import com.example.student.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/homepage")
public class homeregi {

@Autowired
Studentservice studentservice;
    @PostMapping("/registration")
    public Registration addValues(@RequestBody Registration regi) {

        return studentservice.addData(regi);
    }


    @GetMapping("/getallrecords")
    public List<Registration> getdata() {
        return this.studentservice.getalldata();
    }


    @GetMapping("/gettrecord/{id}")
    public Optional<Registration> getdetails(@PathVariable(value = "id") String id) {
        return this.studentservice.getid(id);
    }

    @PutMapping("updated/{id}")
    public Registration updaterecord(@PathVariable(value = "id") String id, @RequestBody Registration updatedRegi) {
        return studentservice.updateData(id, updatedRegi);
    }

    @DeleteMapping("delete/{id}")
    public Registration deleterecord(@PathVariable(value="id")String id){
        return  studentservice.deletedata(id);
    }


    @PostMapping("/login")
    public Registration logininto(@RequestBody Login loginRequest) {
        return studentservice.loginint(loginRequest);
    }


}

