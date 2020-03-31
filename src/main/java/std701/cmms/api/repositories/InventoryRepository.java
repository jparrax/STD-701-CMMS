package std701.cmms.api.repositories;

import org.springframework.data.jpa.repository.Query;
import std701.cmms.api.models.Inventory;
import org.springframework.data.repository.CrudRepository;
import std701.cmms.api.models.InventoryReport;
import std701.cmms.api.models.RawMaterial;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
    public List<Inventory> findByRawMaterialOrderByCreatedAtDesc(RawMaterial rawMaterial);

    @Query(nativeQuery = true)
    public List<InventoryReport> getInventoryReport(Date from, Date to);

    public List<Inventory> findAllByRawMaterialAndCreatedAtBetweenAndQuantityIsLessThanOrderByCreatedAtAsc(
            RawMaterial rawMaterial, Date from, Date to, BigDecimal lessThan);
}
