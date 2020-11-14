package com.library; //issue-1 moved from com.library.shelves so can scan subpackages

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;

import javax.sql.DataSource;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.library.controller.UserController;
import com.library.util.StartHsqldb;

@SpringBootApplication
//@ComponentScan(basePackageClasses = UserController.class)
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@PropertySource("classpath:/application.properties")
public class ShelvesApplication {
	static String FILE_URI="file:hsqldb";
	static String HSQLSERVER_URI="hsql://localhost:5454/hsqldb";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		//localhsqldb();
		//serverhsqldb();
		//StartHsqldb sq = new StartHsqldb();
		/*Connection con = null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			throw e;
		}
		con = DriverManager.getConnection(HSQLSERVER_URI, "SA", "");
		con.createStatement().executeQuery("create table if not exists " +
				" contacts (name varchar(45),email varchar(45),phone varchar(45));");
		
		con.createStatement().executeQuery("insert into contacts" +
				" values ('joe','test@tst.com','12345');");
		*/
		//serverhsqldb();
		//StartHsqldb.serverhsqldb();
		SpringApplication.run(ShelvesApplication.class, args);
	}
	
	static void localhsqldb() {
		String[] dbArgs = {"--user", "sa", "--password", "", "--url", "jdbc:hsqldb:"+FILE_URI};
	//	DatabaseManagerSwing.main(dbArgs);
	}
	
	static void serverhsqldb() {
		String[] dbArgs = {"--database.0", FILE_URI, "--dbname.0", "hsqldb", "--port", "5454"};
		//org.hsqldb.server.Server.main(dbArgs);
	}
	
/*	@Bean
    @ConfigurationProperties("my.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
*/
/*	
	@Bean
	@ConfigurationProperties("my.datasource")
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
           .setType(EmbeddedDatabaseType.HSQL)
           .build();
    }
    */
	
	public static String readToString(String fname) throws Exception {
		File file = new File(fname);
		String string = FileUtils.readFileToString(file, "utf-8");
		return string;
	}
}
