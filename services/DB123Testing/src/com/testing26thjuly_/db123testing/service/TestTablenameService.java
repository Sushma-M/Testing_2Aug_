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

import com.testing26thjuly_.db123testing.TestTablename;

/**
 * Service object for domain model class TestTablename.
 *
 * @see {@link TestTablename}
 */
public interface TestTablenameService {

    /**
     * Creates a new TestTablename.
     *
     * @param testTablename The information of the created CompositeTable.
     * @return The created TestTablename.
     */
	TestTablename create(TestTablename testTablename);


	/**
	 * Finds TestTablename by id.
	 *
	 * @param testTablenameId The id of the wanted TestTablename.
	 * @return The found TestTablename. If no TestTablename is found, this method returns null.
	 */
	TestTablename getById(Integer testTablenameId) throws EntityNotFoundException;

	/**
	 * Updates the information of a TestTablename.
	 *
	 * @param testTablename The information of the updated TestTablename.
	 * @return The updated TestTablename.
     *
	 * @throws EntityNotFoundException if no TestTablename is found with given id.
	 */
	TestTablename update(TestTablename testTablename) throws EntityNotFoundException;

    /**
	 * Deletes a TestTablename.
	 *
	 * @param testTablenameId The id of the deleted TestTablename.
	 * @return The deleted TestTablename.
     *
	 * @throws EntityNotFoundException if no TestTablename is found with the given id.
	 */
	TestTablename delete(Integer testTablenameId) throws EntityNotFoundException;

	/**
	 * Finds all TestTablenames.
	 *
	 * @return A list of TestTablenames.
	 */
    @Deprecated
	Page<TestTablename> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all TestTablenames.
	 * @return A list of TestTablenames.
	 */
    Page<TestTablename> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the TestTablenames in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the TestTablename.
	 */
	long count(String query);

    Page<TestTablename> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}
