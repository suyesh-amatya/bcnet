package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.service.SampleLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

public abstract class SampleActionableDynamicQuery
extends BaseActionableDynamicQuery {
	public SampleActionableDynamicQuery() throws SystemException {
		setBaseLocalService(SampleLocalServiceUtil.getService());
		setClass(Sample.class);

		setClassLoader(PortalClassLoaderUtil.getClassLoader());

		setPrimaryKeyPropertyName("sampleDbId");
	}
}
