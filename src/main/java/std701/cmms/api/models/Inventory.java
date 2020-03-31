package std701.cmms.api.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "inventories")
@SqlResultSetMapping(
        name = "inventoryReportMapping",
        classes = {
                @ConstructorResult(
                        targetClass = InventoryReport.class,
                        columns = {
                                @ColumnResult(name = "materialName"),
                                @ColumnResult(name = "inciName"),
                                @ColumnResult(name = "batchNumber"),
                                @ColumnResult(name = "analysisNumber"),
                                @ColumnResult(name = "quantity", type=BigDecimal.class),
                                @ColumnResult(name = "supplier")
                        }
                )
        }
)
@NamedNativeQuery(name="Inventory.getInventoryReport",query = "select inventories.material_id, raw_materials.\"name\" as materialName,\n" +
        "raw_materials.inci_name as inciName,\n" +
        "string_agg(batch_number, ', ') as batchNumber, \n" +
        "string_agg(analysis_number, ', ') as analysisNumber,\n" +
        "string_agg(suppliers.\"name\", ', ') as supplier,\n" +
        "sum(quantity) as quantity\n" +
        "from inventories\n" +
        "left join raw_materials on inventories.material_id = raw_materials.material_id\n" +
        "left join suppliers on inventories.supplier = suppliers.supplier_id\n" +
        "where inventories.created_at > ?1 and inventories.created_at < ?2\n" +
        "group by inventories.material_id , raw_materials.\"name\" , raw_materials.inci_name;",
        resultSetMapping = "inventoryReportMapping")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invId;

    @ManyToOne
    @JoinColumn(name = "material_id")
    @JsonIgnore
    private RawMaterial rawMaterial;
    private String batchNumber;
    private String analysisNumber;
    private java.sql.Date expiredDate;

    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;
    private String inventoryDesc;
    private BigDecimal quantity;
    private Boolean isActive;
    private java.sql.Timestamp createdAt;


    public Integer getInvId() {
        return invId;
    }

    public void setInvId(Integer invId) {
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


    public String getInventoryDesc() {
        return inventoryDesc;
    }

    public void setInventoryDesc(String inventoryDesc) {
        this.inventoryDesc = inventoryDesc;
    }


    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
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
