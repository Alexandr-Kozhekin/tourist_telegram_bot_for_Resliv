package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import telegram_bot.core.requests.GetAllInfoAboutCityRequest;
import telegram_bot.core.responses.GetAllInfoAboutCityResponse;
import telegram_bot.core.services.GetAllInfoAboutCityService;

@Controller
public class GetAllInfoAboutCityController {

    @Autowired private GetAllInfoAboutCityService getAllInfoAboutCityService;

    @GetMapping(value = "/GetAllInfoAboutCity")
    public String showGetAllInfoAboutCityPage(ModelMap modelMap) {

        modelMap.addAttribute("request", new GetAllInfoAboutCityRequest());

        return "GetAllInfoAboutCity";
    }

    @PostMapping("/GetAllInfoAboutCity")
    public String processGetAllInfoAboutCityRequest(@ModelAttribute(value = "request")
                                                            GetAllInfoAboutCityRequest request, ModelMap modelMap) {

        GetAllInfoAboutCityResponse response = getAllInfoAboutCityService.execute(request);

        modelMap.addAttribute("INFO", response.getInfoList());

        return "GetAllInfoAboutCity";
    }
}
