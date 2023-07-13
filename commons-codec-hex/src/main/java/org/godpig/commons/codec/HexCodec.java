package org.godpig.commons.codec;

/**
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public class HexCodec extends BaseCodec<byte[], String> {

    public HexCodec() {
        super(new HexEncoder(), new HexDecoder());
    }
}
