package com.Cardapio.controller;
import com.Cardapio.Food.FoodRequestDTO;
import com.Cardapio.Food.Food;
import com.Cardapio.Food.FoodRepository;
import com.Cardapio.Food.FoodResponseDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("food") // Mapeando o request do end point Food
public class FoodController {

    @Autowired
    private FoodRepository repository;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        // Implementação do método de salvar Food
        Food foodData = new Food(data);
        repository.save(foodData);
        return;

    }

    @GetMapping
    // Quando bater nesse end point, o método getAll será executado

    // Método para representar dados estáticos
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

}
