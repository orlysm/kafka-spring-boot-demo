package kafka.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaDemoApplication implements CommandLineRunner {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	public KafkaDemoApplication(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		kafkaTemplate.send("Example", new TestMsg());
	}

	private static class TestMsg{
		
		public String id = "1234";

		public String firstName = "Orly";

		public String lastName = "M";

	}

}