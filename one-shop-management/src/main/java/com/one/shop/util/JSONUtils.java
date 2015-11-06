package com.one.shop.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by pein on 2015/10/29.
 */
public class JSONUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(JSONUtils.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    static{
        mapper.enable(SerializationFeature.WRITE_NULL_MAP_VALUES);
        mapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
    }

    /**
     * 对象转换成json
     * @param source
     * @param <T>
     * @return
     */
    public static <T> String  toJson(T source) {
        try {
            return mapper.writeValueAsString(source);
        } catch (JsonProcessingException e) {
            LOGGER.error("to json exception . ",e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String json,Class<T> claZZ) {
        try {
            return mapper.readValue(json, claZZ);
        } catch (IOException e) {
            LOGGER.error("from json exception . ",e);
            throw new RuntimeException(e);
        }
    }
}
