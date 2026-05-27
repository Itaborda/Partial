package entities;

public class Owner {
    private String id;
    private String name;
    private String lastName;
    private String email;
    private String cell;
    private String address;
    private String petName;
    private String petSpecies;
    private String petRace;
    private int petAge;

    public Owner(String address, String cell, String email, String id, String lastName, String name, int petAge, String petName, String petRace, String petSpecies) {
        this.address = address;
        this.cell = cell;
        this.email = email;
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.petAge = petAge;
        this.petName = petName;
        this.petRace = petRace;
        this.petSpecies = petSpecies;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "address='" + address + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", cell='" + cell + '\'' +
                ", petName='" + petName + '\'' +
                ", petSpecies='" + petSpecies + '\'' +
                ", petRace='" + petRace + '\'' +
                ", petAge=" + petAge +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPetAge() {
        return petAge;
    }

    public void setPetAge(int petAge) {
        this.petAge = petAge;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetRace() {
        return petRace;
    }

    public void setPetRace(String petRace) {
        this.petRace = petRace;
    }

    public String getPetSpecies() {
        return petSpecies;
    }

    public void setPetSpecies(String petSpecies) {
        this.petSpecies = petSpecies;
    }
}
