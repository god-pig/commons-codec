package org.godpig.convert;

/**
 * @author litao <litaoh@aliyun.com>
 */
public class HexDecoder implements Converter<String, byte[]> {
    private static final String ALPHABET = "0123456789abcdef";

    @Override
    public byte[] convert(String hex) throws Exception {
        String str = hex.replaceAll(" ", "");
        str = str.toLowerCase();
        int width = 2;
        if (str.length() % width != 0) {
            str = "0" + str;
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            int firstDigit = ALPHABET.indexOf(str.charAt(i * 2));
            int secondDigit = ALPHABET.indexOf(str.charAt(i * 2 + 1));
            if (firstDigit == -1 || secondDigit == -1) {
                throw new Exception("Non-hex character detected in " + hex);
            }
            bytes[i] = (byte) ((firstDigit << 4) + secondDigit);
        }
        return bytes;
    }
}
