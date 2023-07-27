package com.example.demo.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;



@Entity
@Table(name = "weight")
public class WeightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "名前を入力してください")
    @Column(name="name")

    private String name;

    @Column(name="weight")
    @Positive(message = "体重は0より大きい値を入力してください")
    private Double weight;
    
    @Column(name="measurement_date")
    private LocalDate measurement_date;


    public WeightEntity() {
    }

    // ゲッターとセッター
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public LocalDate getMeasurement_date() {
        return measurement_date;
    }

    public void setMeasurement_date(LocalDate measurement_date) {
        this.measurement_date = measurement_date;
    }


   
}
