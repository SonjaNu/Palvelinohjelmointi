package Palvelinohjelmointi.HandlingLists.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Palvelinohjelmointi.HandlingLists.domain.Student;

@Controller

public class StudentController {
	
	//palauttaa kaikki opiskelijat html-listana
	//endpoint    http://localhost:8080/hello
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getStudentList(Model model) { //modelin alle voi laittaa olioita talteen
		// StudentListTemplate.html <- tämä nimi on thymeleaf templaten nimi, mutta returnissa viitataan ilman html-päätettä
		
		List<Student> students = new ArrayList<Student>(); //luotiin tyhjä lista; students on muuttujan nimi ja siellä on Student-tyyppisiä olioita
		students.add(new Student("Cate", "Cole")); //lisättiin opiskelija-olio
		students.add(new Student("Dan", "Brown"));//ja toinenkin olio
		students.add(new Student("Mike", "Mare")); //ja kolmas
		
		model.addAttribute("students", students); //lainausmerkeissä avainsana "students", jonka mukaan opiskelijalista välitetään templaten käyttöön
		
		return "StudentListTemplate";
		
	}

}
