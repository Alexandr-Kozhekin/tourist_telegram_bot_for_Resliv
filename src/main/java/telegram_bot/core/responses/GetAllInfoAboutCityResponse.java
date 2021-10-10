package telegram_bot.core.responses;

import telegram_bot.core.domain.Info;

import java.util.Set;

public class GetAllInfoAboutCityResponse extends CoreResponse {

    private Set<Info> infoSet;

    public GetAllInfoAboutCityResponse(CoreError errors) {
        super(errors);
    }

    public GetAllInfoAboutCityResponse(Set<Info> infoSet) {
        this.infoSet = infoSet;
    }

    public Set<Info> getInfoSet() {
        return infoSet;
    }
}
