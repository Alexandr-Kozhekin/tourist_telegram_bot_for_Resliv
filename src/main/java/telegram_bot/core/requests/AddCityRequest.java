package telegram_bot.core.requests;

public class AddCityRequest {

    private String name;

    public AddCityRequest() {
    }

    public AddCityRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
