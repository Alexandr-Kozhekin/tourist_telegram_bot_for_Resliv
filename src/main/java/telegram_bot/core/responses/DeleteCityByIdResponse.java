package telegram_bot.core.responses;

public class DeleteCityByIdResponse {

    private boolean delete;

    public DeleteCityByIdResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean getDelete() {
        return delete;
    }
}
