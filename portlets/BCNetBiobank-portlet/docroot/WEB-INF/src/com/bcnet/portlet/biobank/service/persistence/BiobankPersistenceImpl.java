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

import com.bcnet.portlet.biobank.NoSuchBiobankException;
import com.bcnet.portlet.biobank.model.Biobank;
import com.bcnet.portlet.biobank.model.impl.BiobankImpl;
import com.bcnet.portlet.biobank.model.impl.BiobankModelImpl;

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
 * The persistence implementation for the biobank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankPersistence
 * @see BiobankUtil
 * @generated
 */
public class BiobankPersistenceImpl extends BasePersistenceImpl<Biobank>
	implements BiobankPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BiobankUtil} to access the biobank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BiobankImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BiobankModelImpl.ENTITY_CACHE_ENABLED,
			BiobankModelImpl.FINDER_CACHE_ENABLED, BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BiobankModelImpl.ENTITY_CACHE_ENABLED,
			BiobankModelImpl.FINDER_CACHE_ENABLED, BiobankImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BiobankModelImpl.ENTITY_CACHE_ENABLED,
			BiobankModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BiobankPersistenceImpl() {
		setModelClass(Biobank.class);
	}

	/**
	 * Caches the biobank in the entity cache if it is enabled.
	 *
	 * @param biobank the biobank
	 */
	@Override
	public void cacheResult(Biobank biobank) {
		EntityCacheUtil.putResult(BiobankModelImpl.ENTITY_CACHE_ENABLED,
			BiobankImpl.class, biobank.getPrimaryKey(), biobank);

		biobank.resetOriginalValues();
	}

	/**
	 * Caches the biobanks in the entity cache if it is enabled.
	 *
	 * @param biobanks the biobanks
	 */
	@Override
	public void cacheResult(List<Biobank> biobanks) {
		for (Biobank biobank : biobanks) {
			if (EntityCacheUtil.getResult(
						BiobankModelImpl.ENTITY_CACHE_ENABLED,
						BiobankImpl.class, biobank.getPrimaryKey()) == null) {
				cacheResult(biobank);
			}
			else {
				biobank.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all biobanks.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BiobankImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BiobankImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the biobank.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Biobank biobank) {
		EntityCacheUtil.removeResult(BiobankModelImpl.ENTITY_CACHE_ENABLED,
			BiobankImpl.class, biobank.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Biobank> biobanks) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Biobank biobank : biobanks) {
			EntityCacheUtil.removeResult(BiobankModelImpl.ENTITY_CACHE_ENABLED,
				BiobankImpl.class, biobank.getPrimaryKey());
		}
	}

	/**
	 * Creates a new biobank with the primary key. Does not add the biobank to the database.
	 *
	 * @param biobankDbId the primary key for the new biobank
	 * @return the new biobank
	 */
	@Override
	public Biobank create(long biobankDbId) {
		Biobank biobank = new BiobankImpl();

		biobank.setNew(true);
		biobank.setPrimaryKey(biobankDbId);

		return biobank;
	}

	/**
	 * Removes the biobank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biobankDbId the primary key of the biobank
	 * @return the biobank that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankException if a biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Biobank remove(long biobankDbId)
		throws NoSuchBiobankException, SystemException {
		return remove((Serializable)biobankDbId);
	}

	/**
	 * Removes the biobank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the biobank
	 * @return the biobank that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankException if a biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Biobank remove(Serializable primaryKey)
		throws NoSuchBiobankException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Biobank biobank = (Biobank)session.get(BiobankImpl.class, primaryKey);

			if (biobank == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBiobankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(biobank);
		}
		catch (NoSuchBiobankException nsee) {
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
	protected Biobank removeImpl(Biobank biobank) throws SystemException {
		biobank = toUnwrappedModel(biobank);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(biobank)) {
				biobank = (Biobank)session.get(BiobankImpl.class,
						biobank.getPrimaryKeyObj());
			}

			if (biobank != null) {
				session.delete(biobank);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (biobank != null) {
			clearCache(biobank);
		}

		return biobank;
	}

	@Override
	public Biobank updateImpl(com.bcnet.portlet.biobank.model.Biobank biobank)
		throws SystemException {
		biobank = toUnwrappedModel(biobank);

		boolean isNew = biobank.isNew();

		Session session = null;

		try {
			session = openSession();

			if (biobank.isNew()) {
				session.save(biobank);

				biobank.setNew(false);
			}
			else {
				session.merge(biobank);
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

		EntityCacheUtil.putResult(BiobankModelImpl.ENTITY_CACHE_ENABLED,
			BiobankImpl.class, biobank.getPrimaryKey(), biobank);

		return biobank;
	}

	protected Biobank toUnwrappedModel(Biobank biobank) {
		if (biobank instanceof BiobankImpl) {
			return biobank;
		}

		BiobankImpl biobankImpl = new BiobankImpl();

		biobankImpl.setNew(biobank.isNew());
		biobankImpl.setPrimaryKey(biobank.getPrimaryKey());

		biobankImpl.setBiobankDbId(biobank.getBiobankDbId());
		biobankImpl.setBiobankId(biobank.getBiobankId());
		biobankImpl.setAcronym(biobank.getAcronym());
		biobankImpl.setName(biobank.getName());
		biobankImpl.setUrl(biobank.getUrl());
		biobankImpl.setJuristicPersonId(biobank.getJuristicPersonId());
		biobankImpl.setCountryCode(biobank.getCountryCode());
		biobankImpl.setDescription(biobank.getDescription());
		biobankImpl.setBackup(biobank.isBackup());
		biobankImpl.setTrainingCourses(biobank.isTrainingCourses());

		return biobankImpl;
	}

	/**
	 * Returns the biobank with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank
	 * @return the biobank
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankException if a biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Biobank findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBiobankException, SystemException {
		Biobank biobank = fetchByPrimaryKey(primaryKey);

		if (biobank == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBiobankException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return biobank;
	}

	/**
	 * Returns the biobank with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankException} if it could not be found.
	 *
	 * @param biobankDbId the primary key of the biobank
	 * @return the biobank
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankException if a biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Biobank findByPrimaryKey(long biobankDbId)
		throws NoSuchBiobankException, SystemException {
		return findByPrimaryKey((Serializable)biobankDbId);
	}

	/**
	 * Returns the biobank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank
	 * @return the biobank, or <code>null</code> if a biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Biobank fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Biobank biobank = (Biobank)EntityCacheUtil.getResult(BiobankModelImpl.ENTITY_CACHE_ENABLED,
				BiobankImpl.class, primaryKey);

		if (biobank == _nullBiobank) {
			return null;
		}

		if (biobank == null) {
			Session session = null;

			try {
				session = openSession();

				biobank = (Biobank)session.get(BiobankImpl.class, primaryKey);

				if (biobank != null) {
					cacheResult(biobank);
				}
				else {
					EntityCacheUtil.putResult(BiobankModelImpl.ENTITY_CACHE_ENABLED,
						BiobankImpl.class, primaryKey, _nullBiobank);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BiobankModelImpl.ENTITY_CACHE_ENABLED,
					BiobankImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return biobank;
	}

	/**
	 * Returns the biobank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biobankDbId the primary key of the biobank
	 * @return the biobank, or <code>null</code> if a biobank with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Biobank fetchByPrimaryKey(long biobankDbId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)biobankDbId);
	}

	/**
	 * Returns all the biobanks.
	 *
	 * @return the biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Biobank> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the biobanks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobanks
	 * @param end the upper bound of the range of biobanks (not inclusive)
	 * @return the range of biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Biobank> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the biobanks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobanks
	 * @param end the upper bound of the range of biobanks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of biobanks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Biobank> findAll(int start, int end,
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

		List<Biobank> list = (List<Biobank>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIOBANK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIOBANK;

				if (pagination) {
					sql = sql.concat(BiobankModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Biobank>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Biobank>(list);
				}
				else {
					list = (List<Biobank>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the biobanks from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Biobank biobank : findAll()) {
			remove(biobank);
		}
	}

	/**
	 * Returns the number of biobanks.
	 *
	 * @return the number of biobanks
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

				Query q = session.createQuery(_SQL_COUNT_BIOBANK);

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
	 * Initializes the biobank persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.Biobank")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Biobank>> listenersList = new ArrayList<ModelListener<Biobank>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Biobank>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BiobankImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIOBANK = "SELECT biobank FROM Biobank biobank";
	private static final String _SQL_COUNT_BIOBANK = "SELECT COUNT(biobank) FROM Biobank biobank";
	private static final String _ORDER_BY_ENTITY_ALIAS = "biobank.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Biobank exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BiobankPersistenceImpl.class);
	private static Biobank _nullBiobank = new BiobankImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Biobank> toCacheModel() {
				return _nullBiobankCacheModel;
			}
		};

	private static CacheModel<Biobank> _nullBiobankCacheModel = new CacheModel<Biobank>() {
			@Override
			public Biobank toEntityModel() {
				return _nullBiobank;
			}
		};
}