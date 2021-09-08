package telegram_bot.core.responses;

import telegram_bot.core.domain.City;

public class AddCityResponse {

    private City city;

    public AddCityResponse(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
