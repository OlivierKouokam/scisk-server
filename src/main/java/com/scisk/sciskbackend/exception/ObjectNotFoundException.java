package com.scisk.sciskbackend.exception;

/**
 * Thrown if a Repository cannot locate an entity
 *
 * @author Ivan Kaptue
 */
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1666394307704694029L;

    /**
     * Constructs a <code>ObjectNotFoundException</code> with the specified message.
     *
     * @param msg the detail message. Will always be an object identifier (e.g: person, user, ...)
     */
    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    /**
     * Constructs a {@code ObjectNotFoundException} with the specified message and root
     * cause.
     *
     * @param msg the detail message. Will always be an object identifier (e.g: person, user, ...)
     * @param t   root cause
     */
    public ObjectNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }

}
