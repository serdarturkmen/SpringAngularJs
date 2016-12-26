package com.example.thymeleaf;

import org.springframework.boot.SpringApplication;

import javax.annotation.processing.FilerException;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bawer on 26.12.2016.
 */
public class DeneJava7 {
    public static void main(String[] args) {
        /**
         * Diamond Operator
         * TreeMap<String, List<Trade>> not needed now
         */
        Map<String, List<Trade>> trades = new TreeMap<>();

        /**
         * Using strings in switch statements
         */
        String status = "pending";

        switch (status) {
            case "new":
                System.out.println("NEW");
                break;
            case "pending":
                System.out.println("PENDING");
                break;
            case "other":
                System.out.println("OTHER");
                break;
            default:
                break;
        }
        /**
         * Automatic resource management
         * File io islemlerinde finally de kapatma gitti
         */
        try (FileOutputStream fos = new FileOutputStream("movies.txt");
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF("Java 7 Block Buster");
        } catch (IOException e) {
            // log the exception
        }
        /**
         * Mult cath in exception handling
         */
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

        /**
         * Nio2
         */
        pathInfo();
    }



    public static void pathInfo() {

        Path path= Paths.get("c:\\Temp\\temp");

        System.out.println("Number of Nodes:"+ path.getNameCount());

        System.out.println("File Name:"+ path.getFileName());

        System.out.println("File Root:"+ path.getRoot());

        System.out.println("File Parent:"+ path.getParent());
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static class Trade {
        String name;
    }
}
