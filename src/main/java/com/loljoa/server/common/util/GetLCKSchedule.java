package com.loljoa.server.common.util;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GetLCKSchedule {
    @Value("${jsonPath}")
    private String jsonPath;

    private final Gson gson = new Gson();

    public Map<String, Object> getLCKSchedule() throws IOException {
        Reader reader = new FileReader(jsonPath + "\\schedule.json");
        JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);

        Map map = null;
        try {
            map = new ObjectMapper().readValue(jsonObj.toString(), ConcurrentHashMap.class);
        } catch (JsonParseException | IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
