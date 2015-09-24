/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rdconnect.org.idcardmolgenis.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis;

/**
 * The persistence interface for the r d connect i d card molgenis service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyeshamatya
 * @see RDConnectIDCardMolgenisPersistenceImpl
 * @see RDConnectIDCardMolgenisUtil
 * @generated
 */
public interface RDConnectIDCardMolgenisPersistence extends BasePersistence<RDConnectIDCardMolgenis> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RDConnectIDCardMolgenisUtil} to access the r d connect i d card molgenis persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the r d connect i d card molgenis in the entity cache if it is enabled.
	*
	* @param rdConnectIDCardMolgenis the r d connect i d card molgenis
	*/
	public void cacheResult(
		com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis rdConnectIDCardMolgenis);

	/**
	* Caches the r d connect i d card molgenises in the entity cache if it is enabled.
	*
	* @param rdConnectIDCardMolgenises the r d connect i d card molgenises
	*/
	public void cacheResult(
		java.util.List<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> rdConnectIDCardMolgenises);

	/**
	* Creates a new r d connect i d card molgenis with the primary key. Does not add the r d connect i d card molgenis to the database.
	*
	* @param id the primary key for the new r d connect i d card molgenis
	* @return the new r d connect i d card molgenis
	*/
	public com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis create(
		long id);

	/**
	* Removes the r d connect i d card molgenis with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the r d connect i d card molgenis
	* @return the r d connect i d card molgenis that was removed
	* @throws com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException if a r d connect i d card molgenis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis remove(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException;

	public com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis updateImpl(
		com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis rdConnectIDCardMolgenis)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the r d connect i d card molgenis with the primary key or throws a {@link com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException} if it could not be found.
	*
	* @param id the primary key of the r d connect i d card molgenis
	* @return the r d connect i d card molgenis
	* @throws com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException if a r d connect i d card molgenis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis findByPrimaryKey(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException;

	/**
	* Returns the r d connect i d card molgenis with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the r d connect i d card molgenis
	* @return the r d connect i d card molgenis, or <code>null</code> if a r d connect i d card molgenis with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis fetchByPrimaryKey(
		long id) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the r d connect i d card molgenises.
	*
	* @return the r d connect i d card molgenises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the r d connect i d card molgenises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d connect i d card molgenises
	* @param end the upper bound of the range of r d connect i d card molgenises (not inclusive)
	* @return the range of r d connect i d card molgenises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the r d connect i d card molgenises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of r d connect i d card molgenises
	* @param end the upper bound of the range of r d connect i d card molgenises (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of r d connect i d card molgenises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the r d connect i d card molgenises from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of r d connect i d card molgenises.
	*
	* @return the number of r d connect i d card molgenises
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}