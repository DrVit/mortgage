package ru.geekbrains.mortgage.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.mortgage.entity.MortgageApplication;

import java.util.Scanner;

@Service
public class FnsService {

    public boolean getIsLow_Budget(MortgageApplication application) {
        String name = application.getName();
        Scanner t=new Scanner(System.in);
        return t.nextBoolean();
    }
}
