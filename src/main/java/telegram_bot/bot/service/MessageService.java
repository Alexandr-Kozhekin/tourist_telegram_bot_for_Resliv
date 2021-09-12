package telegram_bot.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import telegram_bot.bot.domain.TelegramBot;

@Service
public class MessageService {

    @Autowired TelegramBot telegramBot;

    public void sendMessage(Message message, String text) {

        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);

        try {

            telegramBot.execute(sendMessage);

        } catch (TelegramApiException e) {

            e.printStackTrace();
        }
    }
}
