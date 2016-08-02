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

import com.testing26thjuly_.wmstudio.Skill;

/**
 * Service object for domain model class Skill.
 *
 * @see {@link Skill}
 */
public interface SkillService {

    /**
     * Creates a new Skill.
     *
     * @param skill The information of the created CompositeTable.
     * @return The created Skill.
     */
	Skill create(Skill skill);


	/**
	 * Finds Skill by id.
	 *
	 * @param skillId The id of the wanted Skill.
	 * @return The found Skill. If no Skill is found, this method returns null.
	 */
	Skill getById(Double skillId) throws EntityNotFoundException;

	/**
	 * Updates the information of a Skill.
	 *
	 * @param skill The information of the updated Skill.
	 * @return The updated Skill.
     *
	 * @throws EntityNotFoundException if no Skill is found with given id.
	 */
	Skill update(Skill skill) throws EntityNotFoundException;

    /**
	 * Deletes a Skill.
	 *
	 * @param skillId The id of the deleted Skill.
	 * @return The deleted Skill.
     *
	 * @throws EntityNotFoundException if no Skill is found with the given id.
	 */
	Skill delete(Double skillId) throws EntityNotFoundException;

	/**
	 * Finds all Skills.
	 *
	 * @return A list of Skills.
	 */
    @Deprecated
	Page<Skill> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
	 * Finds all Skills.
	 * @return A list of Skills.
	 */
    Page<Skill> findAll(String query, Pageable pageable);

    Downloadable export(ExportType exportType, String query, Pageable pageable);

	/**
	 * Retrieve the count of the Skills in the repository with matching query.
     *
     * @param query query to filter results.
	 * @return The count of the Skill.
	 */
	long count(String query);

    Page<Skill> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);

}
