package com.cahya.spring.core;

public class Database {

    // Static variable to hold the single instance of Database
    private static Database database;

    // Ini adalah contoh implementasi Singleton Pattern
    // yang memastikan hanya ada satu instance dari Database yang dibuat.
    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    // Method untuk menghubungkan ke database
    private Database() {
        // Private konstruktor untuk mencegah instansiasi dari luar kelas ini.
    }
}
