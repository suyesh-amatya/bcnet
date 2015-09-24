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

package com.rdconnect.org.idcardmolgenis.service.persistence;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException;
import com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis;
import com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisImpl;
import com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the r d connect i d card molgenis service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyeshamatya
 * @see RDConnectIDCardMolgenisPersistence
 * @see RDConnectIDCardMolgenisUtil
 * @generated
 */
public class RDConnectIDCardMolgenisPersistenceImpl extends BasePersistenceImpl<RDConnectIDCardMolgenis>
	implements RDConnectIDCardMolgenisPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RDConnectIDCardMolgenisUtil} to access the r d connect i d card molgenis persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RDConnectIDCardMolgenisImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectIDCardMolgenisModelImpl.FINDER_CACHE_ENABLED,
			RDConnectIDCardMolgenisImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectIDCardMolgenisModelImpl.FINDER_CACHE_ENABLED,
			RDConnectIDCardMolgenisImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectIDCardMolgenisModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RDConnectIDCardMolgenisPersistenceImpl() {
		setModelClass(RDConnectIDCardMolgenis.class);
	}

	/**
	 * Caches the r d connect i d card molgenis in the entity cache if it is enabled.
	 *
	 * @param rdConnectIDCardMolgenis the r d connect i d card molgenis
	 */
	@Override
	public void cacheResult(RDConnectIDCardMolgenis rdConnectIDCardMolgenis) {
		EntityCacheUtil.putResult(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectIDCardMolgenisImpl.class,
			rdConnectIDCardMolgenis.getPrimaryKey(), rdConnectIDCardMolgenis);

		rdConnectIDCardMolgenis.resetOriginalValues();
	}

	/**
	 * Caches the r d connect i d card molgenises in the entity cache if it is enabled.
	 *
	 * @param rdConnectIDCardMolgenises the r d connect i d card molgenises
	 */
	@Override
	public void cacheResult(
		List<RDConnectIDCardMolgenis> rdConnectIDCardMolgenises) {
		for (RDConnectIDCardMolgenis rdConnectIDCardMolgenis : rdConnectIDCardMolgenises) {
			if (EntityCacheUtil.getResult(
						RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
						RDConnectIDCardMolgenisImpl.class,
						rdConnectIDCardMolgenis.getPrimaryKey()) == null) {
				cacheResult(rdConnectIDCardMolgenis);
			}
			else {
				rdConnectIDCardMolgenis.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all r d connect i d card molgenises.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RDConnectIDCardMolgenisImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RDConnectIDCardMolgenisImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the r d connect i d card molgenis.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RDConnectIDCardMolgenis rdConnectIDCardMolgenis) {
		EntityCacheUtil.removeResult(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectIDCardMolgenisImpl.class,
			rdConnectIDCardMolgenis.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<RDConnectIDCardMolgenis> rdConnectIDCardMolgenises) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RDConnectIDCardMolgenis rdConnectIDCardMolgenis : rdConnectIDCardMolgenises) {
			EntityCacheUtil.removeResult(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
				RDConnectIDCardMolgenisImpl.class,
				rdConnectIDCardMolgenis.getPrimaryKey());
		}
	}

	/**
	 * Creates a new r d connect i d card molgenis with the primary key. Does not add the r d connect i d card molgenis to the database.
	 *
	 * @param id the primary key for the new r d connect i d card molgenis
	 * @return the new r d connect i d card molgenis
	 */
	@Override
	public RDConnectIDCardMolgenis create(long id) {
		RDConnectIDCardMolgenis rdConnectIDCardMolgenis = new RDConnectIDCardMolgenisImpl();

		rdConnectIDCardMolgenis.setNew(true);
		rdConnectIDCardMolgenis.setPrimaryKey(id);

		return rdConnectIDCardMolgenis;
	}

	/**
	 * Removes the r d connect i d card molgenis with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the r d connect i d card molgenis
	 * @return the r d connect i d card molgenis that was removed
	 * @throws com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException if a r d connect i d card molgenis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectIDCardMolgenis remove(long id)
		throws NoSuchRDConnectIDCardMolgenisException, SystemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the r d connect i d card molgenis with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the r d connect i d card molgenis
	 * @return the r d connect i d card molgenis that was removed
	 * @throws com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException if a r d connect i d card molgenis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectIDCardMolgenis remove(Serializable primaryKey)
		throws NoSuchRDConnectIDCardMolgenisException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RDConnectIDCardMolgenis rdConnectIDCardMolgenis = (RDConnectIDCardMolgenis)session.get(RDConnectIDCardMolgenisImpl.class,
					primaryKey);

			if (rdConnectIDCardMolgenis == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRDConnectIDCardMolgenisException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rdConnectIDCardMolgenis);
		}
		catch (NoSuchRDConnectIDCardMolgenisException nsee) {
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
	protected RDConnectIDCardMolgenis removeImpl(
		RDConnectIDCardMolgenis rdConnectIDCardMolgenis)
		throws SystemException {
		rdConnectIDCardMolgenis = toUnwrappedModel(rdConnectIDCardMolgenis);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rdConnectIDCardMolgenis)) {
				rdConnectIDCardMolgenis = (RDConnectIDCardMolgenis)session.get(RDConnectIDCardMolgenisImpl.class,
						rdConnectIDCardMolgenis.getPrimaryKeyObj());
			}

			if (rdConnectIDCardMolgenis != null) {
				session.delete(rdConnectIDCardMolgenis);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rdConnectIDCardMolgenis != null) {
			clearCache(rdConnectIDCardMolgenis);
		}

		return rdConnectIDCardMolgenis;
	}

	@Override
	public RDConnectIDCardMolgenis updateImpl(
		com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis rdConnectIDCardMolgenis)
		throws SystemException {
		rdConnectIDCardMolgenis = toUnwrappedModel(rdConnectIDCardMolgenis);

		boolean isNew = rdConnectIDCardMolgenis.isNew();

		Session session = null;

		try {
			session = openSession();

			if (rdConnectIDCardMolgenis.isNew()) {
				session.save(rdConnectIDCardMolgenis);

				rdConnectIDCardMolgenis.setNew(false);
			}
			else {
				session.merge(rdConnectIDCardMolgenis);
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

		EntityCacheUtil.putResult(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
			RDConnectIDCardMolgenisImpl.class,
			rdConnectIDCardMolgenis.getPrimaryKey(), rdConnectIDCardMolgenis);

		return rdConnectIDCardMolgenis;
	}

	protected RDConnectIDCardMolgenis toUnwrappedModel(
		RDConnectIDCardMolgenis rdConnectIDCardMolgenis) {
		if (rdConnectIDCardMolgenis instanceof RDConnectIDCardMolgenisImpl) {
			return rdConnectIDCardMolgenis;
		}

		RDConnectIDCardMolgenisImpl rdConnectIDCardMolgenisImpl = new RDConnectIDCardMolgenisImpl();

		rdConnectIDCardMolgenisImpl.setNew(rdConnectIDCardMolgenis.isNew());
		rdConnectIDCardMolgenisImpl.setPrimaryKey(rdConnectIDCardMolgenis.getPrimaryKey());

		rdConnectIDCardMolgenisImpl.setId(rdConnectIDCardMolgenis.getId());

		return rdConnectIDCardMolgenisImpl;
	}

	/**
	 * Returns the r d connect i d card molgenis with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d connect i d card molgenis
	 * @return the r d connect i d card molgenis
	 * @throws com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException if a r d connect i d card molgenis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectIDCardMolgenis findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRDConnectIDCardMolgenisException, SystemException {
		RDConnectIDCardMolgenis rdConnectIDCardMolgenis = fetchByPrimaryKey(primaryKey);

		if (rdConnectIDCardMolgenis == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRDConnectIDCardMolgenisException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rdConnectIDCardMolgenis;
	}

	/**
	 * Returns the r d connect i d card molgenis with the primary key or throws a {@link com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException} if it could not be found.
	 *
	 * @param id the primary key of the r d connect i d card molgenis
	 * @return the r d connect i d card molgenis
	 * @throws com.rdconnect.org.idcardmolgenis.NoSuchRDConnectIDCardMolgenisException if a r d connect i d card molgenis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectIDCardMolgenis findByPrimaryKey(long id)
		throws NoSuchRDConnectIDCardMolgenisException, SystemException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the r d connect i d card molgenis with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the r d connect i d card molgenis
	 * @return the r d connect i d card molgenis, or <code>null</code> if a r d connect i d card molgenis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectIDCardMolgenis fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RDConnectIDCardMolgenis rdConnectIDCardMolgenis = (RDConnectIDCardMolgenis)EntityCacheUtil.getResult(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
				RDConnectIDCardMolgenisImpl.class, primaryKey);

		if (rdConnectIDCardMolgenis == _nullRDConnectIDCardMolgenis) {
			return null;
		}

		if (rdConnectIDCardMolgenis == null) {
			Session session = null;

			try {
				session = openSession();

				rdConnectIDCardMolgenis = (RDConnectIDCardMolgenis)session.get(RDConnectIDCardMolgenisImpl.class,
						primaryKey);

				if (rdConnectIDCardMolgenis != null) {
					cacheResult(rdConnectIDCardMolgenis);
				}
				else {
					EntityCacheUtil.putResult(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
						RDConnectIDCardMolgenisImpl.class, primaryKey,
						_nullRDConnectIDCardMolgenis);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RDConnectIDCardMolgenisModelImpl.ENTITY_CACHE_ENABLED,
					RDConnectIDCardMolgenisImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rdConnectIDCardMolgenis;
	}

	/**
	 * Returns the r d connect i d card molgenis with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the r d connect i d card molgenis
	 * @return the r d connect i d card molgenis, or <code>null</code> if a r d connect i d card molgenis with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RDConnectIDCardMolgenis fetchByPrimaryKey(long id)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the r d connect i d card molgenises.
	 *
	 * @return the r d connect i d card molgenises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectIDCardMolgenis> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the r d connect i d card molgenises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d connect i d card molgenises
	 * @param end the upper bound of the range of r d connect i d card molgenises (not inclusive)
	 * @return the range of r d connect i d card molgenises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectIDCardMolgenis> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the r d connect i d card molgenises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rdconnect.org.idcardmolgenis.model.impl.RDConnectIDCardMolgenisModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of r d connect i d card molgenises
	 * @param end the upper bound of the range of r d connect i d card molgenises (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of r d connect i d card molgenises
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RDConnectIDCardMolgenis> findAll(int start, int end,
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

		List<RDConnectIDCardMolgenis> list = (List<RDConnectIDCardMolgenis>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RDCONNECTIDCARDMOLGENIS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RDCONNECTIDCARDMOLGENIS;

				if (pagination) {
					sql = sql.concat(RDConnectIDCardMolgenisModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RDConnectIDCardMolgenis>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RDConnectIDCardMolgenis>(list);
				}
				else {
					list = (List<RDConnectIDCardMolgenis>)QueryUtil.list(q,
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
	 * Removes all the r d connect i d card molgenises from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RDConnectIDCardMolgenis rdConnectIDCardMolgenis : findAll()) {
			remove(rdConnectIDCardMolgenis);
		}
	}

	/**
	 * Returns the number of r d connect i d card molgenises.
	 *
	 * @return the number of r d connect i d card molgenises
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

				Query q = session.createQuery(_SQL_COUNT_RDCONNECTIDCARDMOLGENIS);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the r d connect i d card molgenis persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rdconnect.org.idcardmolgenis.model.RDConnectIDCardMolgenis")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RDConnectIDCardMolgenis>> listenersList = new ArrayList<ModelListener<RDConnectIDCardMolgenis>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RDConnectIDCardMolgenis>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RDConnectIDCardMolgenisImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RDCONNECTIDCARDMOLGENIS = "SELECT rdConnectIDCardMolgenis FROM RDConnectIDCardMolgenis rdConnectIDCardMolgenis";
	private static final String _SQL_COUNT_RDCONNECTIDCARDMOLGENIS = "SELECT COUNT(rdConnectIDCardMolgenis) FROM RDConnectIDCardMolgenis rdConnectIDCardMolgenis";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rdConnectIDCardMolgenis.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RDConnectIDCardMolgenis exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RDConnectIDCardMolgenisPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
	private static RDConnectIDCardMolgenis _nullRDConnectIDCardMolgenis = new RDConnectIDCardMolgenisImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RDConnectIDCardMolgenis> toCacheModel() {
				return _nullRDConnectIDCardMolgenisCacheModel;
			}
		};

	private static CacheModel<RDConnectIDCardMolgenis> _nullRDConnectIDCardMolgenisCacheModel =
		new CacheModel<RDConnectIDCardMolgenis>() {
			@Override
			public RDConnectIDCardMolgenis toEntityModel() {
				return _nullRDConnectIDCardMolgenis;
			}
		};
}