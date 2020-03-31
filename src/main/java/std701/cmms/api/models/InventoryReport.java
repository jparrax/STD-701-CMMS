package std701.cmms.api.models;

import java.math.BigDecimal;

public class InventoryReport {
    private String materialName;
    private String inciName;
    private String batchNumber;
    private String analysisNumber;
    private BigDecimal quantity;
    private String supplier;

    public InventoryReport(String materialName, String inciName, String batchNumber, String analysisNumber, BigDecimal quantity, String supplier) {
        this.materialName = materialName;
        this.inciName = inciName;
        this.batchNumber = batchNumber;
        this.analysisNumber = analysisNumber;
        this.quantity = quantity;
        this.supplier = supplier;
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

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getInciName() {
        return inciName;
    }

    public void setInciName(String inciName) {
        this.inciName = inciName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
