package telegram_bot.core.requests;

public class DeleteCityRequest {

    private Long id;

    public DeleteCityRequest() {
    }

    public DeleteCityRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
