package telegram_bot.core.databases;

import org.hibernate.Query;
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
    public void addInfoAboutCity(Long cityId, Info info) {

        sessionFactory.getCurrentSession().save(info);

        City existingCity = (City) sessionFactory.getCurrentSession().get(City.class, cityId);

        existingCity.getCityInfo().add(info);

        sessionFactory.getCurrentSession().save(existingCity);
    }

    @Override
    public List<Info> getAllInfoAboutCity(String cityName) {

        org.hibernate.Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT city_info FROM CityInfo \n" +
                        "INNER JOIN CITIES ON CITIES.city_id = CityInfo.city_id\n" +
                        "INNER JOIN INFOS ON INFOS.info_id = CityInfo.info_id WHERE city_name = :cityName;", Info.class);
        query.setParameter("cityName", cityName);

        return query.getResultList();
    }

    @Override
    public boolean deleteInfoAboutCity(Long cityId, Long infoId) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE info_id WHERE city_id = :city_id AND info_id = :info_id");
        query.setParameter("city_id", cityId);
        query.setParameter("info_id", infoId);

        int result = query.executeUpdate();

        return result == 1;
    }

    @Override
    public boolean deleteAllInfoAboutCity(Long cityId) {

        org.hibernate.Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE info_id WHERE city_id = :cityId");
        query.setParameter("cityId", cityId);

        int result = query.executeUpdate();

        return result == 1;
    }

}
