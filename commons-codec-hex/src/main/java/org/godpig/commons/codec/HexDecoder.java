package org.godpig.commons.codec;

/**
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public class HexDecoder implements Converter<String, byte[]> {
    private static final String ALPHABET = "0123456789abcdef";

    @Override
    public byte[] convert(String hex) throws ConvertException {
        hex = hex.toLowerCase();
        int width = 2;
        if (hex.length() % width != 0) {
            hex = "0" + hex;
        }

        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            int firstDigit = ALPHABET.indexOf(hex.charAt(i * 2));
            int secondDigit = ALPHABET.indexOf(hex.charAt(i * 2 + 1));
            if (firstDigit == -1 || secondDigit == -1) {
                throw new ConvertException("Non-hex character detected in " + hex);
            }
            bytes[i] = (byte) ((firstDigit << 4) + secondDigit);
        }
        return bytes;
    }
}
