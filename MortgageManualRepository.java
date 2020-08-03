package ru.geekbrains.mortgage.repository;


import org.springframework.stereotype.Repository;
import ru.geekbrains.mortgage.entity.MortgageApplication;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MortgageManualRepository {

    EntityManager manager;

    public MortgageManualRepository(EntityManager manager) {
        this.manager = manager;
    }

    public List<MortgageApplication> getAllSuccessful() {
        Query nativeQuery = manager.createNativeQuery(
                "select * from mortgage_application where status = 0",
                MortgageApplication.class);

        List<MortgageApplication> resultList = nativeQuery.getResultList();
        return resultList;
    }

    public List<MortgageApplication> getAllLow_Budget() {
        Query nativeQuery = manager.createNativeQuery(
                "select * from mortgage_application where status = 1",
                MortgageApplication.class);

        List<MortgageApplication> resultList = nativeQuery.getResultList();
        return resultList;
    }

    public List<MortgageApplication> getAllTerrorist() {
        Query nativeQuery = manager.createNativeQuery(
                "select * from mortgage_application where status = 2",
                MortgageApplication.class);

        List<MortgageApplication> resultList = nativeQuery.getResultList();
        return resultList;
    }
}
