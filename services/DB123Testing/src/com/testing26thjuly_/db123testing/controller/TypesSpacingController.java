/*Copyright (c) 2016-2017 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/
package com.testing26thjuly_.db123testing.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.testing26thjuly_.db123testing.TypesSpacing;
import com.testing26thjuly_.db123testing.service.TypesSpacingService;
import com.wordnik.swagger.annotations.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class TypesSpacing.
 * @see TypesSpacing
 */
@RestController("DB123Testing.TypesSpacingController")
@RequestMapping("/DB123Testing/TypesSpacing")
@Api(description = "Exposes APIs to work with TypesSpacing resource.", value = "TypesSpacingController")
public class TypesSpacingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypesSpacingController.class);

    @Autowired
    @Qualifier("DB123Testing.TypesSpacingService")
    private TypesSpacingService typesSpacingService;

    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Retrieves content for the given BLOB field in TypesSpacing instance")
    public DownloadResponse getTypesSpacingBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value = "download", defaultValue = "false") boolean download) {
        LOGGER.debug("Retrieves content for the given BLOB field {} in TypesSpacing instance", fieldName);
        if (!WMRuntimeUtils.isLob(TypesSpacing.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        TypesSpacing typesspacing = typesSpacingService.getById(id);
        return WMMultipartUtils.buildDownloadResponseForBlob(typesspacing, fieldName, httpServletRequest, download);
    }

    /**
     * @deprecated Use {@link #findTypesSpacings(String)} instead.
     */
    @Deprecated
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of TypesSpacing instances matching the search criteria.")
    public Page<TypesSpacing> findTypesSpacings(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering TypesSpacings list");
        return typesSpacingService.findAll(queryFilters, pageable);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of TypesSpacing instances matching the search criteria.")
    public Page<TypesSpacing> findTypesSpacings(@RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering TypesSpacings list");
        return typesSpacingService.findAll(query, pageable);
    }

    @RequestMapping(value = "/export/{exportType}", method = RequestMethod.GET, produces = "application/octet-stream")
    @ApiOperation(value = "Returns downloadable file for the data.")
    public Downloadable exportTypesSpacings(@PathVariable("exportType") ExportType exportType, @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        return typesSpacingService.export(exportType, query, pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service TypesSpacingService instance
	 */
    protected void setTypesSpacingService(TypesSpacingService service) {
        this.typesSpacingService = service;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new TypesSpacing instance.")
    public TypesSpacing createTypesSpacing(MultipartHttpServletRequest multipartHttpServletRequest) {
        TypesSpacing typesspacing = WMMultipartUtils.toObject(multipartHttpServletRequest, TypesSpacing.class, "DB123Testing");
        LOGGER.debug("Creating a new TypesSpacing with information: {}", typesspacing);
        return typesSpacingService.create(typesspacing);
    }

    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new TypesSpacing instance.")
    public TypesSpacing createTypesSpacing(@RequestBody TypesSpacing typesspacing) {
        LOGGER.debug("Create TypesSpacing with information: {}", typesspacing);
        typesspacing = typesSpacingService.create(typesspacing);
        LOGGER.debug("Created TypesSpacing with information: {}", typesspacing);
        return typesspacing;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of TypesSpacing instances.")
    public Long countTypesSpacings(@RequestParam(value = "q", required = false) String query) {
        LOGGER.debug("counting TypesSpacings");
        return typesSpacingService.count(query);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the TypesSpacing instance associated with the given id.")
    public TypesSpacing getTypesSpacing(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting TypesSpacing with id: {}", id);
        TypesSpacing foundTypesSpacing = typesSpacingService.getById(id);
        LOGGER.debug("TypesSpacing details with id: {}", foundTypesSpacing);
        return foundTypesSpacing;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the TypesSpacing instance associated with the given id.")
    public TypesSpacing editTypesSpacing(@PathVariable(value = "id") Integer id, @RequestBody TypesSpacing typesspacing) throws EntityNotFoundException {
        LOGGER.debug("Editing TypesSpacing with id: {}", typesspacing.getId());
        typesspacing.setId(id);
        typesspacing = typesSpacingService.update(typesspacing);
        LOGGER.debug("TypesSpacing details with id: {}", typesspacing);
        return typesspacing;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the TypesSpacing instance associated with the given id.This API should be used when TypesSpacing instance fields that require multipart data.")
    public TypesSpacing editTypesSpacing(@PathVariable(value = "id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) throws EntityNotFoundException {
        TypesSpacing newTypesSpacing = WMMultipartUtils.toObject(multipartHttpServletRequest, TypesSpacing.class, "DB123Testing");
        newTypesSpacing.setId(id);
        TypesSpacing oldTypesSpacing = typesSpacingService.getById(id);
        WMMultipartUtils.updateLobsContent(oldTypesSpacing, newTypesSpacing);
        LOGGER.debug("Updating TypesSpacing with information: {}", newTypesSpacing);
        return typesSpacingService.update(newTypesSpacing);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the TypesSpacing instance associated with the given id.")
    public boolean deleteTypesSpacing(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting TypesSpacing with id: {}", id);
        TypesSpacing deletedTypesSpacing = typesSpacingService.delete(id);
        return deletedTypesSpacing != null;
    }
}
