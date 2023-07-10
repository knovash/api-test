package org.itacademy.api.utils;

import org.itacademy.api.models.Request;

import java.util.Arrays;

public class RequestUtils {

    public static Request create(String playerName, String[] params) {
        /** request sample {"id": 1, "method": "slim.request", "params":["HomePod", ["mixer", "volume", "?"]]} */
        Request request = new Request();
        request.setId("1");
        request.setMethod("slim.request");
        request.setParams(Arrays.asList(playerName, Arrays.asList(params)));
        return request;
    }
}
