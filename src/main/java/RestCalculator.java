import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "services",
        "controllers",
        "entities"
})
public class RestCalculator {

    public static void main(String[] args) {
        SpringApplication.run(RestCalculator.class);
    }
}
