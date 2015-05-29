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

package com.bcnet.portlet.biobank.service.base;

import com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsService;
import com.bcnet.portlet.biobank.service.persistence.BiobankAttributeListsMasterPersistence;
import com.bcnet.portlet.biobank.service.persistence.BiobankAttributeListsPersistence;
import com.bcnet.portlet.biobank.service.persistence.BiobankGeneralInformationFinder;
import com.bcnet.portlet.biobank.service.persistence.BiobankGeneralInformationPersistence;
import com.bcnet.portlet.biobank.service.persistence.JuristicPersonPersistence;
import com.bcnet.portlet.biobank.service.persistence.SampleCollectionAttributeListsMasterPersistence;
import com.bcnet.portlet.biobank.service.persistence.SampleCollectionAttributeListsPersistence;
import com.bcnet.portlet.biobank.service.persistence.SampleCollectionContactPersistence;
import com.bcnet.portlet.biobank.service.persistence.SampleCollectionPersistence;
import com.bcnet.portlet.biobank.service.persistence.SamplePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the sample collection attribute lists remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.bcnet.portlet.biobank.service.impl.SampleCollectionAttributeListsServiceImpl}.
 * </p>
 *
 * @author suyama
 * @see com.bcnet.portlet.biobank.service.impl.SampleCollectionAttributeListsServiceImpl
 * @see com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsServiceUtil
 * @generated
 */
