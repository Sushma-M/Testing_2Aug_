/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.db123testing.controller;

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
import com.testing26thjuly_.db123testing.YesNoTable;
import com.testing26thjuly_.db123testing.service.YesNoTableService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class YesNoTable.
 * @see YesNoTable
 */
@RestController("DB123Testing.YesNoTableController")
@RequestMapping("/DB123Testing/YesNoTable")
@Api(description = "Exposes APIs to work with YesNoTable resource.", value = "YesNoTableController")
public class YesNoTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(YesNoTableController.class);

    @Autowired
    @Qualifier("DB123Testing.YesNoTableService")
    private YesNoTableService yesNoTableService;

    /**
     * @deprecated Use {@link #findYesNoTables(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of YesNoTable instances matching the search criteria.")
    public Page<YesNoTable> findYesNoTables(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering YesNoTables list");
        return yesNoTableService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of YesNoTable instances matching the search criteria.")
    public Page<YesNoTable> findYesNoTables(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering YesNoTables list");
        return yesNoTableService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportYesNoTables(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return yesNoTableService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service YesNoTableService instance
	 */
    protected void setYesNoTableService(YesNoTableService service) {
        this.yesNoTableService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new YesNoTable instance.")
    public YesNoTable createYesNoTable(@RequestBody YesNoTable yesnotable) {
        LOGGER.debug("Create YesNoTable with information: {}", yesnotable);
        yesnotable = yesNoTableService.create(yesnotable);
        LOGGER.debug("Created YesNoTable with information: {}", yesnotable);
        return yesnotable;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of YesNoTable instances.")
    public Long countYesNoTables(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting YesNoTables");
        return yesNoTableService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the YesNoTable instance associated with the given id.")
    public YesNoTable getYesNoTable(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting YesNoTable with id: {}", id);
        YesNoTable foundYesNoTable = yesNoTableService.getById(id);
        LOGGER.debug("YesNoTable details with id: {}", foundYesNoTable);
        return foundYesNoTable;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the YesNoTable instance associated with the given id.")
    public YesNoTable editYesNoTable(@PathVariable(value = "id") Integer id, @RequestBody YesNoTable yesnotable) throws EntityNotFoundException {
        LOGGER.debug("Editing YesNoTable with id: {}", yesnotable.getId());
        yesnotable.setId(id);
        yesnotable = yesNoTableService.update(yesnotable);
        LOGGER.debug("YesNoTable details with id: {}", yesnotable);
        return yesnotable;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the YesNoTable instance associated with the given id.")
    public boolean deleteYesNoTable(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting YesNoTable with id: {}", id);
        YesNoTable deletedYesNoTable = yesNoTableService.delete(id);
        return deletedYesNoTable != null;
    }
}
