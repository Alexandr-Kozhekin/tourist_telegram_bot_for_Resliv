package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

import telegram_bot.core.requests.DeleteInfoAboutCityRequest;
import telegram_bot.core.responses.DeleteInfoAboutCityResponse;
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
                                                                DeleteInfoAboutCityRequest request, ModelMap modelMap) {

        DeleteInfoAboutCityResponse response = deleteInfoAboutCityService.execute(request);

        if (response.hasErrors()) {

            modelMap.addAttribute("errors", response.getErrors());
            return "DeleteInfoAboutCity";
        }

        return "DeleteInfoAboutCity";
    }
}
