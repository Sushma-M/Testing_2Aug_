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

import com.testing26thjuly_.db123testing.ViewUser;
import com.testing26thjuly_.db123testing.ViewUserId;

/**
 * Service object for domain model class ViewUser.
 *
 * @see {@link ViewUser}
 */
public interface ViewUserService {


	/**
	 * Finds ViewUser by id.
	 *
	 * @param viewUserId The id of the wanted ViewUser.
	 * @return The found ViewUser. If no ViewUser is found, this method returns null.
	 */
	ViewUser getById(ViewUserId viewUserId) throws EntityNotFoundException;

	/**
	 * Finds all ViewUsers.
	 *
	 * @return A list of ViewUsers.
	 */
    @Deprecated
	Page<ViewUser> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ViewUsers.
	 * @return A list of ViewUsers.
	 */
    Page<ViewUser> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ViewUsers in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ViewUser.
	 */
	long count(String query);

    Page<ViewUser> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

