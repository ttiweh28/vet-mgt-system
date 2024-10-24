import console.Login;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String banner = "*******************************************";
        String welcome = "   Welcome to Vet Management System   ";

        System.out.println(banner);
        System.out.println(welcome);
        System.out.println(banner);

        DummyDataPopulate.populateAll();

        Login.userLogin();
    }
}
