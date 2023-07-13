package org.godpig.commons.codec;

/**
 * BaseXEncoder
 *
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public class BaseXEncoder implements Converter<byte[], String> {
    private final String alphabet;

    public BaseXEncoder(String alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public String convert(byte[] bytes) throws ConvertException {
        int zeroes = 0;
        int length = 0;
        int begin = 0;
        int end = bytes.length;
        while (begin != end && bytes[begin] == 0) {
            begin++;
            zeroes++;
        }
        // Allocate enough space in big-endian base58 representation.
        int size = (int) ((end - begin) * (Math.log(256) / Math.log(alphabet.length())) + 1);
        byte[] b58 = new byte[size];

        // Process the bytes.
        while (begin != end) {
            int carry = bytes[begin] & 0xFF;

            /// Apply "b58 = b58 * 256 + ch".
            int i = 0;
            for (int it1 = size - 1; (carry != 0 || i < length) && (it1 != -1); it1--, i++) {
                carry += (256 * (b58[it1] & 0xFF));
                b58[it1] = (byte) (carry % alphabet.length());
                carry = (carry / alphabet.length());
            }
            if (carry != 0) {
                throw new ConvertException("Non-zero carry");
            }
            length = i;
            begin++;
        }

        // Skip leading zeroes in base58 result.
        int it2 = size - length;
        while (it2 != size && b58[it2] == 0) {
            it2++;
        }

        // Translate the result into a string.
        StringBuilder str = new StringBuilder();
        if (zeroes != 0) {
            char[] chars = new char[zeroes];
            System.arraycopy("".toCharArray(), 0, chars, 0, 0);
            for (int i = 0; i < zeroes; i++) {
                chars[i] = alphabet.charAt(0);
            }
            str = new StringBuilder(new String(chars));
        }

        for (; it2 < size; ++it2) {
            str.append(alphabet.charAt(b58[it2]));
        }
        return str.toString();
    }
}