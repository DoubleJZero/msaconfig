package msaconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsaconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaconfigApplication.class, args);
	}

}
