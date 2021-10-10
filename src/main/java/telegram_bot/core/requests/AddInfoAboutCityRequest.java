package telegram_bot.core.requests;

public class AddInfoAboutCityRequest {

    private Long cityId;

    private String info;

    public AddInfoAboutCityRequest() {
    }

    public AddInfoAboutCityRequest(Long cityId, String info) {
        this.cityId = cityId;
        this.info = info;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}