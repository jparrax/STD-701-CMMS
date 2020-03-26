package std701.cmms.api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="suppliers")
public class Supplier {
  @Id
  @GeneratedValue
  private long supplierId;
  private String name;
  private Boolean isActive;
  private java.sql.Timestamp createdAt;


  public long getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(long supplierId) {
    this.supplierId = supplierId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