public abstract class SampleCollectionAttributeListsServiceBaseImpl
	extends BaseServiceImpl implements SampleCollectionAttributeListsService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsServiceUtil} to access the sample collection attribute lists remote service.
	 */

	/**
	 * Returns the biobank attribute lists local service.
	 *
	 * @return the biobank attribute lists local service
	 */
	public com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalService getBiobankAttributeListsLocalService() {
		return biobankAttributeListsLocalService;
	}

	/**
	 * Sets the biobank attribute lists local service.
	 *
	 * @param biobankAttributeListsLocalService the biobank attribute lists local service
	 */
	public void setBiobankAttributeListsLocalService(
		com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalService biobankAttributeListsLocalService) {
		this.biobankAttributeListsLocalService = biobankAttributeListsLocalService;
	}

	/**
	 * Returns the biobank attribute lists remote service.
	 *
	 * @return the biobank attribute lists remote service
	 */
	public com.bcnet.portlet.biobank.service.BiobankAttributeListsService getBiobankAttributeListsService() {
		return biobankAttributeListsService;
	}

	/**
	 * Sets the biobank attribute lists remote service.
	 *
	 * @param biobankAttributeListsService the biobank attribute lists remote service
	 */
	public void setBiobankAttributeListsService(
		com.bcnet.portlet.biobank.service.BiobankAttributeListsService biobankAttributeListsService) {
		this.biobankAttributeListsService = biobankAttributeListsService;
	}

	/**
	 * Returns the biobank attribute lists persistence.
	 *
	 * @return the biobank attribute lists persistence
	 */
	public BiobankAttributeListsPersistence getBiobankAttributeListsPersistence() {
		return biobankAttributeListsPersistence;
	}

	/**
	 * Sets the biobank attribute lists persistence.
	 *
	 * @param biobankAttributeListsPersistence the biobank attribute lists persistence
	 */
	public void setBiobankAttributeListsPersistence(
		BiobankAttributeListsPersistence biobankAttributeListsPersistence) {
		this.biobankAttributeListsPersistence = biobankAttributeListsPersistence;
	}

	/**
	 * Returns the biobank attribute lists master local service.
	 *
	 * @return the biobank attribute lists master local service
	 */
	public com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalService getBiobankAttributeListsMasterLocalService() {
		return biobankAttributeListsMasterLocalService;
	}

	/**
	 * Sets the biobank attribute lists master local service.
	 *
	 * @param biobankAttributeListsMasterLocalService the biobank attribute lists master local service
	 */
	public void setBiobankAttributeListsMasterLocalService(
		com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalService biobankAttributeListsMasterLocalService) {
		this.biobankAttributeListsMasterLocalService = biobankAttributeListsMasterLocalService;
	}

	/**
	 * Returns the biobank attribute lists master remote service.
	 *
	 * @return the biobank attribute lists master remote service
	 */
	public com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterService getBiobankAttributeListsMasterService() {
		return biobankAttributeListsMasterService;
	}

	/**
	 * Sets the biobank attribute lists master remote service.
	 *
	 * @param biobankAttributeListsMasterService the biobank attribute lists master remote service
	 */
	public void setBiobankAttributeListsMasterService(
		com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterService biobankAttributeListsMasterService) {
		this.biobankAttributeListsMasterService = biobankAttributeListsMasterService;
	}

	/**
	 * Returns the biobank attribute lists master persistence.
	 *
	 * @return the biobank attribute lists master persistence
	 */
	public BiobankAttributeListsMasterPersistence getBiobankAttributeListsMasterPersistence() {
		return biobankAttributeListsMasterPersistence;
	}

	/**
	 * Sets the biobank attribute lists master persistence.
	 *
	 * @param biobankAttributeListsMasterPersistence the biobank attribute lists master persistence
	 */
	public void setBiobankAttributeListsMasterPersistence(
		BiobankAttributeListsMasterPersistence biobankAttributeListsMasterPersistence) {
		this.biobankAttributeListsMasterPersistence = biobankAttributeListsMasterPersistence;
	}

	/**
	 * Returns the biobank general information local service.
	 *
	 * @return the biobank general information local service
	 */
	public com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalService getBiobankGeneralInformationLocalService() {
		return biobankGeneralInformationLocalService;
	}

	/**
	 * Sets the biobank general information local service.
	 *
	 * @param biobankGeneralInformationLocalService the biobank general information local service
	 */
	public void setBiobankGeneralInformationLocalService(
		com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalService biobankGeneralInformationLocalService) {
		this.biobankGeneralInformationLocalService = biobankGeneralInformationLocalService;
	}

	/**
	 * Returns the biobank general information remote service.
	 *
	 * @return the biobank general information remote service
	 */
	public com.bcnet.portlet.biobank.service.BiobankGeneralInformationService getBiobankGeneralInformationService() {
		return biobankGeneralInformationService;
	}

	/**
	 * Sets the biobank general information remote service.
	 *
	 * @param biobankGeneralInformationService the biobank general information remote service
	 */
	public void setBiobankGeneralInformationService(
		com.bcnet.portlet.biobank.service.BiobankGeneralInformationService biobankGeneralInformationService) {
		this.biobankGeneralInformationService = biobankGeneralInformationService;
	}

	/**
	 * Returns the biobank general information persistence.
	 *
	 * @return the biobank general information persistence
	 */
	public BiobankGeneralInformationPersistence getBiobankGeneralInformationPersistence() {
		return biobankGeneralInformationPersistence;
	}

	/**
	 * Sets the biobank general information persistence.
	 *
	 * @param biobankGeneralInformationPersistence the biobank general information persistence
	 */
	public void setBiobankGeneralInformationPersistence(
		BiobankGeneralInformationPersistence biobankGeneralInformationPersistence) {
		this.biobankGeneralInformationPersistence = biobankGeneralInformationPersistence;
	}

	/**
	 * Returns the biobank general information finder.
	 *
	 * @return the biobank general information finder
	 */
	public BiobankGeneralInformationFinder getBiobankGeneralInformationFinder() {
		return biobankGeneralInformationFinder;
	}

	/**
	 * Sets the biobank general information finder.
	 *
	 * @param biobankGeneralInformationFinder the biobank general information finder
	 */
	public void setBiobankGeneralInformationFinder(
		BiobankGeneralInformationFinder biobankGeneralInformationFinder) {
		this.biobankGeneralInformationFinder = biobankGeneralInformationFinder;
	}

	/**
	 * Returns the juristic person local service.
	 *
	 * @return the juristic person local service
	 */
	public com.bcnet.portlet.biobank.service.JuristicPersonLocalService getJuristicPersonLocalService() {
		return juristicPersonLocalService;
	}

	/**
	 * Sets the juristic person local service.
	 *
	 * @param juristicPersonLocalService the juristic person local service
	 */
	public void setJuristicPersonLocalService(
		com.bcnet.portlet.biobank.service.JuristicPersonLocalService juristicPersonLocalService) {
		this.juristicPersonLocalService = juristicPersonLocalService;
	}

	/**
	 * Returns the juristic person remote service.
	 *
	 * @return the juristic person remote service
	 */
	public com.bcnet.portlet.biobank.service.JuristicPersonService getJuristicPersonService() {
		return juristicPersonService;
	}

	/**
	 * Sets the juristic person remote service.
	 *
	 * @param juristicPersonService the juristic person remote service
	 */
	public void setJuristicPersonService(
		com.bcnet.portlet.biobank.service.JuristicPersonService juristicPersonService) {
		this.juristicPersonService = juristicPersonService;
	}

	/**
	 * Returns the juristic person persistence.
	 *
	 * @return the juristic person persistence
	 */
	public JuristicPersonPersistence getJuristicPersonPersistence() {
		return juristicPersonPersistence;
	}

	/**
	 * Sets the juristic person persistence.
	 *
	 * @param juristicPersonPersistence the juristic person persistence
	 */
	public void setJuristicPersonPersistence(
		JuristicPersonPersistence juristicPersonPersistence) {
		this.juristicPersonPersistence = juristicPersonPersistence;
	}

	/**
	 * Returns the sample local service.
	 *
	 * @return the sample local service
	 */
	public com.bcnet.portlet.biobank.service.SampleLocalService getSampleLocalService() {
		return sampleLocalService;
	}

	/**
	 * Sets the sample local service.
	 *
	 * @param sampleLocalService the sample local service
	 */
	public void setSampleLocalService(
		com.bcnet.portlet.biobank.service.SampleLocalService sampleLocalService) {
		this.sampleLocalService = sampleLocalService;
	}

	/**
	 * Returns the sample remote service.
	 *
	 * @return the sample remote service
	 */
	public com.bcnet.portlet.biobank.service.SampleService getSampleService() {
		return sampleService;
	}

	/**
	 * Sets the sample remote service.
	 *
	 * @param sampleService the sample remote service
	 */
	public void setSampleService(
		com.bcnet.portlet.biobank.service.SampleService sampleService) {
		this.sampleService = sampleService;
	}

	/**
	 * Returns the sample persistence.
	 *
	 * @return the sample persistence
	 */
	public SamplePersistence getSamplePersistence() {
		return samplePersistence;
	}

	/**
	 * Sets the sample persistence.
	 *
	 * @param samplePersistence the sample persistence
	 */
	public void setSamplePersistence(SamplePersistence samplePersistence) {
		this.samplePersistence = samplePersistence;
	}

	/**
	 * Returns the sample collection local service.
	 *
	 * @return the sample collection local service
	 */
	public com.bcnet.portlet.biobank.service.SampleCollectionLocalService getSampleCollectionLocalService() {
		return sampleCollectionLocalService;
	}

	/**
	 * Sets the sample collection local service.
	 *
	 * @param sampleCollectionLocalService the sample collection local service
	 */
	public void setSampleCollectionLocalService(
		com.bcnet.portlet.biobank.service.SampleCollectionLocalService sampleCollectionLocalService) {
		this.sampleCollectionLocalService = sampleCollectionLocalService;
	}

	/**
	 * Returns the sample collection remote service.
	 *
	 * @return the sample collection remote service
	 */
	public com.bcnet.portlet.biobank.service.SampleCollectionService getSampleCollectionService() {
		return sampleCollectionService;
	}

	/**
	 * Sets the sample collection remote service.
	 *
	 * @param sampleCollectionService the sample collection remote service
	 */
	public void setSampleCollectionService(
		com.bcnet.portlet.biobank.service.SampleCollectionService sampleCollectionService) {
		this.sampleCollectionService = sampleCollectionService;
	}

	/**
	 * Returns the sample collection persistence.
	 *
	 * @return the sample collection persistence
	 */
	public SampleCollectionPersistence getSampleCollectionPersistence() {
		return sampleCollectionPersistence;
	}

	/**
	 * Sets the sample collection persistence.
	 *
	 * @param sampleCollectionPersistence the sample collection persistence
	 */
	public void setSampleCollectionPersistence(
		SampleCollectionPersistence sampleCollectionPersistence) {
		this.sampleCollectionPersistence = sampleCollectionPersistence;
	}

	/**
	 * Returns the sample collection attribute lists local service.
	 *
	 * @return the sample collection attribute lists local service
	 */
	public com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalService getSampleCollectionAttributeListsLocalService() {
		return sampleCollectionAttributeListsLocalService;
	}

	/**
	 * Sets the sample collection attribute lists local service.
	 *
	 * @param sampleCollectionAttributeListsLocalService the sample collection attribute lists local service
	 */
	public void setSampleCollectionAttributeListsLocalService(
		com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalService sampleCollectionAttributeListsLocalService) {
		this.sampleCollectionAttributeListsLocalService = sampleCollectionAttributeListsLocalService;
	}

	/**
	 * Returns the sample collection attribute lists remote service.
	 *
	 * @return the sample collection attribute lists remote service
	 */
	public com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsService getSampleCollectionAttributeListsService() {
		return sampleCollectionAttributeListsService;
	}

	/**
	 * Sets the sample collection attribute lists remote service.
	 *
	 * @param sampleCollectionAttributeListsService the sample collection attribute lists remote service
	 */
	public void setSampleCollectionAttributeListsService(
		com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsService sampleCollectionAttributeListsService) {
		this.sampleCollectionAttributeListsService = sampleCollectionAttributeListsService;
	}

	/**
	 * Returns the sample collection attribute lists persistence.
	 *
	 * @return the sample collection attribute lists persistence
	 */
	public SampleCollectionAttributeListsPersistence getSampleCollectionAttributeListsPersistence() {
		return sampleCollectionAttributeListsPersistence;
	}

	/**
	 * Sets the sample collection attribute lists persistence.
	 *
	 * @param sampleCollectionAttributeListsPersistence the sample collection attribute lists persistence
	 */
	public void setSampleCollectionAttributeListsPersistence(
		SampleCollectionAttributeListsPersistence sampleCollectionAttributeListsPersistence) {
		this.sampleCollectionAttributeListsPersistence = sampleCollectionAttributeListsPersistence;
	}

	/**
	 * Returns the sample collection attribute lists master local service.
	 *
	 * @return the sample collection attribute lists master local service
	 */
	public com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalService getSampleCollectionAttributeListsMasterLocalService() {
		return sampleCollectionAttributeListsMasterLocalService;
	}

	/**
	 * Sets the sample collection attribute lists master local service.
	 *
	 * @param sampleCollectionAttributeListsMasterLocalService the sample collection attribute lists master local service
	 */
	public void setSampleCollectionAttributeListsMasterLocalService(
		com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalService sampleCollectionAttributeListsMasterLocalService) {
		this.sampleCollectionAttributeListsMasterLocalService = sampleCollectionAttributeListsMasterLocalService;
	}

	/**
	 * Returns the sample collection attribute lists master remote service.
	 *
	 * @return the sample collection attribute lists master remote service
	 */
	public com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterService getSampleCollectionAttributeListsMasterService() {
		return sampleCollectionAttributeListsMasterService;
	}

	/**
	 * Sets the sample collection attribute lists master remote service.
	 *
	 * @param sampleCollectionAttributeListsMasterService the sample collection attribute lists master remote service
	 */
	public void setSampleCollectionAttributeListsMasterService(
		com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterService sampleCollectionAttributeListsMasterService) {
		this.sampleCollectionAttributeListsMasterService = sampleCollectionAttributeListsMasterService;
	}

	/**
	 * Returns the sample collection attribute lists master persistence.
	 *
	 * @return the sample collection attribute lists master persistence
	 */
	public SampleCollectionAttributeListsMasterPersistence getSampleCollectionAttributeListsMasterPersistence() {
		return sampleCollectionAttributeListsMasterPersistence;
	}

	/**
	 * Sets the sample collection attribute lists master persistence.
	 *
	 * @param sampleCollectionAttributeListsMasterPersistence the sample collection attribute lists master persistence
	 */
	public void setSampleCollectionAttributeListsMasterPersistence(
		SampleCollectionAttributeListsMasterPersistence sampleCollectionAttributeListsMasterPersistence) {
		this.sampleCollectionAttributeListsMasterPersistence = sampleCollectionAttributeListsMasterPersistence;
	}

	/**
	 * Returns the sample collection contact local service.
	 *
	 * @return the sample collection contact local service
	 */
	public com.bcnet.portlet.biobank.service.SampleCollectionContactLocalService getSampleCollectionContactLocalService() {
		return sampleCollectionContactLocalService;
	}

	/**
	 * Sets the sample collection contact local service.
	 *
	 * @param sampleCollectionContactLocalService the sample collection contact local service
	 */
	public void setSampleCollectionContactLocalService(
		com.bcnet.portlet.biobank.service.SampleCollectionContactLocalService sampleCollectionContactLocalService) {
		this.sampleCollectionContactLocalService = sampleCollectionContactLocalService;
	}

	/**
	 * Returns the sample collection contact remote service.
	 *
	 * @return the sample collection contact remote service
	 */
	public com.bcnet.portlet.biobank.service.SampleCollectionContactService getSampleCollectionContactService() {
		return sampleCollectionContactService;
	}

	/**
	 * Sets the sample collection contact remote service.
	 *
	 * @param sampleCollectionContactService the sample collection contact remote service
	 */
	public void setSampleCollectionContactService(
		com.bcnet.portlet.biobank.service.SampleCollectionContactService sampleCollectionContactService) {
		this.sampleCollectionContactService = sampleCollectionContactService;
	}

	/**
	 * Returns the sample collection contact persistence.
	 *
	 * @return the sample collection contact persistence
	 */
	public SampleCollectionContactPersistence getSampleCollectionContactPersistence() {
		return sampleCollectionContactPersistence;
	}

	/**
	 * Sets the sample collection contact persistence.
	 *
	 * @param sampleCollectionContactPersistence the sample collection contact persistence
	 */
	public void setSampleCollectionContactPersistence(
		SampleCollectionContactPersistence sampleCollectionContactPersistence) {
		this.sampleCollectionContactPersistence = sampleCollectionContactPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SampleCollectionAttributeLists.class;
	}

	protected String getModelClassName() {
		return SampleCollectionAttributeLists.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = sampleCollectionAttributeListsPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalService.class)
	protected com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalService biobankAttributeListsLocalService;
	@BeanReference(type = com.bcnet.portlet.biobank.service.BiobankAttributeListsService.class)
	protected com.bcnet.portlet.biobank.service.BiobankAttributeListsService biobankAttributeListsService;
	@BeanReference(type = BiobankAttributeListsPersistence.class)
	protected BiobankAttributeListsPersistence biobankAttributeListsPersistence;
	@BeanReference(type = com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalService.class)
	protected com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalService biobankAttributeListsMasterLocalService;
	@BeanReference(type = com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterService.class)
	protected com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterService biobankAttributeListsMasterService;
	@BeanReference(type = BiobankAttributeListsMasterPersistence.class)
	protected BiobankAttributeListsMasterPersistence biobankAttributeListsMasterPersistence;
	@BeanReference(type = com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalService.class)
	protected com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalService biobankGeneralInformationLocalService;
	@BeanReference(type = com.bcnet.portlet.biobank.service.BiobankGeneralInformationService.class)
	protected com.bcnet.portlet.biobank.service.BiobankGeneralInformationService biobankGeneralInformationService;
	@BeanReference(type = BiobankGeneralInformationPersistence.class)
	protected BiobankGeneralInformationPersistence biobankGeneralInformationPersistence;
	@BeanReference(type = BiobankGeneralInformationFinder.class)
	protected BiobankGeneralInformationFinder biobankGeneralInformationFinder;
	@BeanReference(type = com.bcnet.portlet.biobank.service.JuristicPersonLocalService.class)
	protected com.bcnet.portlet.biobank.service.JuristicPersonLocalService juristicPersonLocalService;
	@BeanReference(type = com.bcnet.portlet.biobank.service.JuristicPersonService.class)
	protected com.bcnet.portlet.biobank.service.JuristicPersonService juristicPersonService;
	@BeanReference(type = JuristicPersonPersistence.class)
	protected JuristicPersonPersistence juristicPersonPersistence;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleLocalService.class)
	protected com.bcnet.portlet.biobank.service.SampleLocalService sampleLocalService;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleService.class)
	protected com.bcnet.portlet.biobank.service.SampleService sampleService;
	@BeanReference(type = SamplePersistence.class)
	protected SamplePersistence samplePersistence;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleCollectionLocalService.class)
	protected com.bcnet.portlet.biobank.service.SampleCollectionLocalService sampleCollectionLocalService;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleCollectionService.class)
	protected com.bcnet.portlet.biobank.service.SampleCollectionService sampleCollectionService;
	@BeanReference(type = SampleCollectionPersistence.class)
	protected SampleCollectionPersistence sampleCollectionPersistence;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalService.class)
	protected com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalService sampleCollectionAttributeListsLocalService;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsService.class)
	protected com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsService sampleCollectionAttributeListsService;
	@BeanReference(type = SampleCollectionAttributeListsPersistence.class)
	protected SampleCollectionAttributeListsPersistence sampleCollectionAttributeListsPersistence;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalService.class)
	protected com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalService sampleCollectionAttributeListsMasterLocalService;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterService.class)
	protected com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterService sampleCollectionAttributeListsMasterService;
	@BeanReference(type = SampleCollectionAttributeListsMasterPersistence.class)
	protected SampleCollectionAttributeListsMasterPersistence sampleCollectionAttributeListsMasterPersistence;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleCollectionContactLocalService.class)
	protected com.bcnet.portlet.biobank.service.SampleCollectionContactLocalService sampleCollectionContactLocalService;
	@BeanReference(type = com.bcnet.portlet.biobank.service.SampleCollectionContactService.class)
	protected com.bcnet.portlet.biobank.service.SampleCollectionContactService sampleCollectionContactService;
	@BeanReference(type = SampleCollectionContactPersistence.class)
	protected SampleCollectionContactPersistence sampleCollectionContactPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SampleCollectionAttributeListsServiceClpInvoker _clpInvoker = new SampleCollectionAttributeListsServiceClpInvoker();
}