package be.ehb.jfcafemenu.controller;

import be.ehb.jfcafemenu.dao.DrinkDAO;
import be.ehb.jfcafemenu.dao.TastingNoteDAO;
import be.ehb.jfcafemenu.entities.Drink;
import be.ehb.jfcafemenu.entities.TastingNote;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class DrinkController {

    private TastingNoteDAO mTastingDAO;
    private DrinkDAO mDrinkDAO;
@Autowired
    public DrinkController(DrinkDAO mDrinkDAO, TastingNoteDAO mTastingDAO) {
        this.mDrinkDAO = mDrinkDAO;
        this.mTastingDAO = mTastingDAO;
    }
    @ModelAttribute("drinks")
    public Iterable<Drink> getAllDrinks(){
    return mDrinkDAO.findAll();
    }

    @GetMapping({"/","/index"})
    public String displayIndex(ModelMap modelMap){
        return "index";
}
    @GetMapping("/about")
    public String showAbout(){
    return "about";
    }

    @ModelAttribute("drinktoSave")
    public Drink drinkForForm(){
    return new Drink();
    }
    @GetMapping("/newdrink")
    public String showNewDrink(ModelMap modelMap){
    return "/newdrink";
    }
    @PostMapping("/newdrink")
    public String InsertDrink(@Valid @ModelAttribute ("drinktoSave") Drink drink, BindingResult result){

    if(result.hasErrors()){

        return "/newdrink";
    } mDrinkDAO.save(drink);

    return "redirect:/index";
    }

    @GetMapping("delete/{id}")
    public String deleteItem(@PathVariable int id){
        if(mDrinkDAO.existsById(id))
            mDrinkDAO.deleteById(id);
        return "redirect:/index";
    }

}
