package com.akelius.demographql.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Contract {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String moveIn;
    private int rent;
    @ManyToOne
    @JoinColumn(name = "author_id",
            nullable = false, updatable = false)
    private Tenant tenant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        return id.equals(contract.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rent='" + rent + '\'' +
                ", moveIn=" + moveIn +
                ", tenant=" + tenant+
                '}';
    }
}
