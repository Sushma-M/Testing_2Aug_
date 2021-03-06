/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.demo.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing26thjuly_.demo.Table12;

/**
 * Service object for domain model class Table12.
 *
 * @see {@link Table12}
 */
public interface Table12Service {

    /**
     * Creates a new Table12.
     *
     * @param table12 The information of the created CompositeTable.
     * @return The created Table12.
     */
	Table12 create(Table12 table12);


	/**
	 * Finds Table12 by id.
	 *
	 * @param table12Id The id of the wanted Table12.
	 * @return The found Table12. If no Table12 is found, this method returns null.
	 */
	Table12 getById(Integer table12Id) throws EntityNotFoundException;

	/**
	 * Updates the information of a Table12.
	 *
	 * @param table12 The information of the updated Table12.
	 * @return The updated Table12.
     *
	 * @throws EntityNotFoundException if no Table12 is found with given id.
	 */
	Table12 update(Table12 table12) throws EntityNotFoundException;

    /**
	 * Deletes a Table12.
	 *
	 * @param table12Id The id of the deleted Table12.
	 * @return The deleted Table12.
     *
	 * @throws EntityNotFoundException if no Table12 is found with the given id.
	 */
	Table12 delete(Integer table12Id) throws EntityNotFoundException;

	/**
	 * Finds all Table12s.
	 *
	 * @return A list of Table12s.
	 */
    @Deprecated
	Page<Table12> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Table12s.
	 * @return A list of Table12s.
	 */
    Page<Table12> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Table12s in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Table12.
	 */
	long count(String query);

    Page<Table12> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

