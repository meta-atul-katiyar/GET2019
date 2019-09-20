//package com.metacube.demo.config;
//import java.util.Properties;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp.BasicDataSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//public class Config {
//
//	@Bean
//	public EntityManagerFactory entityManagerFactory() {
//
//	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//	vendorAdapter.setGenerateDdl(true);
//	vendorAdapter.setShowSql(false);
//	vendorAdapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
//	LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//	factory.setJpaVendorAdapter(vendorAdapter);
//	factory.setJpaProperties(hibernateProperties());
//	factory.setPackagesToScan("com.metacube.demo.entity");
//	factory.setDataSource(getDataSource());
//	factory.afterPropertiesSet();
//	return factory.getObject();
//	}
//
//	// JpaTransactionManager Bean
//	@Bean
//	public JpaTransactionManager transactionManager() {
//	JpaTransactionManager txManager = new JpaTransactionManager();
//	txManager.setDataSource(getDataSource());
//	txManager.setEntityManagerFactory(entityManagerFactory());
//	return txManager;
//	}
//	
//	// DataSource Bean
//	@Bean
//	public DataSource getDataSource() {
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/EAD11?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
//		dataSource.setUsername("root");
//		dataSource.setPassword("root");
//		return dataSource;
//	}
//	
//	//Setting properties of hibernate
//	private Properties hibernateProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
//		properties.put("hibernate.hbm2ddl.auto", "update");
//		properties.put("hibernate.show_sql", "true");
//		return properties;
//	}
//}