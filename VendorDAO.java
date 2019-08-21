package com.hexaware.MLP156.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP156.model.Vendor;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Vendor")
    @Mapper(VendorMapper.class)
    List<Vendor> show();
/**
 *
 * @param vName gets vendor name.
 * @param vPwd gets vendor password.
 * @return the validation.
 */
  @SqlQuery("SELECT * FROM Vendor WHERE VEN_USERNAME = :vName AND VEN_PWD = :vPassword")
  @Mapper(VendorMapper.class)
  Vendor validateVLogin(@Bind("vName")String vName,
                          @Bind("vPassword") String vPwd);
/**
 *
 * @param vid gets the vendor id.
 * @return the vendor wallet balance.
 */
  @SqlQuery("SELECT VEN_WLT FROM Vendor WHERE VEN_ID = :vId")
  //@Mapper(VendorMapper.class)
    double venwalletbal(@Bind("vId") int vid);
}
