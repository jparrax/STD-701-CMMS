package std701.cmms.api.repositories;

import std701.cmms.api.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
