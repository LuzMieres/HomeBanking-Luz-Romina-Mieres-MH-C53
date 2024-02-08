package com.mindhub.HomeBanking.models;


import jakarta.persistence.*;

import java.util.List;


@Entity
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Integer> payments;

    public Payments() {
    }

    public Payments(List<Integer> payments) {
        this.payments = payments;
    }

    public Long getId() {
        return id;
    }

    public List<Integer> getPayments() {
        return payments;
    }

    public void setPayments(List<Integer> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "id=" + id +
                ", payments=" + payments +
                '}';
    }
}