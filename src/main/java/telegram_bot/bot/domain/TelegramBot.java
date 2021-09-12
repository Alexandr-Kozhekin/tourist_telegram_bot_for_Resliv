package telegram_bot.bot.domain;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.*;
import telegram_bot.bot.service.MessageService;
import telegram_bot.core.domain.*;
import telegram_bot.core.requests.FiendCityByNameRequest;
import telegram_bot.core.requests.GetAllInfoAboutCityRequest;
import telegram_bot.core.responses.*;
import telegram_bot.core.services.*;

import java.util.List;
import java.util.Optional;

@PropertySource("application.properties")
@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired private MessageService messageService;

    @Autowired private GetAllCityService cityService;

    @Autowired private GetAllInfoAboutCityService getAllInfoAboutCityService;

    @Autowired private FiendCityByNameService fiendCityByNameService;

    @Value("${bot.username}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()){
            handleMessage(update.getMessage());
        }
    }

    private void handleMessage(Message message) {
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity =
                    message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
            if(commandEntity.isPresent()) {
                String command = message.getText()
                        .substring(commandEntity.get().getOffset(), commandEntity.get().getLength());

                switch (command) {
                    case "/get_all_city" -> messageService.sendMessage(message, allCity());
                }
            }
        }
        if (message.hasText()) {

            String messageText = message.getText();

            messageService.sendMessage(message, "Please, input city name: ");
            messageService.sendMessage(message, infoAboutCity(messageText));
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    private String allCity() {

        String allCity = "";

        StringBuilder stringBuilder = new StringBuilder(allCity);

        GetAllCityResponse response = cityService.execute();

        List<City> cities = response.getCity();

        if(!cities.isEmpty()) {
            for (City city : cities) {
                allCity = String.join(". ", city.getCityId().toString(), city.getCityName(), "\n");
                stringBuilder.append(allCity);
            }
        }
        return stringBuilder.toString();
    }

    private String infoAboutCity(String cityName) {

        String cityInfo = "";

        StringBuilder stringBuilder = new StringBuilder(cityInfo);

        GetAllInfoAboutCityResponse response = getAllInfoAboutCityService
                .execute(new GetAllInfoAboutCityRequest(cityName));

        List<Info> infos = response.getInfoList();

        if (!infos.isEmpty()) {
            for (Info info : infos) {
                cityInfo = String.join( " ",info.getCityInfo(),"\n");
                stringBuilder.append(cityInfo);
            }
        }
        return stringBuilder.toString();
    }
}
