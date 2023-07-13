package org.godpig.commons.codec;

import java.util.Formatter;

/**
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public class HexEncoder implements Converter<byte[], String> {
    @Override
    public String convert(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        formatter.close();
        return sb.toString();
    }
}
