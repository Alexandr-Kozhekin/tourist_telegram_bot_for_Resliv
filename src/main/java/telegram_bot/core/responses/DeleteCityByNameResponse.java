package telegram_bot.core.responses;

public class DeleteCityByNameResponse {

    private boolean delete;

    public DeleteCityByNameResponse(boolean delete) {
        this.delete = delete;
    }

    public boolean getDelete() {
        return delete;
    }

}
