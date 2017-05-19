package com.construction.dao;


import com.construction.view.ParticipantView;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.UUID;

@Mapper
public interface ParticipantDao {
    @Insert("INSERT INTO vendor_rental_inventory(id, vendor_id, category, name, image_url,total_units) " +
            "VALUES (#{id},#{vendorId},#{category},#{name},#{imageUrl},#{totalUnits})")
    int createParticipant(Object dto);

    @Select("SELECT * FROM vendor_rental_inventory WHERE id = #{id}")
    ParticipantView getParticipant(@Param("id") UUID id);
}
