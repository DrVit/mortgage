package ru.geekbrains.mortgage.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.mortgage.entity.MortgageApplication;
import ru.geekbrains.mortgage.entity.ResolutionStatus;
import ru.geekbrains.mortgage.model.MortgageList;
import ru.geekbrains.mortgage.repository.MortgageApplicationRepository;

import java.util.List;
import java.util.Scanner;

@Service
public class PoliceService {

    public boolean getIsTerrorist(MortgageApplication application) {
        String name = application.getName();
        Scanner t=new Scanner(System.in);
        return t.nextBoolean();

    }
}
