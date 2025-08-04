package com.cahya.spring.core.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.ArrayList;
import java.util.List;

public class DoubletonScope implements Scope {

    private final List<Object> objects = new ArrayList<>(2);
    private Long counter = -1L; // Counter dimulai dari -1 agar objek pertama yang dibuat adalah 0


    // Tidak perlu implemen semuanya, yang penting adalah get dan remove
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        counter++;
        // Jika sudah ada 2 objek, kembalikan objek yang sesuai dengan counter.
        if (objects.size() == 2) {
            int index = (int) (counter % 2);
            return objects.get(index);
        } else {
            Object object = objectFactory.getObject();
            objects.add(object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        // Jika objects sudah ada, hapus objek pertama
        if (!objects.isEmpty()) {
            return objects.remove(0);
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "";
    }
}
