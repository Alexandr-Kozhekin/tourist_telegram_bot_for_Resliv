package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

import telegram_bot.core.requests.AddInfoAboutCityRequest;
import telegram_bot.core.responses.AddInfoAboutCityResponse;
import telegram_bot.core.services.AddInfoAboutCityService;

@Controller
public class AddInfoAboutCityController {

    @Autowired private AddInfoAboutCityService addInfoAboutCityService;

    @GetMapping(value = "/AddInfoAboutCity")
    public String showAddInfoAboutCityPage(ModelMap modelMap) {

        modelMap.addAttribute("request", new AddInfoAboutCityRequest());

        return "AddInfoAboutCity";
    }

    @PostMapping("/AddInfoAboutCity")
    public String processAddInfoAboutCityRequest(@ModelAttribute(value = "request") AddInfoAboutCityRequest request,
                                                 ModelMap modelMap) {

        AddInfoAboutCityResponse response = addInfoAboutCityService.execute(request);

        if (response.hasErrors()) {

            modelMap.addAttribute("errors", response.getErrors());
            return "AddInfoAboutCity";

        }

        return "AddInfoAboutCity";
    }
}
