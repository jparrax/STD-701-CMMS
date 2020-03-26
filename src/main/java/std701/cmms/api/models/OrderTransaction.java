package std701.cmms.api.models;

import javax.persistence.*;

@Entity
@Table(name="order_transactions")
public class OrderTransaction {
  @Id
  @GeneratedValue
  private long transactionId;

  @ManyToOne
  @JoinColumn(name = "fk_order_id")
  private Order order;

  @ManyToOne
  @JoinColumn(name = "fk_formula_id")
  private Formula formula;
  private double batchSize;
  private String desc;
  private Boolean isActive;
  private java.sql.Timestamp createdAt;


  public long getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(long transactionId) {
    this.transactionId = transactionId;
  }


  public double getBatchSize() {
    return batchSize;
  }

  public void setBatchSize(double batchSize) {
    this.batchSize = batchSize;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
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
