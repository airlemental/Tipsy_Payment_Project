package net.treXis.tipsy.security.configuration;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration //Have to add this because Spring does not know what it is just by naming it configuration.
public class MySqlDatasource {

    //Override the data connection properties, has to be annotated

    @Profile("{authentication}")
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder<?> builder = DataSourceBuilder.create();  // use a builder pattern to create DataSources
        builder.url("jdbc:mysql://localhost:3306/tipsy.users"); //address same as property or yaml files
        builder.username("Wind");
        builder.password("B031ng777");
        System.out.println("Custom MySQL Task datasource has been set."); // Don't need this, but it's nice to know. This will be in the logs.
        return builder.build(); //because this is a bean, Spring will look for the bean in the Spring context and replace the datasource definition with this implementation.
    }
}


// My original attempt to get it to read from a properties file.

//@Configuration
//@PropertySource("mysql.yaml")
//public class MySqlDatasource {
//    @Value("${spring.datasource.url}")
//    private String springDatasourceUrl;
//
//    @Value("${spring.datasource.username}")
//    private String springDatasourceUsername;
//
//    @Value("${spring.datasource.password}")
//    private String springDatasourcePassword;
//
//    @Bean
//    @Primary
//    public DataSource msDataSource(){
//        DataSourceBuilder builder = DataSourceBuilder.create();
////        builder.url("jdbc:mysql://localhost:3306/");
////        builder.username("Wind");
////        builder.password("B031ng777");
//        builder.url(springDatasourceUrl);
//        builder.username(springDatasourceUsername);
//        builder.password(springDatasourcePassword);
//        System.out.println("Custom MySQL datasource has been set.");
//        return builder.build();
//    }
//}
