package com.scisk.sciskbackend.exception;

/**
 * Thrown if an instance of entity to save already exists in database
 *
 * @author Ivan Kaptue
 */
public class ObjectExistsException extends RuntimeException {

    private static final long serialVersionUID = -1666394307704694029L;

    /**
     * Constructs a <code>ObjectExistsException</code> with the specified message.
     *
     * @param msg the detail message. Will always a unique existing column
     */
    public ObjectExistsException(String msg) {
        super(msg);
    }

    /**
     * Constructs a {@code ObjectExistsException} with the specified message and root
     * cause.
     *
     * @param msg the detail message. Will always a unique existing column
     * @param t   root cause
     */
    public ObjectExistsException(String msg, Throwable t) {
        super(msg, t);
    }

}
