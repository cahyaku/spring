package com.cahya.spring.core;

import com.cahya.spring.core.data.MultiFoo;
import com.cahya.spring.core.repository.CategoryRepository;
import com.cahya.spring.core.repository.CustomerRepository;
import com.cahya.spring.core.repository.ProductRepository;
import com.cahya.spring.core.service.CategoryService;
import com.cahya.spring.core.service.CustomerService;
import com.cahya.spring.core.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponenConfiguration.class);
    }

    @Test
    void testService() {
        ProductService productService1 = applicationContext.getBean(ProductService.class);
        ProductService productService2 = applicationContext.getBean("productService", ProductService.class);

        // test apakah kedua bean tersebut sama
        Assertions.assertSame(productService1, productService2);
    }

    /**
     * Test untuk memastikan bahwa ProductService dapat di-inject melalui dependency injection.
     * Dari constructor ProductService akan di-inject bean ProductRepository
     */
    @Test
    void testConstructorDependencyInjection() {
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        // Cek apakah ProductRepository yang di-inject ke dalam ProductService adalah bean yang sama
        Assertions.assertSame(productRepository, productService.getProductRepository());
    }

    /**
     * Test ini tidak akan berhasil karena kita tidak menggunakan setter injection
     * pada ProductService. Namun, jika kita ingin menggunakan setter injection,
     */
    @Test
    void testSetterDependencyInjection() {
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);

        // Cek apakah CategoryRepository yang di-inject ke dalam CategoryService adalah bean yang sama
        Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());
    }

    /**
     * Test ini menggunakan field injection pada ProductService.
     * Dan iini contoh jika menggunakan 2 constructor injection.
     */
    @Test
    void testFieldDependencyInjection() {
        CustomerService customerService = applicationContext.getBean(CustomerService.class);

        CustomerRepository normalCustomerRepository = applicationContext.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = applicationContext.getBean("premiumCustomerRepository", CustomerRepository.class);

        // Cek apakah normalCustomerRepository yang di-inject ke dalam CustomerService adalah bean yang sama
        Assertions.assertSame(normalCustomerRepository, customerService.getNormalCustomerRepository());
        // Cek apakah premiumCustomerRepository yang di-inject ke dalam CustomerService adalah bean yang sama
        Assertions.assertSame(premiumCustomerRepository, customerService.getPremiumCustomerRepository());
    }

    /**
     * Test untuk ObjectProvider.
     */
    @Test
    void testObjectProvider() {
        MultiFoo multiFoo = applicationContext.getBean(MultiFoo.class);
        // Cek apakah MultiFoo berhasil mengambil semua Foo, jadi haru ada 3 Foo
        Assertions.assertEquals(3, multiFoo.getFoos().size());
    }
}
