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

import com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException;
import com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists;
import com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsImpl;
import com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl;

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
 * The persistence implementation for the sample collection attribute lists service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionAttributeListsPersistence
 * @see SampleCollectionAttributeListsUtil
 * @generated
 */
public class SampleCollectionAttributeListsPersistenceImpl
	extends BasePersistenceImpl<SampleCollectionAttributeLists>
	implements SampleCollectionAttributeListsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SampleCollectionAttributeListsUtil} to access the sample collection attribute lists persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SampleCollectionAttributeListsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID =
		new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBysampleCollectionDbId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID =
		new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysampleCollectionDbId",
			new String[] { Long.class.getName() },
			SampleCollectionAttributeListsModelImpl.SAMPLECOLLECTIONDBID_COLUMN_BITMASK |
			SampleCollectionAttributeListsModelImpl.ATTRIBUTELISTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID = new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysampleCollectionDbId", new String[] { Long.class.getName() });

	/**
	 * Returns all the sample collection attribute listses where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @return the matching sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeLists> findBysampleCollectionDbId(
		long sampleCollectionDbId) throws SystemException {
		return findBysampleCollectionDbId(sampleCollectionDbId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample collection attribute listses where sampleCollectionDbId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param start the lower bound of the range of sample collection attribute listses
	 * @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	 * @return the range of matching sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeLists> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end)
		throws SystemException {
		return findBysampleCollectionDbId(sampleCollectionDbId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample collection attribute listses where sampleCollectionDbId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param start the lower bound of the range of sample collection attribute listses
	 * @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeLists> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID;
			finderArgs = new Object[] { sampleCollectionDbId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID;
			finderArgs = new Object[] {
					sampleCollectionDbId,
					
					start, end, orderByComparator
				};
		}

		List<SampleCollectionAttributeLists> list = (List<SampleCollectionAttributeLists>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SampleCollectionAttributeLists sampleCollectionAttributeLists : list) {
				if ((sampleCollectionDbId != sampleCollectionAttributeLists.getSampleCollectionDbId())) {
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

			query.append(_SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_SAMPLECOLLECTIONDBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SampleCollectionAttributeListsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sampleCollectionDbId);

				if (!pagination) {
					list = (List<SampleCollectionAttributeLists>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SampleCollectionAttributeLists>(list);
				}
				else {
					list = (List<SampleCollectionAttributeLists>)QueryUtil.list(q,
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
	 * Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample collection attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists findBysampleCollectionDbId_First(
		long sampleCollectionDbId, OrderByComparator orderByComparator)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = fetchBysampleCollectionDbId_First(sampleCollectionDbId,
				orderByComparator);

		if (sampleCollectionAttributeLists != null) {
			return sampleCollectionAttributeLists;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sampleCollectionDbId=");
		msg.append(sampleCollectionDbId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleCollectionAttributeListsException(msg.toString());
	}

	/**
	 * Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists fetchBysampleCollectionDbId_First(
		long sampleCollectionDbId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SampleCollectionAttributeLists> list = findBysampleCollectionDbId(sampleCollectionDbId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample collection attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists findBysampleCollectionDbId_Last(
		long sampleCollectionDbId, OrderByComparator orderByComparator)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = fetchBysampleCollectionDbId_Last(sampleCollectionDbId,
				orderByComparator);

		if (sampleCollectionAttributeLists != null) {
			return sampleCollectionAttributeLists;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sampleCollectionDbId=");
		msg.append(sampleCollectionDbId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleCollectionAttributeListsException(msg.toString());
	}

	/**
	 * Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists fetchBysampleCollectionDbId_Last(
		long sampleCollectionDbId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBysampleCollectionDbId(sampleCollectionDbId);

		if (count == 0) {
			return null;
		}

		List<SampleCollectionAttributeLists> list = findBysampleCollectionDbId(sampleCollectionDbId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sample collection attribute listses before and after the current sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionAttributeListsId the primary key of the current sample collection attribute lists
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample collection attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists[] findBysampleCollectionDbId_PrevAndNext(
		long sampleCollectionAttributeListsId, long sampleCollectionDbId,
		OrderByComparator orderByComparator)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = findByPrimaryKey(sampleCollectionAttributeListsId);

		Session session = null;

		try {
			session = openSession();

			SampleCollectionAttributeLists[] array = new SampleCollectionAttributeListsImpl[3];

			array[0] = getBysampleCollectionDbId_PrevAndNext(session,
					sampleCollectionAttributeLists, sampleCollectionDbId,
					orderByComparator, true);

			array[1] = sampleCollectionAttributeLists;

			array[2] = getBysampleCollectionDbId_PrevAndNext(session,
					sampleCollectionAttributeLists, sampleCollectionDbId,
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

	protected SampleCollectionAttributeLists getBysampleCollectionDbId_PrevAndNext(
		Session session,
		SampleCollectionAttributeLists sampleCollectionAttributeLists,
		long sampleCollectionDbId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE);

		query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_SAMPLECOLLECTIONDBID_2);

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
			query.append(SampleCollectionAttributeListsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sampleCollectionDbId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sampleCollectionAttributeLists);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SampleCollectionAttributeLists> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample collection attribute listses where sampleCollectionDbId = &#63; from the database.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysampleCollectionDbId(long sampleCollectionDbId)
		throws SystemException {
		for (SampleCollectionAttributeLists sampleCollectionAttributeLists : findBysampleCollectionDbId(
				sampleCollectionDbId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sampleCollectionAttributeLists);
		}
	}

	/**
	 * Returns the number of sample collection attribute listses where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @return the number of matching sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysampleCollectionDbId(long sampleCollectionDbId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID;

		Object[] finderArgs = new Object[] { sampleCollectionDbId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_SAMPLECOLLECTIONDBID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sampleCollectionDbId);

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

	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_SAMPLECOLLECTIONDBID_2 =
		"sampleCollectionAttributeLists.sampleCollectionDbId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME =
		new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBysampleCollectionDbId_attributeListName",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME =
		new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysampleCollectionDbId_attributeListName",
			new String[] { Long.class.getName(), String.class.getName() },
			SampleCollectionAttributeListsModelImpl.SAMPLECOLLECTIONDBID_COLUMN_BITMASK |
			SampleCollectionAttributeListsModelImpl.ATTRIBUTELISTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME =
		new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysampleCollectionDbId_attributeListName",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @return the matching sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeLists> findBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, String attributeListName)
		throws SystemException {
		return findBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
			attributeListName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param start the lower bound of the range of sample collection attribute listses
	 * @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	 * @return the range of matching sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeLists> findBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, String attributeListName, int start, int end)
		throws SystemException {
		return findBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
			attributeListName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param start the lower bound of the range of sample collection attribute listses
	 * @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeLists> findBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, String attributeListName, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME;
			finderArgs = new Object[] { sampleCollectionDbId, attributeListName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME;
			finderArgs = new Object[] {
					sampleCollectionDbId, attributeListName,
					
					start, end, orderByComparator
				};
		}

		List<SampleCollectionAttributeLists> list = (List<SampleCollectionAttributeLists>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SampleCollectionAttributeLists sampleCollectionAttributeLists : list) {
				if ((sampleCollectionDbId != sampleCollectionAttributeLists.getSampleCollectionDbId()) ||
						!Validator.equals(attributeListName,
							sampleCollectionAttributeLists.getAttributeListName())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_SAMPLECOLLECTIONDBID_2);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SampleCollectionAttributeListsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sampleCollectionDbId);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
				}

				if (!pagination) {
					list = (List<SampleCollectionAttributeLists>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SampleCollectionAttributeLists>(list);
				}
				else {
					list = (List<SampleCollectionAttributeLists>)QueryUtil.list(q,
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
	 * Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample collection attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists findBysampleCollectionDbId_attributeListName_First(
		long sampleCollectionDbId, String attributeListName,
		OrderByComparator orderByComparator)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = fetchBysampleCollectionDbId_attributeListName_First(sampleCollectionDbId,
				attributeListName, orderByComparator);

		if (sampleCollectionAttributeLists != null) {
			return sampleCollectionAttributeLists;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sampleCollectionDbId=");
		msg.append(sampleCollectionDbId);

		msg.append(", attributeListName=");
		msg.append(attributeListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleCollectionAttributeListsException(msg.toString());
	}

	/**
	 * Returns the first sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_First(
		long sampleCollectionDbId, String attributeListName,
		OrderByComparator orderByComparator) throws SystemException {
		List<SampleCollectionAttributeLists> list = findBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
				attributeListName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample collection attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists findBysampleCollectionDbId_attributeListName_Last(
		long sampleCollectionDbId, String attributeListName,
		OrderByComparator orderByComparator)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = fetchBysampleCollectionDbId_attributeListName_Last(sampleCollectionDbId,
				attributeListName, orderByComparator);

		if (sampleCollectionAttributeLists != null) {
			return sampleCollectionAttributeLists;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sampleCollectionDbId=");
		msg.append(sampleCollectionDbId);

		msg.append(", attributeListName=");
		msg.append(attributeListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleCollectionAttributeListsException(msg.toString());
	}

	/**
	 * Returns the last sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_Last(
		long sampleCollectionDbId, String attributeListName,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
				attributeListName);

		if (count == 0) {
			return null;
		}

		List<SampleCollectionAttributeLists> list = findBysampleCollectionDbId_attributeListName(sampleCollectionDbId,
				attributeListName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sample collection attribute listses before and after the current sample collection attribute lists in the ordered set where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param sampleCollectionAttributeListsId the primary key of the current sample collection attribute lists
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample collection attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists[] findBysampleCollectionDbId_attributeListName_PrevAndNext(
		long sampleCollectionAttributeListsId, long sampleCollectionDbId,
		String attributeListName, OrderByComparator orderByComparator)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = findByPrimaryKey(sampleCollectionAttributeListsId);

		Session session = null;

		try {
			session = openSession();

			SampleCollectionAttributeLists[] array = new SampleCollectionAttributeListsImpl[3];

			array[0] = getBysampleCollectionDbId_attributeListName_PrevAndNext(session,
					sampleCollectionAttributeLists, sampleCollectionDbId,
					attributeListName, orderByComparator, true);

			array[1] = sampleCollectionAttributeLists;

			array[2] = getBysampleCollectionDbId_attributeListName_PrevAndNext(session,
					sampleCollectionAttributeLists, sampleCollectionDbId,
					attributeListName, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SampleCollectionAttributeLists getBysampleCollectionDbId_attributeListName_PrevAndNext(
		Session session,
		SampleCollectionAttributeLists sampleCollectionAttributeLists,
		long sampleCollectionDbId, String attributeListName,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE);

		query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_SAMPLECOLLECTIONDBID_2);

		boolean bindAttributeListName = false;

		if (attributeListName == null) {
			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_1);
		}
		else if (attributeListName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_3);
		}
		else {
			bindAttributeListName = true;

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_2);
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
			query.append(SampleCollectionAttributeListsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sampleCollectionDbId);

		if (bindAttributeListName) {
			qPos.add(attributeListName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sampleCollectionAttributeLists);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SampleCollectionAttributeLists> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63; from the database.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, String attributeListName)
		throws SystemException {
		for (SampleCollectionAttributeLists sampleCollectionAttributeLists : findBysampleCollectionDbId_attributeListName(
				sampleCollectionDbId, attributeListName, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(sampleCollectionAttributeLists);
		}
	}

	/**
	 * Returns the number of sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @return the number of matching sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysampleCollectionDbId_attributeListName(
		long sampleCollectionDbId, String attributeListName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME;

		Object[] finderArgs = new Object[] {
				sampleCollectionDbId, attributeListName
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_SAMPLECOLLECTIONDBID_2);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sampleCollectionDbId);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
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

	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_SAMPLECOLLECTIONDBID_2 =
		"sampleCollectionAttributeLists.sampleCollectionDbId = ? AND ";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_1 =
		"sampleCollectionAttributeLists.attributeListName IS NULL";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_2 =
		"sampleCollectionAttributeLists.attributeListName = ?";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTNAME_3 =
		"(sampleCollectionAttributeLists.attributeListName IS NULL OR sampleCollectionAttributeLists.attributeListName = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE =
		new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBysampleCollectionDbId_attributeListName_attributeListValue",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			SampleCollectionAttributeListsModelImpl.SAMPLECOLLECTIONDBID_COLUMN_BITMASK |
			SampleCollectionAttributeListsModelImpl.ATTRIBUTELISTNAME_COLUMN_BITMASK |
			SampleCollectionAttributeListsModelImpl.ATTRIBUTELISTVALUE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE =
		new FinderPath(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysampleCollectionDbId_attributeListName_attributeListValue",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException} if it could not be found.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param attributeListValue the attribute list value
	 * @return the matching sample collection attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists findBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, String attributeListName,
		String attributeListValue)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = fetchBysampleCollectionDbId_attributeListName_attributeListValue(sampleCollectionDbId,
				attributeListName, attributeListValue);

		if (sampleCollectionAttributeLists == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sampleCollectionDbId=");
			msg.append(sampleCollectionDbId);

			msg.append(", attributeListName=");
			msg.append(attributeListName);

			msg.append(", attributeListValue=");
			msg.append(attributeListValue);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSampleCollectionAttributeListsException(msg.toString());
		}

		return sampleCollectionAttributeLists;
	}

	/**
	 * Returns the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param attributeListValue the attribute list value
	 * @return the matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, String attributeListName,
		String attributeListValue) throws SystemException {
		return fetchBysampleCollectionDbId_attributeListName_attributeListValue(sampleCollectionDbId,
			attributeListName, attributeListValue, true);
	}

	/**
	 * Returns the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param attributeListValue the attribute list value
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching sample collection attribute lists, or <code>null</code> if a matching sample collection attribute lists could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists fetchBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, String attributeListName,
		String attributeListValue, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				sampleCollectionDbId, attributeListName, attributeListValue
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
					finderArgs, this);
		}

		if (result instanceof SampleCollectionAttributeLists) {
			SampleCollectionAttributeLists sampleCollectionAttributeLists = (SampleCollectionAttributeLists)result;

			if ((sampleCollectionDbId != sampleCollectionAttributeLists.getSampleCollectionDbId()) ||
					!Validator.equals(attributeListName,
						sampleCollectionAttributeLists.getAttributeListName()) ||
					!Validator.equals(attributeListValue,
						sampleCollectionAttributeLists.getAttributeListValue())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_SAMPLECOLLECTIONDBID_2);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_2);
			}

			boolean bindAttributeListValue = false;

			if (attributeListValue == null) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_1);
			}
			else if (attributeListValue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_3);
			}
			else {
				bindAttributeListValue = true;

				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sampleCollectionDbId);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
				}

				if (bindAttributeListValue) {
					qPos.add(attributeListValue);
				}

				List<SampleCollectionAttributeLists> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SampleCollectionAttributeListsPersistenceImpl.fetchBysampleCollectionDbId_attributeListName_attributeListValue(long, String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SampleCollectionAttributeLists sampleCollectionAttributeLists =
						list.get(0);

					result = sampleCollectionAttributeLists;

					cacheResult(sampleCollectionAttributeLists);

					if ((sampleCollectionAttributeLists.getSampleCollectionDbId() != sampleCollectionDbId) ||
							(sampleCollectionAttributeLists.getAttributeListName() == null) ||
							!sampleCollectionAttributeLists.getAttributeListName()
															   .equals(attributeListName) ||
							(sampleCollectionAttributeLists.getAttributeListValue() == null) ||
							!sampleCollectionAttributeLists.getAttributeListValue()
															   .equals(attributeListValue)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
							finderArgs, sampleCollectionAttributeLists);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
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
			return (SampleCollectionAttributeLists)result;
		}
	}

	/**
	 * Removes the sample collection attribute lists where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63; from the database.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param attributeListValue the attribute list value
	 * @return the sample collection attribute lists that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists removeBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, String attributeListName,
		String attributeListValue)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = findBysampleCollectionDbId_attributeListName_attributeListValue(sampleCollectionDbId,
				attributeListName, attributeListValue);

		return remove(sampleCollectionAttributeLists);
	}

	/**
	 * Returns the number of sample collection attribute listses where sampleCollectionDbId = &#63; and attributeListName = &#63; and attributeListValue = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param attributeListName the attribute list name
	 * @param attributeListValue the attribute list value
	 * @return the number of matching sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysampleCollectionDbId_attributeListName_attributeListValue(
		long sampleCollectionDbId, String attributeListName,
		String attributeListValue) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE;

		Object[] finderArgs = new Object[] {
				sampleCollectionDbId, attributeListName, attributeListValue
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_SAMPLECOLLECTIONDBID_2);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_2);
			}

			boolean bindAttributeListValue = false;

			if (attributeListValue == null) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_1);
			}
			else if (attributeListValue.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_3);
			}
			else {
				bindAttributeListValue = true;

				query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sampleCollectionDbId);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
				}

				if (bindAttributeListValue) {
					qPos.add(attributeListValue);
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

	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_SAMPLECOLLECTIONDBID_2 =
		"sampleCollectionAttributeLists.sampleCollectionDbId = ? AND ";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_1 =
		"sampleCollectionAttributeLists.attributeListName IS NULL AND ";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_2 =
		"sampleCollectionAttributeLists.attributeListName = ? AND ";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTNAME_3 =
		"(sampleCollectionAttributeLists.attributeListName IS NULL OR sampleCollectionAttributeLists.attributeListName = '') AND ";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_1 =
		"sampleCollectionAttributeLists.attributeListValue IS NULL";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_2 =
		"sampleCollectionAttributeLists.attributeListValue = ?";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE_ATTRIBUTELISTVALUE_3 =
		"(sampleCollectionAttributeLists.attributeListValue IS NULL OR sampleCollectionAttributeLists.attributeListValue = '')";

	public SampleCollectionAttributeListsPersistenceImpl() {
		setModelClass(SampleCollectionAttributeLists.class);
	}

	/**
	 * Caches the sample collection attribute lists in the entity cache if it is enabled.
	 *
	 * @param sampleCollectionAttributeLists the sample collection attribute lists
	 */
	@Override
	public void cacheResult(
		SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		EntityCacheUtil.putResult(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class,
			sampleCollectionAttributeLists.getPrimaryKey(),
			sampleCollectionAttributeLists);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
			new Object[] {
				sampleCollectionAttributeLists.getSampleCollectionDbId(),
				sampleCollectionAttributeLists.getAttributeListName(),
				sampleCollectionAttributeLists.getAttributeListValue()
			}, sampleCollectionAttributeLists);

		sampleCollectionAttributeLists.resetOriginalValues();
	}

	/**
	 * Caches the sample collection attribute listses in the entity cache if it is enabled.
	 *
	 * @param sampleCollectionAttributeListses the sample collection attribute listses
	 */
	@Override
	public void cacheResult(
		List<SampleCollectionAttributeLists> sampleCollectionAttributeListses) {
		for (SampleCollectionAttributeLists sampleCollectionAttributeLists : sampleCollectionAttributeListses) {
			if (EntityCacheUtil.getResult(
						SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
						SampleCollectionAttributeListsImpl.class,
						sampleCollectionAttributeLists.getPrimaryKey()) == null) {
				cacheResult(sampleCollectionAttributeLists);
			}
			else {
				sampleCollectionAttributeLists.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sample collection attribute listses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SampleCollectionAttributeListsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SampleCollectionAttributeListsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample collection attribute lists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		EntityCacheUtil.removeResult(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class,
			sampleCollectionAttributeLists.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(sampleCollectionAttributeLists);
	}

	@Override
	public void clearCache(
		List<SampleCollectionAttributeLists> sampleCollectionAttributeListses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SampleCollectionAttributeLists sampleCollectionAttributeLists : sampleCollectionAttributeListses) {
			EntityCacheUtil.removeResult(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
				SampleCollectionAttributeListsImpl.class,
				sampleCollectionAttributeLists.getPrimaryKey());

			clearUniqueFindersCache(sampleCollectionAttributeLists);
		}
	}

	protected void cacheUniqueFindersCache(
		SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		if (sampleCollectionAttributeLists.isNew()) {
			Object[] args = new Object[] {
					sampleCollectionAttributeLists.getSampleCollectionDbId(),
					sampleCollectionAttributeLists.getAttributeListName(),
					sampleCollectionAttributeLists.getAttributeListValue()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
				args, sampleCollectionAttributeLists);
		}
		else {
			SampleCollectionAttributeListsModelImpl sampleCollectionAttributeListsModelImpl =
				(SampleCollectionAttributeListsModelImpl)sampleCollectionAttributeLists;

			if ((sampleCollectionAttributeListsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sampleCollectionAttributeLists.getSampleCollectionDbId(),
						sampleCollectionAttributeLists.getAttributeListName(),
						sampleCollectionAttributeLists.getAttributeListValue()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
					args, sampleCollectionAttributeLists);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		SampleCollectionAttributeListsModelImpl sampleCollectionAttributeListsModelImpl =
			(SampleCollectionAttributeListsModelImpl)sampleCollectionAttributeLists;

		Object[] args = new Object[] {
				sampleCollectionAttributeLists.getSampleCollectionDbId(),
				sampleCollectionAttributeLists.getAttributeListName(),
				sampleCollectionAttributeLists.getAttributeListValue()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
			args);

		if ((sampleCollectionAttributeListsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE.getColumnBitmask()) != 0) {
			args = new Object[] {
					sampleCollectionAttributeListsModelImpl.getOriginalSampleCollectionDbId(),
					sampleCollectionAttributeListsModelImpl.getOriginalAttributeListName(),
					sampleCollectionAttributeListsModelImpl.getOriginalAttributeListValue()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME_ATTRIBUTELISTVALUE,
				args);
		}
	}

	/**
	 * Creates a new sample collection attribute lists with the primary key. Does not add the sample collection attribute lists to the database.
	 *
	 * @param sampleCollectionAttributeListsId the primary key for the new sample collection attribute lists
	 * @return the new sample collection attribute lists
	 */
	@Override
	public SampleCollectionAttributeLists create(
		long sampleCollectionAttributeListsId) {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = new SampleCollectionAttributeListsImpl();

		sampleCollectionAttributeLists.setNew(true);
		sampleCollectionAttributeLists.setPrimaryKey(sampleCollectionAttributeListsId);

		return sampleCollectionAttributeLists;
	}

	/**
	 * Removes the sample collection attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	 * @return the sample collection attribute lists that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists remove(
		long sampleCollectionAttributeListsId)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		return remove((Serializable)sampleCollectionAttributeListsId);
	}

	/**
	 * Removes the sample collection attribute lists with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample collection attribute lists
	 * @return the sample collection attribute lists that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists remove(Serializable primaryKey)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SampleCollectionAttributeLists sampleCollectionAttributeLists = (SampleCollectionAttributeLists)session.get(SampleCollectionAttributeListsImpl.class,
					primaryKey);

			if (sampleCollectionAttributeLists == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSampleCollectionAttributeListsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sampleCollectionAttributeLists);
		}
		catch (NoSuchSampleCollectionAttributeListsException nsee) {
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
	protected SampleCollectionAttributeLists removeImpl(
		SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws SystemException {
		sampleCollectionAttributeLists = toUnwrappedModel(sampleCollectionAttributeLists);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sampleCollectionAttributeLists)) {
				sampleCollectionAttributeLists = (SampleCollectionAttributeLists)session.get(SampleCollectionAttributeListsImpl.class,
						sampleCollectionAttributeLists.getPrimaryKeyObj());
			}

			if (sampleCollectionAttributeLists != null) {
				session.delete(sampleCollectionAttributeLists);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sampleCollectionAttributeLists != null) {
			clearCache(sampleCollectionAttributeLists);
		}

		return sampleCollectionAttributeLists;
	}

	@Override
	public SampleCollectionAttributeLists updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists sampleCollectionAttributeLists)
		throws SystemException {
		sampleCollectionAttributeLists = toUnwrappedModel(sampleCollectionAttributeLists);

		boolean isNew = sampleCollectionAttributeLists.isNew();

		SampleCollectionAttributeListsModelImpl sampleCollectionAttributeListsModelImpl =
			(SampleCollectionAttributeListsModelImpl)sampleCollectionAttributeLists;

		Session session = null;

		try {
			session = openSession();

			if (sampleCollectionAttributeLists.isNew()) {
				session.save(sampleCollectionAttributeLists);

				sampleCollectionAttributeLists.setNew(false);
			}
			else {
				session.merge(sampleCollectionAttributeLists);
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
				!SampleCollectionAttributeListsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sampleCollectionAttributeListsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sampleCollectionAttributeListsModelImpl.getOriginalSampleCollectionDbId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID,
					args);

				args = new Object[] {
						sampleCollectionAttributeListsModelImpl.getSampleCollectionDbId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID,
					args);
			}

			if ((sampleCollectionAttributeListsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sampleCollectionAttributeListsModelImpl.getOriginalSampleCollectionDbId(),
						sampleCollectionAttributeListsModelImpl.getOriginalAttributeListName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME,
					args);

				args = new Object[] {
						sampleCollectionAttributeListsModelImpl.getSampleCollectionDbId(),
						sampleCollectionAttributeListsModelImpl.getAttributeListName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID_ATTRIBUTELISTNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionAttributeListsImpl.class,
			sampleCollectionAttributeLists.getPrimaryKey(),
			sampleCollectionAttributeLists);

		clearUniqueFindersCache(sampleCollectionAttributeLists);
		cacheUniqueFindersCache(sampleCollectionAttributeLists);

		return sampleCollectionAttributeLists;
	}

	protected SampleCollectionAttributeLists toUnwrappedModel(
		SampleCollectionAttributeLists sampleCollectionAttributeLists) {
		if (sampleCollectionAttributeLists instanceof SampleCollectionAttributeListsImpl) {
			return sampleCollectionAttributeLists;
		}

		SampleCollectionAttributeListsImpl sampleCollectionAttributeListsImpl = new SampleCollectionAttributeListsImpl();

		sampleCollectionAttributeListsImpl.setNew(sampleCollectionAttributeLists.isNew());
		sampleCollectionAttributeListsImpl.setPrimaryKey(sampleCollectionAttributeLists.getPrimaryKey());

		sampleCollectionAttributeListsImpl.setSampleCollectionAttributeListsId(sampleCollectionAttributeLists.getSampleCollectionAttributeListsId());
		sampleCollectionAttributeListsImpl.setSampleCollectionDbId(sampleCollectionAttributeLists.getSampleCollectionDbId());
		sampleCollectionAttributeListsImpl.setAttributeListName(sampleCollectionAttributeLists.getAttributeListName());
		sampleCollectionAttributeListsImpl.setAttributeListValue(sampleCollectionAttributeLists.getAttributeListValue());

		return sampleCollectionAttributeListsImpl;
	}

	/**
	 * Returns the sample collection attribute lists with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample collection attribute lists
	 * @return the sample collection attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = fetchByPrimaryKey(primaryKey);

		if (sampleCollectionAttributeLists == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSampleCollectionAttributeListsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sampleCollectionAttributeLists;
	}

	/**
	 * Returns the sample collection attribute lists with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException} if it could not be found.
	 *
	 * @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	 * @return the sample collection attribute lists
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionAttributeListsException if a sample collection attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists findByPrimaryKey(
		long sampleCollectionAttributeListsId)
		throws NoSuchSampleCollectionAttributeListsException, SystemException {
		return findByPrimaryKey((Serializable)sampleCollectionAttributeListsId);
	}

	/**
	 * Returns the sample collection attribute lists with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample collection attribute lists
	 * @return the sample collection attribute lists, or <code>null</code> if a sample collection attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		SampleCollectionAttributeLists sampleCollectionAttributeLists = (SampleCollectionAttributeLists)EntityCacheUtil.getResult(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
				SampleCollectionAttributeListsImpl.class, primaryKey);

		if (sampleCollectionAttributeLists == _nullSampleCollectionAttributeLists) {
			return null;
		}

		if (sampleCollectionAttributeLists == null) {
			Session session = null;

			try {
				session = openSession();

				sampleCollectionAttributeLists = (SampleCollectionAttributeLists)session.get(SampleCollectionAttributeListsImpl.class,
						primaryKey);

				if (sampleCollectionAttributeLists != null) {
					cacheResult(sampleCollectionAttributeLists);
				}
				else {
					EntityCacheUtil.putResult(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
						SampleCollectionAttributeListsImpl.class, primaryKey,
						_nullSampleCollectionAttributeLists);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SampleCollectionAttributeListsModelImpl.ENTITY_CACHE_ENABLED,
					SampleCollectionAttributeListsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sampleCollectionAttributeLists;
	}

	/**
	 * Returns the sample collection attribute lists with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleCollectionAttributeListsId the primary key of the sample collection attribute lists
	 * @return the sample collection attribute lists, or <code>null</code> if a sample collection attribute lists with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionAttributeLists fetchByPrimaryKey(
		long sampleCollectionAttributeListsId) throws SystemException {
		return fetchByPrimaryKey((Serializable)sampleCollectionAttributeListsId);
	}

	/**
	 * Returns all the sample collection attribute listses.
	 *
	 * @return the sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeLists> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample collection attribute listses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample collection attribute listses
	 * @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	 * @return the range of sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeLists> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample collection attribute listses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionAttributeListsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample collection attribute listses
	 * @param end the upper bound of the range of sample collection attribute listses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sample collection attribute listses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionAttributeLists> findAll(int start, int end,
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

		List<SampleCollectionAttributeLists> list = (List<SampleCollectionAttributeLists>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTS;

				if (pagination) {
					sql = sql.concat(SampleCollectionAttributeListsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SampleCollectionAttributeLists>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SampleCollectionAttributeLists>(list);
				}
				else {
					list = (List<SampleCollectionAttributeLists>)QueryUtil.list(q,
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
	 * Removes all the sample collection attribute listses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SampleCollectionAttributeLists sampleCollectionAttributeLists : findAll()) {
			remove(sampleCollectionAttributeLists);
		}
	}

	/**
	 * Returns the number of sample collection attribute listses.
	 *
	 * @return the number of sample collection attribute listses
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

				Query q = session.createQuery(_SQL_COUNT_SAMPLECOLLECTIONATTRIBUTELISTS);

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
	 * Initializes the sample collection attribute lists persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.SampleCollectionAttributeLists")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SampleCollectionAttributeLists>> listenersList =
					new ArrayList<ModelListener<SampleCollectionAttributeLists>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SampleCollectionAttributeLists>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SampleCollectionAttributeListsImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTS = "SELECT sampleCollectionAttributeLists FROM SampleCollectionAttributeLists sampleCollectionAttributeLists";
	private static final String _SQL_SELECT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE =
		"SELECT sampleCollectionAttributeLists FROM SampleCollectionAttributeLists sampleCollectionAttributeLists WHERE ";
	private static final String _SQL_COUNT_SAMPLECOLLECTIONATTRIBUTELISTS = "SELECT COUNT(sampleCollectionAttributeLists) FROM SampleCollectionAttributeLists sampleCollectionAttributeLists";
	private static final String _SQL_COUNT_SAMPLECOLLECTIONATTRIBUTELISTS_WHERE = "SELECT COUNT(sampleCollectionAttributeLists) FROM SampleCollectionAttributeLists sampleCollectionAttributeLists WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sampleCollectionAttributeLists.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SampleCollectionAttributeLists exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SampleCollectionAttributeLists exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SampleCollectionAttributeListsPersistenceImpl.class);
	private static SampleCollectionAttributeLists _nullSampleCollectionAttributeLists =
		new SampleCollectionAttributeListsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SampleCollectionAttributeLists> toCacheModel() {
				return _nullSampleCollectionAttributeListsCacheModel;
			}
		};

	private static CacheModel<SampleCollectionAttributeLists> _nullSampleCollectionAttributeListsCacheModel =
		new CacheModel<SampleCollectionAttributeLists>() {
			@Override
			public SampleCollectionAttributeLists toEntityModel() {
				return _nullSampleCollectionAttributeLists;
			}
		};
}