package telegram_bot.core.responses;

import java.util.List;

public class CoreResponse {

    private List<CoreError> errors;

    private CoreError coreError;

    public CoreResponse() { }

    public CoreResponse(List<CoreError> errors) {
        this.errors = errors;
    }

    public CoreResponse(CoreError coreError) {
        this.coreError = coreError;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public CoreError getCoreError() {
        return coreError;
    }

    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }
}
