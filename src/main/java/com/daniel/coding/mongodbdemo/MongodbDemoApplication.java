package com.daniel.coding.mongodbdemo;

import com.daniel.coding.mongodbdemo.category.Category;
import com.daniel.coding.mongodbdemo.category.CategoryRepository;
import com.daniel.coding.mongodbdemo.product.Product;
import com.daniel.coding.mongodbdemo.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbDemoApplication.class, args);

		// Acessando com o Swagger - link: localhost:8080/swagger-ui/index.html
	}

	/* O Script abaixo significa que eu quero executar algum código na inicialização do aplicativo*/
	//@Bean
	public CommandLineRunner commandLineRunner(ProductRepository productRepository, CategoryRepository categoryRepository){
		return args -> {

			var category = Category.builder()
					.name("Phones")
					.description("Description Phone")
					.build();

			categoryRepository.insert(category);

			var product = Product.builder()
					.name("iPhone")
					.description("Smart Phone")
					.build();

			productRepository.insert(product);
		};
	}
}
