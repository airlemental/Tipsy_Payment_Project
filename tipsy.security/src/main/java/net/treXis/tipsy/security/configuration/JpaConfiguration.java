//package net.treXis.tipsy.security.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJpaRepositories
//@EnableTransactionManagement
//public class JpaConfiguration {
//
//    private final DataSource dataSource;
//    @Autowired  //constructor injection
//    public JpaConfiguration(DataSource dataSource){
//        this.dataSource = dataSource;
//    }
//
//    @Bean   // set the entity manager
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
//        LocalContainerEntityManagerFactoryBean entityFactory = new LocalContainerEntityManagerFactoryBean();
//        entityFactory.setDataSource(dataSource);
//        entityFactory.setPackagesToScan("net.treXis.tipsy.security");
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//        entityFactory.setJpaVendorAdapter(vendorAdapter);
//        return entityFactory;
//
//    }
//
//    @Bean    // set the transaction manager
//    public PlatformTransactionManager transactionManager (EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        txManager.setEntityManagerFactory(entityManagerFactory);
//        return txManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//
//}
