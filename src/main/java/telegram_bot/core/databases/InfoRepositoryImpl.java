package telegram_bot.core.databases;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public List<Info> getAllInfoAboutCity(Long cityId) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("SELECT i FROM Info i WHERE city_id = :city_id", Info.class);
        query.setParameter("city_id", cityId);

        return query.getResultList();
    }

    @Override
    public boolean deleteAllInfoAboutCity(Long cityId) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE Info WHERE city_id = :city_id");
        query.setParameter("city_id", cityId);

        int result = query.executeUpdate();

        return result == 1;
    }

    @Override
    public boolean deleteInfoAboutCity(Long infoId, Long cityId) {

        Query query = sessionFactory.getCurrentSession()
                .createQuery("DELETE Info WHERE info_id = :info_id AND city_id = :city_id");
        query.setParameter("info_id", infoId);
        query.setParameter("city_id", cityId);

        int result = query.executeUpdate();

        return result == 1;
    }

}
