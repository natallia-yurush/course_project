package by.ny.server.entity;

import java.io.Serializable;
import java.util.Date;

public class UserCredit implements Serializable {
    private static final long serialVersionUID = -903275726973172758L;

    private Integer id;
    private Date issueDate;
    private Double issueAmount;
    private Double basicMonthlyPayment;
    private Double interestMonthlyPayment;
    private CreditStatus status;
    private Integer creditId;
    private Integer userId;
    private Double contributed_amount;


    public UserCredit(Integer id, Date issueDate, Double issueAmount, Double basicMonthlyPayment, Double interestMonthlyPayment, CreditStatus status, Integer creditId, Integer userId, Double contributed_amount) {
        this.id = id;
        this.issueDate = issueDate;
        this.issueAmount = issueAmount;
        this.basicMonthlyPayment = basicMonthlyPayment;
        this.interestMonthlyPayment = interestMonthlyPayment;
        this.status = status;
        this.creditId = creditId;
        this.userId = userId;
        this.contributed_amount = contributed_amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Double getIssueAmount() {
        return issueAmount;
    }

    public void setIssueAmount(Double issueAmount) {
        this.issueAmount = issueAmount;
    }

    public Double getBasicMonthlyPayment() {
        return basicMonthlyPayment;
    }

    public void setBasicMonthlyPayment(Double basicMonthlyPayment) {
        this.basicMonthlyPayment = basicMonthlyPayment;
    }

    public Double getInterestMonthlyPayment() {
        return interestMonthlyPayment;
    }

    public void setInterestMonthlyPayment(Double interestMonthlyPayment) {
        this.interestMonthlyPayment = interestMonthlyPayment;
    }

    public CreditStatus getStatus() {
        return status;
    }

    public void setStatus(CreditStatus status) {
        this.status = status;
    }

    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getContributed_amount() {
        return contributed_amount;
    }

    public void setContributed_amount(Double contributed_amount) {
        this.contributed_amount = contributed_amount;
    }
}
