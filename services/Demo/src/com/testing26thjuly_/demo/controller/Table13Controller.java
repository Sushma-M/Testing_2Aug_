/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.demo.controller;

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
import com.testing26thjuly_.demo.Table13;
import com.testing26thjuly_.demo.Table14Id;
import com.testing26thjuly_.demo.service.Table13Service;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Table13.
 * @see Table13
 */
@RestController("Demo.Table13Controller")
@RequestMapping("/Demo/Table13")
@Api(description = "Exposes APIs to work with Table13 resource.", value = "Table13Controller")
public class Table13Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table13Controller.class);

    @Autowired
    @Qualifier("Demo.Table13Service")
    private Table13Service table13Service;

    /**
     * @deprecated Use {@link #findTable13s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Table13 instances matching the search criteria.")
    public Page<Table13> findTable13s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table13s list");
        return table13Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Table13 instances matching the search criteria.")
    public Page<Table13> findTable13s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table13s list");
        return table13Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTable13s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return table13Service.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table13Service instance
	 */
    protected void setTable13Service(Table13Service service) {
        this.table13Service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Table13 instance.")
    public Table13 createTable13(@RequestBody Table13 table13) {
        LOGGER.debug("Create Table13 with information: {}", table13);
        table13 = table13Service.create(table13);
        LOGGER.debug("Created Table13 with information: {}", table13);
        return table13;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Table13 instance associated with the given composite-id.")
    public Table13 getTable13(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "column2", required = true) String column2, @RequestParam(value = "column3", required = true) String column3) throws EntityNotFoundException {
        Table14Id table13Id = new Table14Id();
        table13Id.setId(id);
        table13Id.setColumn2(column2);
        table13Id.setColumn3(column3);
        LOGGER.debug("Getting Table13 with id: {}", table13Id);
        Table13 table13 = table13Service.getById(table13Id);
        LOGGER.debug("Table13 details with id: {}", table13);
        return table13;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Table13 instance associated with the given composite-id.")
    public Table13 editTable13(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "column2", required = true) String column2, @RequestParam(value = "column3", required = true) String column3, @RequestBody Table13 table13) throws EntityNotFoundException {
        Table14Id table13Id = new Table14Id();
        table13Id.setId(id);
        table13Id.setColumn2(column2);
        table13Id.setColumn3(column3);
        table13Service.delete(table13Id);
        table13 = table13Service.create(table13);
        LOGGER.debug("Table13 details with id is updated: {}", table13);
        return table13;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Table13 instance associated with the given composite-id.")
    public boolean deleteTable13(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "column2", required = true) String column2, @RequestParam(value = "column3", required = true) String column3) throws EntityNotFoundException {
        Table14Id table13Id = new Table14Id();
        table13Id.setId(id);
        table13Id.setColumn2(column2);
        table13Id.setColumn3(column3);
        LOGGER.debug("Deleting Table13 with id: {}", table13Id);
        Table13 table13 = table13Service.delete(table13Id);
        return table13 != null;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Table13 instances.")
    public Long countTable13s(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Table13s");
        return table13Service.count(query);
    }
}
