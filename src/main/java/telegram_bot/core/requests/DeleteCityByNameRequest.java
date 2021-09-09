package telegram_bot.core.requests;

public class DeleteCityByNameRequest {

    private String city_name;

    public DeleteCityByNameRequest() {
    }

    public DeleteCityByNameRequest(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}