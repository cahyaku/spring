package com.cahya.spring.core.application;

import com.cahya.spring.core.data.Foo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Menggunakan spring boot application tidak pakai @Configuration
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
public class FooApplication {
    /**
     * Di otomatis kita bisa bikin bean juga, karena dia adalah configuration class.
     * <p>
     * <p>
     * Tambahan parameter bar, artinya butuh dependensi Bar
     * Tapi kita tidak set barnya.
     * Tambahkan (Bar bar), di parameter untuk test spring boot Analyzer
     */
    @Bean
    public Foo foo() {
        return new Foo();
    }

    /**
     * Membuat application context dengan SpringApplication.run
     * tidak manual lagi seperti di Spring Framework
     * <p>
     * kemudian tinggal masukan nama classnya, misalnya FooApplication.
     * Jadi tidak perlu new FooApplication() lagi.
     */
//    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);
//
//        // coba run main method ini
//        // hasilnya adalah com.cahya.spring.core.data.Foo@7d70638
//    }

    /**
     * Ini test hanya untuk customizing Spring Application
     * Jadi harus buat spring applicationnya secara manual
     */
    // OPEN ME: ini karena tes mvn spring-boot:run (maka di komen sementara)
//    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(FooApplication.class);
//
//        // disini bisa melakukan customizing
//        // misalnya setBanner mode, sehingga otomatis tidak menampilkan banner
//        application.setBannerMode(Banner.Mode.OFF);
//
//        // set listener untuk class AppStartingListener
//        application.setListeners(List.of(new AppStartingListener()));
//
//        ConfigurableApplicationContext applicationContext = application.run(args);
//
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);
//    }
}
