package telegram_bot.core.responses;

import telegram_bot.core.domain.City;

import java.util.List;

public class GetAllCityResponse {

    private List<City> city;

    public GetAllCityResponse(List<City> city) {
        this.city = city;
    }

    public List<City> getCity() {
        return city;
    }

    public boolean hasCity() {
        return !city.isEmpty();
    }
}
