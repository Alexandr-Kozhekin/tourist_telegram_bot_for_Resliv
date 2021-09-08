package telegram_bot.core.databases;

import telegram_bot.core.domain.City;

import java.util.List;

public interface CityDatabase {

    void addCity(City city);

    boolean deleteCity(Long id);

    List<City> getAllCity();

//    CityInfo addInfoAboutCity(CityInfo cityInfo);
//
//    void updateInfoAboutCity(Long id);
//
//    boolean deleteInfoAboutCity(Long id);
}
