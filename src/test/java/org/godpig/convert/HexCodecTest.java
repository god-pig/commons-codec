package org.godpig.convert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HexCodecTest {
    private static final HexCodec HEX = new HexCodec();
    private final byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21, 97, -24, 85, -27, 109, -68, 53, -110, 43, 36, -10, -18, 110, 55, -54, -93, -96, 123, -87, 35};
    private final String hex = "0efb18dccaeb61e855e56dbc35922b24f6ee6e37caa3a07ba923";


    @Test
    void hexEncode() throws Exception {
        assertEquals(HEX.encode(bytes), hex);
    }

    @Test
    void hexDecode() throws Exception {
        assertArrayEquals(HEX.decode(hex), bytes);
    }
}
