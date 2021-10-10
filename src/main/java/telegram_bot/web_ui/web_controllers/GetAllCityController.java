package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import telegram_bot.core.responses.GetAllCityResponse;
import telegram_bot.core.services.GetAllCityService;

@Controller
public class GetAllCityController {

    @Autowired private GetAllCityService getAllCityService;

    @GetMapping(value = "/AllCity")
    public String showGetAllTitlesPage(ModelMap modelMap) {

        GetAllCityResponse response = getAllCityService.execute();

        modelMap.addAttribute("CITY", response.getCity());

        return "AllCity";
    }
}
