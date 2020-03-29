package std701.cmms.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "formulas")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Formula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer formulaId;
    private String formulaName;
    private String formulaDesc;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
    private Boolean isActive;
    private java.sql.Timestamp createdAt;

    @OneToMany(mappedBy = "formula")
    private Set<Ingredient> ingredientList;


    public Integer getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(Integer formulaId) {
        this.formulaId = formulaId;
    }


    public String getFormulaName() {
        return formulaName;
    }

    public void setFormulaName(String formulaName) {
        this.formulaName = formulaName;
    }


    public String getFormulaDesc() {
        return formulaDesc;
    }

    public void setFormulaDesc(String formulaDesc) {
        this.formulaDesc = formulaDesc;
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

    public Set<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(Set<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
