package kafka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class DemoApplication {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public DemoApplication(KafkaTemplate<String, Object> kafkaTemplate) {

		this.kafkaTemplate = kafkaTemplate;
		TestMsg testMsg = new TestMsg();
		kafkaTemplate.send("Example",testMsg);

	}

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}
	
	private static class TestMsg{
		
		public String id = "123";

		public String firstName = "Orly";

		public String lastName = "M";

	}

}
