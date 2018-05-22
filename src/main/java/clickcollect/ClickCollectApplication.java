package clickcollect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClickCollectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClickCollectApplication.class, args);
		
		DatabaseService databaseService = DatabaseService.getInstance();
		try {
			databaseService.init();
		} catch (Exception e) {
			System.out.println("Error initializing dynamoDB");
			e.printStackTrace();
		}
	}
}
