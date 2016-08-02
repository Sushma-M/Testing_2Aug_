/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.testing26thjuly_.wmstudio.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;

import com.testing26thjuly_.wmstudio.TFTable;

/**
 * Service object for domain model class TFTable.
 *
 * @see {@link TFTable}
 */
public interface TFTableService {

    /**
     * Creates a new TFTable.
     *
     * @param tFTable The information of the created CompositeTable.
     * @return The created TFTable.
     */
	TFTable create(TFTable tFTable);


	/**
	 * Finds TFTable by id.
	 *
	 * @param tFTableId The id of the wanted TFTable.
	 * @return The found TFTable. If no TFTable is found, this method returns null.
	 */
	TFTable getById(Integer tFTableId) throws EntityNotFoundException;

	/**
	 * Updates the information of a TFTable.
	 *
	 * @param tFTable The information of the updated TFTable.
	 * @return The updated TFTable.
     *
	 * @throws EntityNotFoundException if no TFTable is found with given id.
	 */
	TFTable update(TFTable tFTable) throws EntityNotFoundException;

    /**
	 * Deletes a TFTable.
	 *
	 * @param tFTableId The id of the deleted TFTable.
	 * @return The deleted TFTable.
     *
	 * @throws EntityNotFoundException if no TFTable is found with the given id.
	 */
	TFTable delete(Integer tFTableId) throws EntityNotFoundException;

	/**
	 * Finds all TFTables.
	 *
	 * @return A list of TFTables.
	 */
    @Deprecated
	Page<TFTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all TFTables.
	 * @return A list of TFTables.
	 */
    Page<TFTable> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the TFTables in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the TFTable.
	 */
	long count(String query);

    Page<TFTable> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}
