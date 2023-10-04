package com.example;

import java.util.List;

public interface FelineActions {
    int getKittens();

    List<String> getFood(String animalKind) throws Exception;
}
