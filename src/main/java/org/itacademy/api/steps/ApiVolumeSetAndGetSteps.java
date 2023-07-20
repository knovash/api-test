package org.itacademy.api.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.itacademy.api.models.Request;
import org.itacademy.api.models.Response;
import org.itacademy.api.requests.Requests;
import org.itacademy.api.utils.LogListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import static io.restassured.RestAssured.given;

@Log4j2
@Listeners(LogListener.class)
public class ApiVolumeSetAndGetSteps {

    @Step("volume set")
    public void volumeSet(String serverAddress, String volume) {
        log.info("volume set");
        String value = volume;
        Request request = Requests.setVolume(value);
        log.info("REQUEST: " + request);
        Response response = given()
                .body(request).when().post(serverAddress).then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Response.class);
        log.info("RESPONSE: " + response);
    }

    @Step("volume get")
    public Response volumeGet(String serverAddress) {
        log.info("volume get");
        Request request = Requests.getVolume;
        log.info("REQUEST: " + request);
        Response response = given().body(request)
                .when().post(serverAddress).then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Response.class);
        log.info("RESPONSE: " + response);
        log.info("GET VOLUME: " + response.result._volume);
        return response;
    }

    @Step("check result")
    public void checkResult(Response response, String volume) {
        log.info("check result");
        Assert.assertEquals(response.getResult().get_volume(), volume);
    }
}
