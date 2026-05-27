package entities;

public class Benefit {

    private String code;
    private String name;
    private String description;
    private String date;
    private String hourI;
    private String hourF;
    private int totalQuotas;
    private int remainingQuotas;
    private double basePrice;
    private String estate;

    public Benefit(double basePrice, String code, String date, String description, String estate, String hourF, String hourI, String name, int remainingQuotas, int totalQuotas) {
        this.basePrice = basePrice;
        this.code = code;
        this.date = date;
        this.description = description;
        this.estate = estate;
        this.hourF = hourF;
        this.hourI = hourI;
        this.name = name;
        this.remainingQuotas = remainingQuotas;
        this.totalQuotas = totalQuotas;
    }

    @Override
    public String toString() {
        return "Benefit{" +
                "basePrice=" + basePrice +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", hourI='" + hourI + '\'' +
                ", hourF='" + hourF + '\'' +
                ", totalQuotas=" + totalQuotas +
                ", remainingQuotas=" + remainingQuotas +
                ", estate='" + estate + '\'' +
                '}';
    }
    public double calculateFinalPrice(){
        return basePrice;
    }
    public void reducirCupos(int cantidad) {
        remainingQuotas -= cantidad;
    }

    public void devolverCupos(int cantidad) {
        remainingQuotas += cantidad;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getHourF() {
        return hourF;
    }

    public void setHourF(String hourF) {
        this.hourF = hourF;
    }

    public String getHourI() {
        return hourI;
    }

    public void setHourI(String hourI) {
        this.hourI = hourI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRemainingQuotas() {
        return remainingQuotas;
    }

    public void setRemainingQuotas(int remainingQuotas) {
        this.remainingQuotas = remainingQuotas;
    }

    public int getTotalQuotas() {
        return totalQuotas;
    }

    public void setTotalQuotas(int totalQuotas) {
        this.totalQuotas = totalQuotas;
    }
}

