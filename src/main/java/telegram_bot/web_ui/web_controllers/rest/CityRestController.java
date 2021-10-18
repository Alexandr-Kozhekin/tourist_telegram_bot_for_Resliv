package telegram_bot.web_ui.web_controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import telegram_bot.core.requests.*;
import telegram_bot.core.responses.*;
import telegram_bot.core.services.*;

@RestController
@RequestMapping("/city")
public class CityRestController {

    @Autowired private AddCityService addCityService;

    @Autowired private GetAllCityService getAllCityService;

    @Autowired private FiendCityByIdService fiendCityByIdService;

    @Autowired private FiendCityByNameService fiendCityByNameService;

    @Autowired private DeleteCityByIdService deleteCityByIdService;

    @Autowired private DeleteCityByNameService deleteCityByNameService;

    @PostMapping(path = "/",
            consumes = "application/json",
            produces = "application/json")
    public AddCityResponse addCity(@RequestBody AddCityRequest request) {

        return addCityService.execute(request);
    }

    @GetMapping(path = "/",
            produces = "application/json")
    public GetAllCityResponse fiendAllCity() {

        return getAllCityService.execute();
    }

    @GetMapping(path = "id/{cityId}",
            consumes = "application/json",
            produces = "application/json")
    public FiendCityByIdResponse fiendById(@PathVariable(name= "cityId") Long cityId) {

        FiendCityByIdRequest request = new FiendCityByIdRequest(cityId);

        return fiendCityByIdService.execute(request);
    }

    @GetMapping(path = "name/{cityName}",
            consumes = "application/json",
            produces = "application/json")
    public FiendCityByNameResponse fiendByName(@PathVariable(value = "cityName") String cityName) {

        FiendCityByNameRequest request = new FiendCityByNameRequest(cityName);

        return fiendCityByNameService.execute(request);
    }

    @DeleteMapping(path = "id/{id}",
            produces = "application/json")
    public DeleteCityByIdResponse deleteById(@PathVariable(name = "id") Long id) {

        DeleteCityByIdRequest request = new DeleteCityByIdRequest(id);

        return deleteCityByIdService.execute(request);
    }

    @DeleteMapping(path = "name/{cityName}",
            produces = "application/json")
    public DeleteCityByNameResponse deleteByName(@PathVariable(name = "cityName") String cityName) {

        DeleteCityByNameRequest request = new DeleteCityByNameRequest(cityName);

        return deleteCityByNameService.execute(request);
    }

}
