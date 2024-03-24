package za.ac.cput.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> student1 = studentRepository.findStudentByEmail(student.getEmail());
        if(student1.isPresent()){
            throw new IllegalStateException("Email already taken.");
        }
        studentRepository.save(student);
        //System.out.println(student);
    }

    public void deleteStudent(long studentId) {
        //studentRepository.findById(studentId);
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with ID" + studentId + " does not exist");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()
                -> new IllegalStateException("Student with id" + studentId + " does not exist"));

        if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if(email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> student1 = studentRepository.findStudentByEmail(email);
            if(student1.isPresent()){
                throw new IllegalStateException("Email already taken.");
            }
            student.setEmail(email);
        }

    }
}
