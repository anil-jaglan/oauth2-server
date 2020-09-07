package com.softron.security.auth.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

/**
 * 
 * Generic Api response transfer object.
 *
 * @author Anil Jaglan
 * @version 1.0
 */
@JsonInclude(value = Include.NON_NULL)
public class ApiResponseTO<T> implements Serializable {

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 2458911627368220068L;

    /**
     * Http Status code.
     */
    private HttpStatus status;

    /**
     * Response Message.
     */
    private String message;

    /**
     * Response data.
     */
    private T data;

    /**
     * 
     * Constructor.
     *
     * @param status
     */
    public ApiResponseTO(final HttpStatus status) {
        super();
        this.status = status;
        this.message = status.getReasonPhrase();
    }

    /**
     * 
     * Constructor.
     *
     * @param status
     * @param message
     */
    public ApiResponseTO(final HttpStatus status, final String message) {
        super();
        this.status = status;
        this.message = message;
    }

    /**
     * 
     * Constructor.
     *
     * @param status
     * @param data
     */
    public ApiResponseTO(final HttpStatus status, final T data) {
        super();
        this.status = status;
        this.message = status.getReasonPhrase();
        this.data = data;
    }

    /**
     * 
     * Constructor.
     *
     * @param status
     * @param message
     * @param data
     */
    public ApiResponseTO(final HttpStatus status, final String message, final T data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 
     * Getter of {@link #status}.
     * 
     * @return {@link #status}
     */
    public int getStatus() {
        return status.value();
    }

    /**
     * 
     * Setter of {@link #status}.
     * 
     * @param status
     *            to be set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * 
     * Getter of {@link #message}.
     * 
     * @return {@link #message}
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * Setter of {@link #message}.
     * 
     * @param message
     *            to be set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * Getter of {@link #data}.
     * 
     * @return {@link #data}
     */
    public T getData() {
        return data;
    }

    /**
     * 
     * Setter of {@link #data}.
     * 
     * @param data
     *            to be set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ApiResponseTO [status=");
        builder.append(status.value());
        builder.append(", message=");
        builder.append(message);
        builder.append(", data=");
        builder.append(data);
        builder.append("]");
        return builder.toString();
    }

}
