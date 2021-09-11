package telegram_bot.core.responses;

public class DeleteAllInfoAboutCityResponse {

    private boolean delete;

    public DeleteAllInfoAboutCityResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }
}
