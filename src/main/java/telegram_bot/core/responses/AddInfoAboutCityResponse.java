package telegram_bot.core.responses;

import telegram_bot.core.domain.Info;

public class AddInfoAboutCityResponse {

    private Info info;

    public AddInfoAboutCityResponse(Info info) {
        this.info = info;
    }

    public Info getInfo() {
        return info;
    }
}
