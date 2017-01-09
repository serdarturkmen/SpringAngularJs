package com.example.thymeleaf;

import com.example.thymeleaf.model.mon.Student;
import org.springframework.boot.SpringApplication;

import javax.annotation.processing.FilerException;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by bawer on 26.12.2016.
 */
public class DeneJava7 {
    public static void main(String[] args) {


    sirala();



//        isPresent(5, 2);
//
//        fizzBuzz(50);
//
//        java7Samples();
//
//        Set<String> subStringSet = getSubString("ohazmsexovixkuuneqnzdhhsweyjmrevqszglreqzacuzefaszzyzramuctxeusmzmtajezzfnrqmmmcyvrogrhntqwlbfpatgjxlweewaiaqidxrqplxdudscuqhrfjtqvksksnfmfhcodvghtkgzojpzytmdcimjzwaonnwmhmsaacnrblvvzhwbiokgziuvsfersuxiiydcfcvnkpbzljsqrqtgmhywkjxlxsixlxrwsnyypjkoxgtyczbouvojmfoqptnqfkvrynavuywnemedlvbvlafhorcfpqixphfwoybefcsbubegqmhcgyfbetfsyuqbadugfylowmzrifijkzlpawkewixgcfvqxapcyzpegrzrqczfdssgvspnjktlshhjqvvlkcmvwtwclpfwlwwulvfvmnnzldpiotcalpktbklalusufgbkrqgzdbagtqzlzealvq\n");
//        List<String> subStringList = new ArrayList<>();
//        subStringList.addAll(subStringSet);
//        List<String> subsequenceList = getSubsequence("pxmfjrmvkehafjpxrehkkqcqbjpcmxymsgnfdzzplkdaewzoteyavwwzcnbtsrxyccjxfmbwsfquqelpicmmvymatfvwpemabhlxpjxuywludjhkfwpyowvnkpupalimnnecvtesblatxnewkywvvohdbgfavjxumqhvkznutjpowuvhmnyvzbykuzmchbnlmuiavdfbcuutaqqgiwhjefmcapfisdtohavoputtnhzecalriymlnfabvtbkhtnpenxkbtubuyskwykpablacspjkanwlnxeuuksccptvtqwomusmvuygfdmbkftbdlwmmxeudbdknqudfcrsaefetouygyejfelfqoqvhfabprdbjcihqrzfdbqcafvoowjskqwzironkxxsqedgbycvhnuskhdkkgfpggahvuznqytlldquvbofbxafrxmnbaignazengaxngdobatpmqfzghlamzuoelwvajlvzbuoxwluxqhsmcj\n");
//        subStringList.sort((s1, s2) -> Math.abs(s1.length() - "intelligent".length()) - Math.abs(s2.length() - "intelligent".length()));
//        subsequenceList.sort((s1, s2) -> Math.abs(s1.length() - "intelligent".length()) - Math.abs(s2.length() - "intelligent".length()));
//
//        System.out.print("da");
//        String result = "";
//
//        for(int i= 0; i<subStringList.size(); i++){
//            if(subsequenceList.contains(subStringList.get(i))){
//                result = subStringList.get(i);
//                break;
//            }
//        }
//
//        System.out.println(result);
//
//
//        for(int i= 0; i<subsequenceList.size(); i++){
//            subsequenceList.get(i).length();
//        }

//        String[] ips = new String[3];
//        ips[0] = "192.168.10.78";
//        ips[1] = "serdar";
//        ips[2] = "2001:cdba:0000:0000:0000:0000:3257:9652";
//        checkIPs(ips);


    }




    public static int[] sirala(){

        Random rd = new Random();
        int birinci = rd.nextInt(1000);
        int ikinci = rd.nextInt(1000);
        int ucuncu = rd.nextInt(1000);
        int[]dizi = new int[3];
        dizi[0] = birinci;
        dizi[1] = ikinci;
        dizi[2] = ucuncu;
        System.out.println(birinci);
        System.out.println(ikinci);
        System.out.println(ucuncu);
        Arrays.sort(dizi);

        System.out.print(dizi[0]+ " "+dizi[1]+ " "+ dizi[2]);
        return dizi;

    }





    public static class IP4AddressValidator{

        private Pattern pattern;
        private Matcher matcher;

        private static final String IPADDRESS_PATTERN =
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        public IP4AddressValidator(){
            pattern = Pattern.compile(IPADDRESS_PATTERN);
        }

        public boolean validate(final String ip){
            matcher = pattern.matcher(ip);
            return matcher.matches();
        }
    }

    public static class IPAddressValidator{

        private Pattern pattern4;
        private Pattern pattern6;
        private Matcher matcher4;
        private Matcher matcher6;

        private static final String IP6ADDRESS_PATTERN = "([0-9a-f]{1,4}:){7}([0-9a-f]){1,4}";
        private static final String IP4ADDRESS_PATTERN =
                "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                        "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        public IPAddressValidator(){
            pattern6 = Pattern.compile(IP6ADDRESS_PATTERN);
            pattern4 = Pattern.compile(IP4ADDRESS_PATTERN);
        }

        public boolean validate6(final String ip){
            matcher6 = pattern6.matcher(ip);
            return matcher6.matches();
        }
        public boolean validate4(final String ip){
            matcher4 = pattern4.matcher(ip);
            return matcher4.matches();
        }
    }

    public static String checkIPs(String[] ip_array){
        IPAddressValidator ipAddressValidator = new IPAddressValidator();
        boolean result = false;
        for(int i=0; i<ip_array.length; i++){
            if(ipAddressValidator.validate6(ip_array[i])){
                System.out.println("IPv4");
            }else if(ipAddressValidator.validate4(ip_array[i])){
                System.out.println("IPv6");
            }else{
                System.out.println("Neither");
            }

        }
        return "ok";

    }





    public static Set<String> getSubString(String string){
        Set<String> response = new HashSet<>();
        int i, c, length;
        String sub;
        length = string.length();

        for( c = 0 ; c < length ; c++ )
        {
            for( i = 1 ; i <= length - c ; i++ )
            {
                sub = string.substring(c, c+i);
                response.add(sub);
                System.out.println(sub);
            }
        }
        return response;
    }

    public static List<String> getSubsequence(String string){
        String[] args = string.split("");
        List<String> results = new ArrayList<>();
        for ( int i = 1; i <= (1<<(args.length))-1; i++ ) {
            StringBuilder builder = new StringBuilder();
            for ( int j = 0; j < args.length; j++ ) {
                if ( (i & (1<<j)) != 0) {
                    builder.append(args[j]);
                }
            }
            results.add(builder.toString());
        }
        System.out.println( results );
        return results;
    }



    static int longSubsequence(String x, String y){

        return 0;

    }


    interface AdvancedArithmetic{
        int divisor_sum(int n);
        Student std = new Student();
    }

    public class Dene implements Square, Rectangle{

        @Override
        public int calc(int x, int y) {
            System.out.println(x*y);
            return x*y;
        }

        @Override
        public int calc(int x) {
            System.out.println(x*x);
            return x*x;
        }
    }

    interface Square{
        int calc(int x, int y);
    }

    interface Rectangle{
        int calc(int x);
    }

    private static void isPresent(int root, int value) {

    }

    static void fizzBuzz(int n){
        for (int i= 1; i<=n; i++){
            if(i%3==0 && i%5==0){
                System.out.println("FizBuzz");
            }
            else if(i%3 == 0){
                System.out.println("Fizz");
            }else if(i%5 == 0){
                System.out.println("Buzz");
            }else{
                System.out.println(i);
            }
        }
    }

    private static void java7Samples() {
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
