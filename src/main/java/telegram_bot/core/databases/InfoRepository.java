package telegram_bot.core.databases;

import telegram_bot.core.domain.Info;

import java.util.Set;

public interface InfoRepository {

    void addInfoAboutCity(Long cityId, String info);

    Set<Info> getAllInfoAboutCity(String cityName);

    boolean deleteInfoAboutCity(Long cityId, Long infoId);

    boolean deleteAllInfoAboutCity(Long cityId);

}
