package org.godpig.commons.codec;

/**
 * Thrown when there is a failure condition during the encoding / decoding process.
 *
 * @author <a href="mailto:litaoh@aliyun.com">LiTao</a>
 */
public class ConvertException extends Exception {
    /**
     * Declares the Serial Version Uid.
     *
     * @see <a href="http://c2.com/cgi/wiki?AlwaysDeclareSerialVersionUid">Always Declare Serial Version Uid</a>
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new exception with {@code null} as its detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link #initCause}.
     *
     * @since 1.4
     */
    public ConvertException() {
    }

    /**
     * Constructs a new exception with the specified detail message. The cause is not initialized, and may subsequently
     * be initialized by a call to {@link #initCause}.
     *
     * @param message The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public ConvertException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with {@code cause} is not automatically incorporated into this
     * exception's detail message.
     * </p>
     *
     * @param message The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     * @param cause   The cause which is saved for later retrieval by the {@link #getCause()} method. A {@code null}
     *                value is permitted, and indicates that the cause is nonexistent or unknown.
     * @since 1.4
     */
    public ConvertException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of <code>(cause==null ?
     * null : cause.toString())</code> (which typically contains the class and detail message of {@code cause}).
     * This constructor is useful for exceptions that are little more than wrappers for other throwables.
     *
     * @param cause The cause which is saved for later retrieval by the {@link #getCause()} method. A {@code null}
     *              value is permitted, and indicates that the cause is nonexistent or unknown.
     * @since 1.4
     */
    public ConvertException(final Throwable cause) {
        super(cause);
    }
}
