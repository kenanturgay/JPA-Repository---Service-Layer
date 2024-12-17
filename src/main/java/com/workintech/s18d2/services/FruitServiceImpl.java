package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FruitServiceImpl implements FruitService {

    private final FruitRepository fruitRepository;
    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public Fruit getById(Long id) {
        Fruit fruit = fruitRepository.getById(id);
        if (fruit == null) {
            throw new PlantException("Fruit not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        return fruit;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruit = fruitRepository.getById(id);
        if (fruit == null) {
            throw new PlantException("Fruit not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        fruitRepository.deleteById(id);
        return fruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);

    }
}
