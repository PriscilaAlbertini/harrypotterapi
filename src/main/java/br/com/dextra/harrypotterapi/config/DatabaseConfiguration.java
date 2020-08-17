package br.com.dextra.harrypotterapi.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource() throws Exception {
        String ipBanco = "localhost";
        int portaBanco = 5432;
        String nomeBanco = "harrypotterapi";
        String usuarioBanco = "postgres";
        String senhaBanco = "postgres";

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://" + ipBanco + ":" + portaBanco + "/" + nomeBanco);
        dataSource.setUsername(usuarioBanco);
        dataSource.setPassword(senhaBanco);
        return dataSource;
    }

}
