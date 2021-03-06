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

import com.testing26thjuly_.wmstudio.Alltypes;

/**
 * Service object for domain model class Alltypes.
 *
 * @see {@link Alltypes}
 */
public interface AlltypesService {

    /**
     * Creates a new Alltypes.
     *
     * @param alltypes The information of the created CompositeTable.
     * @return The created Alltypes.
     */
	Alltypes create(Alltypes alltypes);


	/**
	 * Finds Alltypes by id.
	 *
	 * @param alltypesId The id of the wanted Alltypes.
	 * @return The found Alltypes. If no Alltypes is found, this method returns null.
	 */
	Alltypes getById(Integer alltypesId) throws EntityNotFoundException;

	/**
	 * Updates the information of a Alltypes.
	 *
	 * @param alltypes The information of the updated Alltypes.
	 * @return The updated Alltypes.
     *
	 * @throws EntityNotFoundException if no Alltypes is found with given id.
	 */
	Alltypes update(Alltypes alltypes) throws EntityNotFoundException;

    /**
	 * Deletes a Alltypes.
	 *
	 * @param alltypesId The id of the deleted Alltypes.
	 * @return The deleted Alltypes.
     *
	 * @throws EntityNotFoundException if no Alltypes is found with the given id.
	 */
	Alltypes delete(Integer alltypesId) throws EntityNotFoundException;

	/**
	 * Finds all Alltypes.
	 *
	 * @return A list of Alltypes.
	 */
    @Deprecated
	Page<Alltypes> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Alltypes.
	 * @return A list of Alltypes.
	 */
    Page<Alltypes> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Alltypes in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Alltypes.
	 */
	long count(String query);

    Page<Alltypes> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

