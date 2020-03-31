package std701.cmms.api.repositories;

import std701.cmms.api.models.Formula;
import std701.cmms.api.models.OrderTransaction;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface OrderTransactionRepository extends CrudRepository<OrderTransaction, Integer> {
    public List<OrderTransaction> findAllByFormulaAndCreatedAtBetweenOrderByCreatedAtAsc(
            Formula formula, Date from, Date to
            );
}
