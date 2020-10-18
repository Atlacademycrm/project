package com.atlacademy.crm.entity;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("required format");

        LocalDate localDate;
        localDate = LocalDate.parse(p.getText(), formatter);

        return localDate;
    }
}