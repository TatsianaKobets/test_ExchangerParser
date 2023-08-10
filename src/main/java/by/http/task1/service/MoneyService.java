package by.http.task1.service;

import by.http.task1.entity.Money;
import by.http.task1.repository.MoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyService {

    @Autowired
    private MoneyRepository moneyRepository;

    public List<Money> listAll() {
        return moneyRepository.findAll();
    }

    public void save(Money money) {
        moneyRepository.save(money);
    }

    public Money get(Long id) {
        return moneyRepository.findById(id).get();
    }

    public void delete(Long id) {
        moneyRepository.deleteById(id);
    }

    public boolean isExist(String moneyName) {
        List<Money> allMoney = moneyRepository.findAll();
        for (Money m : allMoney) {
            if (m.getMoneyName().equals(moneyName)) {
                return true;
            }
        }
        return false;
    }
}
