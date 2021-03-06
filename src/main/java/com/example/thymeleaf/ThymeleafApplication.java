package com.example.thymeleaf;

import com.example.thymeleaf.config.ApplicationProperties;
import com.example.thymeleaf.model.mon.*;
import com.example.thymeleaf.repository.mongo.FacultyMRepository;
import com.example.thymeleaf.repository.mongo.RoleMRepository;
import com.example.thymeleaf.repository.mongo.StudentMRepository;
import com.example.thymeleaf.repository.mongo.UserMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.PostConstruct;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
@EnableElasticsearchRepositories("com.example.thymeleaf.repository.search")
public class ThymeleafApplication {

    @Autowired
    private FacultyMRepository facultyMRepository;

    @Autowired
    private StudentMRepository studentMRepository;

    @Autowired
    private UserMRepository userMRepository;

    @Autowired
    private RoleMRepository roleMRepository;


    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }

    @PostConstruct
    public void dene() throws IOException{
        initMongo();
//        optionalExamples();
//        int a = 5 % 3;
//        int b = 4 % 2;
        //StairCase(6);
//        linkedListExample();
//        coprimeSum();
//        fleIOOperations();
        createPath();
    }


    private void createPath() {
        /**
         * Write string to file relative path
         */

        Path p = Paths.get("dene.txt");
        String s = "Hello World! ";
        byte data[] = s.getBytes();
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, CREATE, APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }

        PrintWriter outputStream = null;
        BufferedReader inputStream  = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/config.txt")));

        String l;
        try {
            while ((l = inputStream.readLine()) != null) {
                System.out.println(l);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path pathToFile = Paths.get("C:\\users\\bawer\\Desktop\\BaseModel.java");
        System.out.print(pathToFile);
        Path path = Paths.get("Directory1");
        try {
            Files.createDirectories(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void fleIOOperations() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("example.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    private void linkedListExample() {
        System.out.println();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an integer");
        int x = keyboard.nextInt();

        System.out.println();
        Scanner key = new Scanner(System.in);
        System.out.println("enter array with 1 space in each");
//        String y = key.nextLine();
//        String[] parts = y.split(" ");
        LinkedList<Integer> ll = new LinkedList<Integer>();
        while (key.hasNext())
            ll.push(key.nextInt());

        int index = ll.size() - x;
        System.out.println("dsad");
        try {
            System.out.println(ll.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("NIL");
        }

    }

    private void initMongo() {
        studentMRepository.deleteAll();
        facultyMRepository.deleteAll();
        userMRepository.deleteAll();

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

        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleMRepository.save(roleUser);
        roleMRepository.save(roleAdmin);
        User user = new User();
        user.setEmail("user");
        user.setFirstName("serdar");
        user.setLastName("turkmen");
        user.setSalt("1234");
        user.setPassword("243b2e76fd07d358524dc6f7a3bb83c7315c0d07");
        user.setEnabled(true);

        User userAdmin = new User();
        userAdmin.setEmail("admin");
        userAdmin.setFirstName("Ali");
        userAdmin.setLastName("Can");
        userAdmin.setSalt("1234");
        userAdmin.setPassword("e53343d3490f48bb362002cb11d591972d831b3d");
        userAdmin.setEnabled(true);

        userMRepository.save(user);
        userMRepository.save(userAdmin);
        List<User> users = userMRepository.findAll();

        facultyMRepository.save(fac);
        studentMRepository.save(students);
        List<Faculty> facs = facultyMRepository.findAll();
//        Student std = studentMRepository.findByFirstName("serdar");
        System.out.print(facs);
    }

    private void optionalExamples() {
        System.out.println();
        Integer numara = 3;
        Optional<Integer> opt = Optional.ofNullable(numara);
        opt
                .map(num -> Math.pow(num, 2))
                .ifPresent(System.out::println);
        String message = "deneme";
        Optional<String> opt2 = Optional.ofNullable(message);
        opt2
                .filter(m -> m.length() > 5)
                .ifPresent(System.out::println);
    }

    private int coprimeSum() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an integer");
        int myint = keyboard.nextInt();
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        for (int i = 0; i < myint; i++) {
            int newInt = keyboard.nextInt();
            firstList.add(newInt);
        }
        for (int i = 0; i < myint; i++) {
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
