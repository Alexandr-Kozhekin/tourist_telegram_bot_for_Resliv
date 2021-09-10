package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import telegram_bot.core.requests.DeleteCityByNameRequest;
import telegram_bot.core.services.DeleteCityByNameService;

@Controller
public class DeleteCityByNameController {

    @Autowired private DeleteCityByNameService cityService;

    @GetMapping(value = "/DeleteCityByName")
    public String showDeleteCityByNamePage(ModelMap modelMap){

        modelMap.addAttribute("request", new DeleteCityByNameRequest());

        return "DeleteCityByName";
    }

    @PostMapping("/DeleteCityByName")
    public String processDeleteCityByNameRequest(@ModelAttribute(value = "request") DeleteCityByNameRequest request) {

        cityService.execute(request);

        return "DeleteCityByName";
    }
}
