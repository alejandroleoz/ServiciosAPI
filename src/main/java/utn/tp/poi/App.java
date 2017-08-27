package utn.tp.poi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.tp.poi.servlet.DataInitializer;
import utn.tp.poi.servlet.InitHandler;

import java.net.URL;

@SpringBootApplication
public class App {
    public static void main(String[] args) {

        URL bancosURL = App.class.getClassLoader().getResource("bancosConfig.json");
        URL centrosURL = App.class.getClassLoader().getResource("centrosConfig.json");

        DataInitializer initializer = new DataInitializer();
        initializer.initCentrosData(centrosURL);
        initializer.initBancosData(bancosURL);

        // start application after config
        SpringApplication.run(App.class, args);
    }
}
