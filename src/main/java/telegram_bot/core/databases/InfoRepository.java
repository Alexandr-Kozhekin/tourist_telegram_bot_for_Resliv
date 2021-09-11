package telegram_bot.core.databases;

import telegram_bot.core.domain.City;
import telegram_bot.core.domain.Info;

import java.util.List;

public interface InfoRepository {

    void addInfoAboutCity(City city, String info);

    List<Info> getAllInfoAboutCity(Long cityId);

    boolean deleteAllInfoAboutCity(Long cityId);

    boolean deleteInfoAboutCity(Long infoId, Long cityId);

}
