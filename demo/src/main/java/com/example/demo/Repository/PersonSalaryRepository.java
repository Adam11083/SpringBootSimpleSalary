package com.example.demo.Repository;

import com.example.demo.Model.PersonSalaryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonSalaryRepository extends MongoRepository<PersonSalaryModel, String> {

    public List<PersonSalaryModel> findByName(String name);

}
