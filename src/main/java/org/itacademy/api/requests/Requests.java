package org.itacademy.api.requests;

import org.itacademy.api.models.Request;
import org.itacademy.api.utils.RequestUtils;

public class Requests {

    public static Request getCount = RequestUtils.create("", new String[]{"player", "count", "?"});
    public static Request getMode = RequestUtils.create("HomePod", new String[]{"mode", "?"});
    public static Request getPath = RequestUtils.create("HomePod", new String[]{"path", "?"});
    public static Request getVolume = RequestUtils.create("HomePod", new String[]{"mixer", "volume", "?"});

    public static Request setVolume(String value){
        return RequestUtils.create("HomePod", new String[]{"mixer", "volume", value});
    }
}

/** request samples
{"id": 1, "method": "slim.request", "params":["", ["player", "count", "?"]]}
{"id": 1, "method": "slim.request", "params":["HomePod", ["mode", "?"]]}
{"id": 1, "method": "slim.request", "params":["HomePod", ["path", "?"]]}
{"id": 1, "method": "slim.request", "params":["HomePod", ["mixer", "volume", "?"]]}
{"id": 1, "method": "slim.request", "params":["HomePod", ["mixer", "volume", "2"]]}
*/