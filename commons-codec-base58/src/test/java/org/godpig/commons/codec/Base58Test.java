package org.godpig.commons.codec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Base58Test {
    private final byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21, 97, -24, 85, -27, 109, -68, 53, -110, 43, 36, -10, -18, 110, 55, -54, -93, -96, 123, -87, 35};
    private final String hex = "TcASfmyoFiNobNaCHeiPMkWgGmovoxk1sqk";


    @Test
    void encode() throws ConvertException {
        assertEquals(Base58.encode(bytes), hex);
    }

    @Test
    void decode() throws ConvertException {
        assertArrayEquals(Base58.decode(hex), bytes);
    }
}