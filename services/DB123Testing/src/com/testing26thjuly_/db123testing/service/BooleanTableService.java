/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.db123testing.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing26thjuly_.db123testing.BooleanTable;

/**
 * Service object for domain model class BooleanTable.
 *
 * @see {@link BooleanTable}
 */
public interface BooleanTableService {

    /**
     * Creates a new BooleanTable.
     *
     * @param booleanTable The information of the created CompositeTable.
     * @return The created BooleanTable.
     */
	BooleanTable create(BooleanTable booleanTable);


	/**
	 * Finds BooleanTable by id.
	 *
	 * @param booleanTableId The id of the wanted BooleanTable.
	 * @return The found BooleanTable. If no BooleanTable is found, this method returns null.
	 */
	BooleanTable getById(Integer booleanTableId) throws EntityNotFoundException;

	/**
	 * Updates the information of a BooleanTable.
	 *
	 * @param booleanTable The information of the updated BooleanTable.
	 * @return The updated BooleanTable.
     *
	 * @throws EntityNotFoundException if no BooleanTable is found with given id.
	 */
	BooleanTable update(BooleanTable booleanTable) throws EntityNotFoundException;

    /**
	 * Deletes a BooleanTable.
	 *
	 * @param booleanTableId The id of the deleted BooleanTable.
	 * @return The deleted BooleanTable.
     *
	 * @throws EntityNotFoundException if no BooleanTable is found with the given id.
	 */
	BooleanTable delete(Integer booleanTableId) throws EntityNotFoundException;

	/**
	 * Finds all BooleanTables.
	 *
	 * @return A list of BooleanTables.
	 */
    @Deprecated
	Page<BooleanTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all BooleanTables.
	 * @return A list of BooleanTables.
	 */
    Page<BooleanTable> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the BooleanTables in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the BooleanTable.
	 */
	long count(String query);

    Page<BooleanTable> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

