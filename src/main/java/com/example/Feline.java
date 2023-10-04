package com.example;

import java.util.List;

public class Feline implements FelineActions, Predator {

    @Override
    public int getKittens() {
        return 1;
    }

    @Override
    public List<String> getFood(String animalKind) throws Exception {
        if ("Хищник".equals(animalKind)) {
            return List.of("Мясо");
        } else {
            throw new Exception("Неизвестный вид животного");
        }
    }

    public String getFamily() {
        return "Кошачьи";
    }

    public List<String> eatMeat() throws Exception {
        return getFood("Хищник");
    }

}
