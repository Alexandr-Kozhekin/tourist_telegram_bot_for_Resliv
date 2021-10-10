package telegram_bot.core.requests;

public class DeleteInfoAboutCityRequest {

    private Long cityId;

    private Long infoId;

    public DeleteInfoAboutCityRequest() {
    }

    public DeleteInfoAboutCityRequest(Long cityId, Long infoId) {
        this.cityId = cityId;
        this.infoId = infoId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }
}
