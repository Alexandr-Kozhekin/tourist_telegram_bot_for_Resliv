package telegram_bot.core.responses;

import telegram_bot.core.domain.Info;

import java.util.List;

public class AddInfoAboutCityResponse extends CoreResponse {

    private Info info;

    public AddInfoAboutCityResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddInfoAboutCityResponse(Info info) {
        this.info = info;
    }

    public Info getInfo() {
        return info;
    }
}
