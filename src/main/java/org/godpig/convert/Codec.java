package org.godpig.convert;

/**
 * @author litao litaoh@aliyun.com
 */
public interface Codec<S, T> {
    /**
     * Returns the encoder from [S] to [T].
     * @return encoder
     */
    Converter<S, T> getEncoder();

    /**
     * Returns the decoder of `this`, converting from [T] to [S].
     * @return decoder
     */
    Converter<T, S> getDecoder();

    /**
     * Encodes [input].
     * @param input S
     * @return T
     * @throws Exception exception
     */
    default T encode(S input) throws Exception {
        return getEncoder().convert(input);
    }

    /**
     * Decodes [encoded] data.
     * @param encoded T
     * @return S
     * @throws Exception exception
     */
    default S decode(T encoded) throws Exception {
        return getDecoder().convert(encoded);
    }
}
