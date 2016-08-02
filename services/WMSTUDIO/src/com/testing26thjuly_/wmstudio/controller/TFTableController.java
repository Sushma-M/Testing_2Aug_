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
import com.testing26thjuly_.wmstudio.TFTable;
import com.testing26thjuly_.wmstudio.service.TFTableService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class TFTable.
 * @see TFTable
 */
@RestController("WMSTUDIO.TFTableController")
@RequestMapping("/WMSTUDIO/TFTable")
@Api(description = "Exposes APIs to work with TFTable resource.", value = "TFTableController")
public class TFTableController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TFTableController.class);

    @Autowired
    @Qualifier("WMSTUDIO.TFTableService")
    private TFTableService tFTableService;

    /**
     * @deprecated Use {@link #findTFTables(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of TFTable instances matching the search criteria.")
    public Page<TFTable> findTFTables(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TFTables list");
        return tFTableService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TFTable instances matching the search criteria.")
    public Page<TFTable> findTFTables(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TFTables list");
        return tFTableService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTFTables(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return tFTableService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TFTableService instance
	 */
    protected void setTFTableService(TFTableService service) {
        this.tFTableService = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new TFTable instance.")
    public TFTable createTFTable(@RequestBody TFTable tftable) {
        LOGGER.debug("Create TFTable with information: {}", tftable);
        tftable = tFTableService.create(tftable);
        LOGGER.debug("Created TFTable with information: {}", tftable);
        return tftable;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of TFTable instances.")
    public Long countTFTables(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting TFTables");
        return tFTableService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the TFTable instance associated with the given id.")
    public TFTable getTFTable(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TFTable with id: {}", id);
        TFTable foundTFTable = tFTableService.getById(id);
        LOGGER.debug("TFTable details with id: {}", foundTFTable);
        return foundTFTable;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the TFTable instance associated with the given id.")
    public TFTable editTFTable(@PathVariable(value = "id") Integer id, @RequestBody TFTable tftable) throws EntityNotFoundException {
        LOGGER.debug("Editing TFTable with id: {}", tftable.getId());
        tftable.setId(id);
        tftable = tFTableService.update(tftable);
        LOGGER.debug("TFTable details with id: {}", tftable);
        return tftable;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the TFTable instance associated with the given id.")
    public boolean deleteTFTable(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TFTable with id: {}", id);
        TFTable deletedTFTable = tFTableService.delete(id);
        return deletedTFTable != null;
    }
}
