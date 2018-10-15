package com.phq.frame.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@SpringBootConfiguration
@MapperScan(basePackages = "com.phq.frame.mapper.master", sqlSessionTemplateRef = "masterSqlSessionTemplate") // 扫描Dao文件
@EnableTransactionManagement // 支持事务注解
public class MasterDataSourceConfig {

	@Value("${spring.datasource.master.url}")
	private String url;

	@Value("${spring.datasource.master.data-username}")
	private String user;

	@Value("${spring.datasource.master.data-password}")
	private String password;

	@Value("${spring.datasource.master.driver-class-name}")
	private String driverClass;

	@Value("${master.mybatis.mapperLocations}")
	private String mapperLocations;

	@Value("${master.mybatis.mapperLocations}")
	private String typeAliasesPackage;

	@Value("${spring.datasource.master.initialSize}")
	private int initialSize;

	@Value("${spring.datasource.master.minIdle}")
	private int minIdle;

	@Value("${spring.datasource.master.maxActive}")
	private int maxActive;

	@Value("${spring.datasource.master.maxWait}")
	private int maxWait;

	@Value("${spring.datasource.master.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${spring.datasource.master.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Value("${spring.datasource.master.validationQuery}")
	private String validationQuery;

	@Value("${spring.datasource.master.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${spring.datasource.master.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${spring.datasource.master.testOnReturn}")
	private boolean testOnReturn;

	@Value("${spring.datasource.master.poolPreparedStatements}")
	private boolean poolPreparedStatements;

	@Value("${spring.datasource.master.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;

	@Value("${spring.datasource.master.filters}")
	private String filters;
	@Value("${spring.datasource.master.connectionProperties}")

	private String connectionProperties;
	@Value("${spring.datasource.master.useGlobalDataSourceStat}")
	private boolean useGlobalDataSourceStat;

	@Bean(name = "masterDataSource")
	@Primary
	public DataSource masterDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);

		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);
		dataSource.setMaxWait(maxWait);
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setTestWhileIdle(testWhileIdle);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestOnReturn(testOnReturn);
		dataSource.setPoolPreparedStatements(poolPreparedStatements);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
		try {
			dataSource.setFilters(filters);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean(name = "masterTransactionManager")
	@Primary
	public DataSourceTransactionManager masterTransactionManager() {
		return new DataSourceTransactionManager(masterDataSource());
	}

	@Bean(name = "masterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
			throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(masterDataSource);
		sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(typeAliasesPackage));
		return sessionFactory.getObject();
	}

	@Bean(name = "masterSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate setSqlSessionTemplate(
			@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
