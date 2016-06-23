package mtg.myCardCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MtgMyCardCollectionApplication {

	public static void main(String[] args) {
		SpringApplication notificationMicroService = new SpringApplication(MtgMyCardCollectionApplication.class);
		notificationMicroService.run(args);
	}
}
