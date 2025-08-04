package com.cahya.spring.core.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyclicC {
    // CyclicC membutuhkan CyclicA
    private CyclicA cyclicA;
}
