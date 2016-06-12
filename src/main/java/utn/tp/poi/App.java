package utn.tp.poi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
//        SpringApplication.run(App.class, args);


        Factory factory = new Factory();
        try{
            factory.createCentrosFromConfig("/Users/aleoz/Mago/repository/github/ServiciosAPI/src/main/webapp/WEB-INF/resources/centrosConfig.json");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
