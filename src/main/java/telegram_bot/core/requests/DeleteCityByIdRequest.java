package telegram_bot.core.requests;

public class DeleteCityByIdRequest {

    private Long id;

    public DeleteCityByIdRequest() {
    }

    public DeleteCityByIdRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
