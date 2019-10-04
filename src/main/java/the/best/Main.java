package the.best;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.Integer.parseInt;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private UserInterfaceService userInterfaceService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) {
        userInterfaceService.run();
    }

    @Autowired
    public void setUserInterfaceService(UserInterfaceService userInterfaceService) {
        this.userInterfaceService = userInterfaceService;
    }
}
