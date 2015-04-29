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

package com.bcnet.portlet.biobank.service.persistence;

import com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException;
import com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster;
import com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterImpl;
import com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sample collection attribute lists master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionAttributeListsMasterPersistence
 * @see SampleCollectionAttributeListsMasterUtil
 * @generated
 */
public class SampleCollectionAttributeListsMasterPersistenceImpl
	extends BasePersistenceImpl<SampleCollectionAttributeListsMaster>
	implements SampleCollectionAttributeListsMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SampleCollectionAttributeListsMasterUtil} to access the sample collection attribute lists master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SampleCollectionAttributeListsMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionAttributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionAttributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public SampleCollectionAttributeListsMasterPersistenceImpl() {
		setModelClass(SampleCollectionAttributeListsMaster.class);
	}

	/**
	 * Caches the sample collection attribute lists master in the entity cache if it is enabled.
	 *
	 * @param sampleCollectionAttributeListsMaster the sample collection attribute lists master
	 */
	@Override
	public void cacheResult(
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster) {
		EntityCacheUtil.putResult(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsMasterImpl.class,
			sampleCollectionAttributeListsMaster.getPrimaryKey(),
			sampleCollectionAttributeListsMaster);

		sampleCollectionAttributeListsMaster.resetOriginalValues();
	}

	/**
	 * Caches the sample collection attribute lists masters in the entity cache if it is enabled.
	 *
	 * @param sampleCollectionAttributeListsMasters the sample collection attribute lists masters
	 */
	@Override
	public void cacheResult(
		List<SampleCollectionAttributeListsMaster> sampleCollectionAttributeListsMasters) {
		for (SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster : sampleCollectionAttributeListsMasters) {
			if (EntityCacheUtil.getResult(
						SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
						SampleCollectionAttributeListsMasterImpl.class,
						sampleCollectionAttributeListsMaster.getPrimaryKey()) == null) {
				cacheResult(sampleCollectionAttributeListsMaster);
			}
			else {
				sampleCollectionAttributeListsMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sample collection attribute lists masters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SampleCollectionAttributeListsMasterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SampleCollectionAttributeListsMasterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample collection attribute lists master.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster) {
		EntityCacheUtil.removeResult(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsMasterImpl.class,
			sampleCollectionAttributeListsMaster.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<SampleCollectionAttributeListsMaster> sampleCollectionAttributeListsMasters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster : sampleCollectionAttributeListsMasters) {
			EntityCacheUtil.removeResult(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
				SampleCollectionAttributeListsMasterImpl.class,
				sampleCollectionAttributeListsMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sample collection attribute lists master with the primary key. Does not add the sample collection attribute lists master to the database.
	 *
	 * @param sampleCollectionAttributeListsMasterId the primary key for the new sample collection attribute lists master
	 * @return the new sample collection attribute lists master
	 */
	@Override
	public SampleCollectionAttributeListsMaster create(
		long sampleCollectionAttributeListsMasterId) {
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster =
			new SampleCollectionAttributeListsMasterImpl();

		sampleCollectionAttributeListsMaster.setNew(true);
		sampleCollectionAttributeListsMaster.setPrimaryKey(sampleCollectionAttributeListsMasterId);

		return sampleCollectionAttributeListsMaster;
	}

	/**
	 * Removes the sample collection attribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	 * @return the sample collection attribute lists master that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a sample collection attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeListsMaster remove(
		long sampleCollectionAttributeListsMasterId)
		throws NoSuchSampleCollectionAttributeListsMasterException,
			SystemException {
		return remove((Serializable)sampleCollectionAttributeListsMasterId);
	}

	/**
	 * Removes the sample collection attribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample collection attribute lists master
	 * @return the sample collection attribute lists master that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a sample collection attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeListsMaster remove(Serializable primaryKey)
		throws NoSuchSampleCollectionAttributeListsMasterException,
			SystemException {
		Session session = null;

		try {
			session = openSession();

			SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster =
				(SampleCollectionAttributeListsMaster)session.get(SampleCollectionAttributeListsMasterImpl.class,
					primaryKey);

			if (sampleCollectionAttributeListsMaster == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSampleCollectionAttributeListsMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sampleCollectionAttributeListsMaster);
		}
		catch (NoSuchSampleCollectionAttributeListsMasterException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SampleCollectionAttributeListsMaster removeImpl(
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws SystemException {
		sampleCollectionAttributeListsMaster = toUnwrappedModel(sampleCollectionAttributeListsMaster);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sampleCollectionAttributeListsMaster)) {
				sampleCollectionAttributeListsMaster = (SampleCollectionAttributeListsMaster)session.get(SampleCollectionAttributeListsMasterImpl.class,
						sampleCollectionAttributeListsMaster.getPrimaryKeyObj());
			}

			if (sampleCollectionAttributeListsMaster != null) {
				session.delete(sampleCollectionAttributeListsMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sampleCollectionAttributeListsMaster != null) {
			clearCache(sampleCollectionAttributeListsMaster);
		}

		return sampleCollectionAttributeListsMaster;
	}

	@Override
	public SampleCollectionAttributeListsMaster updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster)
		throws SystemException {
		sampleCollectionAttributeListsMaster = toUnwrappedModel(sampleCollectionAttributeListsMaster);

		boolean isNew = sampleCollectionAttributeListsMaster.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sampleCollectionAttributeListsMaster.isNew()) {
				session.save(sampleCollectionAttributeListsMaster);

				sampleCollectionAttributeListsMaster.setNew(false);
			}
			else {
				session.merge(sampleCollectionAttributeListsMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsMasterImpl.class,
			sampleCollectionAttributeListsMaster.getPrimaryKey(),
			sampleCollectionAttributeListsMaster);

		return sampleCollectionAttributeListsMaster;
	}

	protected SampleCollectionAttributeListsMaster toUnwrappedModel(
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster) {
		if (sampleCollectionAttributeListsMaster instanceof SampleCollectionAttributeListsMasterImpl) {
			return sampleCollectionAttributeListsMaster;
		}

		SampleCollectionAttributeListsMasterImpl sampleCollectionAttributeListsMasterImpl =
			new SampleCollectionAttributeListsMasterImpl();

		sampleCollectionAttributeListsMasterImpl.setNew(sampleCollectionAttributeListsMaster.isNew());
		sampleCollectionAttributeListsMasterImpl.setPrimaryKey(sampleCollectionAttributeListsMaster.getPrimaryKey());

		sampleCollectionAttributeListsMasterImpl.setSampleCollectionAttributeListsMasterId(sampleCollectionAttributeListsMaster.getSampleCollectionAttributeListsMasterId());
		sampleCollectionAttributeListsMasterImpl.setAttributeListName(sampleCollectionAttributeListsMaster.getAttributeListName());
		sampleCollectionAttributeListsMasterImpl.setAttributeListValue(sampleCollectionAttributeListsMaster.getAttributeListValue());

		return sampleCollectionAttributeListsMasterImpl;
	}

	/**
	 * Returns the sample collection attribute lists master with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample collection attribute lists master
	 * @return the sample collection attribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a sample collection attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeListsMaster findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchSampleCollectionAttributeListsMasterException,
			SystemException {
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster =
			fetchByPrimaryKey(primaryKey);

		if (sampleCollectionAttributeListsMaster == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSampleCollectionAttributeListsMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sampleCollectionAttributeListsMaster;
	}

	/**
	 * Returns the sample collection attribute lists master with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException} if it could not be found.
	 *
	 * @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	 * @return the sample collection attribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsMasterException if a sample collection attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeListsMaster findByPrimaryKey(
		long sampleCollectionAttributeListsMasterId)
		throws NoSuchSampleCollectionAttributeListsMasterException,
			SystemException {
		return findByPrimaryKey((Serializable)sampleCollectionAttributeListsMasterId);
	}

	/**
	 * Returns the sample collection attribute lists master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample collection attribute lists master
	 * @return the sample collection attribute lists master, or <code>null</code> if a sample collection attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeListsMaster fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster =
			(SampleCollectionAttributeListsMaster)EntityCacheUtil.getResult(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
				SampleCollectionAttributeListsMasterImpl.class, primaryKey);

		if (sampleCollectionAttributeListsMaster == _nullSampleCollectionAttributeListsMaster) {
			return null;
		}

		if (sampleCollectionAttributeListsMaster == null) {
			Session session = null;

			try {
				session = openSession();

				sampleCollectionAttributeListsMaster = (SampleCollectionAttributeListsMaster)session.get(SampleCollectionAttributeListsMasterImpl.class,
						primaryKey);

				if (sampleCollectionAttributeListsMaster != null) {
					cacheResult(sampleCollectionAttributeListsMaster);
				}
				else {
					EntityCacheUtil.putResult(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
						SampleCollectionAttributeListsMasterImpl.class,
						primaryKey, _nullSampleCollectionAttributeListsMaster);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SampleCollectionAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
					SampleCollectionAttributeListsMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sampleCollectionAttributeListsMaster;
	}

	/**
	 * Returns the sample collection attribute lists master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleCollectionAttributeListsMasterId the primary key of the sample collection attribute lists master
	 * @return the sample collection attribute lists master, or <code>null</code> if a sample collection attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeListsMaster fetchByPrimaryKey(
		long sampleCollectionAttributeListsMasterId) throws SystemException {
		return fetchByPrimaryKey((Serializable)sampleCollectionAttributeListsMasterId);
	}

	/**
	 * Returns all the sample collection attribute lists masters.
	 *
	 * @return the sample collection attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeListsMaster> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample collection attribute lists masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample collection attribute lists masters
	 * @param end the upper bound of the range of sample collection attribute lists masters (not inclusive)
	 * @return the range of sample collection attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeListsMaster> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample collection attribute lists masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample collection attribute lists masters
	 * @param end the upper bound of the range of sample collection attribute lists masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sample collection attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeListsMaster> findAll(int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SampleCollectionAttributeListsMaster> list = (List<SampleCollectionAttributeListsMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTSMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTSMASTER;

				if (pagination) {
					sql = sql.concat(SampleCollectionAttributeListsMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SampleCollectionAttributeListsMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SampleCollectionAttributeListsMaster>(list);
				}
				else {
					list = (List<SampleCollectionAttributeListsMaster>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sample collection attribute lists masters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster : findAll()) {
			remove(sampleCollectionAttributeListsMaster);
		}
	}

	/**
	 * Returns the number of sample collection attribute lists masters.
	 *
	 * @return the number of sample collection attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SAMPLECOLLECTIONATTRIBUTELISTSMASTER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the sample collection attribute lists master persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.SampleCollectionAttributeListsMaster")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SampleCollectionAttributeListsMaster>> listenersList =
					new ArrayList<ModelListener<SampleCollectionAttributeListsMaster>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SampleCollectionAttributeListsMaster>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SampleCollectionAttributeListsMasterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTSMASTER =
		"SELECT sampleCollectionAttributeListsMaster FROM SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster";
	private static final String _SQL_COUNT_SAMPLECOLLECTIONATTRIBUTELISTSMASTER = "SELECT COUNT(sampleCollectionAttributeListsMaster) FROM SampleCollectionAttributeListsMaster sampleCollectionAttributeListsMaster";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sampleCollectionAttributeListsMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SampleCollectionAttributeListsMaster exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SampleCollectionAttributeListsMasterPersistenceImpl.class);
	private static SampleCollectionAttributeListsMaster _nullSampleCollectionAttributeListsMaster =
		new SampleCollectionAttributeListsMasterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SampleCollectionAttributeListsMaster> toCacheModel() {
				return _nullSampleCollectionAttributeListsMasterCacheModel;
			}
		};

	private static CacheModel<SampleCollectionAttributeListsMaster> _nullSampleCollectionAttributeListsMasterCacheModel =
		new CacheModel<SampleCollectionAttributeListsMaster>() {
			@Override
			public SampleCollectionAttributeListsMaster toEntityModel() {
				return _nullSampleCollectionAttributeListsMaster;
			}
		};
}