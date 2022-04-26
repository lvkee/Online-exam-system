package com.sy.dao;

import com.sy.entity.Organization;

import java.util.List;

public interface OrganizationMapper {

    List<Organization> getOrganizations(int id);

}
