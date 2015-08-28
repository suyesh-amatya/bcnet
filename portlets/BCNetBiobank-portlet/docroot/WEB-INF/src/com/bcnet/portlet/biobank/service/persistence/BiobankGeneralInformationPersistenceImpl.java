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

import com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException;
import com.bcnet.portlet.biobank.model.BiobankGeneralInformation;
import com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationImpl;
import com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the biobank general information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankGeneralInformationPersistence
 * @see BiobankGeneralInformationUtil
 * @generated
 */
public class BiobankGeneralInformationPersistenceImpl
	extends BasePersistenceImpl<BiobankGeneralInformation>
	implements BiobankGeneralInformationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BiobankGeneralInformationUtil} to access the biobank general information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BiobankGeneralInformationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			BiobankGeneralInformationModelImpl.FINDER_CACHE_ENABLED,
			BiobankGeneralInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			BiobankGeneralInformationModelImpl.FINDER_CACHE_ENABLED,
			BiobankGeneralInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			BiobankGeneralInformationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_BIOBANKID = new FinderPath(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			BiobankGeneralInformationModelImpl.FINDER_CACHE_ENABLED,
			BiobankGeneralInformationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBybiobankId", new String[] { String.class.getName() },
			BiobankGeneralInformationModelImpl.BIOBANKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BIOBANKID = new FinderPath(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			BiobankGeneralInformationModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybiobankId", new String[] { String.class.getName() });

	/**
	 * Returns the biobank general information where biobankId = &#63; or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException} if it could not be found.
	 *
	 * @param biobankId the biobank ID
	 * @return the matching biobank general information
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException if a matching biobank general information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation findBybiobankId(String biobankId)
		throws NoSuchBiobankGeneralInformationException, SystemException {
		BiobankGeneralInformation biobankGeneralInformation = fetchBybiobankId(biobankId);

		if (biobankGeneralInformation == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("biobankId=");
			msg.append(biobankId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBiobankGeneralInformationException(msg.toString());
		}

		return biobankGeneralInformation;
	}

	/**
	 * Returns the biobank general information where biobankId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param biobankId the biobank ID
	 * @return the matching biobank general information, or <code>null</code> if a matching biobank general information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation fetchBybiobankId(String biobankId)
		throws SystemException {
		return fetchBybiobankId(biobankId, true);
	}

	/**
	 * Returns the biobank general information where biobankId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param biobankId the biobank ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching biobank general information, or <code>null</code> if a matching biobank general information could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation fetchBybiobankId(String biobankId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { biobankId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_BIOBANKID,
					finderArgs, this);
		}

		if (result instanceof BiobankGeneralInformation) {
			BiobankGeneralInformation biobankGeneralInformation = (BiobankGeneralInformation)result;

			if (!Validator.equals(biobankId,
						biobankGeneralInformation.getBiobankId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BIOBANKGENERALINFORMATION_WHERE);

			boolean bindBiobankId = false;

			if (biobankId == null) {
				query.append(_FINDER_COLUMN_BIOBANKID_BIOBANKID_1);
			}
			else if (biobankId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKID_BIOBANKID_3);
			}
			else {
				bindBiobankId = true;

				query.append(_FINDER_COLUMN_BIOBANKID_BIOBANKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBiobankId) {
					qPos.add(biobankId);
				}

				List<BiobankGeneralInformation> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BiobankGeneralInformationPersistenceImpl.fetchBybiobankId(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BiobankGeneralInformation biobankGeneralInformation = list.get(0);

					result = biobankGeneralInformation;

					cacheResult(biobankGeneralInformation);

					if ((biobankGeneralInformation.getBiobankId() == null) ||
							!biobankGeneralInformation.getBiobankId()
														  .equals(biobankId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKID,
							finderArgs, biobankGeneralInformation);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (BiobankGeneralInformation)result;
		}
	}

	/**
	 * Removes the biobank general information where biobankId = &#63; from the database.
	 *
	 * @param biobankId the biobank ID
	 * @return the biobank general information that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation removeBybiobankId(String biobankId)
		throws NoSuchBiobankGeneralInformationException, SystemException {
		BiobankGeneralInformation biobankGeneralInformation = findBybiobankId(biobankId);

		return remove(biobankGeneralInformation);
	}

	/**
	 * Returns the number of biobank general informations where biobankId = &#63;.
	 *
	 * @param biobankId the biobank ID
	 * @return the number of matching biobank general informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBybiobankId(String biobankId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BIOBANKID;

		Object[] finderArgs = new Object[] { biobankId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIOBANKGENERALINFORMATION_WHERE);

			boolean bindBiobankId = false;

			if (biobankId == null) {
				query.append(_FINDER_COLUMN_BIOBANKID_BIOBANKID_1);
			}
			else if (biobankId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BIOBANKID_BIOBANKID_3);
			}
			else {
				bindBiobankId = true;

				query.append(_FINDER_COLUMN_BIOBANKID_BIOBANKID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBiobankId) {
					qPos.add(biobankId);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BIOBANKID_BIOBANKID_1 = "biobankGeneralInformation.biobankId IS NULL";
	private static final String _FINDER_COLUMN_BIOBANKID_BIOBANKID_2 = "biobankGeneralInformation.biobankId = ?";
	private static final String _FINDER_COLUMN_BIOBANKID_BIOBANKID_3 = "(biobankGeneralInformation.biobankId IS NULL OR biobankGeneralInformation.biobankId = '')";

	public BiobankGeneralInformationPersistenceImpl() {
		setModelClass(BiobankGeneralInformation.class);
	}

	/**
	 * Caches the biobank general information in the entity cache if it is enabled.
	 *
	 * @param biobankGeneralInformation the biobank general information
	 */
	@Override
	public void cacheResult(BiobankGeneralInformation biobankGeneralInformation) {
		EntityCacheUtil.putResult(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			BiobankGeneralInformationImpl.class,
			biobankGeneralInformation.getPrimaryKey(), biobankGeneralInformation);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKID,
			new Object[] { biobankGeneralInformation.getBiobankId() },
			biobankGeneralInformation);

		biobankGeneralInformation.resetOriginalValues();
	}

	/**
	 * Caches the biobank general informations in the entity cache if it is enabled.
	 *
	 * @param biobankGeneralInformations the biobank general informations
	 */
	@Override
	public void cacheResult(
		List<BiobankGeneralInformation> biobankGeneralInformations) {
		for (BiobankGeneralInformation biobankGeneralInformation : biobankGeneralInformations) {
			if (EntityCacheUtil.getResult(
						BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
						BiobankGeneralInformationImpl.class,
						biobankGeneralInformation.getPrimaryKey()) == null) {
				cacheResult(biobankGeneralInformation);
			}
			else {
				biobankGeneralInformation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all biobank general informations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BiobankGeneralInformationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BiobankGeneralInformationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the biobank general information.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BiobankGeneralInformation biobankGeneralInformation) {
		EntityCacheUtil.removeResult(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			BiobankGeneralInformationImpl.class,
			biobankGeneralInformation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(biobankGeneralInformation);
	}

	@Override
	public void clearCache(
		List<BiobankGeneralInformation> biobankGeneralInformations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BiobankGeneralInformation biobankGeneralInformation : biobankGeneralInformations) {
			EntityCacheUtil.removeResult(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
				BiobankGeneralInformationImpl.class,
				biobankGeneralInformation.getPrimaryKey());

			clearUniqueFindersCache(biobankGeneralInformation);
		}
	}

	protected void cacheUniqueFindersCache(
		BiobankGeneralInformation biobankGeneralInformation) {
		if (biobankGeneralInformation.isNew()) {
			Object[] args = new Object[] {
					biobankGeneralInformation.getBiobankId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BIOBANKID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKID, args,
				biobankGeneralInformation);
		}
		else {
			BiobankGeneralInformationModelImpl biobankGeneralInformationModelImpl =
				(BiobankGeneralInformationModelImpl)biobankGeneralInformation;

			if ((biobankGeneralInformationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_BIOBANKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						biobankGeneralInformation.getBiobankId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BIOBANKID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_BIOBANKID, args,
					biobankGeneralInformation);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BiobankGeneralInformation biobankGeneralInformation) {
		BiobankGeneralInformationModelImpl biobankGeneralInformationModelImpl = (BiobankGeneralInformationModelImpl)biobankGeneralInformation;

		Object[] args = new Object[] { biobankGeneralInformation.getBiobankId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKID, args);

		if ((biobankGeneralInformationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_BIOBANKID.getColumnBitmask()) != 0) {
			args = new Object[] {
					biobankGeneralInformationModelImpl.getOriginalBiobankId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BIOBANKID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_BIOBANKID, args);
		}
	}

	/**
	 * Creates a new biobank general information with the primary key. Does not add the biobank general information to the database.
	 *
	 * @param biobankDbId the primary key for the new biobank general information
	 * @return the new biobank general information
	 */
	@Override
	public BiobankGeneralInformation create(long biobankDbId) {
		BiobankGeneralInformation biobankGeneralInformation = new BiobankGeneralInformationImpl();

		biobankGeneralInformation.setNew(true);
		biobankGeneralInformation.setPrimaryKey(biobankDbId);

		return biobankGeneralInformation;
	}

	/**
	 * Removes the biobank general information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biobankDbId the primary key of the biobank general information
	 * @return the biobank general information that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException if a biobank general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation remove(long biobankDbId)
		throws NoSuchBiobankGeneralInformationException, SystemException {
		return remove((Serializable)biobankDbId);
	}

	/**
	 * Removes the biobank general information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the biobank general information
	 * @return the biobank general information that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException if a biobank general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation remove(Serializable primaryKey)
		throws NoSuchBiobankGeneralInformationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BiobankGeneralInformation biobankGeneralInformation = (BiobankGeneralInformation)session.get(BiobankGeneralInformationImpl.class,
					primaryKey);

			if (biobankGeneralInformation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBiobankGeneralInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(biobankGeneralInformation);
		}
		catch (NoSuchBiobankGeneralInformationException nsee) {
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
	protected BiobankGeneralInformation removeImpl(
		BiobankGeneralInformation biobankGeneralInformation)
		throws SystemException {
		biobankGeneralInformation = toUnwrappedModel(biobankGeneralInformation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(biobankGeneralInformation)) {
				biobankGeneralInformation = (BiobankGeneralInformation)session.get(BiobankGeneralInformationImpl.class,
						biobankGeneralInformation.getPrimaryKeyObj());
			}

			if (biobankGeneralInformation != null) {
				session.delete(biobankGeneralInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (biobankGeneralInformation != null) {
			clearCache(biobankGeneralInformation);
		}

		return biobankGeneralInformation;
	}

	@Override
	public BiobankGeneralInformation updateImpl(
		com.bcnet.portlet.biobank.model.BiobankGeneralInformation biobankGeneralInformation)
		throws SystemException {
		biobankGeneralInformation = toUnwrappedModel(biobankGeneralInformation);

		boolean isNew = biobankGeneralInformation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (biobankGeneralInformation.isNew()) {
				session.save(biobankGeneralInformation);

				biobankGeneralInformation.setNew(false);
			}
			else {
				session.merge(biobankGeneralInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!BiobankGeneralInformationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
			BiobankGeneralInformationImpl.class,
			biobankGeneralInformation.getPrimaryKey(), biobankGeneralInformation);

		clearUniqueFindersCache(biobankGeneralInformation);
		cacheUniqueFindersCache(biobankGeneralInformation);

		return biobankGeneralInformation;
	}

	protected BiobankGeneralInformation toUnwrappedModel(
		BiobankGeneralInformation biobankGeneralInformation) {
		if (biobankGeneralInformation instanceof BiobankGeneralInformationImpl) {
			return biobankGeneralInformation;
		}

		BiobankGeneralInformationImpl biobankGeneralInformationImpl = new BiobankGeneralInformationImpl();

		biobankGeneralInformationImpl.setNew(biobankGeneralInformation.isNew());
		biobankGeneralInformationImpl.setPrimaryKey(biobankGeneralInformation.getPrimaryKey());

		biobankGeneralInformationImpl.setBiobankDbId(biobankGeneralInformation.getBiobankDbId());
		biobankGeneralInformationImpl.setBiobankId(biobankGeneralInformation.getBiobankId());
		biobankGeneralInformationImpl.setAcronym(biobankGeneralInformation.getAcronym());
		biobankGeneralInformationImpl.setUrl(biobankGeneralInformation.getUrl());
		biobankGeneralInformationImpl.setJuristicPersonId(biobankGeneralInformation.getJuristicPersonId());
		biobankGeneralInformationImpl.setCountryCode(biobankGeneralInformation.getCountryCode());
		biobankGeneralInformationImpl.setDescription(biobankGeneralInformation.getDescription());
		biobankGeneralInformationImpl.setBackup(biobankGeneralInformation.isBackup());
		biobankGeneralInformationImpl.setTrainingCourses(biobankGeneralInformation.isTrainingCourses());

		return biobankGeneralInformationImpl;
	}

	/**
	 * Returns the biobank general information with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank general information
	 * @return the biobank general information
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException if a biobank general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBiobankGeneralInformationException, SystemException {
		BiobankGeneralInformation biobankGeneralInformation = fetchByPrimaryKey(primaryKey);

		if (biobankGeneralInformation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBiobankGeneralInformationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return biobankGeneralInformation;
	}

	/**
	 * Returns the biobank general information with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException} if it could not be found.
	 *
	 * @param biobankDbId the primary key of the biobank general information
	 * @return the biobank general information
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankGeneralInformationException if a biobank general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation findByPrimaryKey(long biobankDbId)
		throws NoSuchBiobankGeneralInformationException, SystemException {
		return findByPrimaryKey((Serializable)biobankDbId);
	}

	/**
	 * Returns the biobank general information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank general information
	 * @return the biobank general information, or <code>null</code> if a biobank general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BiobankGeneralInformation biobankGeneralInformation = (BiobankGeneralInformation)EntityCacheUtil.getResult(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
				BiobankGeneralInformationImpl.class, primaryKey);

		if (biobankGeneralInformation == _nullBiobankGeneralInformation) {
			return null;
		}

		if (biobankGeneralInformation == null) {
			Session session = null;

			try {
				session = openSession();

				biobankGeneralInformation = (BiobankGeneralInformation)session.get(BiobankGeneralInformationImpl.class,
						primaryKey);

				if (biobankGeneralInformation != null) {
					cacheResult(biobankGeneralInformation);
				}
				else {
					EntityCacheUtil.putResult(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
						BiobankGeneralInformationImpl.class, primaryKey,
						_nullBiobankGeneralInformation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BiobankGeneralInformationModelImpl.ENTITY_CACHE_ENABLED,
					BiobankGeneralInformationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return biobankGeneralInformation;
	}

	/**
	 * Returns the biobank general information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biobankDbId the primary key of the biobank general information
	 * @return the biobank general information, or <code>null</code> if a biobank general information with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankGeneralInformation fetchByPrimaryKey(long biobankDbId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)biobankDbId);
	}

	/**
	 * Returns all the biobank general informations.
	 *
	 * @return the biobank general informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankGeneralInformation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the biobank general informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobank general informations
	 * @param end the upper bound of the range of biobank general informations (not inclusive)
	 * @return the range of biobank general informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankGeneralInformation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the biobank general informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankGeneralInformationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobank general informations
	 * @param end the upper bound of the range of biobank general informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of biobank general informations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankGeneralInformation> findAll(int start, int end,
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

		List<BiobankGeneralInformation> list = (List<BiobankGeneralInformation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIOBANKGENERALINFORMATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIOBANKGENERALINFORMATION;

				if (pagination) {
					sql = sql.concat(BiobankGeneralInformationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BiobankGeneralInformation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankGeneralInformation>(list);
				}
				else {
					list = (List<BiobankGeneralInformation>)QueryUtil.list(q,
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
	 * Removes all the biobank general informations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BiobankGeneralInformation biobankGeneralInformation : findAll()) {
			remove(biobankGeneralInformation);
		}
	}

	/**
	 * Returns the number of biobank general informations.
	 *
	 * @return the number of biobank general informations
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

				Query q = session.createQuery(_SQL_COUNT_BIOBANKGENERALINFORMATION);

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
	 * Initializes the biobank general information persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.BiobankGeneralInformation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BiobankGeneralInformation>> listenersList = new ArrayList<ModelListener<BiobankGeneralInformation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BiobankGeneralInformation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BiobankGeneralInformationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIOBANKGENERALINFORMATION = "SELECT biobankGeneralInformation FROM BiobankGeneralInformation biobankGeneralInformation";
	private static final String _SQL_SELECT_BIOBANKGENERALINFORMATION_WHERE = "SELECT biobankGeneralInformation FROM BiobankGeneralInformation biobankGeneralInformation WHERE ";
	private static final String _SQL_COUNT_BIOBANKGENERALINFORMATION = "SELECT COUNT(biobankGeneralInformation) FROM BiobankGeneralInformation biobankGeneralInformation";
	private static final String _SQL_COUNT_BIOBANKGENERALINFORMATION_WHERE = "SELECT COUNT(biobankGeneralInformation) FROM BiobankGeneralInformation biobankGeneralInformation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "biobankGeneralInformation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BiobankGeneralInformation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BiobankGeneralInformation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BiobankGeneralInformationPersistenceImpl.class);
	private static BiobankGeneralInformation _nullBiobankGeneralInformation = new BiobankGeneralInformationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BiobankGeneralInformation> toCacheModel() {
				return _nullBiobankGeneralInformationCacheModel;
			}
		};

	private static CacheModel<BiobankGeneralInformation> _nullBiobankGeneralInformationCacheModel =
		new CacheModel<BiobankGeneralInformation>() {
			@Override
			public BiobankGeneralInformation toEntityModel() {
				return _nullBiobankGeneralInformation;
			}
		};
}