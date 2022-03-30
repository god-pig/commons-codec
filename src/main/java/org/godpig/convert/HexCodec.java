package org.godpig.convert;

/**
 * @author litao <litaoh@aliyun.com>
 */
public class HexCodec extends BaseCodec<byte[], String>{
    public HexCodec() {
        encoder = new HexEncoder();
        decoder = new HexDecoder();
    }
}
