package org.godpig.commons.codec;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BaseXCodecTest {
    @Test
    void testBase2() throws ConvertException {
        BaseXCodec base2 = new BaseXCodec(BaseXCodec.BASE_2);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21};
        String encoded = "11101111101100011000110111001100101011101011";
        assertEquals(base2.encode(bytes), encoded);
        assertArrayEquals(base2.decode(encoded), bytes);
    }

    @Test
    void testBase8() throws ConvertException {
        BaseXCodec base8 = new BaseXCodec(BaseXCodec.BASE_8);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21};
        String encoded = "357543067145353";
        assertEquals(base8.encode(bytes), encoded);
        assertArrayEquals(base8.decode(encoded), bytes);
    }

    @Test
    void testBase11() throws ConvertException {
        BaseXCodec base11 = new BaseXCodec(BaseXCodec.BASE_11);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21};
        String encoded = "528063423a99a";
        assertEquals(base11.encode(bytes), encoded);
        assertArrayEquals(base11.decode(encoded), bytes);
    }

    @Test
    void testBase16() throws ConvertException {
        BaseXCodec base16 = new BaseXCodec(BaseXCodec.BASE_16);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21};
        System.out.println(base16.encode(bytes));
        String encoded = "efb18dccaeb";
        assertEquals(base16.encode(bytes), encoded);
        assertArrayEquals(base16.decode(encoded), bytes);
    }

    @Test
    void testBase32() throws ConvertException {
        BaseXCodec base32 = new BaseXCodec(BaseXCodec.BASE_32);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21};
        String encoded = "EZCCDSJQB";
        assertEquals(base32.encode(bytes), encoded);
        assertArrayEquals(base32.decode(encoded), bytes);
    }

    @Test
    void testZBase32() throws ConvertException {
        BaseXCodec base32 = new BaseXCodec(BaseXCodec.Z_BASE_32);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21};
        String encoded = "q9ccp31zm";
        assertEquals(base32.encode(bytes), encoded);
        assertArrayEquals(base32.decode(encoded), bytes);
    }


    @Test
    void testBase36() throws ConvertException {
        BaseXCodec base36 = new BaseXCodec(BaseXCodec.BASE_36);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21};
        String encoded = "5u6yfatij";
        assertEquals(base36.encode(bytes), encoded);
        assertArrayEquals(base36.decode(encoded), bytes);
    }

    @Test
    void testBase58() throws ConvertException {
        BaseXCodec base58 = new BaseXCodec(BaseXCodec.BASE_58);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21, 97, -24, 85, -27, 109, -68, 53, -110, 43, 36, -10, -18, 110, 55, -54, -93, -96, 123, -87, 35};
        String encoded = "TcASfmyoFiNobNaCHeiPMkWgGmovoxk1sqk";
        assertEquals(base58.encode(bytes), encoded);
        assertArrayEquals(base58.decode(encoded), bytes);
    }

    @Test
    void testBase62() throws ConvertException {
        BaseXCodec base62 = new BaseXCodec(BaseXCodec.BASE_62);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21, 97, -24, 85, -27, 109, -68, 53, -110, 43, 36, -10, -18, 110, 55, -54, -93, -96, 123, -87, 35};
        String encoded = "2KQzx0EP5rZfWK41LH7rl6IFaIg4BcEAvPJ";
        assertEquals(base62.encode(bytes), encoded);
        assertArrayEquals(base62.decode(encoded), bytes);
    }

    @Test
    void testBase64() throws ConvertException {
        BaseXCodec base64 = new BaseXCodec(BaseXCodec.BASE_64);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21, 97, -24, 85, -27, 109, -68, 53, -110, 43, 36, -10, -18, 110, 55, -54, -93, -96, 123, -87, 35};
        String encoded = "77GNzK62HoVeVtvDWSKyT27m43yqOge6kj";
        assertEquals(base64.encode(bytes), encoded);
        assertArrayEquals(base64.decode(encoded), bytes);
    }

    @Test
    void testBase66() throws ConvertException {
        BaseXCodec base66 = new BaseXCodec(BaseXCodec.BASE_66);
        byte[] bytes = new byte[]{14, -5, 24, -36, -54, -21, 97, -24, 85, -27, 109, -68, 53, -110, 43, 36, -10, -18, 110, 55, -54, -93, -96, 123, -87, 35};
        String encoded = "NObH9zQZYhrZZy.Jd68-4GJRRxLi8B!Wgo";
        assertEquals(base66.encode(bytes), encoded);
        assertArrayEquals(base66.decode(encoded), bytes);
    }
}