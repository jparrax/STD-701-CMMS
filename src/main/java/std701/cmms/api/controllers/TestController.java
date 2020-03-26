package std701.cmms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import std701.cmms.api.models.RawMaterial;
import std701.cmms.api.repositories.RawMaterialRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TestController {
    private RawMaterialRepository rawMaterialRepository;
    @Autowired
    public TestController(RawMaterialRepository rawMaterialRepository){
        this.rawMaterialRepository = rawMaterialRepository;
    }

    @GetMapping("/test")
    public List<RawMaterial> test(){
        return StreamSupport.stream(rawMaterialRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello There Saw!!";
    }
}
