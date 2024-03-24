package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Student;
import za.ac.cput.service.StudentService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    // N-Tier Design Pattern, Dependency Injection
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // Get and Display data
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @PostMapping// Add new resources to the system
    public void registerNewStudent(Student student){
        studentService.addNewStudent(student);
    }

}