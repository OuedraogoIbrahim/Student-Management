package Management;

import java.util.Scanner;

public class StudentVerification {

    protected static Scanner scanner = new Scanner(System.in);

    public static String verifyname() {

        while (scanner.hasNextInt()) {
            System.out.print("Invalide. Reessayer : ");
            scanner.nextLine();
        }

        while (scanner.hasNextDouble()) {
            System.out.print("Invalide. Reessayer : ");
            scanner.nextLine();
        }
        String name = scanner.nextLine();
        return name;
    }

    public static int verifyAge() {
        while (!scanner.hasNextInt()) {
            System.out.print("Age invalide. Reessayer : ");
            scanner.nextLine();
        }
        int age = scanner.nextInt();
        scanner.nextLine();

        return age;

    }

    public static String StudentExist(int id) {
        String error = null;
        if (id <= 0 || id > Etudiants.getEtudiantsList().size()) {
            error = "  **** Aucun etudiant correspondant ***";
        }

        return error;
    }

    public static int idVerification() {
        System.out.print(" **** Identifiant de l'etudiant : ");
        while (!scanner.hasNextInt()) {
            System.out.print("erreur . Reessayer : ");
            scanner.nextLine();
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        return id;
    }

}
