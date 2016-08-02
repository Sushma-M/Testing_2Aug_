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
import com.testing26thjuly_.demo.Table9;
import com.testing26thjuly_.demo.Table9Id;
import com.testing26thjuly_.demo.service.Table9Service;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Table9.
 * @see Table9
 */
@RestController("Demo.Table9Controller")
@RequestMapping("/Demo/Table9")
@Api(description = "Exposes APIs to work with Table9 resource.", value = "Table9Controller")
public class Table9Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table9Controller.class);

    @Autowired
    @Qualifier("Demo.Table9Service")
    private Table9Service table9Service;

    /**
     * @deprecated Use {@link #findTable9s(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Table9 instances matching the search criteria.")
    public Page<Table9> findTable9s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table9s list");
        return table9Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Table9 instances matching the search criteria.")
    public Page<Table9> findTable9s(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering Table9s list");
        return table9Service.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTable9s(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return table9Service.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service Table9Service instance
	 */
    protected void setTable9Service(Table9Service service) {
        this.table9Service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Table9 instance.")
    public Table9 createTable9(@RequestBody Table9 table9) {
        LOGGER.debug("Create Table9 with information: {}", table9);
        table9 = table9Service.create(table9);
        LOGGER.debug("Created Table9 with information: {}", table9);
        return table9;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Table9 instance associated with the given composite-id.")
    public Table9 getTable9(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "column2", required = true) String column2) throws EntityNotFoundException {
        Table9Id table9Id = new Table9Id();
        table9Id.setId(id);
        table9Id.setColumn2(column2);
        LOGGER.debug("Getting Table9 with id: {}", table9Id);
        Table9 table9 = table9Service.getById(table9Id);
        LOGGER.debug("Table9 details with id: {}", table9);
        return table9;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Table9 instance associated with the given composite-id.")
    public Table9 editTable9(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "column2", required = true) String column2, @RequestBody Table9 table9) throws EntityNotFoundException {
        Table9Id table9Id = new Table9Id();
        table9Id.setId(id);
        table9Id.setColumn2(column2);
        table9Service.delete(table9Id);
        table9 = table9Service.create(table9);
        LOGGER.debug("Table9 details with id is updated: {}", table9);
        return table9;
    }

    @RequestMapping(value = "/composite-id", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Table9 instance associated with the given composite-id.")
    public boolean deleteTable9(@RequestParam(value = "id", required = true) int id, @RequestParam(value = "column2", required = true) String column2) throws EntityNotFoundException {
        Table9Id table9Id = new Table9Id();
        table9Id.setId(id);
        table9Id.setColumn2(column2);
        LOGGER.debug("Deleting Table9 with id: {}", table9Id);
        Table9 table9 = table9Service.delete(table9Id);
        return table9 != null;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Table9 instances.")
    public Long countTable9s(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting Table9s");
        return table9Service.count(query);
    }
}