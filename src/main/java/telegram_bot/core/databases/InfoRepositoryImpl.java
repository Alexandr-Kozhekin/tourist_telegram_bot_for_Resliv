package telegram_bot.core.databases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import telegram_bot.core.domain.*;

import org.hibernate.*;

import java.util.*;

@Component
@Transactional
public class InfoRepositoryImpl implements InfoRepository {

    @Autowired SessionFactory sessionFactory;

    @Override
    public void addInfoAboutCity(Long cityId, String info) {

        sessionFactory.getCurrentSession().save(new Info(info));

        City existingCity = sessionFactory.getCurrentSession().get(City.class, cityId);

        existingCity.getCityInfo().add(new Info(info));

        sessionFactory.getCurrentSession().save(existingCity);
    }

    @Override
    public Set<Info> getAllInfoAboutCity(String cityName) {

        City city = getExistingCity(cityName);

        return city.getCityInfo();
    }

    @Override
    public boolean deleteInfoAboutCity(Long cityId, Long infoId) {

        City existingCity = sessionFactory.getCurrentSession().get(City.class, cityId);

        Set<Info> existingInfo = existingCity.getCityInfo();

        if (!existingInfo.isEmpty()) {

            Optional<Info> infoExist = existingInfo.stream()
                    .filter(info -> info.getInfoId().equals(infoId))
                    .findFirst();

            infoExist.ifPresent(existingInfo::remove);

            sessionFactory.getCurrentSession().save(existingCity);

            return true;

        } else {

            return false;
        }
    }

    @Override
    public boolean deleteAllInfoAboutCity(Long cityId) {

        City existingCity = sessionFactory.getCurrentSession().get(City.class, cityId);

        Set<Info> info = existingCity.getCityInfo();

        if (!info.isEmpty()) {

            info.clear();

            sessionFactory.getCurrentSession().save(existingCity);

            return true;

        } else {

            return false;
        }
    }

    private City getExistingCity(String cityName) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT c FROM City c WHERE city_name = :cityName", City.class);

        query.setParameter("cityName", cityName);

        List<City> city = query.getResultList();

        return city.get(0);
    }
}
