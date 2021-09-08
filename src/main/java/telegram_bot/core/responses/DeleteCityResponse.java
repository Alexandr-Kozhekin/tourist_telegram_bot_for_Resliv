package telegram_bot.core.responses;

public class DeleteCityResponse {

    private boolean delete;

    public DeleteCityResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean getDelete() {
        return delete;
    }
}
