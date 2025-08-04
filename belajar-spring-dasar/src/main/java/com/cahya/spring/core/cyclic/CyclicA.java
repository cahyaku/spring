package com.cahya.spring.core.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// Cyslic A membutuhkan CyclicB
public class CyclicA {
    private CyclicB cb;
}
