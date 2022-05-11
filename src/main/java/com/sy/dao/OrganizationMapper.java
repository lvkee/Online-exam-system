package com.sy.dao;

import com.sy.entity.Organization;

import java.util.List;

/**
 * @author chris
 *
 */
public interface OrganizationMapper {

    /**
     * 通过组织 id 查找组织
     * @param id 组织 id
     * @return List
     */
    List<Organization> getOrganizations(int id);

}
