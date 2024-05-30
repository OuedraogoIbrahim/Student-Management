import java.util.ArrayList;
import java.util.Scanner;

import Management.Actions;
import Management.Etudiants;
import Management.StudentVerification;

public class Main extends Thread {

    public static void main(String[] args) {

        System.out.println("Actions disponibles : ");
        Scanner sc = new Scanner(System.in);

        while (true) {
            Actions.actions();

            System.out.print("Votre choix : ");
            String action = sc.nextLine();

            ArrayList<Etudiants> etudiantsList = Etudiants.getEtudiantsList();

            switch (action) {

                case "1":
                    System.out.println("*** Liste de tous les Etudiants ***");
                    if (etudiantsList.isEmpty()) {
                        System.out.println("Il n y' a aucun étudiant enregisté");
                    } else {
                        for (Etudiants et : etudiantsList) {
                            System.out.print("etudiant " + et.getId() + " : " + et.getLastName() + " ");
                            System.out.println(et.getFirstName() + " " + et.getAge() + " ans");
                        }
                    }
                    System.out.println();
                    break;

                case "2":
                    System.out.println("*** Ajout d'un etudiant ");
                    System.out.print("Entrez le Nom : ");
                    String nom = StudentVerification.verifyname();

                    System.out.print("Entrez le Prenom : ");
                    String prenom = StudentVerification.verifyname();

                    System.out.print("Entrez L'age : ");
                    int age = StudentVerification.verifyAge();

                    if (etudiantsList.isEmpty()) {
                        Etudiants etudiant = new Etudiants(1, nom, prenom, age);
                        etudiant.addStudent(etudiant);

                    } else {
                        int lastIndex = etudiantsList.size();
                        Etudiants etudiant = new Etudiants(lastIndex + 1, nom, prenom, age);
                        etudiant.addStudent(etudiant);
                    }
                    System.out.println();
                    break;

                case "3":
                    System.out.print("Identifiant de l'etudiant : ");
                    while (!sc.hasNextInt()) {
                        System.out.print("    Erreur. Entrez un entier : ");
                        sc.nextLine();
                    }
                    int id = sc.nextInt();
                    sc.nextLine();
                    if (id <= 0 || id > etudiantsList.size()) {
                        System.out.println("  **** Aucun etudiant correspondant ***");
                        break;
                    }
                    Etudiants.deleteStudent(id);
                    System.out.println("   *** suppression reussie ***");
                    break;

                case "4":
                    System.out.println(3);

                    break;

                default:
                    System.exit(1);
            }
        }
    }

}
