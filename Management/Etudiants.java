package Ecole;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Etudiants {

    protected int id;
    protected String lastName;
    protected String firstName;
    protected int age;

    protected static HashMap<String, Double> notes = new HashMap<>();
    protected static ArrayList<Etudiants> etudiants = new ArrayList<Etudiants>();

    public Etudiants(String nom, String prenom, int age) {

        this.id = etudiants.isEmpty() ? 1 : etudiants.size() + 1;
        this.lastName = nom;
        this.firstName = prenom;
        this.age = age;
        etudiants.add(this);
        System.out.println("Nouvel etudiant ajoute ****");
    }

    public static void EtudiantsList() {

        if (etudiants.isEmpty()) {
            System.out.println("Aucun etudiant");
        }
        for (Etudiants etudiant : etudiants) {
            System.out.println(
                    "Etudiant " + etudiant.id + "*** Nom : " + etudiant.lastName + "*** Prenom : "
                            + etudiant.firstName);
        }
    }

    public void addNotes() {
        String[] matieres = { "Francais", "Maths", "PC" };

        Scanner sc = new Scanner(System.in);
        System.out.print("Identifiant de l'Etudiant : ");
        while (!sc.hasNextInt()) {
            System.out.print("Incorrect . Reeassayer : ");
            sc.next();
        }

        int id = sc.nextInt();

        for (Etudiants etudiant : etudiants) {
            if (etudiant.id == id) {

                for (String matiere : matieres) {
                    System.out.print("Entrez la note de " + matiere + " : ");
                    while (!sc.hasNextDouble()) {
                        System.out.print("Entrez un nombre : ");
                        sc.next();
                    }

                    Double note = sc.nextDouble();
                    while (note < 0 || note > 20) {
                        System.out.println("Entrez un nombre entre 0 et 20");
                    }

                    this.notes.put(matiere, note);
                }
            }
        }

        System.out.println("Notes ajoutees avec succes");

    }

    public void viewEtudiantNotes() {
        if (this.notes.isEmpty()) {
            System.out.println("Aucune note pour cet etudiant");
        } else {

            for (Map.Entry<String, Double> entry : this.notes.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

}
