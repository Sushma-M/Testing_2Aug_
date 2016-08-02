/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.wmstudio.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.testing26thjuly_.wmstudio.YNtable;
import com.testing26thjuly_.wmstudio.service.YNtableService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class YNtable.
 * @see YNtable
 */
@RestController("WMSTUDIO.YNtableController")
@RequestMapping("/WMSTUDIO/YNtable")
@Api(description = "Exposes APIs to work with YNtable resource.", value = "YNtableController")
public class YNtableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(YNtableController.class);

    @Autowired
    @Qualifier("WMSTUDIO.YNtableService")
    private YNtableService yNtableService;

    /**
     * @deprecated Use {@link #findYNtables(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of YNtable instances matching the search criteria.")
    public Page<YNtable> findYNtables(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering YNtables list");
        return yNtableService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of YNtable instances matching the search criteria.")
    public Page<YNtable> findYNtables(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering YNtables list");
        return yNtableService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportYNtables(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return yNtableService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service YNtableService instance
	 */
    protected void setYNtableService(YNtableService service) {
        this.yNtableService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new YNtable instance.")
    public YNtable createYNtable(@RequestBody YNtable yntable) {
        LOGGER.debug("Create YNtable with information: {}", yntable);
        yntable = yNtableService.create(yntable);
        LOGGER.debug("Created YNtable with information: {}", yntable);
        return yntable;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of YNtable instances.")
    public Long countYNtables(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting YNtables");
        return yNtableService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the YNtable instance associated with the given id.")
    public YNtable getYNtable(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting YNtable with id: {}", id);
        YNtable foundYNtable = yNtableService.getById(id);
        LOGGER.debug("YNtable details with id: {}", foundYNtable);
        return foundYNtable;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the YNtable instance associated with the given id.")
    public YNtable editYNtable(@PathVariable(value = "id") Integer id, @RequestBody YNtable yntable) throws EntityNotFoundException {
        LOGGER.debug("Editing YNtable with id: {}", yntable.getId());
        yntable.setId(id);
        yntable = yNtableService.update(yntable);
        LOGGER.debug("YNtable details with id: {}", yntable);
        return yntable;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the YNtable instance associated with the given id.")
    public boolean deleteYNtable(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting YNtable with id: {}", id);
        YNtable deletedYNtable = yNtableService.delete(id);
        return deletedYNtable != null;
    }
}
