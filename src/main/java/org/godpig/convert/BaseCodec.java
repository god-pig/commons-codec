package org.godpig.convert;

/**
 * @author litao <litaoh@aliyun.com>
 */
public abstract class BaseCodec<S, T> implements Codec<S, T> {
    protected Converter<S, T> encoder;

    protected Converter<T, S> decoder;

    @Override
    public Converter<S, T> getEncoder() {
        return encoder;
    }

    @Override
    public Converter<T, S> getDecoder() {
        return decoder;
    }
}
