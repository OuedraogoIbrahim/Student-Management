import java.util.Scanner;

import Management.Actions;
import Management.Etudiants;
import Management.StudentVerification;

public class Main extends Thread {

    public static void main(String[] args) {

        System.out.println("Actions disponibles : ");

        Actions.actions();
        Scanner sc = new Scanner(System.in);

        while (true) {
            Actions.actions();

            System.out.print("Votre choix : ");
            String action = sc.nextLine();
            switch (action) {

                case "1":
                    System.out.println("*** Liste de tous les Etudiants ***");
                    Etudiants.EtudiantsList();
                    break;

                case "2":
                    System.out.println("*** Ajout d'un etudiant ");
                    System.out.print("Entrez le Nom : ");
                    String nom = StudentVerification.verifyname();

                    System.out.print("Entrez le Prenom : ");
                    String prenom = StudentVerification.verifyname();

                    System.out.print("Entrez L'age : ");
                    int age = StudentVerification.verifyAge();

                    Etudiants etudiant = new Etudiants(nom, prenom, age);
                    break;

                case "3":
                    System.out.println(3);
                    break;

                case "4":
                    System.out.println(3);

                    break;

                default:
                    System.exit(1);
            }

            sc.close();
        }

    }

}
