package std701.cmms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import std701.cmms.api.models.HttpResponse;
import std701.cmms.api.models.RawMaterial;
import std701.cmms.api.models.Supplier;
import std701.cmms.api.repositories.RawMaterialRepository;
import std701.cmms.api.services.SupplierService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/rawmaterials")
public class RawMaterialController {
    private RawMaterialRepository rawMaterialRepository;
    private SupplierService supplierService;

    @Autowired
    public RawMaterialController(RawMaterialRepository rawMaterialRepository, SupplierService supplierService) {
        this.rawMaterialRepository = rawMaterialRepository;
        this.supplierService = supplierService;
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

    @GetMapping("/supplier")
    public HttpResponse<List<Supplier>> getSupplier() {
        HttpResponse<List<Supplier>> response = new HttpResponse<>();
        response.setMessage("Success!");
        response.setStatus(200);
        response.setData(supplierService.findAllSupplier());

        return response;
    }
}
