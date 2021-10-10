package telegram_bot.core.databases;

import telegram_bot.core.domain.City;

import java.util.*;

public interface CityRepository {

    void addCity(City city);

    boolean deleteCityById(Long cityId);

    boolean deleteCityByName(String cityName);

    List<City> getAllCity();

    Optional<City> fiendCityByName(String cityName);

    Optional<City> fiendCityById(Long cityId);

}
