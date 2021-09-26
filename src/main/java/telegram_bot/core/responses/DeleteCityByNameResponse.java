package telegram_bot.core.responses;

import java.util.List;

public class DeleteCityByNameResponse extends CoreResponse {

    private boolean delete;

    public DeleteCityByNameResponse(List<CoreError> errors) {
        super(errors);
    }

    public DeleteCityByNameResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean getDelete() {
        return delete;
    }
}
