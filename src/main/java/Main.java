package main.java;

public class Main {
    public static void main(String args[]) {
        String str = "";
        for (String arg : args) {
            str += arg + " ";
        }
        System.out.println(str);
    }
}
