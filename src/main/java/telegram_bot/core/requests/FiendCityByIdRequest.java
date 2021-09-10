package telegram_bot.core.requests;

public class FiendCityByIdRequest {

    private Long cityId;

    public FiendCityByIdRequest() {
    }

    public FiendCityByIdRequest(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
}