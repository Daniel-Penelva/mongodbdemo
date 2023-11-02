package com.daniel.coding.mongodbdemo.category;

import com.daniel.coding.mongodbdemo.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "category")
@Data
@AllArgsConstructor
@Builder
public class Category {

    @Id
    private String id;

    private String name;
    private String description;
}
