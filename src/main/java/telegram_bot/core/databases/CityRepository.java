package telegram_bot.core.databases;

import telegram_bot.core.domain.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository {

    void addCity(City city);

    boolean deleteCityById(Long city_id);

    boolean deleteCityByName(String city_name);

    List<City> getAllCity();

    Optional<City> fiendCityByName(String city_name);

    Optional<City> fiendCityById(Long city_id);

}
