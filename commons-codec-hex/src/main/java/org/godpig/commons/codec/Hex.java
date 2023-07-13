package org.godpig.commons.codec;

/**
 * HEX
 *
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public class Hex {

    private static final BaseCodec<byte[], String> INSTANCE = new HexCodec();

    private Hex() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Encodes [input].
     *
     * @throws ConvertException exception
     */
    public static String encode(byte[] input) throws ConvertException {
        return INSTANCE.encode(input);
    }

    /**
     * Decodes [encoded] data.
     *
     * @param encoded T
     * @return S
     * @throws ConvertException exception
     */
    public static byte[] decode(String encoded) throws ConvertException {
        return INSTANCE.decode(encoded);
    }
}
