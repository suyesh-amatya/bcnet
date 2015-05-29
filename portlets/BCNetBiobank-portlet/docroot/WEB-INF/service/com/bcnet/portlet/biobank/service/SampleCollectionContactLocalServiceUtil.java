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

package com.bcnet.portlet.biobank.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SampleCollectionContact. This utility wraps
 * {@link com.bcnet.portlet.biobank.service.impl.SampleCollectionContactLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author suyama
 * @see SampleCollectionContactLocalService
 * @see com.bcnet.portlet.biobank.service.base.SampleCollectionContactLocalServiceBaseImpl
 * @see com.bcnet.portlet.biobank.service.impl.SampleCollectionContactLocalServiceImpl
 * @generated
 */
public class SampleCollectionContactLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.bcnet.portlet.biobank.service.impl.SampleCollectionContactLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the sample collection contact to the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionContact the sample collection contact
	* @return the sample collection contact that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact addSampleCollectionContact(
		com.bcnet.portlet.biobank.model.SampleCollectionContact sampleCollectionContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSampleCollectionContact(sampleCollectionContact);
	}

	/**
	* Creates a new sample collection contact with the primary key. Does not add the sample collection contact to the database.
	*
	* @param sampleCollectionContactPK the primary key for the new sample collection contact
	* @return the new sample collection contact
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact createSampleCollectionContact(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK) {
		return getService()
				   .createSampleCollectionContact(sampleCollectionContactPK);
	}

	/**
	* Deletes the sample collection contact with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionContactPK the primary key of the sample collection contact
	* @return the sample collection contact that was removed
	* @throws PortalException if a sample collection contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact deleteSampleCollectionContact(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteSampleCollectionContact(sampleCollectionContactPK);
	}

	/**
	* Deletes the sample collection contact from the database. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionContact the sample collection contact
	* @return the sample collection contact that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact deleteSampleCollectionContact(
		com.bcnet.portlet.biobank.model.SampleCollectionContact sampleCollectionContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteSampleCollectionContact(sampleCollectionContact);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollectionContact fetchSampleCollectionContact(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchSampleCollectionContact(sampleCollectionContactPK);
	}

	/**
	* Returns the sample collection contact with the primary key.
	*
	* @param sampleCollectionContactPK the primary key of the sample collection contact
	* @return the sample collection contact
	* @throws PortalException if a sample collection contact with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact getSampleCollectionContact(
		com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPK sampleCollectionContactPK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSampleCollectionContact(sampleCollectionContactPK);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the sample collection contacts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sample collection contacts
	* @param end the upper bound of the range of sample collection contacts (not inclusive)
	* @return the range of sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> getSampleCollectionContacts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSampleCollectionContacts(start, end);
	}

	/**
	* Returns the number of sample collection contacts.
	*
	* @return the number of sample collection contacts
	* @throws SystemException if a system exception occurred
	*/
	public static int getSampleCollectionContactsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSampleCollectionContactsCount();
	}

	/**
	* Updates the sample collection contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sampleCollectionContact the sample collection contact
	* @return the sample collection contact that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.bcnet.portlet.biobank.model.SampleCollectionContact updateSampleCollectionContact(
		com.bcnet.portlet.biobank.model.SampleCollectionContact sampleCollectionContact)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateSampleCollectionContact(sampleCollectionContact);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollectionContact getSampleCollectionContact(
		long sampleCollectionDbId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSampleCollectionContact(sampleCollectionDbId, userId);
	}

	public static com.bcnet.portlet.biobank.model.SampleCollectionContact getSampleCollectionMainContact(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSampleCollectionMainContact(sampleCollectionDbId);
	}

	public static java.util.List<com.bcnet.portlet.biobank.model.SampleCollectionContact> getSampleCollectionContactsBySampleCollectionDbId(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getSampleCollectionContactsBySampleCollectionDbId(sampleCollectionDbId);
	}

	public static void editSampleCollectionMainContact(
		long sampleCollectionDbId, long sampleCollectionMainContactUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.editSampleCollectionMainContact(sampleCollectionDbId,
			sampleCollectionMainContactUserId);
	}

	public static void deleteSampleCollectionContactsBySampleCollectionDbId(
		long sampleCollectionDbId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.deleteSampleCollectionContactsBySampleCollectionDbId(sampleCollectionDbId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SampleCollectionContactLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SampleCollectionContactLocalService.class.getName());

			if (invokableLocalService instanceof SampleCollectionContactLocalService) {
				_service = (SampleCollectionContactLocalService)invokableLocalService;
			}
			else {
				_service = new SampleCollectionContactLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SampleCollectionContactLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SampleCollectionContactLocalService service) {
	}

	private static SampleCollectionContactLocalService _service;
}