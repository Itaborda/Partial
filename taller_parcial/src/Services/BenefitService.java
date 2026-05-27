package Services;

import Repositories.BenefitRepository;
import entities.Benefit;

public class BenefitService {
    private BenefitRepository benefitRepository = new BenefitRepository();

    public void registerBenefit(Benefit b) {
        try {
            if (benefitRepository.getByCode(b.getCode()) != null) {
                System.out.println("El codigo ya existe");
                return;
            }
            if (b.getCode().isBlank() || b.getName().isBlank() || b.getDescription().isBlank()
                    || b.getDate().isBlank() || b.getHourI().isBlank() || b.getHourF().isBlank()
                    || b.getEstate().isBlank()) {
                System.out.println("Todos los campos son obligatorios");
                return;
            }
            if (b.getTotalQuotas() <= 0) {
                System.out.println("Debe haber al menos 1 cupo");
                return;
            }
            if (b.getBasePrice() <= 0) {
                System.out.println("El precio debe ser mayor a 0");
                return;
            }
            benefitRepository.saveBenefit(b);
            System.out.println("Servicio registrado");
        } catch (Exception e) {
            System.out.println(".....Error al registrar el servicio: " + e.getMessage());
        }
    }

    public void listAllServices() {
        try {
            if (benefitRepository.getAll().isEmpty()) {
                System.out.println("No hay servicios registrados");
                return;
            }
            benefitRepository.showAllBenefit();
        } catch (Exception e) {
            System.out.println("..........Error al listar los servicios: " + e.getMessage());
        }
    }

    public Benefit searchBenefit(String code) {
        try {
            Benefit found = benefitRepository.getByCode(code);
            if (found == null) {
                System.out.println("No se encontró el servicio con codigo: " + code);
            }
            return found;
        } catch (Exception e) {
            System.out.println(".........Error al buscar el servicio: " + e.getMessage());
            return null;
        }
    }
}
