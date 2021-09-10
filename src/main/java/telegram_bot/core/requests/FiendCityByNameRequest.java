package telegram_bot.core.requests;

public class FiendCityByNameRequest {

    private String cityName;

    public FiendCityByNameRequest() {
    }

    public FiendCityByNameRequest(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}