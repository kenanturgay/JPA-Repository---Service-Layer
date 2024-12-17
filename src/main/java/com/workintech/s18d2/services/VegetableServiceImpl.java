package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VegetableServiceImpl implements VegetableService{

    private final VegetableRepository vegetableRepository;
    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable getById(Long id) {
        return vegetableRepository.findById(id).orElseThrow(()->new PlantException("Could not find"+ id, HttpStatus.NOT_FOUND ));

    }

    @Override
    public Vegetable save(Vegetable vegetable) {

        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        Vegetable vegetable = vegetableRepository.findById(id).orElseThrow(()->new PlantException("Could not find"+ id, HttpStatus.NOT_FOUND ));
        vegetableRepository.deleteById(id);
        return vegetable;
    }

    @Override
    public List<Vegetable> searchByName(String name) {

        return vegetableRepository.searchByName(name);
    }
}
