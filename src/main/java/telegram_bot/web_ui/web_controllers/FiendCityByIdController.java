package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import telegram_bot.core.requests.FiendCityByIdRequest;
import telegram_bot.core.responses.FiendCityByIdResponse;
import telegram_bot.core.services.FiendCityByIdService;

@Controller
public class FiendCityByIdController {

    @Autowired FiendCityByIdService fiendCityByIdService;

    @GetMapping(value = "/FiendCityById")
    public String showFiendCityByIdPage(ModelMap modelMap) {


        modelMap.addAttribute("request", new FiendCityByIdRequest());

        return "FiendCityById";
    }

    @PostMapping("/FiendCityById")
    public String processFiendCityByIdRequest(@ModelAttribute(value = "request")
                                                            FiendCityByIdRequest request, ModelMap modelMap) {

        FiendCityByIdResponse response = fiendCityByIdService.execute(request);

        modelMap.addAttribute("CITY", response.getCity());

        return "FiendCityById";
    }
}
