package pl.agh.id.tripsettlement.rest.groups.model;

/**
 * Created by pawel on 22.10.16.
 */
public class UserResumeDTO {

    private Long id;
    private Double toPay;
    private Double overpayment;
    private String currency;

    public UserResumeDTO() {
    }

    @Override
    public String toString() {
        return "UserResumeDTO{" +
                "id=" + id +
                ", toPay=" + toPay +
                ", overpayment=" + overpayment +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getToPay() {
        return toPay;
    }

    public void setToPay(Double toPay) {
        this.toPay = toPay;
    }

    public Double getOverpayment() {
        return overpayment;
    }

    public void setOverpayment(Double overpayment) {
        this.overpayment = overpayment;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
