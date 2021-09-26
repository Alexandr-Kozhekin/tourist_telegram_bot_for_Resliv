package telegram_bot.core.requests;


import telegram_bot.core.domain.Info;

public class AddInfoAboutCityRequest {

    private Long cityId;
    private Info info;

    public AddInfoAboutCityRequest() {
    }

    public AddInfoAboutCityRequest(Long cityId, Info info) {
        this.cityId = cityId;
        this.info = info;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}