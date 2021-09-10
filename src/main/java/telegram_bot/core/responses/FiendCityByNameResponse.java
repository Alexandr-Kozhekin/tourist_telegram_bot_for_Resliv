package telegram_bot.core.responses;

import telegram_bot.core.domain.City;

import java.util.Optional;

public class FiendCityByNameResponse {

    private City city;

    public FiendCityByNameResponse(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
