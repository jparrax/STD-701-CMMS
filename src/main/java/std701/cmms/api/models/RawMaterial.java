package std701.cmms.api.models;

import javax.persistence.*;

@Entity
@Table(name="raw_materials")
public class RawMaterial {
  @Id
  @GeneratedValue
  private long materialId;
  private String name;
  private String inciName;
  private Boolean isActive;
  private java.sql.Timestamp createdAt;
  @ManyToOne
  @JoinColumn(name = "fk_user_id")
  private User user;


  public long getMaterialId() {
    return materialId;
  }

  public void setMaterialId(long materialId) {
    this.materialId = materialId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getInciName() {
    return inciName;
  }

  public void setInciName(String inciName) {
    this.inciName = inciName;
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
