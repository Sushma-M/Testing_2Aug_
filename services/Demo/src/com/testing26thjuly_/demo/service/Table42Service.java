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

import com.testing26thjuly_.demo.Table42;
import com.testing26thjuly_.demo.Table42Id;

/**
 * Service object for domain model class Table42.
 *
 * @see {@link Table42}
 */
public interface Table42Service {

    /**
     * Creates a new Table42.
     *
     * @param table42 The information of the created CompositeTable.
     * @return The created Table42.
     */
	Table42 create(Table42 table42);


	/**
	 * Finds Table42 by id.
	 *
	 * @param table42Id The id of the wanted Table42.
	 * @return The found Table42. If no Table42 is found, this method returns null.
	 */
	Table42 getById(Table42Id table42Id) throws EntityNotFoundException;

	/**
	 * Updates the information of a Table42.
	 *
	 * @param table42 The information of the updated Table42.
	 * @return The updated Table42.
     *
	 * @throws EntityNotFoundException if no Table42 is found with given id.
	 */
	Table42 update(Table42 table42) throws EntityNotFoundException;

    /**
	 * Deletes a Table42.
	 *
	 * @param table42Id The id of the deleted Table42.
	 * @return The deleted Table42.
     *
	 * @throws EntityNotFoundException if no Table42 is found with the given id.
	 */
	Table42 delete(Table42Id table42Id) throws EntityNotFoundException;

	/**
	 * Finds all Table42s.
	 *
	 * @return A list of Table42s.
	 */
    @Deprecated
	Page<Table42> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Table42s.
	 * @return A list of Table42s.
	 */
    Page<Table42> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Table42s in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Table42.
	 */
	long count(String query);

    Page<Table42> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

