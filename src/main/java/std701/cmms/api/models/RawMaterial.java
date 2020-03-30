package std701.cmms.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "raw_materials")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer materialId;
    private String name;
    private String inciName;
    private Boolean isActive;
    private java.sql.Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Where(clause = "is_active = 'true'")
    @OneToMany(mappedBy = "rawMaterial")
    @JsonIgnore
    private List<Inventory> inventoryList;

    @JsonInclude()
    @Transient
    private BigDecimal quantity;

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public BigDecimal getQuantity() {
        if(this.inventoryList != null){
            setQuantity(this.inventoryList
                    .stream()
                    .reduce(new BigDecimal(0), (total, inventory) -> {
                        return total.add(inventory.getQuantity());
                    }, BigDecimal::add)
            );
        }
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
