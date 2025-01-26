package com.example.student.Repository;
import com.example.student.model.Login;
import com.example.student.model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

@Repository
public interface Jpstu extends MongoRepository<Registration, String> {
  Registration findByGmail(String gmail);  // Update to match the field name
}


