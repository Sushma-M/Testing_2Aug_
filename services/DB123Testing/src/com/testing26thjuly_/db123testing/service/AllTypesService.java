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

import com.testing26thjuly_.db123testing.AllTypes;

/**
 * Service object for domain model class AllTypes.
 *
 * @see {@link AllTypes}
 */
public interface AllTypesService {

    /**
     * Creates a new AllTypes.
     *
     * @param allTypes The information of the created CompositeTable.
     * @return The created AllTypes.
     */
	AllTypes create(AllTypes allTypes);


	/**
	 * Finds AllTypes by id.
	 *
	 * @param allTypesId The id of the wanted AllTypes.
	 * @return The found AllTypes. If no AllTypes is found, this method returns null.
	 */
	AllTypes getById(Integer allTypesId) throws EntityNotFoundException;

	/**
	 * Updates the information of a AllTypes.
	 *
	 * @param allTypes The information of the updated AllTypes.
	 * @return The updated AllTypes.
     *
	 * @throws EntityNotFoundException if no AllTypes is found with given id.
	 */
	AllTypes update(AllTypes allTypes) throws EntityNotFoundException;

    /**
	 * Deletes a AllTypes.
	 *
	 * @param allTypesId The id of the deleted AllTypes.
	 * @return The deleted AllTypes.
     *
	 * @throws EntityNotFoundException if no AllTypes is found with the given id.
	 */
	AllTypes delete(Integer allTypesId) throws EntityNotFoundException;

	/**
	 * Finds all AllTypes.
	 *
	 * @return A list of AllTypes.
	 */
    @Deprecated
	Page<AllTypes> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all AllTypes.
	 * @return A list of AllTypes.
	 */
    Page<AllTypes> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the AllTypes in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the AllTypes.
	 */
	long count(String query);

    Page<AllTypes> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

