package telegram_bot.core.responses;

import telegram_bot.core.domain.City;

import java.util.List;

public class FiendCityByIdResponse extends CoreResponse {

    private City city;

    public FiendCityByIdResponse (List<CoreError> errors) {
        super(errors);
    }

    public FiendCityByIdResponse(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
