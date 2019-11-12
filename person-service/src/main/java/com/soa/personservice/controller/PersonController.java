package com.soa.personservice.controller;

import com.soa.personservice.Service.PersonService;
import com.soa.personservice.pojo.Person;
import com.soa.personservice.pojo.PersonInfo;
import com.soa.personservice.pojo.Stand_Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    //新建个人信息

    @PostMapping("/Person")
    public Stand_Result NewPerson(@RequestBody PersonInfo personInfo) {
        Person person=new Person();
        person.setId(personInfo.getId());
        person.setName(personInfo.getName());
        person.setAge(personInfo.getAge());
        person.setSex(personInfo.getSex());
        person.setCountry(personInfo.getCountry());
        person.setSignature(personInfo.getSignature());
        person.setEmail(personInfo.getE_mail());
        /*还没添加时间参数，先空着*/

        personService.save(person);
        Stand_Result result=new Stand_Result();
        result.setSucceed(true);
        result.setWrongCode("0");
        return result;
    }

    //查询个人信息

    @GetMapping("/Person")
    public PersonInfo QueryPerson(@RequestParam(value = "id") String id) {
        Person person=personService.findById(id);
        PersonInfo personInfo=new PersonInfo();
        personInfo.setAge(person.getAge());
        personInfo.setName(person.getName());
        personInfo.setId(person.getId());
        personInfo.setSex(person.getSex());
        personInfo.setCountry(person.getCountry());
        personInfo.setSignature(person.getSignature());
        personInfo.setPhone(person.getPhone());
        personInfo.setE_mail(person.getEmail());
        return personInfo;
    }

    //修改个人信息

    @PutMapping("/Person")
    public Stand_Result Update(@RequestBody PersonInfo personInfo) {
        personService.modifyAgeById(personInfo.getAge(),personInfo.getId());
        Stand_Result result=new Stand_Result();
        result.setWrongCode("0");
        result.setSucceed(true);
        /*未添加时间*/
        return result;
    }

    //删除个人信息

    @DeleteMapping("/Person")
    public Stand_Result Delete(@RequestParam(value = "id") String id) {
        personService.delete(id);
        Stand_Result result=new Stand_Result();
        result.setWrongCode("0");
        result.setSucceed(true);
        /*未添加时间*/
        return result;
    }
}