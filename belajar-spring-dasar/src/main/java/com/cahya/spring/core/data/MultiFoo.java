package com.cahya.spring.core.data;

import lombok.Getter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MultiFoo {
    /**
     * Misalkan ingin mengambil semua list Foo
     */
    @Getter
    private final List<Foo> foos;

    /**
     * Constructor dengan ObjectProvider
     */
    public MultiFoo(ObjectProvider<Foo> objectProvider) {
        // 1. Jika mengambil satu Foo saja
        // objectProvider.getIfAvailable();

        // 2. Jika mengambil semua Foo
        foos = objectProvider.stream().collect(Collectors.toList());
    }
}
