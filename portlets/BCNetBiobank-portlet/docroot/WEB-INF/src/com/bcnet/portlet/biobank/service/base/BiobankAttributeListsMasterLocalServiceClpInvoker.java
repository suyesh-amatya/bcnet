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

import com.bcnet.portlet.biobank.service.BiobankAttributeListsMasterLocalServiceUtil;

import java.util.Arrays;

/**
 * @author suyama
 * @generated
 */
public class BiobankAttributeListsMasterLocalServiceClpInvoker {
	public BiobankAttributeListsMasterLocalServiceClpInvoker() {
		_methodName0 = "addBiobankAttributeListsMaster";

		_methodParameterTypes0 = new String[] {
				"com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster"
			};

		_methodName1 = "createBiobankAttributeListsMaster";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBiobankAttributeListsMaster";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBiobankAttributeListsMaster";

		_methodParameterTypes3 = new String[] {
				"com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchBiobankAttributeListsMaster";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBiobankAttributeListsMaster";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBiobankAttributeListsMasters";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBiobankAttributeListsMastersCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBiobankAttributeListsMaster";

		_methodParameterTypes15 = new String[] {
				"com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster"
			};

		_methodName66 = "getBeanIdentifier";

		_methodParameterTypes66 = new String[] {  };

		_methodName67 = "setBeanIdentifier";

		_methodParameterTypes67 = new String[] { "java.lang.String" };

		_methodName72 = "addBiobankAttributeListsMaster";

		_methodParameterTypes72 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName73 = "deleteBiobankAttributeListsMaster";

		_methodParameterTypes73 = new String[] {
				"com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster"
			};

		_methodName74 = "deleteBiobankAttributeListsMaster";

		_methodParameterTypes74 = new String[] { "long" };

		_methodName75 = "getBiobankAttributeListsMaster";

		_methodParameterTypes75 = new String[] { "long" };

		_methodName76 = "getAllBiobankAttributeListsMasters";

		_methodParameterTypes76 = new String[] {  };

		_methodName77 = "getAllBiobankAttributeListsMasters";

		_methodParameterTypes77 = new String[] { "int", "int" };

		_methodName78 = "getBiobankAttributeListsMasterByAttributeListName";

		_methodParameterTypes78 = new String[] { "java.lang.String" };

		_methodName79 = "updateBiobankAttributeListsMaster";

		_methodParameterTypes79 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.addBiobankAttributeListsMaster((com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.createBiobankAttributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.deleteBiobankAttributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.deleteBiobankAttributeListsMaster((com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.fetchBiobankAttributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.getBiobankAttributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.getBiobankAttributeListsMasters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.getBiobankAttributeListsMastersCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.updateBiobankAttributeListsMaster((com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster)arguments[0]);
		}

		if (_methodName66.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName67.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
			BiobankAttributeListsMasterLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName72.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.addBiobankAttributeListsMaster((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName73.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.deleteBiobankAttributeListsMaster((com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster)arguments[0]);
		}

		if (_methodName74.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.deleteBiobankAttributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName75.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes75, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.getBiobankAttributeListsMaster(((Long)arguments[0]).longValue());
		}

		if (_methodName76.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes76, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.getAllBiobankAttributeListsMasters();
		}

		if (_methodName77.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes77, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.getAllBiobankAttributeListsMasters(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName78.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes78, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.getBiobankAttributeListsMasterByAttributeListName((java.lang.String)arguments[0]);
		}

		if (_methodName79.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes79, parameterTypes)) {
			return BiobankAttributeListsMasterLocalServiceUtil.updateBiobankAttributeListsMaster(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
}