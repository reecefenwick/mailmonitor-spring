package au.com.suncorp.mailmonitor;

import au.com.suncorp.mailmonitor.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class MailMonitorApplication {

    private static final Logger log = LoggerFactory.getLogger(MailMonitorApplication.class);

    /**
     * If no profile has been configured, set by default the "dev" profile.
     */
    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active") &&
                !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {

            log.info("##### \n SETTING DEFAULT SPRING PROFILE");
            app.setAdditionalProfiles(Constants.SPRING_PROFILE_DEVELOPMENT);
        }

        log.info("##### \n executed addDefaultProfile");

    }

    /**
     * Main method, used to run the application.
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(MailMonitorApplication.class);
        app.setShowBanner(false);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
        addDefaultProfile(app, source);

        Environment env = app.run(args).getEnvironment();
        log.info("Access URLs:\n----------------------------------------------------------\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}\n\t" +
                        "External: \thttp://{}:{}\n----------------------------------------------------------",
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }
}
