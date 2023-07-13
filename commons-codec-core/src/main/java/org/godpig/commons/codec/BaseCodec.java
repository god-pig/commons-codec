package org.godpig.commons.codec;

/**
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public abstract class BaseCodec<S, T> implements Codec<S, T> {
    private final Converter<S, T> encoder;

    private final Converter<T, S> decoder;

    protected BaseCodec(Converter<S, T> encoder, Converter<T, S> decoder) {
        this.encoder = encoder;
        this.decoder = decoder;
    }

    @Override
    public Converter<S, T> getEncoder() {
        return encoder;
    }

    @Override
    public Converter<T, S> getDecoder() {
        return decoder;
    }
}
