package sg.edu.nus.iss.vttp5a_ssf_day02l.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_ssf_day02l.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

    List<Student> students = new ArrayList<>();
    

    @RequestMapping(path = {"", "/allStudents"}, method=RequestMethod.GET)
    public String studentListing(Model model) throws ParseException {

        // convert a date string to epoch (long)
        String dob = "18 Dec 1975 10:25:00.000 SGT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS zzz");
        Date dDob = sdf.parse(dob);
        Long epochDob = dDob.getTime();

        Student s1 = new Student(1, "Damien", "Cumming", epochDob, "damient@nus.edu.sg", "25 HMKT 119615");
        students.add(s1);

        Student s2 = new Student(1, "Darryl", "Ng", epochDob, "darrylng@nus.edu.sg", "25 HMKT 119615");
        students.add(s2);

        Student s3 = new Student(1, "Brandon", "Ng", epochDob, "bradonng@nus.edu.sg", "25 HMKT 119615");
        students.add(s3);


        model.addAttribute("students", students);
        return "studentlist";
    }
}
