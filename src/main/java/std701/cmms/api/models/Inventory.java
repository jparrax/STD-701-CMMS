package std701.cmms.api.models;


import javax.persistence.*;

@Entity
@Table(name="inventories")
public class Inventory {
  @Id
  @GeneratedValue
  private long invId;

  @ManyToOne
  @JoinColumn(name = "material_id")
  private RawMaterial rawMaterial;
  private String batchNumber;
  private String analysisNumber;
  private java.sql.Date expiredDate;

  @ManyToOne
  @JoinColumn(name = "supplier")
  private Supplier supplier;
  private String desc;
  private double quantity;
  private Boolean isActive;
  private java.sql.Timestamp createdAt;


  public long getInvId() {
    return invId;
  }

  public void setInvId(long invId) {
    this.invId = invId;
  }


  public String getBatchNumber() {
    return batchNumber;
  }

  public void setBatchNumber(String batchNumber) {
    this.batchNumber = batchNumber;
  }


  public String getAnalysisNumber() {
    return analysisNumber;
  }

  public void setAnalysisNumber(String analysisNumber) {
    this.analysisNumber = analysisNumber;
  }


  public java.sql.Date getExpiredDate() {
    return expiredDate;
  }

  public void setExpiredDate(java.sql.Date expiredDate) {
    this.expiredDate = expiredDate;
  }


  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }


  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
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

  public RawMaterial getRawMaterial() {
    return rawMaterial;
  }

  public void setRawMaterial(RawMaterial rawMaterial) {
    this.rawMaterial = rawMaterial;
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }
}
