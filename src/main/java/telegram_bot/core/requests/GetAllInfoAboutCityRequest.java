package telegram_bot.core.requests;

public class GetAllInfoAboutCityRequest {

    private Long cityId;

    public GetAllInfoAboutCityRequest() {
    }

    public GetAllInfoAboutCityRequest(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
