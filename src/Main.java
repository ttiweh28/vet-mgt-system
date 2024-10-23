import console.Login;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


//        LoadingPage.showLoadingPage("Vet Management System", 2);

//        ConsoleUtil.displayColoredMessageWithNewLine("Load DummyData?(Y/N)", ConsoleUtil.GREEN);
//
//        String loadData = ConsoleUtil.getScanner().nextLine();
//
//        if (loadData.equalsIgnoreCase("y")) {
        DummyDataPopulate.populateAll();
//        }

        Login.userLogin();
    }


}
