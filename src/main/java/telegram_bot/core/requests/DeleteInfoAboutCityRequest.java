package telegram_bot.core.requests;

public class DeleteInfoAboutCityRequest {

    private String cityName;

    private Long infoId;

    private Long cityId;

    public DeleteInfoAboutCityRequest() {
    }

    public DeleteInfoAboutCityRequest(String cityName) {
        this.cityName = cityName;
    }

    public DeleteInfoAboutCityRequest(Long infoId, Long cityId) {
        this.infoId = infoId;
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}
