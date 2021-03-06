/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.db123testing.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Qualifier;
import com.testing26thjuly_.db123testing.service.DB123TestingQueryExecutorService;
import com.wavemaker.runtime.data.model.CustomQuery;
import com.wavemaker.runtime.data.exception.QueryParameterMismatchException;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

@RestController(value = "DB123Testing.QueryExecutionController")
@RequestMapping("/DB123Testing/queryExecutor")
@Api(description = "Controller class for query execution", value = "QueryExecutionController")
public class QueryExecutionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueryExecutionController.class);

    @Autowired
    private DB123TestingQueryExecutorService queryService;

    @RequestMapping(value = "/queries/wm_custom", method = RequestMethod.POST)
    @ApiOperation(value = "Process request to execute customer queries")
    public Page<Object> executeWMCustomQuery(@RequestBody CustomQuery query, Pageable pageable) {
        Page<Object> result = queryService.executeWMCustomQuerySelect(query, pageable);
        LOGGER.debug("got the result {}" + result);
        return result;
    }

    @RequestMapping(value = "/queries/SV_InsertTypes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute queries")
    public int executeSV_InsertTypes(@RequestParam(value = "id", required = false) java.lang.Integer id, @RequestParam(value = "bytecol", required = false) java.lang.Byte bytecol, @RequestParam(value = "shortcol", required = false) java.lang.Short shortcol, @RequestParam(value = "intcol", required = false) java.lang.Integer intcol, @RequestParam(value = "longcol", required = false) java.lang.Long longcol, @RequestParam(value = "bigintcol", required = false) java.math.BigInteger bigintcol, @RequestParam(value = "floatcol", required = false) java.lang.Float floatcol, @RequestParam(value = "doublecol", required = false) java.lang.Double doublecol, @RequestParam(value = "bigdeccol", required = false) java.math.BigDecimal bigdeccol, @RequestParam(value = "charcol", required = false) java.lang.Character charcol, @RequestParam(value = "stringcol", required = false) java.lang.String stringcol, @RequestParam(value = "textcol", required = false) java.lang.String textcol, @RequestParam(value = "booleancol", required = false) java.lang.Boolean booleancol, @RequestParam(value = "datetimecol", required = false) org.joda.time.LocalDateTime datetimecol, @RequestParam(value = "timestampcol", required = false) java.sql.Timestamp timestampcol, @RequestParam(value = "datecol", required = false) java.sql.Date datecol, @RequestParam(value = "timecol", required = false) java.sql.Time timecol) throws QueryParameterMismatchException {
        LOGGER.debug("Executing named query SV_InsertTypes");
        int result = queryService.executeSV_InsertTypes(id, bytecol, shortcol, intcol, longcol, bigintcol, floatcol, doublecol, bigdeccol, charcol, stringcol, textcol, booleancol, datetimecol, timestampcol, datecol, timecol);
        LOGGER.debug("got the result of named query {}", result);
        return result;
    }

    @RequestMapping(value = "/queries/wm_custom_update", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Process request to execute customer queries")
    public int executeWMCustomQuery(@RequestBody CustomQuery query) {
        int result = queryService.executeWMCustomQueryUpdate(query);
        LOGGER.debug("got the result {}" + result);
        return result;
    }
}
