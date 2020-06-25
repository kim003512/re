package org.duksung.matdog_server_hanuim.mapper;

import org.apache.ibatis.annotations.*;
import org.duksung.matdog_server_hanuim.dto.Register;
import org.duksung.matdog_server_hanuim.dto.Register_lost;

import java.util.List;

@Mapper
public interface RegisterLostMapper {
    //모든 실종 공고 리스트 조회
    @Select("SELECT * FROM register_lost ORDER BY registerIdx ASC")
    List<Register> findAll_lost();

    //registerIdx 조회
    @Select("SELECT * FROM register_lost WHERE registerIdx = #{registerIdx}")
    Register findByRegisterIdx_lost(@Param("registerIdx") final int registerIdx);

    //실종 공고 등록
    @Insert("INSERT INTO register_lost(variety, gender, weight, age, protectPlace, lostPlace,lostDate, feature, tel, email, memo) " +
            "VALUES(#{register_lost.variety}, #{register_lost.gender}, #{register_lost.weight}, #{register_lost.age}, #{register_lost.protectPlace}, " +
            "#{register_lost.lostPlace},#{register_lost.lostDate},#{register_lost.feature}, #{register_lost.tel}, " +
            "#{register_lost.email}, #{register_lost.memo})")
    @Options(useGeneratedKeys = true, keyColumn = "register_lost.registerIdx")
    int save_lost(@Param("register_lost") final Register_lost register_lost);

    //실종 공고 수정
    @Update("UPDATE register_lost SET variety=#{register_lost.variety}, gender=#{register_lost.gender},weight=#{register_lost.weight},age=#{register_lost.age}," +
            "protectPlace=#{register_lost.protectPlace},lostPlace=#{register_lost.lostPlace},lostDate=#{register_lost.lostDate},feature=#{register_lost.feature}, " +
            "tel=#{register_lost.tel}, email=#{register_lost.email},memo=#{register_lost.memo}" +
            "where registerIdx = #{registerIdx}")
    void update_lost(@Param("registerIdx") final int registerIdx, @Param("register_lost") Register_lost register_lost);

    //실종 공고 삭제
    @Delete("DELETE FROM register_lost WHERE registerIdx = #{registerIdx}")
    void deleteRegister_lost(@Param("registerIdx") final int registerIdx);
}
