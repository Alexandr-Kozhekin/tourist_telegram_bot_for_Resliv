package telegram_bot.core.requests;

public class DeleteInfoAboutCityRequest {

    private String cityName;

    private Long infoId;

    public DeleteInfoAboutCityRequest() {
    }

    public DeleteInfoAboutCityRequest(String cityName) {
        this.cityName = cityName;
    }

    public DeleteInfoAboutCityRequest(String cityName, Long infoId) {
        this.cityName = cityName;
        this.infoId = infoId;
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
}
