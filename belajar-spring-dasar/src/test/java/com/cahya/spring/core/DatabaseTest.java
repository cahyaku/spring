package com.cahya.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DatabaseTest {
    @Test
    void testSingleton() {
        // Test untuk memastikan bahwa Database adalah singleton
        // jadi kita tidak bisa new Database() secara langsung, karena dia sudah private constructor.
        var database1 = Database.getInstance();
        var database2 = Database.getInstance();

        // Pastikan kedua instance adalah sama (itu-itu saja)
        Assertions.assertSame(database1, database2);

        // Jadi seberapa banyak membuat database,walaupun di variabel yang berbeda,
        // tetap saja instance-nya sama.
    }
}
