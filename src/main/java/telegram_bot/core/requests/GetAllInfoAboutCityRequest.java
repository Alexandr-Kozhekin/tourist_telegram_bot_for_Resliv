package telegram_bot.core.requests;

public class GetAllInfoAboutCityRequest {

    private String cityName;

    public GetAllInfoAboutCityRequest() {
    }

    public GetAllInfoAboutCityRequest(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
