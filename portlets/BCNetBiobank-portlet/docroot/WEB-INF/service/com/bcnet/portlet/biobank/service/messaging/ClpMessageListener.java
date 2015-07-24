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

package com.bcnet.portlet.biobank.service.messaging;

import com.bcnet.portlet.biobank.service.BiobankAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankAttributeListsServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationLocalServiceUtil;
import com.bcnet.portlet.biobank.service.BiobankGeneralInformationServiceUtil;
import com.bcnet.portlet.biobank.service.ClpSerializer;
import com.bcnet.portlet.biobank.service.JuristicPersonLocalServiceUtil;
import com.bcnet.portlet.biobank.service.JuristicPersonServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsMasterServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionAttributeListsServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionContactLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionContactServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleCollectionServiceUtil;
import com.bcnet.portlet.biobank.service.SampleImportLogLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleImportLogServiceUtil;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.bcnet.portlet.biobank.service.SampleServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author suyama
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			BiobankAttributeListsLocalServiceUtil.clearService();

			BiobankAttributeListsServiceUtil.clearService();
			BiobankAttributeListsMasterLocalServiceUtil.clearService();

			BiobankAttributeListsMasterServiceUtil.clearService();
			BiobankGeneralInformationLocalServiceUtil.clearService();

			BiobankGeneralInformationServiceUtil.clearService();
			JuristicPersonLocalServiceUtil.clearService();

			JuristicPersonServiceUtil.clearService();
			SampleLocalServiceUtil.clearService();

			SampleServiceUtil.clearService();
			SampleCollectionLocalServiceUtil.clearService();

			SampleCollectionServiceUtil.clearService();
			SampleCollectionAttributeListsLocalServiceUtil.clearService();

			SampleCollectionAttributeListsServiceUtil.clearService();
			SampleCollectionAttributeListsMasterLocalServiceUtil.clearService();

			SampleCollectionAttributeListsMasterServiceUtil.clearService();
			SampleCollectionContactLocalServiceUtil.clearService();

			SampleCollectionContactServiceUtil.clearService();
			SampleImportLogLocalServiceUtil.clearService();

			SampleImportLogServiceUtil.clearService();
		}
	}
}