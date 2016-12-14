package com.example.thymeleaf;

import javax.annotation.PostConstruct;

import com.example.thymeleaf.model.*;
import com.example.thymeleaf.repository.mongo.FacultyMRepository;
import com.example.thymeleaf.repository.mongo.StudentMRepository;
import org.hibernate.usertype.CompositeUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ThymeleafApplication {

    @Autowired
    private FacultyMRepository facultyMRepository;

    @Autowired
    private StudentMRepository studentMRepository;

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }

    @PostConstruct
    public void dene() {
        initMongo();
        int a = 5 % 3;
        int b = 4 % 2;
        //StairCase(6);

//        coprimeSum();
    }

    private void initMongo() {
        Faculty fac = new Faculty("Engineering");
        Department depCs = new Department("CS");
        Department depEl = new Department("ELECTRONICS");
        fac.addDepartment(depCs);
        fac.addDepartment(depEl);

        Course courseOne = new Course("Automata", 25, Semester.FALL, depCs.getId());
        Course courseTwo = new Course("Discrete Mathematics", 50, Semester.FALL, depCs.getId());
        courseOne.setDepartmentId(depCs.getId());
        courseTwo.setDepartmentId(depCs.getId());

        Student student = new Student("serdar", "turkmen");
        student.setDepartmentId(depCs.getId());
        student.setFacultyId(fac.getId());
        Student studentTwo = new Student("ali", "kaya");
        studentTwo.setDepartmentId(depEl.getId());
        studentTwo.setFacultyId(fac.getId());

        depCs.addStudent(student);
        depCs.addCourse(courseOne);
        depCs.addCourse(courseTwo);
        depEl.addStudent(studentTwo);


        courseOne.addStudent(student);
        courseTwo.addStudent(student);
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(studentTwo);

        facultyMRepository.save(fac);
        studentMRepository.save(students);
        List<Faculty> facs =  facultyMRepository.findAll();
        Student std = studentMRepository.findByFirstName("serdar");
        System.out.print(facs);
    }

    private int coprimeSum() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an integer");
        int myint = keyboard.nextInt();
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for(int i=0; i<myint; i++){
            int newInt = keyboard.nextInt();
            firstList.add(newInt);
        }
        for(int i=0; i<myint; i++){
            int newInt = keyboard.nextInt();
            secondList.add(newInt);
        }
        int sum = 0;
        for (int i = 0; i < firstList.size(); i++) {
            for (int k = 0; k < secondList.size(); k++) {
                Boolean b = coPrime(firstList.get(i), secondList.get(k));
                if (!b) {
                    firstList.remove(firstList.get(i));
                    secondList.remove(secondList.get(k));
                    sum++;
                    i = 0;
                    k = 0;
                }
            }
        }
        return sum;
    }

    private boolean coPrime(Integer first, Integer second) {
        int small = first;
        int big = second;


        if (first > second) {
            small = second;
            big = first;
        }
        for (int i = 2; i < small; i++) {
            if (big % i == 0 && small % i == 0) {
                return true;
            }
        }
        return false;
    }

    private Boolean isCoPrime(Integer first, Integer second) {
        if (((first | second) & 1) == 0) return false;

        while ((second & 1) == 0) second >>= 1;
        if (second == 1) return true;

        do {
            while ((second & 1) == 0) second >>= 1;
            if (second == 1) return true;

            if (first > second) {
                Integer t = second;
                second = first;
                first = t;
            }
            second -= first;
        } while (second != 0);

        return false;
    }

    static void StairCase(int n) {
        int t = n - 1;
        int r = 1;
        for (int i = 0; i < n; i++) {
            for (int s = 0; s < t; s++) {
                System.out.print(" ");
            }
            for (int k = 0; k < r; k++) {
                System.out.print("#");
            }
            t = t - 1;
            r++;
            System.out.println();
        }

    }

    static int sum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;

    }

}