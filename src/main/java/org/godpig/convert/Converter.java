package org.godpig.convert;

/**
 * @author litao litaoh@aliyun.com
 */
public interface Converter<S, T> {
    /**
     * Converts [input] and returns the result of the conversion.
     * @param input S
     * @return T
     * @throws Exception exception
     */
    T convert(S input) throws Exception;
}
