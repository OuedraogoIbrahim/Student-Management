package Ecole;

import java.util.Scanner;

public class StudentVerification {

    public static String verifyname() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            System.out.print("Invalide. Reessayer : ");
            scanner.nextInt();
        }

        while (scanner.hasNextDouble()) {
            System.out.print("Invalide. Reessayer : ");
            scanner.nextDouble();
        }
        String name = scanner.nextLine();
        return name;
    }

    public static int verifyAge() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.print("Age invalide. Reessayer : ");

        }
        int age = scanner.nextInt();
        return age;

    }
}
