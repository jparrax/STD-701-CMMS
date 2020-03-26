package std701.cmms.api.repositories;

import std701.cmms.api.models.OrderTransaction;
import org.springframework.data.repository.CrudRepository;

public interface OrderTransactionRepository extends CrudRepository<OrderTransaction, Integer> {
}
