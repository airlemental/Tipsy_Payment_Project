package net.treXis.tipsy.security.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class MySqlConfiguration {

    @Bean(name = "mysqlDatasource")
    @Primary
    public DataSource dataSource(){
        DataSourceBuilder<?> builder = DataSourceBuilder.create();
//        builder.driverClassName("com.mysql.cj.jdbc.Driver");
        builder.url("jdbc:mysql://localhost:3306/tipsy/");
        builder.username("Wind");
        builder.password("B031ng777");
        System.out.println("Custom MySQL Tipsy datasource has been set.");
        return builder.build();
    }
}



