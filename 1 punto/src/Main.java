import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        list.add(new Student("Ana", 85));
        list.add(new Student("Luis", 62));
        list.add(new Student("Sofia", 90));
        list.add(new Student("Pedro", 45));
        list.add(new Student("Camila", 78));
        list.add(new Student("Andres", 55));

        char OP = 'S';
        int type;

        while (OP == 'S') {
            type = MENU();

            switch (type) {
                case 1:
                    data();
                    break;
                case 2:
                    eliminate();
                    break;
                case 3:
                    list();
                    break;
                case 4:
                    report();
                    break;
                case 5:
                    OP = 'N';
            }
        }
    }

    public static int MENU() {
        System.out.println("\n...:::MENU:::...");
        System.out.println("1.agregar estudiante");
        System.out.println("2.eliminar estudiante");
        System.out.println("3.mostrar lista");
        System.out.println("4.reporte");
        System.out.println("5.salir");
        System.out.print("Seleccione: ");
        return sc.nextInt();
    }

    public static void data() {
        sc.nextLine();
        System.out.print("Nombre: ");
        String name = sc.nextLine();

        System.out.print("Nota: ");
        double grade = sc.nextDouble();

        list.add(new Student(name, grade));
    }

    public static void eliminate() {
        sc.nextLine();
        System.out.print("nombre del estudiante que va a eliminar: ");
        String name = sc.nextLine();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                list.remove(i);
            }
        }
    }

    public static void list() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName() + " - " + list.get(i).getGrade());
        }
    }

    public static void report() {
        int approved = 0;
        double sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i).getGrade();

            if (list.get(i).getGrade() >= 60) {
                approved++;
            }
        }

        double average = sum / list.size();

        System.out.println("total: " + list.size());
        System.out.println("aprobados: " + approved);
        System.out.println("promedio: " + average);
    }
}