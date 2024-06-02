package Management;

import java.util.ArrayList;

public class Etudiants {

    protected int id;
    protected String lastName;
    protected String firstName;
    protected int age;

    protected ArrayList<Notes> notes = new ArrayList<Notes>();

    protected static ArrayList<Etudiants> etudiants = new ArrayList<Etudiants>();

    public Etudiants() {
    }

    public Etudiants(int id, String nom, String prenom, int age) {
        this.id = id;
        this.lastName = nom;
        this.firstName = prenom;
        this.age = age;
    }

    public void addStudent(Etudiants etudiant) {

        Etudiants.etudiants.add(etudiant);
    }

    public static void deleteStudent(int id) {
        for (Etudiants etudiant : Etudiants.etudiants) {
            if (etudiant.getId() == id) {
                Etudiants.etudiants.remove(etudiant);
            }
        }
    }

    public static void addNotes(Notes note, int id) {
        for (Etudiants etudiant : Etudiants.etudiants) {
            if (etudiant.id == id) {
                etudiant.notes.add(note);
            }
        }
    }

    public static void viewEtudiantNotes(int id) {
        for (Etudiants etudiant : Etudiants.etudiants) {
            if (etudiant.id == id) {
                System.out.print("etudiant " + etudiant.id + " : " + etudiant.lastName + " ");
                System.out.println(etudiant.firstName + " " + etudiant.age + " ans");
                if (etudiant.notes.isEmpty()) {
                    System.out.println(" *** Aucune note pour cet etudiant ***");
                } else {
                    for (Notes n : etudiant.notes) {
                        System.out.println(n.matiere + " : " + n.note);
                    }
                }
            }
        }
    }

    public int getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public static ArrayList<Etudiants> getEtudiantsList() {
        return Etudiants.etudiants;
    }

}
