package std701.cmms.api.repositories;

import org.springframework.data.repository.CrudRepository;
import std701.cmms.api.models.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Integer> {
}
