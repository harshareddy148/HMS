/*
 
 
 
 */
package com.idb.hmis.service;

import com.idb.hmis.entity.Hostel;
import com.idb.hmis.entity.HostelInfo;

/**
 *
 * @author Zobaer Shekh
 */
public interface HostelInfoService {

    HostelInfo save(HostelInfo hostelInfo);

    HostelInfo getByHostel(Long hostelId);

}
