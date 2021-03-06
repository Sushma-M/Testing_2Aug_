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

import com.testing26thjuly_.db123testing.Utable2;

/**
 * Service object for domain model class Utable2.
 *
 * @see {@link Utable2}
 */
public interface Utable2Service {

    /**
     * Creates a new Utable2.
     *
     * @param utable2 The information of the created CompositeTable.
     * @return The created Utable2.
     */
	Utable2 create(Utable2 utable2);


	/**
	 * Finds Utable2 by id.
	 *
	 * @param utable2Id The id of the wanted Utable2.
	 * @return The found Utable2. If no Utable2 is found, this method returns null.
	 */
	Utable2 getById(String utable2Id) throws EntityNotFoundException;

	/**
	 * Updates the information of a Utable2.
	 *
	 * @param utable2 The information of the updated Utable2.
	 * @return The updated Utable2.
     *
	 * @throws EntityNotFoundException if no Utable2 is found with given id.
	 */
	Utable2 update(Utable2 utable2) throws EntityNotFoundException;

    /**
	 * Deletes a Utable2.
	 *
	 * @param utable2Id The id of the deleted Utable2.
	 * @return The deleted Utable2.
     *
	 * @throws EntityNotFoundException if no Utable2 is found with the given id.
	 */
	Utable2 delete(String utable2Id) throws EntityNotFoundException;

	/**
	 * Finds all Utable2s.
	 *
	 * @return A list of Utable2s.
	 */
    @Deprecated
	Page<Utable2> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Utable2s.
	 * @return A list of Utable2s.
	 */
    Page<Utable2> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Utable2s in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Utable2.
	 */
	long count(String query);

    Page<Utable2> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

