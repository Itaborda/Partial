package entities;

public class Especializated extends Benefit{
    private String especialty;
    private boolean exams;
    private double additional;


    public Especializated(double basePrice, String code, String date, String description, String estate, String hourF, String hourI, String name, int remainingQuotas, int totalQuotas, double additional, String especialty, boolean exams) {
        super(basePrice, code, date, description, estate, hourF, hourI, name, remainingQuotas, totalQuotas);
        this.additional = additional;
        this.especialty = especialty;
        this.exams = exams;
    }

    public double getAdditional() {
        return additional;
    }

    public void setAdditional(double additional) {
        this.additional = additional;
    }

    public String getEspecialty() {
        return especialty;
    }

    public void setEspecialty(String especialty) {
        this.especialty = especialty;
    }

    public boolean isExams() {
        return exams;
    }

    public void setExams(boolean exams) {
        this.exams = exams;
    }

    public double calculateFinalPrice(){
        return getBasePrice()+additional;
    }

    @Override
    public String toString() {
        return "Especializated{" +
                super.toString()+
                "additional=" + additional +
                ", especialty='" + especialty + '\'' +
                ", exams=" + exams +
                '}';
    }
}
