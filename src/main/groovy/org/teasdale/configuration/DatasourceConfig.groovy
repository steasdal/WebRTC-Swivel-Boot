package org.teasdale.configuration

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import javax.sql.DataSource

@Configuration
class DatasourceConfig {

    private String driverClassName = "org.h2.Driver"
    private String url = "jdbc:h2:mem:testdb"
    private String username = "sa"
    private String password = ""

    @Bean
    public DataSource dataSource() {

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName(driverClassName)
        dataSourceBuilder.url(url)
        dataSourceBuilder.username(username)
        dataSourceBuilder.password(password)
        return dataSourceBuilder.build()
    }
}
