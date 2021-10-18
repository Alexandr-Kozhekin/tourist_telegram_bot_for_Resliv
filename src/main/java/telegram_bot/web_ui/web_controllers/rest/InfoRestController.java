package telegram_bot.web_ui.web_controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import telegram_bot.core.requests.*;
import telegram_bot.core.responses.*;
import telegram_bot.core.services.*;

@RestController
@RequestMapping("/info")
public class InfoRestController {

    @Autowired private AddInfoAboutCityService addInfoAboutCityService;

    @Autowired private GetAllInfoAboutCityService getAllInfoAboutCityService;

    @Autowired private DeleteInfoAboutCityService deleteInfoAboutCityService;

    @Autowired private DeleteAllInfoAboutCityService deleteAllInfoAboutCityService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddInfoAboutCityResponse addInfo(@RequestBody AddInfoAboutCityRequest request) {

        return addInfoAboutCityService.execute(request);
    }

    @GetMapping(path = "/{cityName}",
            produces = "application/json")
    public GetAllInfoAboutCityResponse getAllInfoAboutCity(@PathVariable(name = "cityName") String cityName) {

        GetAllInfoAboutCityRequest request = new GetAllInfoAboutCityRequest(cityName);

        return getAllInfoAboutCityService.execute(request);
    }

    @DeleteMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public DeleteInfoAboutCityResponse deleteInfo(@RequestBody DeleteInfoAboutCityRequest request) {

        return deleteInfoAboutCityService.execute(request);
    }

    @DeleteMapping(path = "/{cityId}",
            consumes = "application/json",
            produces = "application/json")
    public DeleteAllInfoAboutCityResponse deleteAllInfo(@PathVariable(name = "cityId") Long cityId) {

        DeleteAllInfoAboutCityRequest request = new DeleteAllInfoAboutCityRequest(cityId);

        return deleteAllInfoAboutCityService.execute(request);
    }

}
