package net.treXis.tipsy.viewer.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration //Have to add this because Spring does not know what it is just by naming it configuration.
public class PostgresConfiguration {

    @Bean
    public DataSource postgresDB(){
        DataSourceBuilder<?> builder = DataSourceBuilder.create();  // use a builder pattern to create DataSources
        builder.url("jdbc:postgresql://localhost:5432/tipsy"); //address same as property or yaml files
        builder.username("postgres");
        builder.password("B031ng777");
        builder.driverClassName("org.postgresql.Driver");
        System.out.println("Custom Postgres conference_app datasource has been set."); // Don't need this, but it's nice to know. This will be in the logs.
        return builder.build(); //because this is a bean, Spring will look for the bean in the Spring context and replace the datasource definition with this implementation.
    }

    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(postgresDB());
    }


}


// When abstracting out the usernames and passwords, will need to autowire in a configuration from property files.
// Should be a Git repo setup.

//    @Autowired
//    private Environment fromFile;
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(fromFile.getProperty("jdbc.driverClassName"));
//        dataSource.setUrl(fromFile.getProperty("jdbc.url"));
//        dataSource.setUsername(fromFile.getProperty("jdbc.user"));
//        dataSource.setPassword(fromFile.getProperty("jdbc.pass"));
//        return dataSource;
//    }
