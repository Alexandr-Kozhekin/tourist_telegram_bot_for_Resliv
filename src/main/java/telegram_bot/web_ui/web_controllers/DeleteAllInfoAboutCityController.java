package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import telegram_bot.core.requests.DeleteAllInfoAboutCityRequest;
import telegram_bot.core.services.DeleteAllInfoAboutCityService;

@Controller
public class DeleteAllInfoAboutCityController {

    @Autowired
    private DeleteAllInfoAboutCityService cityService;

    @GetMapping(value = "/DeleteAllInfoAboutCity")
    public String showDeleteAllInfoAboutCityPage(ModelMap modelMap) {

        modelMap.addAttribute("request", new DeleteAllInfoAboutCityRequest());

        return "DeleteAllInfoAboutCity";
    }

    @PostMapping("/DeleteAllInfoAboutCity")
    public String processDeleteAllInfoAboutCityRequest(@ModelAttribute(value = "request")
                                                                   DeleteAllInfoAboutCityRequest request) {

        cityService.execute(request);

        return "DeleteAllInfoAboutCity";
    }
}
