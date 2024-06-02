import java.util.ArrayList;
import java.util.Scanner;

import Management.Actions;
import Management.Etudiants;
import Management.Notes;
import Management.StudentVerification;

public class Main extends Thread {

    public static void main(String[] args) {

        System.out.println("Actions disponibles : ");
        Scanner sc = new Scanner(System.in);
        int id; // Identifiant de l'etudiant
        StringBuilder sb = new StringBuilder();
        // sb.

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
                        Etudiants lastEtudiant = etudiantsList.getLast();
                        int lastIndex = lastEtudiant.getId();
                        Etudiants etudiant = new Etudiants(lastIndex + 1, nom, prenom, age);
                        etudiant.addStudent(etudiant);
                    }
                    System.out.println("Etudiant ajoute avec succes");
                    System.out.println();
                    break;

                case "3":
                    id = StudentVerification.idVerification();
                    String statusForDelete = StudentVerification.StudentExist(id);
                    if (statusForDelete != null) {
                        System.out.println(statusForDelete);
                        break;
                    }

                    Etudiants.deleteStudent(id);
                    System.out.println("   *** suppression reussie ***");
                    break;

                case "4":
                    id = StudentVerification.idVerification();
                    String statusForAdd = StudentVerification.StudentExist(id);
                    if (statusForAdd != null) {
                        System.out.println(statusForAdd);
                        break;
                    }

                    System.out.print("Entrez la matiere : ");
                    while (sc.hasNextInt()) {
                        System.out.print("Incorrect. Saisissez a nouveau : ");
                        sc.nextLine();
                    }
                    String matiere = sc.nextLine();

                    System.out.print("Entrez la note : ");
                    while (!sc.hasNextInt()) {
                        System.out.print("Incorrect. Saisissez a nouveau : ");
                        sc.nextLine();
                    }

                    int studentNot = sc.nextInt();
                    sc.nextLine();

                    Notes note = new Notes(matiere, studentNot);
                    Etudiants.addNotes(note, id);
                    System.out.println(" *** Note ajoute avec succes ***");
                    System.out.println();
                    break;

                case "5":
                    id = StudentVerification.idVerification();
                    String statusForNote = StudentVerification.StudentExist(id);
                    if (statusForNote != null) {
                        System.out.println(statusForNote);
                        break;
                    }

                    Etudiants.viewEtudiantNotes(id);
                    System.out.println();
                    break;

                default:
                    System.exit(1);
            }
        }
    }

}
