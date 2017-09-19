package utn.tp.poi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import utn.tp.poi.servlet.DataInitializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

@SpringBootApplication
@ServletComponentScan
public class App {
    public static void main(String[] args) throws URISyntaxException, IOException {

        URL bancosURL = App.class.getClassLoader().getResource("bancosConfig.json");
        URL centrosURL = App.class.getClassLoader().getResource("centrosConfig.json");
        URL usersURL = App.class.getClassLoader().getResource("usuarios.properties");

        DataInitializer initializer = new DataInitializer();
        initializer.initCentrosData(centrosURL);
        initializer.initBancosData(bancosURL);

        Properties usuariosProps = new Properties();
        usuariosProps.load(new FileInputStream(new File(usersURL.toURI())));
        LoginRegistry.getInstance().setUsuarios(usuariosProps);

        // start application after config
        SpringApplication.run(App.class, args);
    }
}
