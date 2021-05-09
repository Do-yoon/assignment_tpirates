package com.tpirates.api.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class Serializer extends JsonSerializer<String> {

    @Override
    public void serialize(String value,
                          JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        if (value == null) {
            return;
        }
        gen.writeRawValue(value);
    }
}

