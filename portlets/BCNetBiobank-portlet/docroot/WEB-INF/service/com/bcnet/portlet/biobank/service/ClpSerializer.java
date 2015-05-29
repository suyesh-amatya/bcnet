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

import com.bcnet.portlet.biobank.model.BiobankAttributeListsClp;
import com.bcnet.portlet.biobank.model.BiobankAttributeListsMasterClp;
import com.bcnet.portlet.biobank.model.BiobankGeneralInformationClp;
import com.bcnet.portlet.biobank.model.JuristicPersonClp;
import com.bcnet.portlet.biobank.model.SampleClp;
import com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsClp;
import com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMasterClp;
import com.bcnet.portlet.biobank.model.SampleCollectionClp;
import com.bcnet.portlet.biobank.model.SampleCollectionContactClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suyama
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"BCNetBiobank-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"BCNetBiobank-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "BCNetBiobank-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(BiobankAttributeListsClp.class.getName())) {
			return translateInputBiobankAttributeLists(oldModel);
		}

		if (oldModelClassName.equals(
					BiobankAttributeListsMasterClp.class.getName())) {
			return translateInputBiobankAttributeListsMaster(oldModel);
		}

		if (oldModelClassName.equals(
					BiobankGeneralInformationClp.class.getName())) {
			return translateInputBiobankGeneralInformation(oldModel);
		}

		if (oldModelClassName.equals(JuristicPersonClp.class.getName())) {
			return translateInputJuristicPerson(oldModel);
		}

		if (oldModelClassName.equals(SampleClp.class.getName())) {
			return translateInputSample(oldModel);
		}

		if (oldModelClassName.equals(SampleCollectionClp.class.getName())) {
			return translateInputSampleCollection(oldModel);
		}

		if (oldModelClassName.equals(
					SampleCollectionAttributeListsClp.class.getName())) {
			return translateInputSampleCollectionAttributeLists(oldModel);
		}

		if (oldModelClassName.equals(
					SampleCollectionAttributeListsMasterClp.class.getName())) {
			return translateInputSampleCollectionAttributeListsMaster(oldModel);
		}

		if (oldModelClassName.equals(SampleCollectionContactClp.class.getName())) {
			return translateInputSampleCollectionContact(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputBiobankAttributeLists(
		BaseModel<?> oldModel) {
		BiobankAttributeListsClp oldClpModel = (BiobankAttributeListsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBiobankAttributeListsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBiobankAttributeListsMaster(
		BaseModel<?> oldModel) {
		BiobankAttributeListsMasterClp oldClpModel = (BiobankAttributeListsMasterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBiobankAttributeListsMasterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBiobankGeneralInformation(
		BaseModel<?> oldModel) {
		BiobankGeneralInformationClp oldClpModel = (BiobankGeneralInformationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBiobankGeneralInformationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJuristicPerson(BaseModel<?> oldModel) {
		JuristicPersonClp oldClpModel = (JuristicPersonClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJuristicPersonRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSample(BaseModel<?> oldModel) {
		SampleClp oldClpModel = (SampleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSampleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSampleCollection(BaseModel<?> oldModel) {
		SampleCollectionClp oldClpModel = (SampleCollectionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSampleCollectionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSampleCollectionAttributeLists(
		BaseModel<?> oldModel) {
		SampleCollectionAttributeListsClp oldClpModel = (SampleCollectionAttributeListsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSampleCollectionAttributeListsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSampleCollectionAttributeListsMaster(
		BaseModel<?> oldModel) {
		SampleCollectionAttributeListsMasterClp oldClpModel = (SampleCollectionAttributeListsMasterClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSampleCollectionAttributeListsMasterRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSampleCollectionContact(
		BaseModel<?> oldModel) {
		SampleCollectionContactClp oldClpModel = (SampleCollectionContactClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSampleCollectionContactRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsImpl")) {
			return translateOutputBiobankAttributeLists(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterImpl")) {
			return translateOutputBiobankAttributeListsMaster(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationImpl")) {
			return translateOutputBiobankGeneralInformation(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.bcnet.portlet.biobank.model.impl.JuristicPersonImpl")) {
			return translateOutputJuristicPerson(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.bcnet.portlet.biobank.model.impl.SampleImpl")) {
			return translateOutputSample(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.bcnet.portlet.biobank.model.impl.SampleCollectionImpl")) {
			return translateOutputSampleCollection(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsImpl")) {
			return translateOutputSampleCollectionAttributeLists(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterImpl")) {
			return translateOutputSampleCollectionAttributeListsMaster(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"com.bcnet.portlet.biobank.model.impl.SampleCollectionContactImpl")) {
			return translateOutputSampleCollectionContact(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException")) {
			return new com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsException();
		}

		if (className.equals(
					"com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException")) {
			return new com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException();
		}

		if (className.equals(
					"com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException")) {
			return new com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException();
		}

		if (className.equals(
					"com.bcnet.portlet.biobank.NoSuchJuristicPersonException")) {
			return new com.bcnet.portlet.biobank.NoSuchJuristicPersonException();
		}

		if (className.equals("com.bcnet.portlet.biobank.NoSuchSampleException")) {
			return new com.bcnet.portlet.biobank.NoSuchSampleException();
		}

		if (className.equals(
					"com.bcnet.portlet.biobank.NoSuchSampleCollectionException")) {
			return new com.bcnet.portlet.biobank.NoSuchSampleCollectionException();
		}

		if (className.equals(
					"com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException")) {
			return new com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException();
		}

		if (className.equals(
					"com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException")) {
			return new com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException();
		}

		if (className.equals(
					"com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException")) {
			return new com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException();
		}

		return throwable;
	}

	public static Object translateOutputBiobankAttributeLists(
		BaseModel<?> oldModel) {
		BiobankAttributeListsClp newModel = new BiobankAttributeListsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBiobankAttributeListsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBiobankAttributeListsMaster(
		BaseModel<?> oldModel) {
		BiobankAttributeListsMasterClp newModel = new BiobankAttributeListsMasterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBiobankAttributeListsMasterRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBiobankGeneralInformation(
		BaseModel<?> oldModel) {
		BiobankGeneralInformationClp newModel = new BiobankGeneralInformationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBiobankGeneralInformationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJuristicPerson(BaseModel<?> oldModel) {
		JuristicPersonClp newModel = new JuristicPersonClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJuristicPersonRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSample(BaseModel<?> oldModel) {
		SampleClp newModel = new SampleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSampleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSampleCollection(BaseModel<?> oldModel) {
		SampleCollectionClp newModel = new SampleCollectionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSampleCollectionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSampleCollectionAttributeLists(
		BaseModel<?> oldModel) {
		SampleCollectionAttributeListsClp newModel = new SampleCollectionAttributeListsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSampleCollectionAttributeListsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSampleCollectionAttributeListsMaster(
		BaseModel<?> oldModel) {
		SampleCollectionAttributeListsMasterClp newModel = new SampleCollectionAttributeListsMasterClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSampleCollectionAttributeListsMasterRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSampleCollectionContact(
		BaseModel<?> oldModel) {
		SampleCollectionContactClp newModel = new SampleCollectionContactClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSampleCollectionContactRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}