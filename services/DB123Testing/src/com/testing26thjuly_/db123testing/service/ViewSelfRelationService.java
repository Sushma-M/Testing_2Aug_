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

import com.testing26thjuly_.db123testing.ViewSelfRelation;
import com.testing26thjuly_.db123testing.ViewSelfRelationId;

/**
 * Service object for domain model class ViewSelfRelation.
 *
 * @see {@link ViewSelfRelation}
 */
public interface ViewSelfRelationService {


	/**
	 * Finds ViewSelfRelation by id.
	 *
	 * @param viewSelfRelationId The id of the wanted ViewSelfRelation.
	 * @return The found ViewSelfRelation. If no ViewSelfRelation is found, this method returns null.
	 */
	ViewSelfRelation getById(ViewSelfRelationId viewSelfRelationId) throws EntityNotFoundException;

	/**
	 * Finds all ViewSelfRelations.
	 *
	 * @return A list of ViewSelfRelations.
	 */
    @Deprecated
	Page<ViewSelfRelation> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all ViewSelfRelations.
	 * @return A list of ViewSelfRelations.
	 */
    Page<ViewSelfRelation> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the ViewSelfRelations in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the ViewSelfRelation.
	 */
	long count(String query);

    Page<ViewSelfRelation> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}

