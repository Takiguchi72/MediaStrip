package com.media_strip.dao;

/**
 * Interface that give CRUD operations.
 * 
 * @author takiguchi
 * 
 * @param <T>
 *            The class of entity.
 */
public interface DAO<T> {
    /**
     * Find the entity into its table and return the mapped object.
     * 
     * @param pId
     *            The ID number of the entity.
     * @return The mapped entity.
     */
    public T read( final int pId );

    /**
     * Insert the entity in its table and return the mapped object to get the
     * auto-generated key.
     * 
     * @param pObject
     *            The entity to insert.
     * @return The object inserted.
     */
    public T insert( final T pObject );

    /**
     * Update the entity in its table.
     * 
     * @param pObject
     *            The entity to update.
     * @return The entity updated.
     */
    public T update( final T pObject );

    /**
     * Delete the entity in the table.
     * 
     * @param pObject
     *            The entity to delete.
     * @return {@code true} if suppression succeded, {@code false} otherwise.
     */
    public boolean delete( final T pObject );
}
