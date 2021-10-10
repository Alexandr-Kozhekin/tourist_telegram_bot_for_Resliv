package telegram_bot.core.databases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.*;

import java.util.*;

import telegram_bot.core.domain.City;

@Component
@Transactional
public class CityRepositoryImpl implements CityRepository {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public void addCity(City city) {

        sessionFactory.getCurrentSession().save(city);
    }

    @Override
    public boolean deleteCityById(Long id) {

        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE City WHERE id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();

        return result == 1;
    }

    @Override
    public boolean deleteCityByName(String name) {

        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE City WHERE city_name = :city_name");
        query.setParameter("city_name", name);

        int result = query.executeUpdate();

        return result == 1;
    }

    @Override
    public List<City> getAllCity() {

        return sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM City c", City.class)
                .getResultList();
    }

    @Override
    public Optional<City> fiendCityByName(String cityName) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM City c WHERE city_name = :city_name");

        query.setParameter("city_name", cityName);

        return query.getResultList().stream().findFirst();
    }

    @Override
    public Optional<City> fiendCityById(Long cityId) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM City c WHERE city_id = :city_id");

        query.setParameter("city_id", cityId);

        return query.getResultList().stream().findFirst();
    }
}
