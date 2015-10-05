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

import com.bcnet.portlet.biobank.NoSuchSampleException;
import com.bcnet.portlet.biobank.model.Sample;
import com.bcnet.portlet.biobank.model.impl.SampleImpl;
import com.bcnet.portlet.biobank.model.impl.SampleModelImpl;

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
 * The persistence implementation for the sample service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SamplePersistence
 * @see SampleUtil
 * @generated
 */
public class SamplePersistenceImpl extends BasePersistenceImpl<Sample>
	implements SamplePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SampleUtil} to access the sample persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SampleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleModelImpl.FINDER_CACHE_ENABLED, SampleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleModelImpl.FINDER_CACHE_ENABLED, SampleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleModelImpl.FINDER_CACHE_ENABLED, SampleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleModelImpl.FINDER_CACHE_ENABLED, SampleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuuid",
			new String[] { String.class.getName() },
			SampleModelImpl.UUID__COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the samples where uuid_ = &#63;.
	 *
	 * @param uuid_ the uuid_
	 * @return the matching samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sample> findByuuid(String uuid_) throws SystemException {
		return findByuuid(uuid_, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the samples where uuid_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid_ the uuid_
	 * @param start the lower bound of the range of samples
	 * @param end the upper bound of the range of samples (not inclusive)
	 * @return the range of matching samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sample> findByuuid(String uuid_, int start, int end)
		throws SystemException {
		return findByuuid(uuid_, start, end, null);
	}

	/**
	 * Returns an ordered range of all the samples where uuid_ = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid_ the uuid_
	 * @param start the lower bound of the range of samples
	 * @param end the upper bound of the range of samples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sample> findByuuid(String uuid_, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid_ };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid_, start, end, orderByComparator };
		}

		List<Sample> list = (List<Sample>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Sample sample : list) {
				if (!Validator.equals(uuid_, sample.getUuid_())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SAMPLE_WHERE);

			boolean bindUuid_ = false;

			if (uuid_ == null) {
				query.append(_FINDER_COLUMN_UUID_UUID__1);
			}
			else if (uuid_.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID__3);
			}
			else {
				bindUuid_ = true;

				query.append(_FINDER_COLUMN_UUID_UUID__2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SampleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid_) {
					qPos.add(uuid_);
				}

				if (!pagination) {
					list = (List<Sample>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sample>(list);
				}
				else {
					list = (List<Sample>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first sample in the ordered set where uuid_ = &#63;.
	 *
	 * @param uuid_ the uuid_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample findByuuid_First(String uuid_,
		OrderByComparator orderByComparator)
		throws NoSuchSampleException, SystemException {
		Sample sample = fetchByuuid_First(uuid_, orderByComparator);

		if (sample != null) {
			return sample;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid_=");
		msg.append(uuid_);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleException(msg.toString());
	}

	/**
	 * Returns the first sample in the ordered set where uuid_ = &#63;.
	 *
	 * @param uuid_ the uuid_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample, or <code>null</code> if a matching sample could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample fetchByuuid_First(String uuid_,
		OrderByComparator orderByComparator) throws SystemException {
		List<Sample> list = findByuuid(uuid_, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample in the ordered set where uuid_ = &#63;.
	 *
	 * @param uuid_ the uuid_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleException if a matching sample could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample findByuuid_Last(String uuid_,
		OrderByComparator orderByComparator)
		throws NoSuchSampleException, SystemException {
		Sample sample = fetchByuuid_Last(uuid_, orderByComparator);

		if (sample != null) {
			return sample;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid_=");
		msg.append(uuid_);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleException(msg.toString());
	}

	/**
	 * Returns the last sample in the ordered set where uuid_ = &#63;.
	 *
	 * @param uuid_ the uuid_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample, or <code>null</code> if a matching sample could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample fetchByuuid_Last(String uuid_,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuuid(uuid_);

		if (count == 0) {
			return null;
		}

		List<Sample> list = findByuuid(uuid_, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the samples before and after the current sample in the ordered set where uuid_ = &#63;.
	 *
	 * @param sampleDbId the primary key of the current sample
	 * @param uuid_ the uuid_
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample[] findByuuid_PrevAndNext(long sampleDbId, String uuid_,
		OrderByComparator orderByComparator)
		throws NoSuchSampleException, SystemException {
		Sample sample = findByPrimaryKey(sampleDbId);

		Session session = null;

		try {
			session = openSession();

			Sample[] array = new SampleImpl[3];

			array[0] = getByuuid_PrevAndNext(session, sample, uuid_,
					orderByComparator, true);

			array[1] = sample;

			array[2] = getByuuid_PrevAndNext(session, sample, uuid_,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Sample getByuuid_PrevAndNext(Session session, Sample sample,
		String uuid_, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAMPLE_WHERE);

		boolean bindUuid_ = false;

		if (uuid_ == null) {
			query.append(_FINDER_COLUMN_UUID_UUID__1);
		}
		else if (uuid_.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID__3);
		}
		else {
			bindUuid_ = true;

			query.append(_FINDER_COLUMN_UUID_UUID__2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SampleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid_) {
			qPos.add(uuid_);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sample);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Sample> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the samples where uuid_ = &#63; from the database.
	 *
	 * @param uuid_ the uuid_
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByuuid(String uuid_) throws SystemException {
		for (Sample sample : findByuuid(uuid_, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(sample);
		}
	}

	/**
	 * Returns the number of samples where uuid_ = &#63;.
	 *
	 * @param uuid_ the uuid_
	 * @return the number of matching samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByuuid(String uuid_) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid_ };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SAMPLE_WHERE);

			boolean bindUuid_ = false;

			if (uuid_ == null) {
				query.append(_FINDER_COLUMN_UUID_UUID__1);
			}
			else if (uuid_.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID__3);
			}
			else {
				bindUuid_ = true;

				query.append(_FINDER_COLUMN_UUID_UUID__2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid_) {
					qPos.add(uuid_);
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

	private static final String _FINDER_COLUMN_UUID_UUID__1 = "sample.uuid_ IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID__2 = "sample.uuid_ = ?";
	private static final String _FINDER_COLUMN_UUID_UUID__3 = "(sample.uuid_ IS NULL OR sample.uuid_ = '')";

	public SamplePersistenceImpl() {
		setModelClass(Sample.class);
	}

	/**
	 * Caches the sample in the entity cache if it is enabled.
	 *
	 * @param sample the sample
	 */
	@Override
	public void cacheResult(Sample sample) {
		EntityCacheUtil.putResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleImpl.class, sample.getPrimaryKey(), sample);

		sample.resetOriginalValues();
	}

	/**
	 * Caches the samples in the entity cache if it is enabled.
	 *
	 * @param samples the samples
	 */
	@Override
	public void cacheResult(List<Sample> samples) {
		for (Sample sample : samples) {
			if (EntityCacheUtil.getResult(
						SampleModelImpl.ENTITY_CACHE_ENABLED, SampleImpl.class,
						sample.getPrimaryKey()) == null) {
				cacheResult(sample);
			}
			else {
				sample.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all samples.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SampleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SampleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sample sample) {
		EntityCacheUtil.removeResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleImpl.class, sample.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Sample> samples) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Sample sample : samples) {
			EntityCacheUtil.removeResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
				SampleImpl.class, sample.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sample with the primary key. Does not add the sample to the database.
	 *
	 * @param sampleDbId the primary key for the new sample
	 * @return the new sample
	 */
	@Override
	public Sample create(long sampleDbId) {
		Sample sample = new SampleImpl();

		sample.setNew(true);
		sample.setPrimaryKey(sampleDbId);

		return sample;
	}

	/**
	 * Removes the sample with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleDbId the primary key of the sample
	 * @return the sample that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample remove(long sampleDbId)
		throws NoSuchSampleException, SystemException {
		return remove((Serializable)sampleDbId);
	}

	/**
	 * Removes the sample with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample
	 * @return the sample that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample remove(Serializable primaryKey)
		throws NoSuchSampleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Sample sample = (Sample)session.get(SampleImpl.class, primaryKey);

			if (sample == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSampleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sample);
		}
		catch (NoSuchSampleException nsee) {
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
	protected Sample removeImpl(Sample sample) throws SystemException {
		sample = toUnwrappedModel(sample);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sample)) {
				sample = (Sample)session.get(SampleImpl.class,
						sample.getPrimaryKeyObj());
			}

			if (sample != null) {
				session.delete(sample);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sample != null) {
			clearCache(sample);
		}

		return sample;
	}

	@Override
	public Sample updateImpl(com.bcnet.portlet.biobank.model.Sample sample)
		throws SystemException {
		sample = toUnwrappedModel(sample);

		boolean isNew = sample.isNew();

		SampleModelImpl sampleModelImpl = (SampleModelImpl)sample;

		Session session = null;

		try {
			session = openSession();

			if (sample.isNew()) {
				session.save(sample);

				sample.setNew(false);
			}
			else {
				session.merge(sample);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SampleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sampleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { sampleModelImpl.getOriginalUuid_() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { sampleModelImpl.getUuid_() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
			SampleImpl.class, sample.getPrimaryKey(), sample);

		return sample;
	}

	protected Sample toUnwrappedModel(Sample sample) {
		if (sample instanceof SampleImpl) {
			return sample;
		}

		SampleImpl sampleImpl = new SampleImpl();

		sampleImpl.setNew(sample.isNew());
		sampleImpl.setPrimaryKey(sample.getPrimaryKey());

		sampleImpl.setUuid_(sample.getUuid_());
		sampleImpl.setSampleDbId(sample.getSampleDbId());
		sampleImpl.setSampleCollectionId(sample.getSampleCollectionId());
		sampleImpl.setBiobankId(sample.getBiobankId());
		sampleImpl.setHashedSampleId(sample.getHashedSampleId());
		sampleImpl.setHashedIndividualId(sample.getHashedIndividualId());
		sampleImpl.setMaterialType(sample.getMaterialType());
		sampleImpl.setContainer(sample.getContainer());
		sampleImpl.setStorageTemperature(sample.getStorageTemperature());
		sampleImpl.setSampledTime(sample.getSampledTime());
		sampleImpl.setAnatomicalPartOntology(sample.getAnatomicalPartOntology());
		sampleImpl.setAnatomicalPartOntologyVersion(sample.getAnatomicalPartOntologyVersion());
		sampleImpl.setAnatomicalPartOntologyCode(sample.getAnatomicalPartOntologyCode());
		sampleImpl.setAnatomicalPartOntologyDescription(sample.getAnatomicalPartOntologyDescription());
		sampleImpl.setAnatomicalPartFreeText(sample.getAnatomicalPartFreeText());
		sampleImpl.setSex(sample.getSex());
		sampleImpl.setAgeHigh(sample.getAgeHigh());
		sampleImpl.setAgeLow(sample.getAgeLow());
		sampleImpl.setAgeUnit(sample.getAgeUnit());
		sampleImpl.setDiseaseOntology(sample.getDiseaseOntology());
		sampleImpl.setDiseaseOntologyVersion(sample.getDiseaseOntologyVersion());
		sampleImpl.setDiseaseOntologyCode(sample.getDiseaseOntologyCode());
		sampleImpl.setDiseaseOntologyDescription(sample.getDiseaseOntologyDescription());
		sampleImpl.setDiseaseFreeText(sample.getDiseaseFreeText());
		sampleImpl.setCountryOfOrigin(sample.getCountryOfOrigin());

		return sampleImpl;
	}

	/**
	 * Returns the sample with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample
	 * @return the sample
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSampleException, SystemException {
		Sample sample = fetchByPrimaryKey(primaryKey);

		if (sample == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSampleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sample;
	}

	/**
	 * Returns the sample with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleException} if it could not be found.
	 *
	 * @param sampleDbId the primary key of the sample
	 * @return the sample
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleException if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample findByPrimaryKey(long sampleDbId)
		throws NoSuchSampleException, SystemException {
		return findByPrimaryKey((Serializable)sampleDbId);
	}

	/**
	 * Returns the sample with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample
	 * @return the sample, or <code>null</code> if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Sample sample = (Sample)EntityCacheUtil.getResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
				SampleImpl.class, primaryKey);

		if (sample == _nullSample) {
			return null;
		}

		if (sample == null) {
			Session session = null;

			try {
				session = openSession();

				sample = (Sample)session.get(SampleImpl.class, primaryKey);

				if (sample != null) {
					cacheResult(sample);
				}
				else {
					EntityCacheUtil.putResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
						SampleImpl.class, primaryKey, _nullSample);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SampleModelImpl.ENTITY_CACHE_ENABLED,
					SampleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sample;
	}

	/**
	 * Returns the sample with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleDbId the primary key of the sample
	 * @return the sample, or <code>null</code> if a sample with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Sample fetchByPrimaryKey(long sampleDbId) throws SystemException {
		return fetchByPrimaryKey((Serializable)sampleDbId);
	}

	/**
	 * Returns all the samples.
	 *
	 * @return the samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sample> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the samples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of samples
	 * @param end the upper bound of the range of samples (not inclusive)
	 * @return the range of samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sample> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the samples.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of samples
	 * @param end the upper bound of the range of samples (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of samples
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Sample> findAll(int start, int end,
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

		List<Sample> list = (List<Sample>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMPLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLE;

				if (pagination) {
					sql = sql.concat(SampleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Sample>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Sample>(list);
				}
				else {
					list = (List<Sample>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the samples from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Sample sample : findAll()) {
			remove(sample);
		}
	}

	/**
	 * Returns the number of samples.
	 *
	 * @return the number of samples
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

				Query q = session.createQuery(_SQL_COUNT_SAMPLE);

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
	 * Initializes the sample persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.Sample")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Sample>> listenersList = new ArrayList<ModelListener<Sample>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Sample>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SampleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SAMPLE = "SELECT sample FROM Sample sample";
	private static final String _SQL_SELECT_SAMPLE_WHERE = "SELECT sample FROM Sample sample WHERE ";
	private static final String _SQL_COUNT_SAMPLE = "SELECT COUNT(sample) FROM Sample sample";
	private static final String _SQL_COUNT_SAMPLE_WHERE = "SELECT COUNT(sample) FROM Sample sample WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sample.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Sample exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Sample exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SamplePersistenceImpl.class);
	private static Sample _nullSample = new SampleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Sample> toCacheModel() {
				return _nullSampleCacheModel;
			}
		};

	private static CacheModel<Sample> _nullSampleCacheModel = new CacheModel<Sample>() {
			@Override
			public Sample toEntityModel() {
				return _nullSample;
			}
		};
}