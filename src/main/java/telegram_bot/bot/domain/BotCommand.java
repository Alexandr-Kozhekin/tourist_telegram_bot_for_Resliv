package telegram_bot.bot.domain;

public enum BotCommand {

    START("/start"),
    HELP("/help"),
    SETTING("/settings"),
    NONE("/none"),
    GET_ALL_CITY("/getAll"),
    GET_ALL_INFO_ABOUT_CITY("/getInfoAboutCity");

    String command;

    public String getCommand() {
        return command;
    }

    BotCommand(String command) {
        this.command = command;
    }
}