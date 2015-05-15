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

import com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException;
import com.bcnet.portlet.biobank.model.SampleCollectionContact;
import com.bcnet.portlet.biobank.model.impl.SampleCollectionContactImpl;
import com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl;

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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sample collection contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see SampleCollectionContactPersistence
 * @see SampleCollectionContactUtil
 * @generated
 */
public class SampleCollectionContactPersistenceImpl extends BasePersistenceImpl<SampleCollectionContact>
	implements SampleCollectionContactPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SampleCollectionContactUtil} to access the sample collection contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SampleCollectionContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID =
		new FinderPath(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBysampleCollectionDbId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID =
		new FinderPath(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionContactImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findBysampleCollectionDbId",
			new String[] { Long.class.getName() },
			SampleCollectionContactModelImpl.SAMPLECOLLECTIONDBID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID = new FinderPath(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysampleCollectionDbId", new String[] { Long.class.getName() });

	/**
	 * Returns all the sample collection contacts where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @return the matching sample collection contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionContact> findBysampleCollectionDbId(
		long sampleCollectionDbId) throws SystemException {
		return findBysampleCollectionDbId(sampleCollectionDbId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample collection contacts where sampleCollectionDbId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param start the lower bound of the range of sample collection contacts
	 * @param end the upper bound of the range of sample collection contacts (not inclusive)
	 * @return the range of matching sample collection contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionContact> findBysampleCollectionDbId(
		long sampleCollectionDbId, int start, int end)
		throws SystemException {
		return findBysampleCollectionDbId(sampleCollectionDbId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample collection contacts where sampleCollectionDbId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param start the lower bound of the range of sample collection contacts
	 * @param end the upper bound of the range of sample collection contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching sample collection contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionContact> findBysampleCollectionDbId(
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

		List<SampleCollectionContact> list = (List<SampleCollectionContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SampleCollectionContact sampleCollectionContact : list) {
				if ((sampleCollectionDbId != sampleCollectionContact.getSampleCollectionDbId())) {
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

			query.append(_SQL_SELECT_SAMPLECOLLECTIONCONTACT_WHERE);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_SAMPLECOLLECTIONDBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SampleCollectionContactModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sampleCollectionDbId);

				if (!pagination) {
					list = (List<SampleCollectionContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SampleCollectionContact>(list);
				}
				else {
					list = (List<SampleCollectionContact>)QueryUtil.list(q,
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
	 * Returns the first sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample collection contact
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a matching sample collection contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact findBysampleCollectionDbId_First(
		long sampleCollectionDbId, OrderByComparator orderByComparator)
		throws NoSuchSampleCollectionContactException, SystemException {
		SampleCollectionContact sampleCollectionContact = fetchBysampleCollectionDbId_First(sampleCollectionDbId,
				orderByComparator);

		if (sampleCollectionContact != null) {
			return sampleCollectionContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sampleCollectionDbId=");
		msg.append(sampleCollectionDbId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleCollectionContactException(msg.toString());
	}

	/**
	 * Returns the first sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact fetchBysampleCollectionDbId_First(
		long sampleCollectionDbId, OrderByComparator orderByComparator)
		throws SystemException {
		List<SampleCollectionContact> list = findBysampleCollectionDbId(sampleCollectionDbId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample collection contact
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a matching sample collection contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact findBysampleCollectionDbId_Last(
		long sampleCollectionDbId, OrderByComparator orderByComparator)
		throws NoSuchSampleCollectionContactException, SystemException {
		SampleCollectionContact sampleCollectionContact = fetchBysampleCollectionDbId_Last(sampleCollectionDbId,
				orderByComparator);

		if (sampleCollectionContact != null) {
			return sampleCollectionContact;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sampleCollectionDbId=");
		msg.append(sampleCollectionDbId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSampleCollectionContactException(msg.toString());
	}

	/**
	 * Returns the last sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact fetchBysampleCollectionDbId_Last(
		long sampleCollectionDbId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countBysampleCollectionDbId(sampleCollectionDbId);

		if (count == 0) {
			return null;
		}

		List<SampleCollectionContact> list = findBysampleCollectionDbId(sampleCollectionDbId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the sample collection contacts before and after the current sample collection contact in the ordered set where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionContactPK the primary key of the current sample collection contact
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next sample collection contact
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact[] findBysampleCollectionDbId_PrevAndNext(
		SampleCollectionContactPK sampleCollectionContactPK,
		long sampleCollectionDbId, OrderByComparator orderByComparator)
		throws NoSuchSampleCollectionContactException, SystemException {
		SampleCollectionContact sampleCollectionContact = findByPrimaryKey(sampleCollectionContactPK);

		Session session = null;

		try {
			session = openSession();

			SampleCollectionContact[] array = new SampleCollectionContactImpl[3];

			array[0] = getBysampleCollectionDbId_PrevAndNext(session,
					sampleCollectionContact, sampleCollectionDbId,
					orderByComparator, true);

			array[1] = sampleCollectionContact;

			array[2] = getBysampleCollectionDbId_PrevAndNext(session,
					sampleCollectionContact, sampleCollectionDbId,
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

	protected SampleCollectionContact getBysampleCollectionDbId_PrevAndNext(
		Session session, SampleCollectionContact sampleCollectionContact,
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

		query.append(_SQL_SELECT_SAMPLECOLLECTIONCONTACT_WHERE);

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
			query.append(SampleCollectionContactModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(sampleCollectionDbId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sampleCollectionContact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SampleCollectionContact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the sample collection contacts where sampleCollectionDbId = &#63; from the database.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeBysampleCollectionDbId(long sampleCollectionDbId)
		throws SystemException {
		for (SampleCollectionContact sampleCollectionContact : findBysampleCollectionDbId(
				sampleCollectionDbId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(sampleCollectionContact);
		}
	}

	/**
	 * Returns the number of sample collection contacts where sampleCollectionDbId = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @return the number of matching sample collection contacts
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

			query.append(_SQL_COUNT_SAMPLECOLLECTIONCONTACT_WHERE);

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
		"sampleCollectionContact.id.sampleCollectionDbId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT =
		new FinderPath(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactModelImpl.FINDER_CACHE_ENABLED,
			SampleCollectionContactImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBysampleCollectionDbId_mainContact",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			SampleCollectionContactModelImpl.SAMPLECOLLECTIONDBID_COLUMN_BITMASK |
			SampleCollectionContactModelImpl.MAINCONTACT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_MAINCONTACT =
		new FinderPath(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBysampleCollectionDbId_mainContact",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException} if it could not be found.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param mainContact the main contact
	 * @return the matching sample collection contact
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a matching sample collection contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact findBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws NoSuchSampleCollectionContactException, SystemException {
		SampleCollectionContact sampleCollectionContact = fetchBysampleCollectionDbId_mainContact(sampleCollectionDbId,
				mainContact);

		if (sampleCollectionContact == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("sampleCollectionDbId=");
			msg.append(sampleCollectionDbId);

			msg.append(", mainContact=");
			msg.append(mainContact);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSampleCollectionContactException(msg.toString());
		}

		return sampleCollectionContact;
	}

	/**
	 * Returns the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param mainContact the main contact
	 * @return the matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact fetchBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws SystemException {
		return fetchBysampleCollectionDbId_mainContact(sampleCollectionDbId,
			mainContact, true);
	}

	/**
	 * Returns the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param mainContact the main contact
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching sample collection contact, or <code>null</code> if a matching sample collection contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact fetchBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { sampleCollectionDbId, mainContact };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
					finderArgs, this);
		}

		if (result instanceof SampleCollectionContact) {
			SampleCollectionContact sampleCollectionContact = (SampleCollectionContact)result;

			if ((sampleCollectionDbId != sampleCollectionContact.getSampleCollectionDbId()) ||
					(mainContact != sampleCollectionContact.getMainContact())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SAMPLECOLLECTIONCONTACT_WHERE);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_MAINCONTACT_SAMPLECOLLECTIONDBID_2);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_MAINCONTACT_MAINCONTACT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sampleCollectionDbId);

				qPos.add(mainContact);

				List<SampleCollectionContact> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SampleCollectionContactPersistenceImpl.fetchBysampleCollectionDbId_mainContact(long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					SampleCollectionContact sampleCollectionContact = list.get(0);

					result = sampleCollectionContact;

					cacheResult(sampleCollectionContact);

					if ((sampleCollectionContact.getSampleCollectionDbId() != sampleCollectionDbId) ||
							(sampleCollectionContact.getMainContact() != mainContact)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
							finderArgs, sampleCollectionContact);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
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
			return (SampleCollectionContact)result;
		}
	}

	/**
	 * Removes the sample collection contact where sampleCollectionDbId = &#63; and mainContact = &#63; from the database.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param mainContact the main contact
	 * @return the sample collection contact that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact removeBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws NoSuchSampleCollectionContactException, SystemException {
		SampleCollectionContact sampleCollectionContact = findBysampleCollectionDbId_mainContact(sampleCollectionDbId,
				mainContact);

		return remove(sampleCollectionContact);
	}

	/**
	 * Returns the number of sample collection contacts where sampleCollectionDbId = &#63; and mainContact = &#63;.
	 *
	 * @param sampleCollectionDbId the sample collection db ID
	 * @param mainContact the main contact
	 * @return the number of matching sample collection contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBysampleCollectionDbId_mainContact(
		long sampleCollectionDbId, boolean mainContact)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_MAINCONTACT;

		Object[] finderArgs = new Object[] { sampleCollectionDbId, mainContact };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SAMPLECOLLECTIONCONTACT_WHERE);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_MAINCONTACT_SAMPLECOLLECTIONDBID_2);

			query.append(_FINDER_COLUMN_SAMPLECOLLECTIONDBID_MAINCONTACT_MAINCONTACT_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(sampleCollectionDbId);

				qPos.add(mainContact);

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

	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_MAINCONTACT_SAMPLECOLLECTIONDBID_2 =
		"sampleCollectionContact.id.sampleCollectionDbId = ? AND ";
	private static final String _FINDER_COLUMN_SAMPLECOLLECTIONDBID_MAINCONTACT_MAINCONTACT_2 =
		"sampleCollectionContact.mainContact = ?";

	public SampleCollectionContactPersistenceImpl() {
		setModelClass(SampleCollectionContact.class);
	}

	/**
	 * Caches the sample collection contact in the entity cache if it is enabled.
	 *
	 * @param sampleCollectionContact the sample collection contact
	 */
	@Override
	public void cacheResult(SampleCollectionContact sampleCollectionContact) {
		EntityCacheUtil.putResult(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactImpl.class,
			sampleCollectionContact.getPrimaryKey(), sampleCollectionContact);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
			new Object[] {
				sampleCollectionContact.getSampleCollectionDbId(),
				sampleCollectionContact.getMainContact()
			}, sampleCollectionContact);

		sampleCollectionContact.resetOriginalValues();
	}

	/**
	 * Caches the sample collection contacts in the entity cache if it is enabled.
	 *
	 * @param sampleCollectionContacts the sample collection contacts
	 */
	@Override
	public void cacheResult(
		List<SampleCollectionContact> sampleCollectionContacts) {
		for (SampleCollectionContact sampleCollectionContact : sampleCollectionContacts) {
			if (EntityCacheUtil.getResult(
						SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
						SampleCollectionContactImpl.class,
						sampleCollectionContact.getPrimaryKey()) == null) {
				cacheResult(sampleCollectionContact);
			}
			else {
				sampleCollectionContact.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sample collection contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SampleCollectionContactImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SampleCollectionContactImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sample collection contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SampleCollectionContact sampleCollectionContact) {
		EntityCacheUtil.removeResult(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactImpl.class,
			sampleCollectionContact.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(sampleCollectionContact);
	}

	@Override
	public void clearCache(
		List<SampleCollectionContact> sampleCollectionContacts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SampleCollectionContact sampleCollectionContact : sampleCollectionContacts) {
			EntityCacheUtil.removeResult(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
				SampleCollectionContactImpl.class,
				sampleCollectionContact.getPrimaryKey());

			clearUniqueFindersCache(sampleCollectionContact);
		}
	}

	protected void cacheUniqueFindersCache(
		SampleCollectionContact sampleCollectionContact) {
		if (sampleCollectionContact.isNew()) {
			Object[] args = new Object[] {
					sampleCollectionContact.getSampleCollectionDbId(),
					sampleCollectionContact.getMainContact()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
				args, sampleCollectionContact);
		}
		else {
			SampleCollectionContactModelImpl sampleCollectionContactModelImpl = (SampleCollectionContactModelImpl)sampleCollectionContact;

			if ((sampleCollectionContactModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sampleCollectionContact.getSampleCollectionDbId(),
						sampleCollectionContact.getMainContact()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
					args, sampleCollectionContact);
			}
		}
	}

	protected void clearUniqueFindersCache(
		SampleCollectionContact sampleCollectionContact) {
		SampleCollectionContactModelImpl sampleCollectionContactModelImpl = (SampleCollectionContactModelImpl)sampleCollectionContact;

		Object[] args = new Object[] {
				sampleCollectionContact.getSampleCollectionDbId(),
				sampleCollectionContact.getMainContact()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
			args);

		if ((sampleCollectionContactModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT.getColumnBitmask()) != 0) {
			args = new Object[] {
					sampleCollectionContactModelImpl.getOriginalSampleCollectionDbId(),
					sampleCollectionContactModelImpl.getOriginalMainContact()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SAMPLECOLLECTIONDBID_MAINCONTACT,
				args);
		}
	}

	/**
	 * Creates a new sample collection contact with the primary key. Does not add the sample collection contact to the database.
	 *
	 * @param sampleCollectionContactPK the primary key for the new sample collection contact
	 * @return the new sample collection contact
	 */
	@Override
	public SampleCollectionContact create(
		SampleCollectionContactPK sampleCollectionContactPK) {
		SampleCollectionContact sampleCollectionContact = new SampleCollectionContactImpl();

		sampleCollectionContact.setNew(true);
		sampleCollectionContact.setPrimaryKey(sampleCollectionContactPK);

		return sampleCollectionContact;
	}

	/**
	 * Removes the sample collection contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sampleCollectionContactPK the primary key of the sample collection contact
	 * @return the sample collection contact that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact remove(
		SampleCollectionContactPK sampleCollectionContactPK)
		throws NoSuchSampleCollectionContactException, SystemException {
		return remove((Serializable)sampleCollectionContactPK);
	}

	/**
	 * Removes the sample collection contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sample collection contact
	 * @return the sample collection contact that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact remove(Serializable primaryKey)
		throws NoSuchSampleCollectionContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SampleCollectionContact sampleCollectionContact = (SampleCollectionContact)session.get(SampleCollectionContactImpl.class,
					primaryKey);

			if (sampleCollectionContact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSampleCollectionContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sampleCollectionContact);
		}
		catch (NoSuchSampleCollectionContactException nsee) {
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
	protected SampleCollectionContact removeImpl(
		SampleCollectionContact sampleCollectionContact)
		throws SystemException {
		sampleCollectionContact = toUnwrappedModel(sampleCollectionContact);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sampleCollectionContact)) {
				sampleCollectionContact = (SampleCollectionContact)session.get(SampleCollectionContactImpl.class,
						sampleCollectionContact.getPrimaryKeyObj());
			}

			if (sampleCollectionContact != null) {
				session.delete(sampleCollectionContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sampleCollectionContact != null) {
			clearCache(sampleCollectionContact);
		}

		return sampleCollectionContact;
	}

	@Override
	public SampleCollectionContact updateImpl(
		com.bcnet.portlet.biobank.model.SampleCollectionContact sampleCollectionContact)
		throws SystemException {
		sampleCollectionContact = toUnwrappedModel(sampleCollectionContact);

		boolean isNew = sampleCollectionContact.isNew();

		SampleCollectionContactModelImpl sampleCollectionContactModelImpl = (SampleCollectionContactModelImpl)sampleCollectionContact;

		Session session = null;

		try {
			session = openSession();

			if (sampleCollectionContact.isNew()) {
				session.save(sampleCollectionContact);

				sampleCollectionContact.setNew(false);
			}
			else {
				session.merge(sampleCollectionContact);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SampleCollectionContactModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sampleCollectionContactModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sampleCollectionContactModelImpl.getOriginalSampleCollectionDbId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID,
					args);

				args = new Object[] {
						sampleCollectionContactModelImpl.getSampleCollectionDbId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SAMPLECOLLECTIONDBID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SAMPLECOLLECTIONDBID,
					args);
			}
		}

		EntityCacheUtil.putResult(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
			SampleCollectionContactImpl.class,
			sampleCollectionContact.getPrimaryKey(), sampleCollectionContact);

		clearUniqueFindersCache(sampleCollectionContact);
		cacheUniqueFindersCache(sampleCollectionContact);

		return sampleCollectionContact;
	}

	protected SampleCollectionContact toUnwrappedModel(
		SampleCollectionContact sampleCollectionContact) {
		if (sampleCollectionContact instanceof SampleCollectionContactImpl) {
			return sampleCollectionContact;
		}

		SampleCollectionContactImpl sampleCollectionContactImpl = new SampleCollectionContactImpl();

		sampleCollectionContactImpl.setNew(sampleCollectionContact.isNew());
		sampleCollectionContactImpl.setPrimaryKey(sampleCollectionContact.getPrimaryKey());

		sampleCollectionContactImpl.setSampleCollectionDbId(sampleCollectionContact.getSampleCollectionDbId());
		sampleCollectionContactImpl.setUserId(sampleCollectionContact.getUserId());
		sampleCollectionContactImpl.setMainContact(sampleCollectionContact.isMainContact());
		sampleCollectionContactImpl.setSampleCollectionOwner(sampleCollectionContact.isSampleCollectionOwner());
		sampleCollectionContactImpl.setSampleCollectionEditor(sampleCollectionContact.isSampleCollectionEditor());

		return sampleCollectionContactImpl;
	}

	/**
	 * Returns the sample collection contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample collection contact
	 * @return the sample collection contact
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSampleCollectionContactException, SystemException {
		SampleCollectionContact sampleCollectionContact = fetchByPrimaryKey(primaryKey);

		if (sampleCollectionContact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSampleCollectionContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sampleCollectionContact;
	}

	/**
	 * Returns the sample collection contact with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException} if it could not be found.
	 *
	 * @param sampleCollectionContactPK the primary key of the sample collection contact
	 * @return the sample collection contact
	 * @throws com.bcnet.portlet.biobank.NoSuchSampleCollectionContactException if a sample collection contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact findByPrimaryKey(
		SampleCollectionContactPK sampleCollectionContactPK)
		throws NoSuchSampleCollectionContactException, SystemException {
		return findByPrimaryKey((Serializable)sampleCollectionContactPK);
	}

	/**
	 * Returns the sample collection contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sample collection contact
	 * @return the sample collection contact, or <code>null</code> if a sample collection contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SampleCollectionContact sampleCollectionContact = (SampleCollectionContact)EntityCacheUtil.getResult(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
				SampleCollectionContactImpl.class, primaryKey);

		if (sampleCollectionContact == _nullSampleCollectionContact) {
			return null;
		}

		if (sampleCollectionContact == null) {
			Session session = null;

			try {
				session = openSession();

				sampleCollectionContact = (SampleCollectionContact)session.get(SampleCollectionContactImpl.class,
						primaryKey);

				if (sampleCollectionContact != null) {
					cacheResult(sampleCollectionContact);
				}
				else {
					EntityCacheUtil.putResult(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
						SampleCollectionContactImpl.class, primaryKey,
						_nullSampleCollectionContact);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SampleCollectionContactModelImpl.ENTITY_CACHE_ENABLED,
					SampleCollectionContactImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sampleCollectionContact;
	}

	/**
	 * Returns the sample collection contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sampleCollectionContactPK the primary key of the sample collection contact
	 * @return the sample collection contact, or <code>null</code> if a sample collection contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SampleCollectionContact fetchByPrimaryKey(
		SampleCollectionContactPK sampleCollectionContactPK)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)sampleCollectionContactPK);
	}

	/**
	 * Returns all the sample collection contacts.
	 *
	 * @return the sample collection contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionContact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the sample collection contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample collection contacts
	 * @param end the upper bound of the range of sample collection contacts (not inclusive)
	 * @return the range of sample collection contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionContact> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the sample collection contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.SampleCollectionContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of sample collection contacts
	 * @param end the upper bound of the range of sample collection contacts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of sample collection contacts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SampleCollectionContact> findAll(int start, int end,
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

		List<SampleCollectionContact> list = (List<SampleCollectionContact>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAMPLECOLLECTIONCONTACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAMPLECOLLECTIONCONTACT;

				if (pagination) {
					sql = sql.concat(SampleCollectionContactModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SampleCollectionContact>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SampleCollectionContact>(list);
				}
				else {
					list = (List<SampleCollectionContact>)QueryUtil.list(q,
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
	 * Removes all the sample collection contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SampleCollectionContact sampleCollectionContact : findAll()) {
			remove(sampleCollectionContact);
		}
	}

	/**
	 * Returns the number of sample collection contacts.
	 *
	 * @return the number of sample collection contacts
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

				Query q = session.createQuery(_SQL_COUNT_SAMPLECOLLECTIONCONTACT);

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
	 * Initializes the sample collection contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.SampleCollectionContact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SampleCollectionContact>> listenersList = new ArrayList<ModelListener<SampleCollectionContact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SampleCollectionContact>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SampleCollectionContactImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SAMPLECOLLECTIONCONTACT = "SELECT sampleCollectionContact FROM SampleCollectionContact sampleCollectionContact";
	private static final String _SQL_SELECT_SAMPLECOLLECTIONCONTACT_WHERE = "SELECT sampleCollectionContact FROM SampleCollectionContact sampleCollectionContact WHERE ";
	private static final String _SQL_COUNT_SAMPLECOLLECTIONCONTACT = "SELECT COUNT(sampleCollectionContact) FROM SampleCollectionContact sampleCollectionContact";
	private static final String _SQL_COUNT_SAMPLECOLLECTIONCONTACT_WHERE = "SELECT COUNT(sampleCollectionContact) FROM SampleCollectionContact sampleCollectionContact WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sampleCollectionContact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SampleCollectionContact exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SampleCollectionContact exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SampleCollectionContactPersistenceImpl.class);
	private static SampleCollectionContact _nullSampleCollectionContact = new SampleCollectionContactImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SampleCollectionContact> toCacheModel() {
				return _nullSampleCollectionContactCacheModel;
			}
		};

	private static CacheModel<SampleCollectionContact> _nullSampleCollectionContactCacheModel =
		new CacheModel<SampleCollectionContact>() {
			@Override
			public SampleCollectionContact toEntityModel() {
				return _nullSampleCollectionContact;
			}
		};
}