package std701.cmms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import std701.cmms.api.models.Inventory;
import std701.cmms.api.models.InventoryReport;
import std701.cmms.api.models.OrderTransaction;
import std701.cmms.api.repositories.FormulaRepository;
import std701.cmms.api.repositories.InventoryRepository;
import std701.cmms.api.repositories.OrderTransactionRepository;
import std701.cmms.api.repositories.RawMaterialRepository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {
    private RawMaterialRepository rawMaterialRepository;
    private InventoryRepository inventoryRepository;
    private OrderTransactionRepository orderTransactionRepository;
    private FormulaRepository formulaRepository;

    public ReportController(RawMaterialRepository rawMaterialRepository,
                            InventoryRepository inventoryRepository,
                            OrderTransactionRepository orderTransactionRepository,
                            FormulaRepository formulaRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
        this.inventoryRepository = inventoryRepository;
        this.orderTransactionRepository = orderTransactionRepository;
        this.formulaRepository = formulaRepository;
    }

    @GetMapping("/inventory")
    public List<InventoryReport> inventoryReport(@RequestParam Date from, @RequestParam Date to) {
        return inventoryRepository.getInventoryReport(from, to);
    }

    @GetMapping("/usage")
    public List<Inventory> usageReport(@RequestParam Integer materialId,
                                       @RequestParam Date from,
                                       @RequestParam Date to){
        return inventoryRepository.findAllByRawMaterialAndCreatedAtBetweenAndQuantityIsLessThanOrderByCreatedAtAsc(
                rawMaterialRepository.findById(materialId).orElse(null), from, to, new BigDecimal(0)
        );
    }

    @GetMapping("/formula")
    public List<OrderTransaction> formulaReport(@RequestParam Integer formulaId ,
                                                @RequestParam Date from,
                                                @RequestParam Date to){
        return orderTransactionRepository.findAllByFormulaAndCreatedAtBetweenOrderByCreatedAtAsc(
                formulaRepository.findById(formulaId).orElse(null),
                from,
                to
        );
    }
}
