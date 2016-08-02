/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.compositestest.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing26thjuly_.compositestest.Table3;

/**
 * Service object for domain model class Table3.
 *
 * @see {@link Table3}
 */
public interface Table3Service {

    /**
     * Creates a new Table3.
     *
     * @param table3 The information of the created CompositeTable.
     * @return The created Table3.
     */
	Table3 create(Table3 table3);


	/**
	 * Finds Table3 by id.
	 *
	 * @param table3Id The id of the wanted Table3.
	 * @return The found Table3. If no Table3 is found, this method returns null.
	 */
	Table3 getById(String table3Id) throws EntityNotFoundException;

	/**
	 * Updates the information of a Table3.
	 *
	 * @param table3 The information of the updated Table3.
	 * @return The updated Table3.
     *
	 * @throws EntityNotFoundException if no Table3 is found with given id.
	 */
	Table3 update(Table3 table3) throws EntityNotFoundException;

    /**
	 * Deletes a Table3.
	 *
	 * @param table3Id The id of the deleted Table3.
	 * @return The deleted Table3.
     *
	 * @throws EntityNotFoundException if no Table3 is found with the given id.
	 */
	Table3 delete(String table3Id) throws EntityNotFoundException;

	/**
	 * Finds all Table3s.
	 *
	 * @return A list of Table3s.
	 */
    @Deprecated
	Page<Table3> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Table3s.
	 * @return A list of Table3s.
	 */
    Page<Table3> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Table3s in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Table3.
	 */
	long count(String query);

    Page<Table3> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}
