package std701.cmms.api.models;

import javax.persistence.*;

@Entity
@Table(name="formulas")
public class Formula {
  @Id
  @GeneratedValue
  private long formulaId;
  private String name;
  private String desc;

  @ManyToOne
  @JoinColumn(name = "fk_user_id")
  private User user;
  private Boolean isActive;
  private java.sql.Timestamp createdAt;


  public long getFormulaId() {
    return formulaId;
  }

  public void setFormulaId(long formulaId) {
    this.formulaId = formulaId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
