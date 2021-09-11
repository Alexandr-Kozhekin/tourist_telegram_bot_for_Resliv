package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import telegram_bot.core.requests.DeleteInfoAboutCityRequest;
import telegram_bot.core.services.DeleteInfoAboutCityService;

@Controller
public class DeleteInfoAboutCityController {

    @Autowired private DeleteInfoAboutCityService deleteInfoAboutCityService;

    @GetMapping(value = "/DeleteInfoAboutCity")
    public String showDeleteInfoAboutCityPage(ModelMap modelMap){

        modelMap.addAttribute("request", new DeleteInfoAboutCityRequest());

        return "DeleteInfoAboutCity";
    }

    @PostMapping("/DeleteInfoAboutCity")
    public String processDeleteInfoAboutCityRequest(@ModelAttribute(value = "request")
                                                                DeleteInfoAboutCityRequest request) {

        deleteInfoAboutCityService.execute(request);

        return "DeleteInfoAboutCity";
    }
}
