package telegram_bot.core.responses;

import java.util.List;

public class DeleteAllInfoAboutCityResponse extends CoreResponse {

    private boolean delete;

    public DeleteAllInfoAboutCityResponse(List<CoreError> errors) {
        super(errors);
    }

    public DeleteAllInfoAboutCityResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }
}
