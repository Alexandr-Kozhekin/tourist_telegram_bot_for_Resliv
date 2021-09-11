package telegram_bot.web_ui.web_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import telegram_bot.core.requests.AddCityRequest;
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
    public String processAddCityRequest(@ModelAttribute(value = "request") AddCityRequest request) {

        addCityService.execute(request);

        return "AddCity";
    }
}
