package com.colak.springkafkacustomserdetutorial.serde;

import com.colak.springkafkacustomserdetutorial.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class CustomStudentSerializer implements Serializer<Student> {
    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public byte[] serialize(String topic, Student data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }
}
