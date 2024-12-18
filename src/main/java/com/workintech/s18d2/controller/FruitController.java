package com.workintech.s18d2.controller;


import com.workintech.s18d2.dto.FruitResponse;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fruit")
public class FruitController {

    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/{id}")
    public FruitResponse get(@Positive(message = "İd sıfırdan küçük olamaz") @PathVariable("id") Long id ){
        return new FruitResponse("Get by id succeed!", fruitService.getById(id));
    }


    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@Size(min = 2, max = 45, message = "Name size must be betweem 2 to 45") @PathVariable("name") String name){
        return fruitService.searchByName(name);
    }

    @PostMapping
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Positive(message = "Id sıfırdan küçük olamaz") @PathVariable("id") Long id){
        return fruitService.delete(id);
    }


}
