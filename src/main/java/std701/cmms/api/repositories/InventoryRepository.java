package std701.cmms.api.repositories;

import std701.cmms.api.models.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}
