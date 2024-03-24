package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") long studentdentId){
        studentService.deleteStudent(studentdentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
    }

}