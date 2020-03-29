package std701.cmms.api.repositories;

import std701.cmms.api.models.Inventory;
import org.springframework.data.repository.CrudRepository;
import std701.cmms.api.models.RawMaterial;

import java.util.List;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
    public List<Inventory> findByRawMaterialOrderByCreatedAtDesc(RawMaterial rawMaterial);
}
