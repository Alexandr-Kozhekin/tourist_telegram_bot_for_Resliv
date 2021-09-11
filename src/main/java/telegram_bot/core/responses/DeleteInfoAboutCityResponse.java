package telegram_bot.core.responses;

public class DeleteInfoAboutCityResponse {

    private boolean delete;

    public DeleteInfoAboutCityResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean isDelete() {
        return delete;
    }
}
