package entities;

public class Basic extends Benefit{
    private int duration;
    private boolean certificate;


    public Basic(double basePrice, String code, String date, String description, String estate, String hourF, String hourI, String name, int remainingQuotas, int totalQuotas, boolean certificate, int duration) {
        super(basePrice, code, date, description, estate, hourF, hourI, name, remainingQuotas, totalQuotas);
        this.certificate = certificate;
        this.duration = duration;
    }

    public boolean isCertificate() {
        return certificate;
    }

    public void setCertificate(boolean certificate) {
        this.certificate = certificate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Basic{" +
                super.toString()+
                "certificate=" + certificate +
                ", duration=" + duration +
                '}';
    }
}
