package org.itacademy.api;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.itacademy.api.models.Response;
import org.itacademy.api.steps.ApiVolumeSetAndGetSteps;
import org.itacademy.api.utils.LogListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

@Log4j2
@Listeners(LogListener.class)
public class ApiVolumeSetAndGetTest {

    private ResourceBundle bundle = ResourceBundle.getBundle("config");
    private final String SERVERADDRESS = bundle.getString("URL");
    private ApiVolumeSetAndGetSteps apiVolumeSetAndGetSteps = new ApiVolumeSetAndGetSteps();

    @Description("Verify that set volume equals get volume")
    @Test
    public void setAndGetVolumeTest() {
        String volume = "12";
        apiVolumeSetAndGetSteps.volumeSet(SERVERADDRESS, volume);
        Response response = apiVolumeSetAndGetSteps.volumeGet(SERVERADDRESS);
        apiVolumeSetAndGetSteps.checkResult(response, volume);
    }
}