package entities;

public class Appoinment {
    private String code;
    private Owner owner;
    private Benefit serviceCode;
    private int quotas;
    private String scheduletDate;
    private double totalPrice;
    private String estate;

    public Appoinment(String code, String estate, Owner owner, int quotas, String scheduletDate, Benefit serviceCode, double totalPrice) {
        this.code = code;
        this.estate = estate;
        this.owner = owner;
        this.quotas = quotas;
        this.scheduletDate = scheduletDate;
        this.serviceCode = serviceCode;
        this.totalPrice = totalPrice;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getQuotas() {
        return quotas;
    }

    public void setQuotas(int quotas) {
        this.quotas = quotas;
    }

    public String getScheduletDate() {
        return scheduletDate;
    }

    public void setScheduletDate(String scheduletDate) {
        this.scheduletDate = scheduletDate;
    }

    public Benefit getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(Benefit serviceCode) {
        this.serviceCode = serviceCode;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Appoinment{" +
                "code='" + code + '\'' +
                ", owner=" + owner +
                ", serviceCode=" + serviceCode +
                ", quotas=" + quotas +
                ", scheduletDate='" + scheduletDate + '\'' +
                ", totalPrice=" + totalPrice +
                ", estate='" + estate + '\'' +
                '}';
    }
}
