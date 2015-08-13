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

import com.bcnet.portlet.biobank.NoSuchSampleImportLogException;
import com.bcnet.portlet.biobank.model.SampleImportLog;
import com.bcnet.portlet.biobank.model.impl.SampleImportLogImpl;
import com.bcnet.portlet.biobank.model.impl.SampleImportLogModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the sample import log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleImportLogPersistence
 * @see SampleImportLogUtil
 * @generated
 */
public class SampleImportLogPersistenceImpl extends BasePersistenceImpl<SampleImportLog>
	implements SampleImportLogPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SampleImportLogUtil} to access the sample import log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SampleImportLogImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
			SampleImportLogModelImpl.FINDER_CACHE_ENABLED,
			SampleImportLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
			SampleImportLogModelImpl.FINDER_CACHE_ENABLED,
			SampleImportLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
			SampleImportLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
			SampleImportLogModelImpl.FINDER_CACHE_ENABLED,
			SampleImportLogImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
			SampleImportLogModelImpl.FINDER_CACHE_ENABLED,
			SampleImportLogImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SampleImportLogModelImpl.UUID_COLUMN_BITMASK |
			SampleImportLogModelImpl.DATEOFIMPORT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
			SampleImportLogModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the sample import logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching sample import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleImportLog> findByUuid(String uuid)
		throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample import logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample import logs
	 * @param end the upper bound of the range of sample import logs (not inclusive)
	 * @return the range of matching sample import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleImportLog> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample import logs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of sample import logs
	 * @param end the upper bound of the range of sample import logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleImportLog> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<SampleImportLog> list = (List<SampleImportLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SampleImportLog sampleImportLog : list) {
				if (!Validator.equals(uuid, sampleImportLog.getUuid())) {
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

			query.append(_SQL_SELECT_SAMPLEIMPORTLOG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SampleImportLogModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<SampleImportLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SampleImportLog>(list);
				}
				else {
					list = (List<SampleImportLog>)QueryUtil.list(q,
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
	 * Returns the first sample import log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample import log
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleImportLogException if a matching sample import log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSampleImportLogException, SystemException {
		SampleImportLog sampleImportLog = fetchByUuid_First(uuid,
				orderByComparator);

		if (sampleImportLog != null) {
			return sampleImportLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleImportLogException(msg.toString());
	}

	/**
	 * Returns the first sample import log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample import log, or <code>null</code> if a matching sample import log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<SampleImportLog> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample import log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample import log
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleImportLogException if a matching sample import log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog findByUuid_Last(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSampleImportLogException, SystemException {
		SampleImportLog sampleImportLog = fetchByUuid_Last(uuid,
				orderByComparator);

		if (sampleImportLog != null) {
			return sampleImportLog;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleImportLogException(msg.toString());
	}

	/**
	 * Returns the last sample import log in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample import log, or <code>null</code> if a matching sample import log could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SampleImportLog> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sample import logs before and after the current sample import log in the ordered set where uuid = &#63;.
	 *
	 * @param importId the primary key of the current sample import log
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample import log
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleImportLogException if a sample import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog[] findByUuid_PrevAndNext(long importId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchSampleImportLogException, SystemException {
		SampleImportLog sampleImportLog = findByPrimaryKey(importId);

		Session session = null;

		try {
			session = openSession();

			SampleImportLog[] array = new SampleImportLogImpl[3];

			array[0] = getByUuid_PrevAndNext(session, sampleImportLog, uuid,
					orderByComparator, true);

			array[1] = sampleImportLog;

			array[2] = getByUuid_PrevAndNext(session, sampleImportLog, uuid,
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

	protected SampleImportLog getByUuid_PrevAndNext(Session session,
		SampleImportLog sampleImportLog, String uuid,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAMPLEIMPORTLOG_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(SampleImportLogModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sampleImportLog);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SampleImportLog> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample import logs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUuid(String uuid) throws SystemException {
		for (SampleImportLog sampleImportLog : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sampleImportLog);
		}
	}

	/**
	 * Returns the number of sample import logs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching sample import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUuid(String uuid) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SAMPLEIMPORTLOG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "sampleImportLog.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "sampleImportLog.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(sampleImportLog.uuid IS NULL OR sampleImportLog.uuid = '')";

	public SampleImportLogPersistenceImpl() {
		setModelClass(SampleImportLog.class);
	}

	/**
	 * Caches the sample import log in the entity cache if it is enabled.
	 *
	 * @param sampleImportLog the sample import log
	 */
	@Override
	public void cacheResult(SampleImportLog sampleImportLog) {
		EntityCacheUtil.putResult(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
			SampleImportLogImpl.class, sampleImportLog.getPrimaryKey(),
			sampleImportLog);

		sampleImportLog.resetOriginalValues();
	}

	/**
	 * Caches the sample import logs in the entity cache if it is enabled.
	 *
	 * @param sampleImportLogs the sample import logs
	 */
	@Override
	public void cacheResult(List<SampleImportLog> sampleImportLogs) {
		for (SampleImportLog sampleImportLog : sampleImportLogs) {
			if (EntityCacheUtil.getResult(
						SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
						SampleImportLogImpl.class,
						sampleImportLog.getPrimaryKey()) == null) {
				cacheResult(sampleImportLog);
			}
			else {
				sampleImportLog.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sample import logs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SampleImportLogImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SampleImportLogImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample import log.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SampleImportLog sampleImportLog) {
		EntityCacheUtil.removeResult(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
			SampleImportLogImpl.class, sampleImportLog.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SampleImportLog> sampleImportLogs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SampleImportLog sampleImportLog : sampleImportLogs) {
			EntityCacheUtil.removeResult(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
				SampleImportLogImpl.class, sampleImportLog.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sample import log with the primary key. Does not add the sample import log to the database.
	 *
	 * @param importId the primary key for the new sample import log
	 * @return the new sample import log
	 */
	@Override
	public SampleImportLog create(long importId) {
		SampleImportLog sampleImportLog = new SampleImportLogImpl();

		sampleImportLog.setNew(true);
		sampleImportLog.setPrimaryKey(importId);

		String uuid = PortalUUIDUtil.generate();

		sampleImportLog.setUuid(uuid);

		return sampleImportLog;
	}

	/**
	 * Removes the sample import log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param importId the primary key of the sample import log
	 * @return the sample import log that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleImportLogException if a sample import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog remove(long importId)
		throws NoSuchSampleImportLogException, SystemException {
		return remove((Serializable)importId);
	}

	/**
	 * Removes the sample import log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample import log
	 * @return the sample import log that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleImportLogException if a sample import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog remove(Serializable primaryKey)
		throws NoSuchSampleImportLogException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SampleImportLog sampleImportLog = (SampleImportLog)session.get(SampleImportLogImpl.class,
					primaryKey);

			if (sampleImportLog == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSampleImportLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sampleImportLog);
		}
		catch (NoSuchSampleImportLogException nsee) {
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
	protected SampleImportLog removeImpl(SampleImportLog sampleImportLog)
		throws SystemException {
		sampleImportLog = toUnwrappedModel(sampleImportLog);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sampleImportLog)) {
				sampleImportLog = (SampleImportLog)session.get(SampleImportLogImpl.class,
						sampleImportLog.getPrimaryKeyObj());
			}

			if (sampleImportLog != null) {
				session.delete(sampleImportLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sampleImportLog != null) {
			clearCache(sampleImportLog);
		}

		return sampleImportLog;
	}

	@Override
	public SampleImportLog updateImpl(
		com.bcnet.portlet.biobank.model.SampleImportLog sampleImportLog)
		throws SystemException {
		sampleImportLog = toUnwrappedModel(sampleImportLog);

		boolean isNew = sampleImportLog.isNew();

		SampleImportLogModelImpl sampleImportLogModelImpl = (SampleImportLogModelImpl)sampleImportLog;

		if (Validator.isNull(sampleImportLog.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			sampleImportLog.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (sampleImportLog.isNew()) {
				session.save(sampleImportLog);

				sampleImportLog.setNew(false);
			}
			else {
				session.merge(sampleImportLog);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SampleImportLogModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sampleImportLogModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sampleImportLogModelImpl.getOriginalUuid()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { sampleImportLogModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}
		}

		EntityCacheUtil.putResult(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
			SampleImportLogImpl.class, sampleImportLog.getPrimaryKey(),
			sampleImportLog);

		return sampleImportLog;
	}

	protected SampleImportLog toUnwrappedModel(SampleImportLog sampleImportLog) {
		if (sampleImportLog instanceof SampleImportLogImpl) {
			return sampleImportLog;
		}

		SampleImportLogImpl sampleImportLogImpl = new SampleImportLogImpl();

		sampleImportLogImpl.setNew(sampleImportLog.isNew());
		sampleImportLogImpl.setPrimaryKey(sampleImportLog.getPrimaryKey());

		sampleImportLogImpl.setUuid(sampleImportLog.getUuid());
		sampleImportLogImpl.setImportId(sampleImportLog.getImportId());
		sampleImportLogImpl.setFileName(sampleImportLog.getFileName());
		sampleImportLogImpl.setUserId(sampleImportLog.getUserId());
		sampleImportLogImpl.setDateOfImport(sampleImportLog.getDateOfImport());

		return sampleImportLogImpl;
	}

	/**
	 * Returns the sample import log with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample import log
	 * @return the sample import log
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleImportLogException if a sample import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSampleImportLogException, SystemException {
		SampleImportLog sampleImportLog = fetchByPrimaryKey(primaryKey);

		if (sampleImportLog == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSampleImportLogException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sampleImportLog;
	}

	/**
	 * Returns the sample import log with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleImportLogException} if it could not be found.
	 *
	 * @param importId the primary key of the sample import log
	 * @return the sample import log
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleImportLogException if a sample import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog findByPrimaryKey(long importId)
		throws NoSuchSampleImportLogException, SystemException {
		return findByPrimaryKey((Serializable)importId);
	}

	/**
	 * Returns the sample import log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample import log
	 * @return the sample import log, or <code>null</code> if a sample import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SampleImportLog sampleImportLog = (SampleImportLog)EntityCacheUtil.getResult(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
				SampleImportLogImpl.class, primaryKey);

		if (sampleImportLog == _nullSampleImportLog) {
			return null;
		}

		if (sampleImportLog == null) {
			Session session = null;

			try {
				session = openSession();

				sampleImportLog = (SampleImportLog)session.get(SampleImportLogImpl.class,
						primaryKey);

				if (sampleImportLog != null) {
					cacheResult(sampleImportLog);
				}
				else {
					EntityCacheUtil.putResult(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
						SampleImportLogImpl.class, primaryKey,
						_nullSampleImportLog);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SampleImportLogModelImpl.ENTITY_CACHE_ENABLED,
					SampleImportLogImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sampleImportLog;
	}

	/**
	 * Returns the sample import log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param importId the primary key of the sample import log
	 * @return the sample import log, or <code>null</code> if a sample import log with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleImportLog fetchByPrimaryKey(long importId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)importId);
	}

	/**
	 * Returns all the sample import logs.
	 *
	 * @return the sample import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleImportLog> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample import logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample import logs
	 * @param end the upper bound of the range of sample import logs (not inclusive)
	 * @return the range of sample import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleImportLog> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample import logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleImportLogModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample import logs
	 * @param end the upper bound of the range of sample import logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sample import logs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleImportLog> findAll(int start, int end,
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

		List<SampleImportLog> list = (List<SampleImportLog>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMPLEIMPORTLOG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLEIMPORTLOG;

				if (pagination) {
					sql = sql.concat(SampleImportLogModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SampleImportLog>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SampleImportLog>(list);
				}
				else {
					list = (List<SampleImportLog>)QueryUtil.list(q,
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
	 * Removes all the sample import logs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SampleImportLog sampleImportLog : findAll()) {
			remove(sampleImportLog);
		}
	}

	/**
	 * Returns the number of sample import logs.
	 *
	 * @return the number of sample import logs
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

				Query q = session.createQuery(_SQL_COUNT_SAMPLEIMPORTLOG);

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
	 * Initializes the sample import log persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.SampleImportLog")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SampleImportLog>> listenersList = new ArrayList<ModelListener<SampleImportLog>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SampleImportLog>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SampleImportLogImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SAMPLEIMPORTLOG = "SELECT sampleImportLog FROM SampleImportLog sampleImportLog";
	private static final String _SQL_SELECT_SAMPLEIMPORTLOG_WHERE = "SELECT sampleImportLog FROM SampleImportLog sampleImportLog WHERE ";
	private static final String _SQL_COUNT_SAMPLEIMPORTLOG = "SELECT COUNT(sampleImportLog) FROM SampleImportLog sampleImportLog";
	private static final String _SQL_COUNT_SAMPLEIMPORTLOG_WHERE = "SELECT COUNT(sampleImportLog) FROM SampleImportLog sampleImportLog WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sampleImportLog.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SampleImportLog exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SampleImportLog exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SampleImportLogPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
	private static SampleImportLog _nullSampleImportLog = new SampleImportLogImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SampleImportLog> toCacheModel() {
				return _nullSampleImportLogCacheModel;
			}
		};

	private static CacheModel<SampleImportLog> _nullSampleImportLogCacheModel = new CacheModel<SampleImportLog>() {
			@Override
			public SampleImportLog toEntityModel() {
				return _nullSampleImportLog;
			}
		};
}