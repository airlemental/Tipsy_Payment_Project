package net.treXis.tipsy.security.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration //Have to add this because Spring does not know what it is just by naming it configuration.
public class PostgresConfiguration {

    //Override the data connection properties, has to be annotated

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


    // Resource, Initializer, and Populator were all added to work with the JDBC Token Store
    @Value("classpath:schema.sql") //this is set to where exactly?
    private Resource schemaScript;

    @Bean
    public DataSourceInitializer dataSourceInitializer(DataSource postgresDB) {
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(postgresDB);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    //this might be optional since Spring uses schema.sql by default?
    private DatabasePopulator databasePopulator() {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(schemaScript);
        return populator;
    }




}


//----for injecting into other classes---------
//    private final DataSource postgresDB;
//    @Autowired  //constructor injection
//    public NameOfClassBeingInjectedInto(DataSource postgresDB){
//        this.postgresDB = postgresDB;
//    }
