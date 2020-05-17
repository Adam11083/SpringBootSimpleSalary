package com.example.demo.Controller;

import com.example.demo.Model.PersonSalaryModel;
import com.example.demo.Repository.PersonSalaryRepository;

import java.util.List;

public class InitQueryContent {
    private PersonSalaryRepository personSalaryRepository;

    public InitQueryContent(PersonSalaryRepository personSalaryRepository) {
        this.personSalaryRepository = personSalaryRepository;
    }

//    public String QueryContent(String content) {
//        List<PersonSalaryModel> Persons = this.personSalaryRepository.findByName(content);
//        String name = Persons.get(0).getName();
//        float netPay = Persons.get(0).getNetPay().getNetPayTotal();
//        float deductPay = Persons.get(0).getDeductPay().getDeductPayTotal();
//        float totalPay = Persons.get(0).getPayTotal();
//
//        String result = "姓名："+name+"/n"+"应发工资："+ netPay +"元/n"+"应扣费用"+deductPay+"元/n"+"实发工资"+ totalPay + "元/n";
//        return result;
//    }
}
