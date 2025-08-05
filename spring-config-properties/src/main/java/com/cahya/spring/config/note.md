# Spring Configuration Properties Section-2.

#

## Resource

```
Resource adalah bagian untuk mengakses file atau resource lain yang ada di dalam classpath atau filesystem. 
Resource dapat berupa file, URL, atau input stream.
Caranya gunakan class turunan dari `org.springframework.core.io.Resource` seperti `FileSystemResource`, 
`ClassPathResource`, atau `UrlResource`.
```

> > Contoh: pada class ResourceTest
> > ClassPathResource untuk mencari file yang ada di dalam project kita.
> > Resource diperlukan saat melakukan config properties untuk menentukan lokasi file yang akan digunakan.

## Resource Loader

```
Resousrce Loader digunakan untuk mengambil data secara otomatis tanpa membuat object resourcenya.
Caranya menambagkan prefixnya, misal:
1. classpath:/com/pzn/application.properties
2. file:/home/pzn/application.properties
3. url:http://localhost:8080/application.properties

Keterangan:ngam![img.png](img.png)bil file dari classpath.
2. file: untuk mengambil file dari filesystem.
3. url: untuk mengambil file dari URL.
```

> Pertanyaan: Resource loader adalah sebuah interface, sehingga kita perlu mengimplementasikannya.
> Jawaban: Tidak perlu, karena Spring sudah menyediakan implementasi dari Resource Loader.
> Seperti applicationContext adalah turunan dari Resource Loader.
>> Contoh: pada package resourceloader -> class ResourceLoaderTest
> > file yang diambil adalah resource.txt dalam folder text.
>>> Masih ada error past running -> skip dulu.

## Message Source

```
- Pada Java dapat mengambil data dengan menggunakan properties (udemy-section1).
- Dalam Spring GUNAKAN fitur Message Source untuk mengambil message dari resource.
- JADI lokasinya tetap menggunakan resource.

Message Source adalah sebuah interface, untuk menggunakannya kita perlu implementasi class-nya.
UTUNGNYA Spring sudah menyediakan implementasi dari Message Source, yaitu `ResourceBundleMessageSource`.
JADI kita tidak perlu membuatnya secara manual (mengimplementasikan sendiri).
```

> > Contoh: Kita akan membuat file my.properties di dalam folder resources.
> > Misalnya buat file yang bahasa indonesia my in ID.properties
> > Kemudian coba dengan messageSourcenya pada package messagesource -> class MessageSourceTest
>>> Caranya:
> > 1. Buat file `my.properties` di dalam folder resources.
> > 2. Buat file `my_id.properties` untuk bahasa Indonesia.

## Spring Boot Message Source

```
- Pada spring boot tidak perlu membuat Message Source secara manual.
- Secara default Spring Boot akan membuat Message Source dengan mengambil data resource dari file
  `messages.properties` yang ada di dalam classpath. (Jadi sebelumnya kan manual pakai my.properties).
 - Untuk mendapatkan Message Source kita juga dapat menggunakan MessageSourceAware.
```

> Caranya:
> Format: `messages_{locale}.properties`
> > 1. Buat file `messages.properties` di dalam folder resources.
> > 2. Buat file `messages_id.properties` untuk bahasa Indonesia.
>>> Contoh: Kemudian coba gunakan messageSourcenya.
> > > pada package springbootmessagesource -> class SpringBootMessageSourceTest