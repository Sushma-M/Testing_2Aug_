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

import com.testing26thjuly_.db123testing.Urtable2;

/**
 * Service object for domain model class Urtable2.
 *
 * @see {@link Urtable2}
 */
public interface Urtable2Service {

    /**
     * Creates a new Urtable2.
     *
     * @param urtable2 The information of the created CompositeTable.
     * @return The created Urtable2.
     */
	Urtable2 create(Urtable2 urtable2);


	/**
	 * Finds Urtable2 by id.
	 *
	 * @param urtable2Id The id of the wanted Urtable2.
	 * @return The found Urtable2. If no Urtable2 is found, this method returns null.
	 */
	Urtable2 getById(String urtable2Id) throws EntityNotFoundException;

	/**
	 * Updates the information of a Urtable2.
	 *
	 * @param urtable2 The information of the updated Urtable2.
	 * @return The updated Urtable2.
     *
	 * @throws EntityNotFoundException if no Urtable2 is found with given id.
	 */
	Urtable2 update(Urtable2 urtable2) throws EntityNotFoundException;

    /**
	 * Deletes a Urtable2.
	 *
	 * @param urtable2Id The id of the deleted Urtable2.
	 * @return The deleted Urtable2.
     *
	 * @throws EntityNotFoundException if no Urtable2 is found with the given id.
	 */
	Urtable2 delete(String urtable2Id) throws EntityNotFoundException;

	/**
	 * Finds all Urtable2s.
	 *
	 * @return A list of Urtable2s.
	 */
    @Deprecated
	Page<Urtable2> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Urtable2s.
	 * @return A list of Urtable2s.
	 */
    Page<Urtable2> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Urtable2s in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Urtable2.
	 */
	long count(String query);

    Page<Urtable2> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}
