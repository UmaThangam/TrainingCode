package com.example.register.Model;

import javax.persistence.*;

@Entity
@Table(name="operator")
public class operator_model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(insertable = false,updatable = false)
    String date_time;

    public Integer getNumber1() {
        return number1;
    }

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public Integer getNumber2() {
        return number2;
    }
    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    Integer number2;
    Integer number1;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    Integer result;
}
