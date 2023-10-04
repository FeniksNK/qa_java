package com.example;

import java.util.List;

public class Lion {

    private final boolean hasMane;

    private final FelineActions felineActions;


    public Lion(String sex, FelineActions felineActions) throws Exception {
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самей или самка");
        }

        this.felineActions = felineActions;
    }

    public int getKittens() {
        return felineActions.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return felineActions.getFood("Хищник");
    }
}
