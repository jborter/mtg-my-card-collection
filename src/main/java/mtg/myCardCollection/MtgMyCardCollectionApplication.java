package mtg.myCardCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class MtgMyCardCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MtgMyCardCollectionApplication.class, args);
	}
}
