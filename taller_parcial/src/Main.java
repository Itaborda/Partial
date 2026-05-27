import Services.AppoinmentService;
import Services.BenefitService;
import Services.OwnerService;
import entities.*;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        OwnerService ownerService = new OwnerService();
        BenefitService benefitService = new BenefitService();
        AppoinmentService appoinmentService = new AppoinmentService();
        int option;
        do{
            System.out.println(" M E N U ");
            System.out.println("1. Registrar dueño");
            System.out.println("2. Registrar servicio básico");
            System.out.println("3. Registrar servicio especializado");
            System.out.println("4. Registrar cita");
            System.out.println("5. Cancelar cita");
            System.out.println("6. Buscar cita");
            System.out.println("7. Listar citas por dueño");
            System.out.println("8. Total de dueños");
            System.out.println("9. salir");
            System.out.println("Seleccione una opcion: ");
            option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1: registerOwner(sc,ownerService);
                    break;
                case 2: registerBasic(benefitService,sc);
                    break;
                case 3: registerSpecialization(sc,benefitService);
                    break;
                case 4: registerAppointment(sc,appoinmentService,ownerService,benefitService);
                    break;
                case 5: cancelAppoinment(sc,appoinmentService);
                    break;
                case 6: searchAppointment(sc,appoinmentService);
                    break;
                case 7: appointmentsByOwner(sc,appoinmentService);
                    break;
                case 8: totalOwners(ownerService);
                    break;
                case 9:
                    System.out.println("Hasta luego!!!");
                    break;
                default:
                    System.out.println("Esta opcion no está disponible");
            }
        }while(option!=7);

    }
    static void registerOwner(Scanner sd, OwnerService ownerService){
        System.out.println("Ingrese la cedula");
        String id = sd.nextLine();
        System.out.println("Ingrese el nombre: ");
        String name = sd.nextLine();
        System.out.println("Ingrse apellidos: ");
        String lastName = sd.nextLine();
        System.out.println("Ingrese el email: ");
        String email = sd.nextLine();
        System.out.println("Ingrese el telefono: ");
        String cell = sd.nextLine();
        System.out.println("Ingrese la dirección: ");
        String address = sd.nextLine();
        System.out.println("Ingrese el nombre de la mascota: ");
        String petName = sd.nextLine();
        System.out.println("Ingrese especie: ");
        String specie = sd.nextLine();
        System.out.println("Ingrese raza: ");
        String race = sd.nextLine();
        System.out.println("Ingrese la edad: ");
       int age = sd.nextInt();
       sd.nextLine();
        Owner owner = new Owner(address, cell, email , id, lastName, name, age, petName, race, specie);
        ownerService.registerOwner(owner);
    }
    static void registerBasic(BenefitService benefitService, Scanner sd){
        System.out.println("Ingrese codigo:");
        String code = sd.nextLine();

        System.out.println("Ingrese nombre:");
        String name = sd.nextLine();

        System.out.println("Ingrese descripcion:");
        String description = sd.nextLine();

        System.out.println("Ingrese fecha:");
        String date = sd.nextLine();

        System.out.println("Ingrese hora inicio:");
        String startHour = sd.nextLine();

        System.out.println("Ingrese hora fin:");
        String endHour = sd.nextLine();

        System.out.println("Ingrese cupos totales:");
        int totalQuotas = sd.nextInt();

        System.out.println("Ingrese precio base:");
        double basePrice = sd.nextDouble();
        sd.nextLine();

        System.out.println("Ingrese duracion en minutos:");
        int duration = sd.nextInt();
        sd.nextLine();

        System.out.println("Incluye certificado? -digite true o false-");
        Boolean certificate = sd.nextBoolean();
        sd.nextLine();

        Basic basic = new Basic(basePrice, code, date, description, "Disponible", endHour, startHour, name, totalQuotas, totalQuotas, certificate, duration);
        benefitService.registerBenefit(basic);
    }
    static void registerSpecialization(Scanner sd, BenefitService benefitService){
        System.out.println("Ingrese codigo:");
        String code = sd.nextLine();

        System.out.println("Ingrese nombre:");
        String name = sd.nextLine();

        System.out.println("Ingrese descripcion:");
        String description = sd.nextLine();

        System.out.println("Ingrese fecha:");
        String date = sd.nextLine();

        System.out.println("Ingrese hora inicio:");
        String HourI = sd.nextLine();

        System.out.println("Ingrese hora fin:");
        String endHour = sd.nextLine();

        System.out.println("Ingrese cupos totales:");
        int totalQuotas = sd.nextInt();

        System.out.println("Ingrese precio base:");
        double basePrice = sd.nextDouble();
        sd.nextLine();

        System.out.println("Ingrese especialidad:");
        String specialty = sd.nextLine();

        System.out.println("Requiere examenes? true/false");
        Boolean previousExams = sd.nextBoolean();

        System.out.println("Ingrese cargo adicional:");
        double additionalCharge = sd.nextDouble();
        sd.nextLine();

        Especializated especializated = new Especializated( basePrice, code, date, description, "Disponible", endHour, HourI, name, totalQuotas, totalQuotas, additionalCharge, specialty, previousExams);
        benefitService.registerBenefit(especializated);

    }
    static void registerAppointment(Scanner sd, AppoinmentService appoinmentService,OwnerService ownerService, BenefitService benefitService){
        System.out.println("Ingrese codigo de cita:");
        String code = sd.nextLine();

        System.out.println("Ingrese cedula del dueño:");
        String id = sd.nextLine();

        Owner owner = ownerService.searchOwner(id);

        System.out.println("Ingrese codigo del servicio:");
        String serviceCode = sd.nextLine();

        Benefit benefit = benefitService.searchBenefit(code);

        System.out.println("Ingrese cantidad de cupos:");
        int quotas = sd.nextInt();
        sd.nextLine();

        System.out.println("Ingrese fecha:");
        String date = sd.nextLine();

        Appoinment appoinment = new Appoinment(code, "Confirmada", owner, quotas, date, benefit, 0);

        appoinmentService.registerAppoinment(appoinment);
    }
    static void cancelAppoinment(Scanner sd, AppoinmentService appoinmentService){
        System.out.println("Ingrese el codigo de la cita: ");
        String code = sd.nextLine();
        appoinmentService.cancelAppointment(code);
    }
    static void searchAppointment(Scanner sd, AppoinmentService appoinmentService){
        System.out.println("Ingrese el codigo de la cita: ");
        String code = sd.nextLine();
        appoinmentService.searchAppointment(code);
    }
    static void appointmentsByOwner(Scanner sd, AppoinmentService appoinmentService) {
        System.out.println("Ingrese cedula del dueño:");
        String id = sd.nextLine();
        appoinmentService.appointmentsByOwner(id);
    }
    static void totalOwners(OwnerService ownerService){
        System.out.println("Total dueños: " + ownerService.totalOwner());
    }




}
