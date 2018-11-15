package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
@Configuration
@ComponentScan("com.itheima")
@PropertySource("classpath:jdbcConfig.properties")
public class Conf {

    @Value("${jdbc.driver}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private  String password;


    @Bean(name="runner")
    public QueryRunner creatQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean
    public DataSource createDataSource(){
        ComboPooledDataSource cs =null;
        try {
           cs = new ComboPooledDataSource();
            cs.setDriverClass(driverClass);
            cs.setJdbcUrl(jdbcUrl);
            cs.setUser(user);
            cs.setPassword(password);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return cs;
    }
}
