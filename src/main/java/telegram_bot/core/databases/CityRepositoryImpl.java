package telegram_bot.core.databases;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import telegram_bot.core.domain.City;

import java.util.List;
import java.util.Optional;

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
                "delete City where id = :id");
        query.setParameter("id", id);

        int result = query.executeUpdate();

        return result == 1;
    }

    @Override
    public boolean deleteCityByName(String name) {

        Query query = sessionFactory.getCurrentSession().createQuery(
                "delete City where city_name = :city_name");
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
    public Optional<City> fiendCityByName(String city_name) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM City c WHERE city_name = :city_name", City.class);

        query.setParameter("city_name", city_name);

        return query.getResultList().stream().findFirst();
    }

    @Override
    public Optional<City> fiendCityById(Long city_id) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM City c WHERE city_id = :city_id", City.class);

        query.setParameter("city_id", city_id);

        return query.getResultList().stream().findFirst();
    }

}
