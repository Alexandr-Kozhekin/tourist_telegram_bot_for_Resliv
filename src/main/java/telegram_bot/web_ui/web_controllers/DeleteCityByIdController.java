package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

import telegram_bot.core.requests.DeleteCityByIdRequest;
import telegram_bot.core.responses.DeleteCityByIdResponse;
import telegram_bot.core.services.DeleteCityByIdService;

@Controller
public class DeleteCityByIdController {

    @Autowired private DeleteCityByIdService cityService;

    @GetMapping(value = "/DeleteCityById")
    public String showDeleteCityByIDPage(ModelMap modelMap) {

        modelMap.addAttribute("request", new DeleteCityByIdRequest());

        return "DeleteCityById";
    }

    @PostMapping("/DeleteCityById")
    public String processDeleteCityByIdRequest(@ModelAttribute(value = "request") DeleteCityByIdRequest request,
                                               ModelMap modelMap) {

        DeleteCityByIdResponse response = cityService.execute(request);

        if (response.hasErrors()) {

            modelMap.addAttribute("errors", response.getErrors());
            return "DeleteCityById";
        }

        return "DeleteCityById";
    }
}
