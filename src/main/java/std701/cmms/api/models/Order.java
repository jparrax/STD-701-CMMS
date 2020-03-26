package std701.cmms.api.models;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
  @Id
  @GeneratedValue
  private long orderId;

  @ManyToOne
  @JoinColumn(name = "fk_user_id")
  private User user;
  private String customerName;
  private java.sql.Timestamp orderDate;
  private String desc;
  private Boolean isActive;
  private java.sql.Timestamp createdAt;


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  public java.sql.Timestamp getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(java.sql.Timestamp orderDate) {
    this.orderDate = orderDate;
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

}
