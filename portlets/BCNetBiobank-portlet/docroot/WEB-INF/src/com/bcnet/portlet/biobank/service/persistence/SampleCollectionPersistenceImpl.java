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

import com.bcnet.portlet.biobank.NoSuchSampleCollectionException;
import com.bcnet.portlet.biobank.model.SampleCollection;
import com.bcnet.portlet.biobank.model.impl.SampleCollectionImpl;
import com.bcnet.portlet.biobank.model.impl.SampleCollectionModelImpl;

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
 * The persistence implementation for the sample collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionPersistence
 * @see SampleCollectionUtil
 * @generated
 */
public class SampleCollectionPersistenceImpl extends BasePersistenceImpl<SampleCollection>
	implements SampleCollectionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SampleCollectionUtil} to access the sample collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SampleCollectionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SampleCollectionPersistenceImpl() {
		setModelClass(SampleCollection.class);
	}

	/**
	 * Caches the sample collection in the entity cache if it is enabled.
	 *
	 * @param sampleCollection the sample collection
	 */
	@Override
	public void cacheResult(SampleCollection sampleCollection) {
		EntityCacheUtil.putResult(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionImpl.class, sampleCollection.getPrimaryKey(),
			sampleCollection);

		sampleCollection.resetOriginalValues();
	}

	/**
	 * Caches the sample collections in the entity cache if it is enabled.
	 *
	 * @param sampleCollections the sample collections
	 */
	@Override
	public void cacheResult(List<SampleCollection> sampleCollections) {
		for (SampleCollection sampleCollection : sampleCollections) {
			if (EntityCacheUtil.getResult(
						SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
						SampleCollectionImpl.class,
						sampleCollection.getPrimaryKey()) == null) {
				cacheResult(sampleCollection);
			}
			else {
				sampleCollection.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sample collections.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SampleCollectionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SampleCollectionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample collection.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SampleCollection sampleCollection) {
		EntityCacheUtil.removeResult(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionImpl.class, sampleCollection.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SampleCollection> sampleCollections) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SampleCollection sampleCollection : sampleCollections) {
			EntityCacheUtil.removeResult(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
				SampleCollectionImpl.class, sampleCollection.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sample collection with the primary key. Does not add the sample collection to the database.
	 *
	 * @param sampleCollectionDbId the primary key for the new sample collection
	 * @return the new sample collection
	 */
	@Override
	public SampleCollection create(long sampleCollectionDbId) {
		SampleCollection sampleCollection = new SampleCollectionImpl();

		sampleCollection.setNew(true);
		sampleCollection.setPrimaryKey(sampleCollectionDbId);

		return sampleCollection;
	}

	/**
	 * Removes the sample collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleCollectionDbId the primary key of the sample collection
	 * @return the sample collection that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionException if a sample collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollection remove(long sampleCollectionDbId)
		throws NoSuchSampleCollectionException, SystemException {
		return remove((Serializable)sampleCollectionDbId);
	}

	/**
	 * Removes the sample collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample collection
	 * @return the sample collection that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionException if a sample collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollection remove(Serializable primaryKey)
		throws NoSuchSampleCollectionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SampleCollection sampleCollection = (SampleCollection)session.get(SampleCollectionImpl.class,
					primaryKey);

			if (sampleCollection == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSampleCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sampleCollection);
		}
		catch (NoSuchSampleCollectionException nsee) {
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
	protected SampleCollection removeImpl(SampleCollection sampleCollection)
		throws SystemException {
		sampleCollection = toUnwrappedModel(sampleCollection);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sampleCollection)) {
				sampleCollection = (SampleCollection)session.get(SampleCollectionImpl.class,
						sampleCollection.getPrimaryKeyObj());
			}

			if (sampleCollection != null) {
				session.delete(sampleCollection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sampleCollection != null) {
			clearCache(sampleCollection);
		}

		return sampleCollection;
	}

	@Override
	public SampleCollection updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollection sampleCollection)
		throws SystemException {
		sampleCollection = toUnwrappedModel(sampleCollection);

		boolean isNew = sampleCollection.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sampleCollection.isNew()) {
				session.save(sampleCollection);

				sampleCollection.setNew(false);
			}
			else {
				session.merge(sampleCollection);
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

		EntityCacheUtil.putResult(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionImpl.class, sampleCollection.getPrimaryKey(),
			sampleCollection);

		return sampleCollection;
	}

	protected SampleCollection toUnwrappedModel(
		SampleCollection sampleCollection) {
		if (sampleCollection instanceof SampleCollectionImpl) {
			return sampleCollection;
		}

		SampleCollectionImpl sampleCollectionImpl = new SampleCollectionImpl();

		sampleCollectionImpl.setNew(sampleCollection.isNew());
		sampleCollectionImpl.setPrimaryKey(sampleCollection.getPrimaryKey());

		sampleCollectionImpl.setSampleCollectionDbId(sampleCollection.getSampleCollectionDbId());
		sampleCollectionImpl.setSampleCollectionId(sampleCollection.getSampleCollectionId());
		sampleCollectionImpl.setAcronym(sampleCollection.getAcronym());
		sampleCollectionImpl.setName(sampleCollection.getName());
		sampleCollectionImpl.setDescription(sampleCollection.getDescription());
		sampleCollectionImpl.setConsentTemplate(sampleCollection.isConsentTemplate());
		sampleCollectionImpl.setReuseOfSamples(sampleCollection.isReuseOfSamples());
		sampleCollectionImpl.setMaterialTransferAgreement(sampleCollection.isMaterialTransferAgreement());
		sampleCollectionImpl.setAccreditation(sampleCollection.isAccreditation());
		sampleCollectionImpl.setQualityControl(sampleCollection.isQualityControl());

		return sampleCollectionImpl;
	}

	/**
	 * Returns the sample collection with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample collection
	 * @return the sample collection
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionException if a sample collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollection findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSampleCollectionException, SystemException {
		SampleCollection sampleCollection = fetchByPrimaryKey(primaryKey);

		if (sampleCollection == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSampleCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sampleCollection;
	}

	/**
	 * Returns the sample collection with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionException} if it could not be found.
	 *
	 * @param sampleCollectionDbId the primary key of the sample collection
	 * @return the sample collection
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionException if a sample collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollection findByPrimaryKey(long sampleCollectionDbId)
		throws NoSuchSampleCollectionException, SystemException {
		return findByPrimaryKey((Serializable)sampleCollectionDbId);
	}

	/**
	 * Returns the sample collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample collection
	 * @return the sample collection, or <code>null</code> if a sample collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollection fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SampleCollection sampleCollection = (SampleCollection)EntityCacheUtil.getResult(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
				SampleCollectionImpl.class, primaryKey);

		if (sampleCollection == _nullSampleCollection) {
			return null;
		}

		if (sampleCollection == null) {
			Session session = null;

			try {
				session = openSession();

				sampleCollection = (SampleCollection)session.get(SampleCollectionImpl.class,
						primaryKey);

				if (sampleCollection != null) {
					cacheResult(sampleCollection);
				}
				else {
					EntityCacheUtil.putResult(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
						SampleCollectionImpl.class, primaryKey,
						_nullSampleCollection);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SampleCollectionModelImpl.ENTITY_CACHE_ENABLED,
					SampleCollectionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sampleCollection;
	}

	/**
	 * Returns the sample collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleCollectionDbId the primary key of the sample collection
	 * @return the sample collection, or <code>null</code> if a sample collection with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollection fetchByPrimaryKey(long sampleCollectionDbId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)sampleCollectionDbId);
	}

	/**
	 * Returns all the sample collections.
	 *
	 * @return the sample collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollection> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample collections
	 * @param end the upper bound of the range of sample collections (not inclusive)
	 * @return the range of sample collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollection> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample collections.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample collections
	 * @param end the upper bound of the range of sample collections (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sample collections
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollection> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<SampleCollection> list = (List<SampleCollection>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMPLECOLLECTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLECOLLECTION;

				if (pagination) {
					sql = sql.concat(SampleCollectionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SampleCollection>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SampleCollection>(list);
				}
				else {
					list = (List<SampleCollection>)QueryUtil.list(q,
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
	 * Removes all the sample collections from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SampleCollection sampleCollection : findAll()) {
			remove(sampleCollection);
		}
	}

	/**
	 * Returns the number of sample collections.
	 *
	 * @return the number of sample collections
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

				Query q = session.createQuery(_SQL_COUNT_SAMPLECOLLECTION);

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
	 * Initializes the sample collection persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.SampleCollection")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SampleCollection>> listenersList = new ArrayList<ModelListener<SampleCollection>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SampleCollection>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SampleCollectionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SAMPLECOLLECTION = "SELECT sampleCollection FROM SampleCollection sampleCollection";
	private static final String _SQL_COUNT_SAMPLECOLLECTION = "SELECT COUNT(sampleCollection) FROM SampleCollection sampleCollection";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sampleCollection.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SampleCollection exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SampleCollectionPersistenceImpl.class);
	private static SampleCollection _nullSampleCollection = new SampleCollectionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SampleCollection> toCacheModel() {
				return _nullSampleCollectionCacheModel;
			}
		};

	private static CacheModel<SampleCollection> _nullSampleCollectionCacheModel = new CacheModel<SampleCollection>() {
			@Override
			public SampleCollection toEntityModel() {
				return _nullSampleCollection;
			}
		};
}