package org.example.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.example.util.ObjectIdSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
//test branch 1
// test branch 3
//test branch 4
public class Person {
    @Id
    @JsonSerialize(using = ObjectIdSerializer.class)
    private ObjectId id;
    private String name;
    private int age;
    // test branch 2
}
