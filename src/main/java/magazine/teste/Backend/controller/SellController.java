package magazine.teste.Backend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import magazine.teste.Backend.controller.dtos.SellDto;
import magazine.teste.Backend.model.Sale;
import magazine.teste.Backend.service.SellService;


@RestController
@RequestMapping("/api/sells")
public class SellController {
    
    @Autowired
    private SellService sellService;

    
    @PostMapping
    public Sale selling(@Valid @RequestBody SellDto sellRequest){
            Sale currentSale = sellService.selling(sellRequest);
            return currentSale;                   
    }
}
