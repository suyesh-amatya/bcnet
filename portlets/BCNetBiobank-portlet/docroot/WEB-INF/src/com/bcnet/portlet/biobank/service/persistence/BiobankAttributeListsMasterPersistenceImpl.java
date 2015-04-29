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

import com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException;
import com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster;
import com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterImpl;
import com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterModelImpl;

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
 * The persistence implementation for the biobank attribute lists master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author suyama
 * @see BiobankAttributeListsMasterPersistence
 * @see BiobankAttributeListsMasterUtil
 * @generated
 */
public class BiobankAttributeListsMasterPersistenceImpl
	extends BasePersistenceImpl<BiobankAttributeListsMaster>
	implements BiobankAttributeListsMasterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BiobankAttributeListsMasterUtil} to access the biobank attribute lists master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BiobankAttributeListsMasterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTRIBUTE =
		new FinderPath(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByattribute",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE =
		new FinderPath(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			BiobankAttributeListsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByattribute",
			new String[] { String.class.getName() },
			BiobankAttributeListsMasterModelImpl.ATTRIBUTELISTNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ATTRIBUTE = new FinderPath(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsMasterModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByattribute", new String[] { String.class.getName() });

	/**
	 * Returns all the biobank attribute lists masters where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @return the matching biobank attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAttributeListsMaster> findByattribute(
		String attributeListName) throws SystemException {
		return findByattribute(attributeListName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the biobank attribute lists masters where attributeListName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attributeListName the attribute list name
	 * @param start the lower bound of the range of biobank attribute lists masters
	 * @param end the upper bound of the range of biobank attribute lists masters (not inclusive)
	 * @return the range of matching biobank attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAttributeListsMaster> findByattribute(
		String attributeListName, int start, int end) throws SystemException {
		return findByattribute(attributeListName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the biobank attribute lists masters where attributeListName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param attributeListName the attribute list name
	 * @param start the lower bound of the range of biobank attribute lists masters
	 * @param end the upper bound of the range of biobank attribute lists masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching biobank attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAttributeListsMaster> findByattribute(
		String attributeListName, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE;
			finderArgs = new Object[] { attributeListName };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ATTRIBUTE;
			finderArgs = new Object[] {
					attributeListName,
					
					start, end, orderByComparator
				};
		}

		List<BiobankAttributeListsMaster> list = (List<BiobankAttributeListsMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BiobankAttributeListsMaster biobankAttributeListsMaster : list) {
				if (!Validator.equals(attributeListName,
							biobankAttributeListsMaster.getAttributeListName())) {
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

			query.append(_SQL_SELECT_BIOBANKATTRIBUTELISTSMASTER_WHERE);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BiobankAttributeListsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindAttributeListName) {
					qPos.add(attributeListName);
				}

				if (!pagination) {
					list = (List<BiobankAttributeListsMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankAttributeListsMaster>(list);
				}
				else {
					list = (List<BiobankAttributeListsMaster>)QueryUtil.list(q,
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
	 * Returns the first biobank attribute lists master in the ordered set where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching biobank attribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException if a matching biobank attribute lists master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster findByattribute_First(
		String attributeListName, OrderByComparator orderByComparator)
		throws NoSuchBiobankAttributeListsMasterException, SystemException {
		BiobankAttributeListsMaster biobankAttributeListsMaster = fetchByattribute_First(attributeListName,
				orderByComparator);

		if (biobankAttributeListsMaster != null) {
			return biobankAttributeListsMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attributeListName=");
		msg.append(attributeListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBiobankAttributeListsMasterException(msg.toString());
	}

	/**
	 * Returns the first biobank attribute lists master in the ordered set where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching biobank attribute lists master, or <code>null</code> if a matching biobank attribute lists master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster fetchByattribute_First(
		String attributeListName, OrderByComparator orderByComparator)
		throws SystemException {
		List<BiobankAttributeListsMaster> list = findByattribute(attributeListName,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last biobank attribute lists master in the ordered set where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching biobank attribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException if a matching biobank attribute lists master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster findByattribute_Last(
		String attributeListName, OrderByComparator orderByComparator)
		throws NoSuchBiobankAttributeListsMasterException, SystemException {
		BiobankAttributeListsMaster biobankAttributeListsMaster = fetchByattribute_Last(attributeListName,
				orderByComparator);

		if (biobankAttributeListsMaster != null) {
			return biobankAttributeListsMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("attributeListName=");
		msg.append(attributeListName);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBiobankAttributeListsMasterException(msg.toString());
	}

	/**
	 * Returns the last biobank attribute lists master in the ordered set where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching biobank attribute lists master, or <code>null</code> if a matching biobank attribute lists master could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster fetchByattribute_Last(
		String attributeListName, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByattribute(attributeListName);

		if (count == 0) {
			return null;
		}

		List<BiobankAttributeListsMaster> list = findByattribute(attributeListName,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the biobank attribute lists masters before and after the current biobank attribute lists master in the ordered set where attributeListName = &#63;.
	 *
	 * @param biobankAttributeListsMasterId the primary key of the current biobank attribute lists master
	 * @param attributeListName the attribute list name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next biobank attribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException if a biobank attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster[] findByattribute_PrevAndNext(
		long biobankAttributeListsMasterId, String attributeListName,
		OrderByComparator orderByComparator)
		throws NoSuchBiobankAttributeListsMasterException, SystemException {
		BiobankAttributeListsMaster biobankAttributeListsMaster = findByPrimaryKey(biobankAttributeListsMasterId);

		Session session = null;

		try {
			session = openSession();

			BiobankAttributeListsMaster[] array = new BiobankAttributeListsMasterImpl[3];

			array[0] = getByattribute_PrevAndNext(session,
					biobankAttributeListsMaster, attributeListName,
					orderByComparator, true);

			array[1] = biobankAttributeListsMaster;

			array[2] = getByattribute_PrevAndNext(session,
					biobankAttributeListsMaster, attributeListName,
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

	protected BiobankAttributeListsMaster getByattribute_PrevAndNext(
		Session session,
		BiobankAttributeListsMaster biobankAttributeListsMaster,
		String attributeListName, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BIOBANKATTRIBUTELISTSMASTER_WHERE);

		boolean bindAttributeListName = false;

		if (attributeListName == null) {
			query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_1);
		}
		else if (attributeListName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_3);
		}
		else {
			bindAttributeListName = true;

			query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_2);
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
			query.append(BiobankAttributeListsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindAttributeListName) {
			qPos.add(attributeListName);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(biobankAttributeListsMaster);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BiobankAttributeListsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the biobank attribute lists masters where attributeListName = &#63; from the database.
	 *
	 * @param attributeListName the attribute list name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByattribute(String attributeListName)
		throws SystemException {
		for (BiobankAttributeListsMaster biobankAttributeListsMaster : findByattribute(
				attributeListName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(biobankAttributeListsMaster);
		}
	}

	/**
	 * Returns the number of biobank attribute lists masters where attributeListName = &#63;.
	 *
	 * @param attributeListName the attribute list name
	 * @return the number of matching biobank attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByattribute(String attributeListName)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ATTRIBUTE;

		Object[] finderArgs = new Object[] { attributeListName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BIOBANKATTRIBUTELISTSMASTER_WHERE);

			boolean bindAttributeListName = false;

			if (attributeListName == null) {
				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_1);
			}
			else if (attributeListName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_3);
			}
			else {
				bindAttributeListName = true;

				query.append(_FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_1 = "biobankAttributeListsMaster.attributeListName IS NULL";
	private static final String _FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_2 = "biobankAttributeListsMaster.attributeListName = ?";
	private static final String _FINDER_COLUMN_ATTRIBUTE_ATTRIBUTELISTNAME_3 = "(biobankAttributeListsMaster.attributeListName IS NULL OR biobankAttributeListsMaster.attributeListName = '')";

	public BiobankAttributeListsMasterPersistenceImpl() {
		setModelClass(BiobankAttributeListsMaster.class);
	}

	/**
	 * Caches the biobank attribute lists master in the entity cache if it is enabled.
	 *
	 * @param biobankAttributeListsMaster the biobank attribute lists master
	 */
	@Override
	public void cacheResult(
		BiobankAttributeListsMaster biobankAttributeListsMaster) {
		EntityCacheUtil.putResult(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsMasterImpl.class,
			biobankAttributeListsMaster.getPrimaryKey(),
			biobankAttributeListsMaster);

		biobankAttributeListsMaster.resetOriginalValues();
	}

	/**
	 * Caches the biobank attribute lists masters in the entity cache if it is enabled.
	 *
	 * @param biobankAttributeListsMasters the biobank attribute lists masters
	 */
	@Override
	public void cacheResult(
		List<BiobankAttributeListsMaster> biobankAttributeListsMasters) {
		for (BiobankAttributeListsMaster biobankAttributeListsMaster : biobankAttributeListsMasters) {
			if (EntityCacheUtil.getResult(
						BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
						BiobankAttributeListsMasterImpl.class,
						biobankAttributeListsMaster.getPrimaryKey()) == null) {
				cacheResult(biobankAttributeListsMaster);
			}
			else {
				biobankAttributeListsMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all biobank attribute lists masters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BiobankAttributeListsMasterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BiobankAttributeListsMasterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the biobank attribute lists master.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		BiobankAttributeListsMaster biobankAttributeListsMaster) {
		EntityCacheUtil.removeResult(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsMasterImpl.class,
			biobankAttributeListsMaster.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<BiobankAttributeListsMaster> biobankAttributeListsMasters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BiobankAttributeListsMaster biobankAttributeListsMaster : biobankAttributeListsMasters) {
			EntityCacheUtil.removeResult(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
				BiobankAttributeListsMasterImpl.class,
				biobankAttributeListsMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new biobank attribute lists master with the primary key. Does not add the biobank attribute lists master to the database.
	 *
	 * @param biobankAttributeListsMasterId the primary key for the new biobank attribute lists master
	 * @return the new biobank attribute lists master
	 */
	@Override
	public BiobankAttributeListsMaster create(
		long biobankAttributeListsMasterId) {
		BiobankAttributeListsMaster biobankAttributeListsMaster = new BiobankAttributeListsMasterImpl();

		biobankAttributeListsMaster.setNew(true);
		biobankAttributeListsMaster.setPrimaryKey(biobankAttributeListsMasterId);

		return biobankAttributeListsMaster;
	}

	/**
	 * Removes the biobank attribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param biobankAttributeListsMasterId the primary key of the biobank attribute lists master
	 * @return the biobank attribute lists master that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException if a biobank attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster remove(
		long biobankAttributeListsMasterId)
		throws NoSuchBiobankAttributeListsMasterException, SystemException {
		return remove((Serializable)biobankAttributeListsMasterId);
	}

	/**
	 * Removes the biobank attribute lists master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the biobank attribute lists master
	 * @return the biobank attribute lists master that was removed
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException if a biobank attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster remove(Serializable primaryKey)
		throws NoSuchBiobankAttributeListsMasterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BiobankAttributeListsMaster biobankAttributeListsMaster = (BiobankAttributeListsMaster)session.get(BiobankAttributeListsMasterImpl.class,
					primaryKey);

			if (biobankAttributeListsMaster == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBiobankAttributeListsMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(biobankAttributeListsMaster);
		}
		catch (NoSuchBiobankAttributeListsMasterException nsee) {
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
	protected BiobankAttributeListsMaster removeImpl(
		BiobankAttributeListsMaster biobankAttributeListsMaster)
		throws SystemException {
		biobankAttributeListsMaster = toUnwrappedModel(biobankAttributeListsMaster);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(biobankAttributeListsMaster)) {
				biobankAttributeListsMaster = (BiobankAttributeListsMaster)session.get(BiobankAttributeListsMasterImpl.class,
						biobankAttributeListsMaster.getPrimaryKeyObj());
			}

			if (biobankAttributeListsMaster != null) {
				session.delete(biobankAttributeListsMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (biobankAttributeListsMaster != null) {
			clearCache(biobankAttributeListsMaster);
		}

		return biobankAttributeListsMaster;
	}

	@Override
	public BiobankAttributeListsMaster updateImpl(
		com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster biobankAttributeListsMaster)
		throws SystemException {
		biobankAttributeListsMaster = toUnwrappedModel(biobankAttributeListsMaster);

		boolean isNew = biobankAttributeListsMaster.isNew();

		BiobankAttributeListsMasterModelImpl biobankAttributeListsMasterModelImpl =
			(BiobankAttributeListsMasterModelImpl)biobankAttributeListsMaster;

		Session session = null;

		try {
			session = openSession();

			if (biobankAttributeListsMaster.isNew()) {
				session.save(biobankAttributeListsMaster);

				biobankAttributeListsMaster.setNew(false);
			}
			else {
				session.merge(biobankAttributeListsMaster);
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
				!BiobankAttributeListsMasterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((biobankAttributeListsMasterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						biobankAttributeListsMasterModelImpl.getOriginalAttributeListName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTRIBUTE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE,
					args);

				args = new Object[] {
						biobankAttributeListsMasterModelImpl.getAttributeListName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ATTRIBUTE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ATTRIBUTE,
					args);
			}
		}

		EntityCacheUtil.putResult(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
			BiobankAttributeListsMasterImpl.class,
			biobankAttributeListsMaster.getPrimaryKey(),
			biobankAttributeListsMaster);

		return biobankAttributeListsMaster;
	}

	protected BiobankAttributeListsMaster toUnwrappedModel(
		BiobankAttributeListsMaster biobankAttributeListsMaster) {
		if (biobankAttributeListsMaster instanceof BiobankAttributeListsMasterImpl) {
			return biobankAttributeListsMaster;
		}

		BiobankAttributeListsMasterImpl biobankAttributeListsMasterImpl = new BiobankAttributeListsMasterImpl();

		biobankAttributeListsMasterImpl.setNew(biobankAttributeListsMaster.isNew());
		biobankAttributeListsMasterImpl.setPrimaryKey(biobankAttributeListsMaster.getPrimaryKey());

		biobankAttributeListsMasterImpl.setBiobankAttributeListsMasterId(biobankAttributeListsMaster.getBiobankAttributeListsMasterId());
		biobankAttributeListsMasterImpl.setAttributeListName(biobankAttributeListsMaster.getAttributeListName());
		biobankAttributeListsMasterImpl.setAttributeListValue(biobankAttributeListsMaster.getAttributeListValue());

		return biobankAttributeListsMasterImpl;
	}

	/**
	 * Returns the biobank attribute lists master with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank attribute lists master
	 * @return the biobank attribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException if a biobank attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBiobankAttributeListsMasterException, SystemException {
		BiobankAttributeListsMaster biobankAttributeListsMaster = fetchByPrimaryKey(primaryKey);

		if (biobankAttributeListsMaster == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBiobankAttributeListsMasterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return biobankAttributeListsMaster;
	}

	/**
	 * Returns the biobank attribute lists master with the primary key or throws a {@link com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException} if it could not be found.
	 *
	 * @param biobankAttributeListsMasterId the primary key of the biobank attribute lists master
	 * @return the biobank attribute lists master
	 * @throws com.bcnet.portlet.biobank.NoSuchBiobankAttributeListsMasterException if a biobank attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster findByPrimaryKey(
		long biobankAttributeListsMasterId)
		throws NoSuchBiobankAttributeListsMasterException, SystemException {
		return findByPrimaryKey((Serializable)biobankAttributeListsMasterId);
	}

	/**
	 * Returns the biobank attribute lists master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the biobank attribute lists master
	 * @return the biobank attribute lists master, or <code>null</code> if a biobank attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		BiobankAttributeListsMaster biobankAttributeListsMaster = (BiobankAttributeListsMaster)EntityCacheUtil.getResult(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
				BiobankAttributeListsMasterImpl.class, primaryKey);

		if (biobankAttributeListsMaster == _nullBiobankAttributeListsMaster) {
			return null;
		}

		if (biobankAttributeListsMaster == null) {
			Session session = null;

			try {
				session = openSession();

				biobankAttributeListsMaster = (BiobankAttributeListsMaster)session.get(BiobankAttributeListsMasterImpl.class,
						primaryKey);

				if (biobankAttributeListsMaster != null) {
					cacheResult(biobankAttributeListsMaster);
				}
				else {
					EntityCacheUtil.putResult(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
						BiobankAttributeListsMasterImpl.class, primaryKey,
						_nullBiobankAttributeListsMaster);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BiobankAttributeListsMasterModelImpl.ENTITY_CACHE_ENABLED,
					BiobankAttributeListsMasterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return biobankAttributeListsMaster;
	}

	/**
	 * Returns the biobank attribute lists master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param biobankAttributeListsMasterId the primary key of the biobank attribute lists master
	 * @return the biobank attribute lists master, or <code>null</code> if a biobank attribute lists master with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BiobankAttributeListsMaster fetchByPrimaryKey(
		long biobankAttributeListsMasterId) throws SystemException {
		return fetchByPrimaryKey((Serializable)biobankAttributeListsMasterId);
	}

	/**
	 * Returns all the biobank attribute lists masters.
	 *
	 * @return the biobank attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAttributeListsMaster> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the biobank attribute lists masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobank attribute lists masters
	 * @param end the upper bound of the range of biobank attribute lists masters (not inclusive)
	 * @return the range of biobank attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAttributeListsMaster> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the biobank attribute lists masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bcnet.portlet.biobank.model.impl.BiobankAttributeListsMasterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of biobank attribute lists masters
	 * @param end the upper bound of the range of biobank attribute lists masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of biobank attribute lists masters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BiobankAttributeListsMaster> findAll(int start, int end,
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

		List<BiobankAttributeListsMaster> list = (List<BiobankAttributeListsMaster>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BIOBANKATTRIBUTELISTSMASTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BIOBANKATTRIBUTELISTSMASTER;

				if (pagination) {
					sql = sql.concat(BiobankAttributeListsMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BiobankAttributeListsMaster>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BiobankAttributeListsMaster>(list);
				}
				else {
					list = (List<BiobankAttributeListsMaster>)QueryUtil.list(q,
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
	 * Removes all the biobank attribute lists masters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BiobankAttributeListsMaster biobankAttributeListsMaster : findAll()) {
			remove(biobankAttributeListsMaster);
		}
	}

	/**
	 * Returns the number of biobank attribute lists masters.
	 *
	 * @return the number of biobank attribute lists masters
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

				Query q = session.createQuery(_SQL_COUNT_BIOBANKATTRIBUTELISTSMASTER);

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
	 * Initializes the biobank attribute lists master persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.bcnet.portlet.biobank.model.BiobankAttributeListsMaster")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BiobankAttributeListsMaster>> listenersList = new ArrayList<ModelListener<BiobankAttributeListsMaster>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BiobankAttributeListsMaster>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BiobankAttributeListsMasterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BIOBANKATTRIBUTELISTSMASTER = "SELECT biobankAttributeListsMaster FROM BiobankAttributeListsMaster biobankAttributeListsMaster";
	private static final String _SQL_SELECT_BIOBANKATTRIBUTELISTSMASTER_WHERE = "SELECT biobankAttributeListsMaster FROM BiobankAttributeListsMaster biobankAttributeListsMaster WHERE ";
	private static final String _SQL_COUNT_BIOBANKATTRIBUTELISTSMASTER = "SELECT COUNT(biobankAttributeListsMaster) FROM BiobankAttributeListsMaster biobankAttributeListsMaster";
	private static final String _SQL_COUNT_BIOBANKATTRIBUTELISTSMASTER_WHERE = "SELECT COUNT(biobankAttributeListsMaster) FROM BiobankAttributeListsMaster biobankAttributeListsMaster WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "biobankAttributeListsMaster.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BiobankAttributeListsMaster exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BiobankAttributeListsMaster exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BiobankAttributeListsMasterPersistenceImpl.class);
	private static BiobankAttributeListsMaster _nullBiobankAttributeListsMaster = new BiobankAttributeListsMasterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BiobankAttributeListsMaster> toCacheModel() {
				return _nullBiobankAttributeListsMasterCacheModel;
			}
		};

	private static CacheModel<BiobankAttributeListsMaster> _nullBiobankAttributeListsMasterCacheModel =
		new CacheModel<BiobankAttributeListsMaster>() {
			@Override
			public BiobankAttributeListsMaster toEntityModel() {
				return _nullBiobankAttributeListsMaster;
			}
		};
}