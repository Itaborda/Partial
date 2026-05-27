package Services;

import Repositories.AppoinmentRepository;
import Repositories.BenefitRepository;
import Repositories.OwnerRepository;
import entities.Appoinment;

public class AppoinmentService {
    private AppoinmentRepository appoinmentRepository = new AppoinmentRepository();
    private OwnerRepository ownerRepository = new OwnerRepository();
    private BenefitRepository benefitRepository = new BenefitRepository();

    public void registerAppoinment(Appoinment a) {
        try {
            if (appoinmentRepository.getBycode(a.getCode()) != null) {
                System.out.println("El codigo ya existe");
                return;
            }
            if (ownerRepository.getById(a.getOwner().getId()) == null) {
                System.out.println("El usuario no existe");
                return;
            }
            if (benefitRepository.getByCode(a.getServiceCode().getCode()) == null) {
                System.out.println("El servicio no existe");
                return;
            }
            if (!a.getServiceCode().getEstate().equalsIgnoreCase("Disponible")) {
                System.out.println("No se puede agendar en un servicio no disponible");
                return;
            }
            if (a.getQuotas() < 1 || a.getQuotas() > 3) {
                System.out.println("Solo se pueden reservar entre 1 y 3 cupos");
                return;
            }
            if (a.getQuotas() > a.getServiceCode().getRemainingQuotas()) {
                System.out.println("No hay suficientes cupos disponibles");
                return;
            }
            a.setEstate("Confirmada");
            a.setTotalPrice(a.getServiceCode().calculateFinalPrice() * a.getQuotas());
            int newQuotas = a.getServiceCode().getRemainingQuotas() - a.getQuotas();
            a.getServiceCode().setRemainingQuotas(newQuotas);
            appoinmentRepository.saveAppoinment(a);
            System.out.println("Cita agendada correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar la cita: " + e.getMessage());
        }
    }

    public void cancelAppointment(String code) {
        try {
            Appoinment a = appoinmentRepository.getBycode(code);
            if (a == null) {
                System.out.println("Cita no encontrada");
                return;
            }
            a.setEstate("Cancelado");
            a.getServiceCode().setRemainingQuotas(a.getServiceCode().getRemainingQuotas() + a.getQuotas());
            System.out.println("Cita cancelada");
        } catch (Exception e) {
            System.out.println("Error al cancelar la cita: " + e.getMessage());
        }
    }

    public Appoinment searchAppointment(String code) {
        try {
            Appoinment found = appoinmentRepository.getBycode(code);
            if (found == null) {
                System.out.println("No se encontro la cita");
                return null;
            }
            System.out.println(found);
            return found;
        } catch (Exception e) {
            System.out.println("Error al buscar la cita: " + e.getMessage());
            return null;
        }
    }

    public void appointmentsByOwner(String id) {
        try {
            int count = 0;
            for (Appoinment a : appoinmentRepository.getAll()) {
                if (a.getOwner().getId().equals(id)) {
                    System.out.println(a);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("No se encontraron citas para ese dueño");
            }
        } catch (Exception e) {
            System.out.println("Error al listar las citas: " + e.getMessage());
        }
    }
}
