/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.springlab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Kamil
 */
@Controller
public class CalculatorControler {
    @RequestMapping("/hello")
public String hello(Model model, Integer x, Integer y) {
    model.addAttribute("x",x);
    model.addAttribute("y", y);
    return "hello";
}
    @RequestMapping("/calc")
public String calc(Model model, Integer x, Integer y, String znak) {
    model.addAttribute("x",x);
    model.addAttribute("y", y);
     model.addAttribute("znak", znak);
    Integer wynik = null;
    switch(znak){
        case "+": wynik=x+y; break;
        case "-": wynik=x-y; break;
        case "*": wynik=x*y; break;
    }
    model.addAttribute("wynik",wynik);
    return "calc";
}

 @RequestMapping("/calcv2")
public String calcv2(Model model, CalculatorForm calc) {
    model.addAttribute("x",calc.getX());
    model.addAttribute("y", calc.getY());
    model.addAttribute("znak", calc.getZnak());
    Integer wynik = null;
    switch(calc.getZnak()){
        case "+": wynik=calc.getX()+calc.getY(); break;
        case "-": wynik=calc.getX()-calc.getY(); break;
        case "*": wynik=calc.getX()*calc.getY(); break;
    }
    model.addAttribute("wynik",wynik);
    return "calc";
}
}
