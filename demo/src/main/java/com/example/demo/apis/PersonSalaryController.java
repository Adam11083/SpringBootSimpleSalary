package com.example.demo.apis;

import com.example.demo.Model.PersonSalaryModel;
import com.example.demo.Repository.PersonSalaryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/Person")
public class PersonSalaryController {

    // Inject the repository
    private PersonSalaryRepository personSalaryRepository;

    public PersonSalaryController(PersonSalaryRepository personSalaryRepository) {
        this.personSalaryRepository = personSalaryRepository;
    }

    // The GetAll() for the PersonSalary Collection
    @GetMapping("/all")
    public List<PersonSalaryModel> getAll(){
        List<PersonSalaryModel> Persons = this.personSalaryRepository.findAll();

        return Persons;
    }

    // The SearchByName() for the PersonSalary Collection
    @GetMapping("/search/{name}")
    public List<PersonSalaryModel> SearchByName(@PathVariable String name){
        List<PersonSalaryModel> Persons = this.personSalaryRepository.findByName(name);

        return Persons;
    }
}
