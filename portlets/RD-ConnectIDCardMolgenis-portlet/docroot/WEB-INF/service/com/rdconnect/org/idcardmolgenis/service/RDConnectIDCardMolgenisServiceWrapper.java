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

package com.rdconnect.org.idcardmolgenis.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RDConnectIDCardMolgenisService}.
 *
 * @author suyeshamatya
 * @see RDConnectIDCardMolgenisService
 * @generated
 */
public class RDConnectIDCardMolgenisServiceWrapper
	implements RDConnectIDCardMolgenisService,
		ServiceWrapper<RDConnectIDCardMolgenisService> {
	public RDConnectIDCardMolgenisServiceWrapper(
		RDConnectIDCardMolgenisService rdConnectIDCardMolgenisService) {
		_rdConnectIDCardMolgenisService = rdConnectIDCardMolgenisService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rdConnectIDCardMolgenisService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rdConnectIDCardMolgenisService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rdConnectIDCardMolgenisService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RDConnectIDCardMolgenisService getWrappedRDConnectIDCardMolgenisService() {
		return _rdConnectIDCardMolgenisService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRDConnectIDCardMolgenisService(
		RDConnectIDCardMolgenisService rdConnectIDCardMolgenisService) {
		_rdConnectIDCardMolgenisService = rdConnectIDCardMolgenisService;
	}

	@Override
	public RDConnectIDCardMolgenisService getWrappedService() {
		return _rdConnectIDCardMolgenisService;
	}

	@Override
	public void setWrappedService(
		RDConnectIDCardMolgenisService rdConnectIDCardMolgenisService) {
		_rdConnectIDCardMolgenisService = rdConnectIDCardMolgenisService;
	}

	private RDConnectIDCardMolgenisService _rdConnectIDCardMolgenisService;
}