package org.godpig.commons.codec;

/**
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public interface Converter<S, T> {
    /**
     * Converts [input] and returns the result of the conversion.
     *
     * @param input S
     * @return T
     * @throws ConvertException exception
     */
    T convert(S input) throws ConvertException;
}
