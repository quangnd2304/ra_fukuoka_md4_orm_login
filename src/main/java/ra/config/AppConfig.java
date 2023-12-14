package ra.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan({"ra.controller", "ra.serviceImp", "ra.repositoryImp","ra.mapper"})
@Transactional
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    //Cấu hình các thông tin kết nối đến DB
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jpa_login_demo");
        dataSource.setUsername("root");
        dataSource.setPassword("1234$");
        return dataSource;
    }

    //Cấu hình thông số và cơ chế làm việc của JPA
    /*
     * hibernate.hbm2dll.auto: create, update, create-drop, none
     * create: Khi ứng dụng chạy, xóa các bảng trong CSDL và tạo các bảng mới
     * update: Khi ứng dụng chạy, so sánh các bảng trong CSDL và các entity, nếu có sự khác biệt sẽ cập nhật bổ sung
     * create-drop: xóa các bảng trong CSDL, tạo bảng mới, kết thúc chạy xóa các bảng CSDL
     * none
     * */
    public Properties addionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }

    //Cấu hình cho EntityManagerFactory
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan("ra.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactory.setJpaProperties(addionalProperties());
        return entityManagerFactory;
    }

    //@Quanlifier === @Autowird
    @Bean
    @Qualifier(value = "entityManager")
    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    //Cấu hình quản lý transaction
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
    //Cấu hình tài nguyên css, js nằm trong thư mục resources
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("resources/**")
                .addResourceLocations("/resources/");
    }
}
