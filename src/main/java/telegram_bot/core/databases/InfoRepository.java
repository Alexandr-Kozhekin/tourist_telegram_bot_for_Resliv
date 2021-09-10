package telegram_bot.core.databases;

import telegram_bot.core.domain.City;
import telegram_bot.core.domain.Info;

import java.util.List;

public interface InfoRepository {

    void addInfoAboutCity(City city, String info);

    List<City> getAllInfoAboutCity(String city_name);

    boolean deleteInfoAboutCity(String city_name, Long id);

    void updateInfoAboutCity(String city_name, Long id);

//    boolean deleteInfoByName(String name);

}
