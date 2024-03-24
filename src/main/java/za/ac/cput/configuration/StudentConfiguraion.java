package za.ac.cput.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.ac.cput.domain.Student;
import za.ac.cput.repository.StudentRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfiguraion {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student nathan = new Student(
                    "Nathan",
                    "nathan@gmail.com",
                    LocalDate.of(2005, Month.DECEMBER, 31)
            );

            Student saturo = new Student(
                    "Saturo",
                    "saturo@gmail.com",
                    LocalDate.of(1995, Month.DECEMBER, 31)
            );

            repository.saveAll(
                    List.of(nathan, saturo)
            );

        };
    }

}
