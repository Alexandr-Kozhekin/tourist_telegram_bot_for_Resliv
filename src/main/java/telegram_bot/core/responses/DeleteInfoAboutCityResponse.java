package telegram_bot.core.responses;

import java.util.List;

public class DeleteInfoAboutCityResponse extends CoreResponse {

    private boolean delete;

    public DeleteInfoAboutCityResponse(List<CoreError> errors) {
        super(errors);
    }

    public DeleteInfoAboutCityResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }
}
