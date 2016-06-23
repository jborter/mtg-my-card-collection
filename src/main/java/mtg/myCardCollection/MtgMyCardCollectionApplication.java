package mtg.myCardCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableEurekaClient
public class MtgMyCardCollectionApplication {

	public static void main(String[] args) {
		SpringApplication notificationMicroService = new SpringApplication(MtgMyCardCollectionApplication.class);
		notificationMicroService.addListeners(new ApplicationPidFileWriter("notification-micro-service.pid"));
		notificationMicroService.run(args);
	}
}
