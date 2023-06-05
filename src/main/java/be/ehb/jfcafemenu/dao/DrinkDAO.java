package be.ehb.jfcafemenu.dao;

import be.ehb.jfcafemenu.entities.Drink;
import org.springframework.data.repository.CrudRepository;

public interface DrinkDAO extends CrudRepository <Drink, Integer> {
    //es integer porque el id es integer.
}
