/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.db123testing.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.TypeMismatchException;
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
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.testing26thjuly_.db123testing.ViewSelfRelation;
import com.testing26thjuly_.db123testing.ViewSelfRelationId;
import com.testing26thjuly_.db123testing.service.ViewSelfRelationService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class ViewSelfRelation.
 * @see ViewSelfRelation
 */
@RestController("DB123Testing.ViewSelfRelationController")
@RequestMapping("/DB123Testing/ViewSelfRelation")
@Api(description = "Exposes APIs to work with ViewSelfRelation resource.", value = "ViewSelfRelationController")
public class ViewSelfRelationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ViewSelfRelationController.class);

    @Autowired
    @Qualifier("DB123Testing.ViewSelfRelationService")
    private ViewSelfRelationService viewSelfRelationService;

    @RequestMapping(value = "/composite-id", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the ViewSelfRelation instance associated with the given composite-id.")
    public ViewSelfRelation getViewSelfRelation(@RequestParam("id") int id, @RequestParam("dateCol") Date dateCol, @RequestParam("datetimeCol") Date datetimeCol, @RequestParam("timeCol") Date timeCol, @RequestParam("timestampCol") Date timestampCol, @RequestParam("booleanCol") Boolean booleanCol, @RequestParam("blobCol") byte[] blobCol, @RequestParam("intCol") Integer intCol) throws EntityNotFoundException {
        ViewSelfRelationId viewselfrelationId = new ViewSelfRelationId();
        viewselfrelationId.setId(id);
        viewselfrelationId.setDateCol(dateCol);
        viewselfrelationId.setDatetimeCol(datetimeCol);
        viewselfrelationId.setTimeCol(timeCol);
        viewselfrelationId.setTimestampCol(timestampCol);
        viewselfrelationId.setBooleanCol(booleanCol);
        viewselfrelationId.setBlobCol(blobCol);
        viewselfrelationId.setIntCol(intCol);
        LOGGER.debug("Getting ViewSelfRelation with id: {}", viewselfrelationId);
        ViewSelfRelation viewselfrelation = viewSelfRelationService.getById(viewselfrelationId);
        LOGGER.debug("ViewSelfRelation details with id: {}", viewselfrelation);
        return viewselfrelation;
    }

    @RequestMapping(value = "/composite-id/content/{fieldName}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves content for the given BLOB field in ViewSelfRelation instance associated with the given composite-id.")
    public void getViewSelfRelationBLOBContent(@RequestParam("id") int id, @RequestParam("dateCol") Date dateCol, @RequestParam("datetimeCol") Date datetimeCol, @RequestParam("timeCol") Date timeCol, @RequestParam("timestampCol") Date timestampCol, @RequestParam("booleanCol") Boolean booleanCol, @RequestParam("blobCol") byte[] blobCol, @RequestParam("intCol") Integer intCol, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws EntityNotFoundException {
        LOGGER.debug("Retrieves content for the given BLOB field {} in ViewSelfRelation instance", fieldName);
        if (!WMRuntimeUtils.isLob(ViewSelfRelation.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        ViewSelfRelationId viewselfrelationId = new ViewSelfRelationId();
        viewselfrelationId.setId(id);
        viewselfrelationId.setDateCol(dateCol);
        viewselfrelationId.setDatetimeCol(datetimeCol);
        viewselfrelationId.setTimeCol(timeCol);
        viewselfrelationId.setTimestampCol(timestampCol);
        viewselfrelationId.setBooleanCol(booleanCol);
        viewselfrelationId.setBlobCol(blobCol);
        viewselfrelationId.setIntCol(intCol);
        ViewSelfRelation viewselfrelation = viewSelfRelationService.getById(viewselfrelationId);
        WMMultipartUtils.buildHttpResponseForBlob(viewselfrelation, fieldName, httpServletRequest, httpServletResponse);
    }

    /**
     * @deprecated Use {@link #findViewSelfRelations(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of ViewSelfRelation instances matching the search criteria.")
    public Page<ViewSelfRelation> findViewSelfRelations(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering ViewSelfRelations list");
        return viewSelfRelationService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of ViewSelfRelation instances matching the search criteria.")
    public Page<ViewSelfRelation> findViewSelfRelations(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering ViewSelfRelations list");
        return viewSelfRelationService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportViewSelfRelations(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return viewSelfRelationService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service ViewSelfRelationService instance
	 */
    protected void setViewSelfRelationService(ViewSelfRelationService service) {
        this.viewSelfRelationService = service;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of ViewSelfRelation instances.")
    public Long countViewSelfRelations(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting ViewSelfRelations");
        return viewSelfRelationService.count(query);
    }
}
