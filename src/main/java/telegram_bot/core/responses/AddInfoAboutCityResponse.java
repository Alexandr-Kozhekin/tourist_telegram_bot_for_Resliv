package telegram_bot.core.responses;

import java.util.List;

public class AddInfoAboutCityResponse extends CoreResponse {

    private String info;

    public AddInfoAboutCityResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddInfoAboutCityResponse(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
