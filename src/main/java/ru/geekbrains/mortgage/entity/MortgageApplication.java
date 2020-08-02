package ru.geekbrains.mortgage.entity;


import javax.persistence.*;

@Entity
@Table(name = "mortgage_application")
public class MortgageApplication { //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private ResolutionStatus status;

    public MortgageApplication() {
    }

    public MortgageApplication(String name, ResolutionStatus status) {
        this.name = name;
        this.status = status;
    }

    public MortgageApplication(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResolutionStatus getStatus() {
        return status;
    }

    public void setStatus(ResolutionStatus status) {
        this.status = status;
    }
}
