package telegram_bot.core.responses;

import telegram_bot.core.domain.Info;

import java.util.List;

public class GetAllInfoAboutCityResponse extends CoreResponse {

    private List<Info> infoList;

    public GetAllInfoAboutCityResponse(List<Info> infoList) {
        this.infoList = infoList;
    }

    public List<Info> getInfoList() {
        return infoList;
    }
}
