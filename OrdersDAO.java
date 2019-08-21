package com.hexaware.MLP156.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP156.model.Orders;
import org.skife.jdbi.v2.sqlobject.Bind;

/**
 * OrdersDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrdersDAO {
    /**
     * @return the all the Orders record.
     */
  @SqlQuery("Select * from Orders")
    @Mapper(OrdersMapper.class)
    List<Orders> show();

    /**
     * @param eid the all the history.
     * @return the all the Orders record.
     */
  @SqlQuery("select * from Orders where EMPLOYEE_ID= :empID ")
    @Mapper(OrdersMapper.class)
    Orders employeeorderhistory(@Bind("empID") int eid);
     /**
       * @param venID the all the history.
       * @return the all the Orders record.
       */
  @SqlQuery("select o.* from Orders o join menu m on o.FOOD_ID=m.FOOD_ID where m.VENDOR_ID = :venID")
     @Mapper(OrdersMapper.class)
     Orders vendororderhistory(@Bind("venID") int venID);
}
