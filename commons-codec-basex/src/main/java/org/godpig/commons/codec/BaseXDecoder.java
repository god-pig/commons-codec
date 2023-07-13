package org.godpig.commons.codec;

import java.util.Arrays;

/**
 * BaseXDecoder
 *
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public class BaseXDecoder implements Converter<String, byte[]> {
    private final String alphabet;
    private final byte[] baseMap = new byte[256];

    public BaseXDecoder(String alphabet) {
        this.alphabet = alphabet;
        Arrays.fill(baseMap, (byte) 0xFF);
        int len = alphabet.length();
        for (int i = 0; i < len; i++) {
            int xc = alphabet.codePointAt(i);
            if (baseMap[xc] != -1) {
                throw new IllegalArgumentException(alphabet.charAt(i) + " is ambiguous");
            }
            baseMap[xc] = (byte) i;
        }
    }

    @Override
    public byte[] convert(String input) throws ConvertException {
        if (input == null || input.isEmpty()) {
            return new byte[0];
        }
        int psz = 0;

        // Skip leading spaces.
        char space = 32;
        if (input.charAt(psz) == space) {
            throw new ConvertException("input cannot begin with a space.");
        }

        // Skip and count leading '1's.
        int zeroes = 0;
        int length = 0;
        while (input.charAt(psz) == alphabet.charAt(0)) {
            zeroes++;
            psz++;
        }

        // Allocate enough space in big-endian base256 representation.
        int len = input.length();
        int size = (int) (((len - psz) * (Math.log(alphabet.length()) / Math.log(256))) + 1);
        byte[] b256 = new byte[size];

        // Process the characters.
        while (psz < len) {
            // Decode character
            int carry = baseMap[input.codePointAt(psz)] & 0xFF;

            // Invalid character
            if (carry == 0xFF) {
                throw new ConvertException("The character " + input.charAt(psz) + " at index $psz is invalid.");
            }
            int i = 0;
            for (int it3 = size - 1; (carry != 0 || i < length) && (it3 != -1); it3--, i++) {
                carry += (alphabet.length() * (b256[it3] & 0xFF));
                b256[it3] = (byte) (carry % 256);
                carry = (carry / 256);
            }
            if (carry != 0) {
                throw new ConvertException("Non-zero carry");
            }
            length = i;
            psz++;
        }

        // Skip leading zeroes in b256.
        int it4 = size - length;
        while (it4 != size && b256[it4] == 0) {
            it4++;
        }
        byte[] vch = new byte[zeroes + (size - it4)];

        if (zeroes != 0) {
            Arrays.fill(vch, 0, zeroes, (byte) 0);
        }
        int j = zeroes;
        while (it4 != size) {
            vch[j++] = b256[it4++];
        }
        return vch;
    }
}
