package com.library.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DataSourceConfig {
    //@Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
           .setType(EmbeddedDatabaseType.HSQL)
           .build();
    }
    
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.hsqldb.jdbc.JDBCDriver");
       // dataSourceBuilder.url("jdbc:hsqldb:file:hsqldb;shutdown=true;hsqldb.write_delay=false;"); //https://stackoverflow.com/questions/3551988/hsqldb-and-hibernate-jpa-not-persisting-to-disk
        dataSourceBuilder.url("jdbc:hsqldb:hsql://localhost:5454/hsqldb;hsqldb.write_delay=false;");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
    
    /*
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.hsqldb.jdbc.JDBCDriver");
       // dataSourceBuilder.url("jdbc:hsqldb:file:hsqldb;shutdown=true;hsqldb.write_delay=false;"); //https://stackoverflow.com/questions/3551988/hsqldb-and-hibernate-jpa-not-persisting-to-disk
        dataSourceBuilder.url("jdbc:hsqldb:file:hsqldb;hsqldb.write_delay=false;");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
    */
}