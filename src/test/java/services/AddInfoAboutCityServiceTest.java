package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import org.mockito.*;

import telegram_bot.core.databases.InfoRepository;
import telegram_bot.core.requests.AddInfoAboutCityRequest;
import telegram_bot.core.services.AddInfoAboutCityService;
import telegram_bot.core.services.validators.AddInfoAboutCityValidator;

import telegram_bot.core.responses.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class AddInfoAboutCityServiceTest {

    @Mock private InfoRepository repository;

    @Mock private AddInfoAboutCityValidator validator;

    @InjectMocks private AddInfoAboutCityService service;

    @Test
    public void shouldInteractWithDBInCaseOfAllValidEntries() {

        AddInfoAboutCityRequest request = new AddInfoAboutCityRequest(1L,"test test test");

        AddInfoAboutCityResponse response = service.execute(request);

        Mockito.verify(repository).addInfoAboutCity(request.getCityId(), request.getInfo());

        assertThat(response.hasErrors()).isFalse();
        assertThat(response.getInfo()).isEqualTo("test test test");
    }

    @Test
    public void shouldReturnErrorWhenCityIdNull() {

        AddInfoAboutCityRequest request = new AddInfoAboutCityRequest(null,"test test test");

        List<CoreError> expected = List.of(
                new CoreError("city id", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        AddInfoAboutCityResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(repository);
    }

    @Test
    public void shouldReturnErrorWhenInfoNull() {

        AddInfoAboutCityRequest request = new AddInfoAboutCityRequest(1L, null);

        List<CoreError> expected = List.of(
                new CoreError("info", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        AddInfoAboutCityResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 1).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(repository);
    }

    @Test
    public void shouldReturnErrorWhenAllFieldNull() {

        AddInfoAboutCityRequest request = new AddInfoAboutCityRequest(null, null);

        List<CoreError> expected = List.of(
                new CoreError("city id", "Must not be empty!"),
                new CoreError("info", "Must not be empty!"));

        Mockito.when(validator.validate(request)).thenReturn(expected);

        AddInfoAboutCityResponse response = service.execute(request);

        assertThat(response.hasErrors()).isTrue();
        assertThat(response.getErrors().size() == 2).isTrue();
        assertThat(response.getErrors()).isEqualTo(expected);

        Mockito.verifyNoInteractions(repository);
    }
}
