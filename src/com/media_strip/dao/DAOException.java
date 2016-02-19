package com.media_strip.dao;

/**
 * Exception to throw when an error occurs during database handling.
 * 
 * @author takiguchi
 * 
 */
public class DAOException extends Exception {
    /**
     * Initialize a new DAO exception.
     * 
     * @param pMessage
     */
    public DAOException( final String pMessage ) {
        super( pMessage );
    }
}
