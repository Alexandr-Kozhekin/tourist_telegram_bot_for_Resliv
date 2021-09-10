package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import telegram_bot.core.requests.FiendCityByNameRequest;
import telegram_bot.core.responses.FiendCityByNameResponse;
import telegram_bot.core.services.FiendCityByNameService;

@Controller
public class FiendCityByNameController {

    @Autowired
    FiendCityByNameService fiendCityByNameService;

    @GetMapping(value = "/FiendCityByName")
    public String showFiendCityByNamePage(ModelMap modelMap) {


        modelMap.addAttribute("request", new FiendCityByNameRequest());

        return "FiendCityByName";
    }

    @PostMapping("/FiendCityByName")
    public String processFiendCityByNameRequest(@ModelAttribute(value = "request")
                                                        FiendCityByNameRequest request, ModelMap modelMap) {

        FiendCityByNameResponse response = fiendCityByNameService.execute(request);

        modelMap.addAttribute("CITY", response.getCity());

        return "FiendCityByName";
    }
}
