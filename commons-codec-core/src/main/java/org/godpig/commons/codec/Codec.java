package org.godpig.commons.codec;

/**
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public interface Codec<S, T> {
    /**
     * Returns the encoder from [S] to [T].
     *
     * @return encoder
     */
    Converter<S, T> getEncoder();

    /**
     * Returns the decoder of `this`, converting from [T] to [S].
     *
     * @return decoder
     */
    Converter<T, S> getDecoder();

    /**
     * Encodes [input].
     *
     * @param input S
     * @return T
     * @throws ConvertException exception
     */
    default T encode(S input) throws ConvertException {
        return getEncoder().convert(input);
    }

    /**
     * Decodes [encoded] data.
     *
     * @param encoded T
     * @return S
     * @throws ConvertException exception
     */
    default S decode(T encoded) throws ConvertException {
        return getDecoder().convert(encoded);
    }
}
