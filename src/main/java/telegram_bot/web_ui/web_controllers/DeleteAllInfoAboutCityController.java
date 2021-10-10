package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

import telegram_bot.core.requests.DeleteAllInfoAboutCityRequest;
import telegram_bot.core.responses.DeleteAllInfoAboutCityResponse;
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
                                                                   DeleteAllInfoAboutCityRequest request, ModelMap modelMap) {

        DeleteAllInfoAboutCityResponse response = cityService.execute(request);

        if (response.hasErrors()) {

            modelMap.addAttribute("errors", response.getErrors());
            return "DeleteAllInfoAboutCity";

        }

        return "DeleteAllInfoAboutCity";
    }
}
