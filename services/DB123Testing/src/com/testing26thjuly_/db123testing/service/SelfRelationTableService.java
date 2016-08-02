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

import com.testing26thjuly_.db123testing.SelfRelationTable;

/**
 * Service object for domain model class SelfRelationTable.
 *
 * @see {@link SelfRelationTable}
 */
public interface SelfRelationTableService {

    /**
     * Creates a new SelfRelationTable.
     *
     * @param selfRelationTable The information of the created CompositeTable.
     * @return The created SelfRelationTable.
     */
	SelfRelationTable create(SelfRelationTable selfRelationTable);


	/**
	 * Finds SelfRelationTable by id.
	 *
	 * @param selfRelationTableId The id of the wanted SelfRelationTable.
	 * @return The found SelfRelationTable. If no SelfRelationTable is found, this method returns null.
	 */
	SelfRelationTable getById(Integer selfRelationTableId) throws EntityNotFoundException;

	/**
	 * Updates the information of a SelfRelationTable.
	 *
	 * @param selfRelationTable The information of the updated SelfRelationTable.
	 * @return The updated SelfRelationTable.
     *
	 * @throws EntityNotFoundException if no SelfRelationTable is found with given id.
	 */
	SelfRelationTable update(SelfRelationTable selfRelationTable) throws EntityNotFoundException;

    /**
	 * Deletes a SelfRelationTable.
	 *
	 * @param selfRelationTableId The id of the deleted SelfRelationTable.
	 * @return The deleted SelfRelationTable.
     *
	 * @throws EntityNotFoundException if no SelfRelationTable is found with the given id.
	 */
	SelfRelationTable delete(Integer selfRelationTableId) throws EntityNotFoundException;

	/**
	 * Finds all SelfRelationTables.
	 *
	 * @return A list of SelfRelationTables.
	 */
    @Deprecated
	Page<SelfRelationTable> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all SelfRelationTables.
	 * @return A list of SelfRelationTables.
	 */
    Page<SelfRelationTable> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the SelfRelationTables in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the SelfRelationTable.
	 */
	long count(String query);

    Page<SelfRelationTable> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}
