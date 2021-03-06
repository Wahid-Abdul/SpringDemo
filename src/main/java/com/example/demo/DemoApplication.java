
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.payroll.Employee;

@CrossOrigin(origins = "*") // Allows requests from all sources
@SpringBootApplication
@RestController
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("Heloooooooooooooooooo");
        return String.format("Hello %s!", name);
    }

    @GetMapping("/hello2")
    @ResponseBody
    public Employee hello2() {
        Employee emp = new Employee("anme", "last aasdasd", "21, street, earth");
        return emp;
    }

    @PostMapping("/employees")
    @ResponseBody
    public Employee newEmployee(@RequestBody Employee newEmployee) {
//        curl -X POST -H "Content-Type: application/json" \
//        -d '{"name": "SomeNameeee", "address": "linuxize@example.com"}' \
//        http://localhost:8080/employees

//        The above curl request works as expected.


        newEmployee.setFirstName(newEmployee.getName());
        newEmployee.setLastName("Lorem ipsum dasdasdlkasldk");
        return newEmployee;
    }
}
