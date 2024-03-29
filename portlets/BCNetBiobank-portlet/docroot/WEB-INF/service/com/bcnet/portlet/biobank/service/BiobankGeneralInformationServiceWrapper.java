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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BiobankGeneralInformationService}.
 *
 * @author suyama
 * @see BiobankGeneralInformationService
 * @generated
 */
public class BiobankGeneralInformationServiceWrapper
	implements BiobankGeneralInformationService,
		ServiceWrapper<BiobankGeneralInformationService> {
	public BiobankGeneralInformationServiceWrapper(
		BiobankGeneralInformationService biobankGeneralInformationService) {
		_biobankGeneralInformationService = biobankGeneralInformationService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _biobankGeneralInformationService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_biobankGeneralInformationService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _biobankGeneralInformationService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.lang.String getAllBiobanks()
		throws com.bcnet.portlet.biobank.NoSuchJuristicPersonException,
			com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _biobankGeneralInformationService.getAllBiobanks();
	}

	@Override
	public java.lang.String helloWorld(java.lang.String worldName) {
		return _biobankGeneralInformationService.helloWorld(worldName);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BiobankGeneralInformationService getWrappedBiobankGeneralInformationService() {
		return _biobankGeneralInformationService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBiobankGeneralInformationService(
		BiobankGeneralInformationService biobankGeneralInformationService) {
		_biobankGeneralInformationService = biobankGeneralInformationService;
	}

	@Override
	public BiobankGeneralInformationService getWrappedService() {
		return _biobankGeneralInformationService;
	}

	@Override
	public void setWrappedService(
		BiobankGeneralInformationService biobankGeneralInformationService) {
		_biobankGeneralInformationService = biobankGeneralInformationService;
	}

	private BiobankGeneralInformationService _biobankGeneralInformationService;
}