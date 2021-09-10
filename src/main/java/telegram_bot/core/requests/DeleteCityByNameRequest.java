package telegram_bot.core.requests;

public class DeleteCityByNameRequest {

    private String cityName;

    public DeleteCityByNameRequest() {
    }

    public DeleteCityByNameRequest(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
