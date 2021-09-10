package telegram_bot.core.requests;


public class AddInfoAboutCityRequest {

    private String cityName;
    private String cityInfo;

    public AddInfoAboutCityRequest() {
    }

    public AddInfoAboutCityRequest(String cityName, String cityInfo) {
        this.cityName = cityName;
        this.cityInfo = cityInfo;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(String cityInfo) {
        this.cityInfo = cityInfo;
    }
}