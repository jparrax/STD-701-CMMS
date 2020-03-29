package std701.cmms.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ingredientId;

    private double percentage;
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_formula_id")
    @JsonIgnore
    private Formula formula;

    @ManyToOne
    @JoinColumn(name = "fk_material_id")
    private RawMaterial rawMaterial;

    private java.sql.Timestamp inputDate;
    private String ingredientDesc;
    private Boolean isActive;
    private java.sql.Timestamp createdAt;


    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public java.sql.Timestamp getInputDate() {
        return inputDate;
    }

    public void setInputDate(java.sql.Timestamp inputDate) {
        this.inputDate = inputDate;
    }

    public String getIngredientDesc() {
        return ingredientDesc;
    }

    public void setIngredientDesc(String ingredientDesc) {
        this.ingredientDesc = ingredientDesc;
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

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public RawMaterial getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(RawMaterial rawMaterial) {
        this.rawMaterial = rawMaterial;
    }
}
