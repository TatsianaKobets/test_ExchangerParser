package by.http.task1.entity;

import javax.persistence.*;

@Entity
@Table(name = "money")
public class Money {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    @Column(name = "moneyCount")
    public String moneyCount;
    @Column(name = "moneyName")
    public String moneyName;
    @Column(name = "price")
    public String price;

    public Money(){}

    public Money(Long id, String moneyCount, String moneyName, String price) {
        this.id = id;
        this.moneyCount = moneyCount;
        this.moneyName = moneyName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoneyCount() {
        return moneyCount;
    }

    public void setMoneyCount(String moneyCount) {
        this.moneyCount = moneyCount;
    }

    public String getMoneyName() {
        return moneyName;
    }

    public void setMoneyName(String moneyName) {
        this.moneyName = moneyName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}


