package telegram_bot.core.responses;

import telegram_bot.core.domain.City;

public class FiendCityByIdResponse {

    private City city;

    public FiendCityByIdResponse(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
