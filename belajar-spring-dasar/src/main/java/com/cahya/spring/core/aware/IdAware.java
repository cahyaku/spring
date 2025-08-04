package com.cahya.spring.core.aware;

public interface IdAware {
    void setId(String id);

    String getId();
    // Jadi ini niatnya kalau ada bean yang implement Id aware,
    // kita akan set Idnya menjadi unik ID

    // HOW: Buat class IdGeneratorBeanPostProcessor yang meng-implement BeanPostProcessor
    // ini pada package processor
}
