package org.itacademy.api;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.itacademy.api.models.Request;
import org.itacademy.api.models.Response;
import org.itacademy.api.requests.Requests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

@Log4j2
public class ApiTest {

    static ResourceBundle bundle = ResourceBundle.getBundle("config");
    private final String URL = bundle.getString("URL");

    @Description("Verify that get volume status is 200")
    @Test
    public void getVolumeTest() {
        log.info("TEST GET VOLUME");
        Request request = Requests.getVolume;
        log.info("REQUEST: " + request);
        Response response = given()
                .body(request)
                .when()
                .post(URL)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Response.class);
        log.info("RESPONSE: " + response);
        log.info("GET VOLUME: " + response.result._volume);
    }

    @Description("Verify that get count status is 200")
    @Test
    public void getCountTest() {
        log.info("TEST GET COUNT");
        Request request = Requests.getCount;
        log.info("REQUEST: " + request);
        Response response = given()
                .body(request)
                .when()
                .post(URL)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Response.class);
        log.info("RESPONSE: " + response);
        log.info("GET COUNT: " + response.result._count);
    }

    @Description("Verify that get path status is 200")
    @Test
    public void getPathTest() {
        log.info("TEST GET PATH");
        Request request = Requests.getPath;
        log.info("REQUEST: " + request);
        Response response = given()
                .body(request)
                .when()
                .post(URL)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Response.class);
        log.info("RESPONSE: " + response);
        log.info("GET PATH: " + response.result._path);
    }

    @Description("Verify that get mode status is 200")
    @Test
    public void getModeTest() {
        log.info("TEST GET PATH");
        Request request = Requests.getMode;
        log.info("REQUEST: " + request);
        Response response = given()
                .body(request)
                .when()
                .post(URL)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Response.class);
        log.info("RESPONSE: " + response);
        log.info("GET MODE: " + response.result._mode);
    }

    @Description("Verify that set volume equals get volume")
    @Test
    public void setAndGetVolumeTest() {
        log.info("TEST SET AND GET VOLUME");
        String value = "17";
        Request request = Requests.setVolume(value);
        log.info("REQUEST: " + request);
        Response response = given()
                .body(request)
                .when()
                .post(URL)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Response.class);
        log.info("RESPONSE: " + response);

        log.info("TEST GET VOLUME");
        request = Requests.getVolume;
        log.info("REQUEST: " + request);
        response = given()
                .body(request)
                .when()
                .post(URL)
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().as(Response.class);
        Assert.assertEquals(response.getResult().get_volume(), value);
        log.info("RESPONSE: " + response);
        log.info("GET VOLUME: " + response.result._volume);
    }
}