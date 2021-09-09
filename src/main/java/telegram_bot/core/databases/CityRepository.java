package telegram_bot.core.databases;

import telegram_bot.core.domain.City;

import java.util.List;

public interface CityRepository {

    void addCity(City city);

    boolean deleteCityById(Long id);

    boolean deleteCityByName(String name);

    List<City> getAllCity();

}
