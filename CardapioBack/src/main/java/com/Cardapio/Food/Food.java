package com.Cardapio.Food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "foods")
@Entity(name = "foods")
@Getter //usando Lombok para gerar todos os metodos Get para cada uma propriedades que a classe tem
@NoArgsConstructor //usando o Lombok declarar contrutor que não tem argumento
@AllArgsConstructor //usando o lombok para declarar um contrutor que receba todos os argumentos
@EqualsAndHashCode(of = "id") //indicando que o Id é a unica representação na class food

public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private String title;
    @Column(length = 500)
    private String image;

    private Integer price;

    public Food(FoodRequestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();

    }
}

