package by.http.exchangerparser.repository;

import by.http.exchangerparser.entity.Money;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<Money, Long> {

}
