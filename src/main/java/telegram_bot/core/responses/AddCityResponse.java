package telegram_bot.core.responses;

import telegram_bot.core.domain.City;

import java.util.List;

public class AddCityResponse extends CoreResponse {

    private City city;

    public AddCityResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddCityResponse(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
