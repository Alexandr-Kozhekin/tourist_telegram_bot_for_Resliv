package matchers;

import org.mockito.ArgumentMatcher;
import telegram_bot.core.domain.City;

public class CityMatchers implements ArgumentMatcher<City> {

    private final String cityName;

    public CityMatchers(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean matches(City city) {
        return city.getCityName().equals(cityName);
    }
}
