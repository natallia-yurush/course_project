package by.ny.server.entity;

import java.io.Serializable;

public class Credit implements Serializable {
    private static final long serialVersionUID = -5082422066775057029L;

    private Integer id;
    private String purpose;
    private Double maxAmount;
    private Integer percent;
    private Integer maxTerm;

    public Credit(Integer id, String purpose, Double maxAmount, Integer percent, Integer maxTerm) {
        this.id = id;
        this.purpose = purpose;
        this.maxAmount = maxAmount;
        this.percent = percent;
        this.maxTerm = maxTerm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Integer getMaxTerm() {
        return maxTerm;
    }

    public void setMaxTerm(Integer maxTerm) {
        this.maxTerm = maxTerm;
    }

    @Override
    public String toString() {
        return purpose + ", сумма: " + maxAmount + ", процент: " + percent + ", срок: " + maxTerm;
    }
}
