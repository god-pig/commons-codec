package org.godpig.commons.codec;

/**
 * Similar to Base64, but modified to avoid both non-alphanumeric characters (+ and /)
 * and letters that might look ambiguous when printed (0 – zero, I – capital i, O – capital o and l – lower-case L).
 * Base58 is used to represent bitcoin addresses.
 *
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public class Base58 {

    private static final BaseCodec<byte[], String> INSTANCE = new BaseXCodec(BaseXCodec.BASE_58);

    private Base58() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Encodes given bytes as a number in base58.
     *
     * @param bytes bytes to encode
     * @return base58 string representation
     */
    public static String encode(byte[] bytes) throws ConvertException {
        return INSTANCE.encode(bytes);
    }

    /**
     * Decodes given bytes as a number in base58.
     *
     * @param base58 string to decode
     * @return number as bytes
     */
    public static byte[] decode(String base58) throws ConvertException {
        return INSTANCE.decode(base58);
    }
}
