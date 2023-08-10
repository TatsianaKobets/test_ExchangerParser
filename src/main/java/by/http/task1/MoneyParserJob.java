package by.http.task1;


import by.http.task1.entity.Money;
import by.http.task1.service.MoneyService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MoneyParserJob {
    @Autowired
    MoneyService moneyService;

    @EventListener(ApplicationReadyEvent.class)
    public void parseMoney() {
        String url = "https://select.by/kurs/";
        try {
            Document document = Jsoup.parse(new URL(url), 3000);
            Element tableExchanger = document.select("table[class=table table-sm table-borderless mb-1]").first();
            Elements lines = tableExchanger.select("tr[class=text-center h4]");

            int index = 0;
            int iterationMoney = 4;
            for (int i = 0; i < iterationMoney; i++) {
                Element valuelines = lines.get(index + i);

                List<String> vlintokens = Arrays.asList(valuelines.text().split("\\s"));
                System.out.println(vlintokens);
                List<String> money = new ArrayList<String>();
                for (String part : vlintokens) {
                    money.add(part);
                }

                String moneyName = vlintokens.get(1);
                if (!moneyService.isExist(moneyName)) {
                    Money obj = new Money();
                    obj.moneyCount = money.get(0);
                    obj.moneyName = money.get(1);
                    obj.price = money.get(money.size() - 1);

                    moneyService.save(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

