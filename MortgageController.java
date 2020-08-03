package ru.geekbrains.mortgage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.mortgage.model.MortgageList;
import ru.geekbrains.mortgage.model.MortgageRequest;
import ru.geekbrains.mortgage.model.MortgageResponse;
import ru.geekbrains.mortgage.repository.MortgageApplicationRepository;
import ru.geekbrains.mortgage.services.MortgageService;

@RestController
public class MortgageController {

    private final MortgageService service;

    public MortgageController(MortgageApplicationRepository repository, MortgageService service) {
        this.service = service;
    }

    @GetMapping("/mortgages")
    public MortgageList getAll() {
        return service.getAllMortgages();
    }

    @GetMapping("/mortgages/successful")
    public MortgageList getAllSuccessful() {
        return service.getAllSuccessfulMortgage();
    }

    @GetMapping("/mortgages/low_budget")
    public MortgageList getAllLow_Budget() {
        return service.getAllLow_BudgetMortgage();
    }

    @GetMapping("/mortgages/terrorist")
    public MortgageList getAllTerrorist() {
        return service.getAllTerroristMortgage();
    }


    @PostMapping("/mortgage")
    public MortgageResponse registerApplication(@RequestBody MortgageRequest request) {
        return service.registerApplication(request);
    }
}
