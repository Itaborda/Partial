package Services;

import Repositories.OwnerRepository;
import entities.Owner;

public class OwnerService {
    private OwnerRepository ownerRepository = new OwnerRepository();

    public void registerOwner(Owner o) {
        try {
            if (ownerRepository.getById(o.getId()) != null) {
                System.out.println("La cedula ya existe");
                return;
            }
            if (!o.getEmail().contains("@")) {
                System.out.println("El correo debe tener @");
                return;
            }
            if (o.getId().isBlank() || o.getName().isBlank() || o.getLastName().isBlank() || o.getEmail().isBlank()) {
                System.out.println("Todos los campos son obligatorios");
                return;
            }
            if (o.getPetAge() < 0) {
                System.out.println("La edad no puede ser negativa");
                return;
            }
            ownerRepository.saveOwner(o);
            System.out.println("Usuario registrado correctamente");
        } catch (Exception e) {
            System.out.println("Error al registrar el dueño: " + e.getMessage());
        }
    }

    public void listAll() {
        try {
            if (ownerRepository.getAll().isEmpty()) {
                System.out.println("No hay dueños registrados");
                return;
            }
            ownerRepository.showAllOwner();
        } catch (Exception e) {
            System.out.println("Error al listar los dueños: " + e.getMessage());
        }
    }

    public Owner searchOwner(String id) {
        try {
            Owner found = ownerRepository.getById(id);
            if (found == null) {
                System.out.println("No se encontró el dueño con cedula: " + id);
            }
            return found;
        } catch (Exception e) {
            System.out.println("Error al buscar el dueño: " + e.getMessage());
            return null;
        }
    }

    public int totalOwner() {
        try {
            return ownerRepository.getAll().size();
        } catch (Exception e) {
            System.out.println("Error al obtener el total de dueños: " + e.getMessage());
            return 0;
        }
    }
}
