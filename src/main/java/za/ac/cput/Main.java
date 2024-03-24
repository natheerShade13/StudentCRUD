package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Control + Alt + O to remove unused imports.

@SpringBootApplication
//@RestController // Moved to StudentController.
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	/*
	@GetMapping
	public String hello(){
		return "Hello World";
	} */

	/*
	@GetMapping
	public List<String> helloList(){
		return List.of("Hello", "World");
	} */

	/* Moved to StudentController.
	@GetMapping
	public List<Student> helloList(){
		return List.of(new Student(1L, "Saton", "dummy@gmail.com",
				LocalDate.of(2000, Month.DECEMBER, 31), 23)
		);
	} */

	/*
	@GetMapping
	public ArrayList<String> helloList(){
		ArrayList<String> list = new ArrayList<>();
		list.add("Way");
		return list;
	} */

}
