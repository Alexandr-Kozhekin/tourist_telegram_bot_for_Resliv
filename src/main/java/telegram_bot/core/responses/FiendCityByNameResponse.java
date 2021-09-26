package telegram_bot.core.responses;

import telegram_bot.core.domain.City;

import java.util.List;
import java.util.Optional;

public class FiendCityByNameResponse extends CoreResponse {

    private City city;

    public FiendCityByNameResponse(List<CoreError> errors) {
        super(errors);
    }

    public FiendCityByNameResponse(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
