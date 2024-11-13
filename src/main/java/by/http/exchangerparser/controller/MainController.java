package by.http.exchangerparser.controller;

import by.http.exchangerparser.entity.Money;
import by.http.exchangerparser.service.MoneyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

  @Autowired
  private MoneyService moneyService;

  @RequestMapping("/")
  public String viewHomePage(Model model) {

    List<Money> listMonies = moneyService.listAll();
    model.addAttribute("listMonies", listMonies);

    return "index";
  }

  @RequestMapping("/new")
  public String showNewMoneyForm(Model model) {
    Money money = new Money();
    model.addAttribute("money", money);

    return "new_money";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveMoney(@ModelAttribute("money") Money money) {
    moneyService.save(money);

    return "redirect:/";
  }

  @RequestMapping("/edit/{id}")
  public ModelAndView showEditMoneyForm(@PathVariable(name = "id") Long id) {
    ModelAndView mav = new ModelAndView("edit_money");

    Money money = moneyService.get(id);
    mav.addObject("money", money);

    return mav;
  }

  @RequestMapping("/delete/{id}")
  public String deleteMoney(@PathVariable(name = "id") Long id) {
    moneyService.delete(id);
    return "redirect:/";
  }
}
