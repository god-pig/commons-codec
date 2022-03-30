package org.godpig.convert;

import java.util.Formatter;

/**
 * @author litao <litaoh@aliyun.com>
 */
public class HexEncoder implements Converter<byte[], String>{
    @Override
    public String convert(byte[] bytes) throws Exception {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return sb.toString();
    }
}
