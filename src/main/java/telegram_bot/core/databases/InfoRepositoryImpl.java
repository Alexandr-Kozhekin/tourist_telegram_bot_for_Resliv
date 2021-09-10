package telegram_bot.core.databases;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.domain.City;
import telegram_bot.core.domain.Info;

import java.util.List;

@Component
@Transactional
public class InfoRepositoryImpl implements InfoRepository {

    @Autowired SessionFactory sessionFactory;

    @Override
    public void addInfoAboutCity(City city, String info) {

        Info cityInfo = new Info(city, info);

        sessionFactory.getCurrentSession().save(cityInfo);

    }

    @Override
    public List<City> getAllInfoAboutCity(String city_name) {
        return null;
    }

    @Override
    public boolean deleteInfoAboutCity(String city_name, Long id) {
        return false;
    }

    @Override
    public void updateInfoAboutCity(String city_name, Long id) {

    }
}
