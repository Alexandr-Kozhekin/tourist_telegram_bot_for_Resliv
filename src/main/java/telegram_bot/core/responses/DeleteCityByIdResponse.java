package telegram_bot.core.responses;

import java.util.List;

public class DeleteCityByIdResponse extends CoreResponse {

    private boolean delete;

    public DeleteCityByIdResponse(List<CoreError> errors) {
        super(errors);
    }

    public DeleteCityByIdResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean getDelete() {
        return delete;
    }
}
