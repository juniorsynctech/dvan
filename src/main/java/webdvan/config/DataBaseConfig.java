package webdvan.config;


import java.net.URISyntaxException;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseConfig {
	
	@Bean
    public BasicDataSource dataSource() throws URISyntaxException {

		String username = "nnijdwcvkiaapb";
        String password = "474f08b3781e9c975c86cc5d5926dd763c89f7de16357f1d0c88b6cab5e19f5f";
        String host = "ec2-52-201-55-4.compute-1.amazonaws.com";
        String port = "5432";
        String path = "d1ujpes6e0vret";
        String dbUrl = "jdbc:postgresql://" + host + ":" + port + "/" +  path + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

}
