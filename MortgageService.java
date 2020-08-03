package ru.geekbrains.mortgage.services;

import org.springframework.stereotype.Service;
import ru.geekbrains.mortgage.entity.MortgageApplication;
import ru.geekbrains.mortgage.entity.ResolutionStatus;
import ru.geekbrains.mortgage.model.MortgageList;
import ru.geekbrains.mortgage.model.MortgageRequest;
import ru.geekbrains.mortgage.model.MortgageResponse;
import ru.geekbrains.mortgage.repository.MortgageApplicationRepository;

import java.util.List;

@Service
public class MortgageService {

    private final MortgageApplicationRepository repository;
    private  PoliceService policeService;
    private  FnsService fnsService;

    public MortgageService(MortgageApplicationRepository repository, PoliceService policeService, FnsService fnsService) {
        this.repository = repository;
        this.policeService = policeService;
        this.fnsService = fnsService;
    }

    public MortgageList getAllMortgages() {
       return new MortgageList(repository.findAll());
    }

    public MortgageList getAllSuccessfulMortgage() {
                List<MortgageApplication> allSuccessful =
                repository.getAllByStatusEquals(ResolutionStatus.SUCCESSFUL);
            return  new MortgageList(allSuccessful);
    }

    public MortgageList getAllTerroristMortgage() {
        List<MortgageApplication> allTerrorist =
                repository.getAllByStatusEquals(ResolutionStatus.TERRORIST);
        return  new MortgageList(allTerrorist);
    }

    public MortgageList getAllLow_BudgetMortgage() {
        List<MortgageApplication> allLow_Budget =
                repository.getAllByStatusEquals(ResolutionStatus.LOW_BUDGET);
        return  new MortgageList(allLow_Budget);
    }

    public MortgageResponse registerApplication(MortgageRequest request) {
        MortgageApplication application = new MortgageApplication();
        if (policeService.getIsTerrorist(application) == false) {
            if (fnsService.getIsLow_Budget(application) == false) {
                application.setName(request.getName());
                application.setStatus(ResolutionStatus.SUCCESSFUL);
                application = repository.save(application);
                MortgageResponse response = new MortgageResponse();
                response.setId(application.getId());
                response.setRequest(request);
                response.setResolution("Ok");
                return response;
            } else {

                application.setName(request.getName());
                application.setStatus(ResolutionStatus.LOW_BUDGET);
                application = repository.save(application);
                MortgageResponse response = new MortgageResponse();
                response.setId(application.getId());
                response.setRequest(request);
                response.setResolution("Not Ok");
                return response;
            }
        }else {
            application.setName(request.getName());
            application.setStatus(ResolutionStatus.TERRORIST);
            application = repository.save(application);
            MortgageResponse response = new MortgageResponse();
            response.setId(application.getId());
            response.setRequest(request);
            response.setResolution("Not Ok");
            return response;
        }
    }
}
