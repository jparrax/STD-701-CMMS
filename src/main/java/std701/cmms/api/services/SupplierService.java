package std701.cmms.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import std701.cmms.api.models.Supplier;
import std701.cmms.api.repositories.SupplierRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SupplierService {
    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findAllSupplier(){
        return StreamSupport.stream(supplierRepository.findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }
}
