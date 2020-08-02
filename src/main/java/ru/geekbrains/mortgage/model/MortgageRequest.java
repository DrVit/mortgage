package ru.geekbrains.mortgage.model;

import java.io.Serializable;

public class MortgageRequest implements Serializable { //создаем запрос на ипотеку, получаем Имя, getters&Setters,
                                        //toString

    private String name;

    @Override
    public String toString() {
        return "MortgageRequest{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
