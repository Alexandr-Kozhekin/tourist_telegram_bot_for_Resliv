package telegram_bot.application;

import org.telegram.telegrambots.ApiContextInitializer;
import telegram_bot.web_ui.web_config.SpringWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class TouristTelegramBotApplication {

    public static void main(String[] args) {

        try {

            ApiContextInitializer.init();

            ConfigurableApplicationContext context = SpringApplication.run(SpringWebConfiguration.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
