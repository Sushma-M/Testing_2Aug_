/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.testingdb123.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing26thjuly_.testingdb123.Table1Id;
import com.testing26thjuly_.testingdb123.Table6;

/**
 * Service object for domain model class Table6.
 *
 * @see {@link Table6}
 */
public interface Table6Service {

    /**
     * Creates a new Table6.
     *
     * @param table6 The information of the created CompositeTable.
     * @return The created Table6.
     */
	Table6 create(Table6 table6);


	/**
	 * Finds Table6 by id.
	 *
	 * @param table6Id The id of the wanted Table6.
	 * @return The found Table6. If no Table6 is found, this method returns null.
	 */
	Table6 getById(Table1Id table6Id) throws EntityNotFoundException;

	/**
	 * Updates the information of a Table6.
	 *
	 * @param table6 The information of the updated Table6.
	 * @return The updated Table6.
     *
	 * @throws EntityNotFoundException if no Table6 is found with given id.
	 */
	Table6 update(Table6 table6) throws EntityNotFoundException;

    /**
	 * Deletes a Table6.
	 *
	 * @param table6Id The id of the deleted Table6.
	 * @return The deleted Table6.
     *
	 * @throws EntityNotFoundException if no Table6 is found with the given id.
	 */
	Table6 delete(Table1Id table6Id) throws EntityNotFoundException;

	/**
	 * Finds all Table6s.
	 *
	 * @return A list of Table6s.
	 */
    @Deprecated
	Page<Table6> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Table6s.
	 * @return A list of Table6s.
	 */
    Page<Table6> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Table6s in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Table6.
	 */
	long count(String query);

    Page<Table6> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

