package std701.cmms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import std701.cmms.api.models.HttpResponse;
import std701.cmms.api.models.Inventory;
import std701.cmms.api.models.RawMaterial;
import std701.cmms.api.models.Supplier;
import std701.cmms.api.models.User;
import std701.cmms.api.repositories.InventoryRepository;
import std701.cmms.api.repositories.RawMaterialRepository;
import std701.cmms.api.repositories.SupplierRepository;
import std701.cmms.api.repositories.UserRepository;
import std701.cmms.api.services.SupplierService;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/rawmaterials")
public class RawMaterialController {
    private RawMaterialRepository rawMaterialRepository;
    private UserRepository userRepository;
    private InventoryRepository inventoryRepository;
    private SupplierRepository supplierRepository;

    @Autowired
    public RawMaterialController(RawMaterialRepository rawMaterialRepository,
                                 UserRepository userRepository,
                                 InventoryRepository inventoryRepository,
                                 SupplierRepository supplierRepository) {
        this.rawMaterialRepository = rawMaterialRepository;
        this.userRepository = userRepository;
        this.inventoryRepository = inventoryRepository;
        this.supplierRepository = supplierRepository;
    }

    @GetMapping
    public HttpResponse<List<RawMaterial>> getRawMaterial() {
        HttpResponse<List<RawMaterial>> response = new HttpResponse<>();
        response.setMessage("Success!");
        response.setStatus(200);
        response.setData(StreamSupport.stream(rawMaterialRepository.findAll()
                .spliterator(), false)
                .collect(Collectors.toList()));
        return response;
    }

    @PostMapping
    public HttpResponse<RawMaterial> saveRawMaterial(@RequestBody RawMaterial rawMaterial) {
        HttpResponse<RawMaterial> httpResponse = new HttpResponse<>();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        User defaultUser = userRepository.findById(1).orElse(null);
        //If materialId = null that's mean we gonna create a new raw material
        if (rawMaterial.getMaterialId() == null) {
            rawMaterial.setIsActive(true);
            rawMaterial.setCreatedAt(currentTimestamp);
            rawMaterial.setUser(defaultUser);
        }
        //Save or update the raw material
        rawMaterial = rawMaterialRepository.save(rawMaterial);

        if (rawMaterial.getMaterialId() != null) {
            httpResponse.setStatus(200);
            httpResponse.setMessage("Success!");
            httpResponse.setData(rawMaterial);
        } else {
            httpResponse.setStatus(500);
            httpResponse.setMessage("Internal Server Error!");
        }
        return httpResponse;
    }

    @GetMapping("/inventories/{materialId}")
    public List<Inventory> getInventories(@PathVariable Integer materialId) {

        return inventoryRepository.findByRawMaterialOrderByCreatedAtDesc(rawMaterialRepository.findById(materialId)
                .orElse(null));
    }

    @PostMapping("/inventories")
    public HttpResponse<Inventory> saveInventories(@RequestBody Inventory inventory) {
        HttpResponse<Inventory> httpResponse = new HttpResponse<>();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        if (inventory.getInvId() == null) {
            inventory.setCreatedAt(currentTimestamp);
            inventory.setIsActive(true);
        }

        inventory.setRawMaterial(rawMaterialRepository.findById(inventory.getRawMaterial().getMaterialId())
                .orElse(null));
        inventory.setSupplier(supplierRepository.findById(inventory.getSupplier().getSupplierId())
                .orElse(null));

        inventory = inventoryRepository.save(inventory);
        if (inventory.getInvId() != null) {
            httpResponse.setStatus(200);
            httpResponse.setMessage("Success!");
            httpResponse.setData(inventory);
        } else {
            httpResponse.setStatus(500);
            httpResponse.setMessage("Internal Server Error!");
        }
        return httpResponse;
    }

    @GetMapping("/supplier")
    public HttpResponse<List<Supplier>> getSupplier() {
        HttpResponse<List<Supplier>> response = new HttpResponse<>();
        response.setMessage("Success!");
        response.setStatus(200);
        response.setData(StreamSupport.stream(supplierRepository.findAll().spliterator(), false)
                .collect(Collectors.toList()));

        return response;
    }


}
