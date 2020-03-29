package std701.cmms.api.models;

import javax.persistence.*;

@Entity
@Table(name = "order_transactions")
public class OrderTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionId;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "fk_formula_id")
    private Formula formula;
    private double batchSize;
    private String transactionDesc;
    private Boolean isActive;
    private java.sql.Timestamp createdAt;


    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }


    public double getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(double batchSize) {
        this.batchSize = batchSize;
    }


    public String getTransactionDesc() {
        return transactionDesc;
    }

    public void setTransactionDesc(String transactionDesc) {
        this.transactionDesc = transactionDesc;
    }


    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }


    public java.sql.Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }
}
