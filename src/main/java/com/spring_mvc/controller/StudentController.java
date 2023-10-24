package com.spring_mvc.controller;

import com.spring_mvc.entity.Student;
import com.spring_mvc.repository.StudentRepository;
import com.spring_mvc.repository.StudentRepositoryImpl;
import com.spring_mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StudentController{
    @Autowired
    private StudentService studentService;
    @RequestMapping("/")
    public String showListStudents(Model model){
        List<Student> studentList = studentService.getAllStudents();
        model.addAttribute("allStudents", studentList);
        return "list-students";
    }
    @RequestMapping("/addNewStudent")
    public String addNewStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-info";
    }
    @RequestMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")  Student student){
        studentService.saveStudent(student);
        return "redirect:/";
    }
    @RequestMapping("/updateInfo")
    public String updateStudent(@RequestParam("studentId") int id, Model model){
        Student student = studentService.getStudent(id);
        model.addAttribute("student", student);
        return "student-info";
    }
    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }
}
