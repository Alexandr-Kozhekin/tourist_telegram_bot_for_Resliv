package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

import telegram_bot.core.requests.AddCityRequest;
import telegram_bot.core.responses.AddCityResponse;
import telegram_bot.core.services.AddCityService;

@Controller
public class AddCityController {

    @Autowired private AddCityService addCityService;

    @GetMapping(value = "/AddCity")
    public String showAddEmployeePage(ModelMap modelMap) {

        modelMap.addAttribute("request", new AddCityRequest());

        return "AddCity";
    }

    @PostMapping("/AddCity")
    public String processAddCityRequest(@ModelAttribute(value = "request") AddCityRequest request,
                                        ModelMap modelMap) {

        AddCityResponse response = addCityService.execute(request);

        if (response.hasErrors()) {

            modelMap.addAttribute("errors", response.getErrors());
            return "AddCity";

        }

        return "AddCity";
    }
}
