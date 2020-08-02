package ru.geekbrains.mortgage.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.geekbrains.mortgage.entity.MortgageApplication;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

}
