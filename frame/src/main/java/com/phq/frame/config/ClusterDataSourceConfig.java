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
@MapperScan(basePackages = "com.phq.frame.mapper.cluster",sqlSessionTemplateRef = "clusterSqlSessionTemplate") // 扫描Dao文件
@EnableTransactionManagement //支持事务注解
public class ClusterDataSourceConfig {

	
	 @Value("${spring.datasource.cluster.url}")
    private String url;

    @Value("${spring.datasource.cluster.data-username}")
    private String user;

    @Value("${spring.datasource.cluster.data-password}")
    private String password;

    @Value("${spring.datasource.cluster.driver-class-name}")
    private String driverClass;
    
    @Value("${cluster.mybatis.mapperLocations}")
    private String mapperLocations;
    
    @Value("${cluster.mybatis.mapperLocations}")
    private String typeAliasesPackage;
    
   

	@Value("${spring.datasource.cluster.initialSize}")
	private int initialSize;

	@Value("${spring.datasource.cluster.minIdle}")
	private int minIdle;

	@Value("${spring.datasource.cluster.maxActive}")
	private int maxActive;

	@Value("${spring.datasource.cluster.maxWait}")
	private int maxWait;

	@Value("${spring.datasource.cluster.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;

	@Value("${spring.datasource.cluster.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;

	@Value("${spring.datasource.cluster.validationQuery}")
	private String validationQuery;

	@Value("${spring.datasource.cluster.testWhileIdle}")
	private boolean testWhileIdle;

	@Value("${spring.datasource.cluster.testOnBorrow}")
	private boolean testOnBorrow;

	@Value("${spring.datasource.cluster.testOnReturn}")
	private boolean testOnReturn;

	@Value("${spring.datasource.cluster.poolPreparedStatements}")
	private boolean poolPreparedStatements;

	@Value("${spring.datasource.cluster.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;

	@Value("${spring.datasource.cluster.filters}")
	private String filters;
	@Value("${spring.datasource.cluster.connectionProperties}")

	private String connectionProperties;
	@Value("${spring.datasource.cluster.useGlobalDataSourceStat}")
	private boolean useGlobalDataSourceStat;
    
    @Bean(name = "clusterDataSource")
    public DataSource clusterDataSource() {
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

    @Bean(name = "clusterTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(clusterDataSource());
    }

    @Bean(name = "clusterSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("clusterDataSource") DataSource clusterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(clusterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(typeAliasesPackage));
        return sessionFactory.getObject();
    }
  
    @Bean(name = "clusterSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("clusterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

	
}
