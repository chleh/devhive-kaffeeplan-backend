package com.cgi.devhive.kaffeeplan.backend;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.*;
import java.util.Properties;

public class YearWeekSequenceGenerator extends SequenceStyleGenerator {
    //final String yearWeek =

    @Override
    public Serializable generate(SharedSessionContractImplementor session,
                                 Object object) throws HibernateException {
        return String.format("%06d", super.generate(session, object));
        //return "XXX" + super.generate(session, object);
    }

    /*
    @Override
    public String getNext(String yearWeek) {
        int number = Integer.parseInt(yearWeek);
        int year = number/100;
        int week = number%100;
        if (week < 52) week++;
        else {
            week = 1;
            year++;
        }
        return "" + year + (week < 10 ? "0" + week : week);
    }*/
    @Override
    public void configure(Type type, Properties params,
                          ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);

        ConnectionProvider connProv = serviceRegistry.getService(ConnectionProvider.class);
        Connection conn;
        try {
             conn = connProv.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        CallableStatement stmt;
        try {
            stmt = conn.prepareCall("select max(year_Week) from Kaffeeplan_Entry;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("RESULT: " + rs.getString(1));
            }
            // System.out.println("RESULT: " + stmt.getString(0));
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
 /*
        try {
            PreparedStatement stmt;
            stmt = conn.prepareStatement("select max(year_Week) from Kaffeeplan_Entry;");
            stmt.execute();
            stmt.
            System.out.println("RESULT: " + stmt.getString(0));
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
  */

    }

    /*
    @Override
    public void configure(Type type, Properties params,
                          ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER,
                params, VALUE_PREFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,
                params, NUMBER_FORMAT_DEFAULT);
    }
     */
}
