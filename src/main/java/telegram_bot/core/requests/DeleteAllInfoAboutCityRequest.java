package telegram_bot.core.requests;

public class DeleteAllInfoAboutCityRequest {

    private Long cityId;

    public DeleteAllInfoAboutCityRequest() {
    }

    public DeleteAllInfoAboutCityRequest(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
