package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMapper extends Mapper<Brand> {
    //当你的方法有多个参数时候，需要指定参数名
    @Insert("insert into tb_category_brand (category_id,brand_id) values (#{cid}, #{bid})")
    void insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);
    /**
     * 根据分类id查询品牌列表，用于新增商品的form表单查询
     * 多表查询，自定义SQL语句
     * @param cid
     * @return
     */
    @Select("select * from tb_brand a inner join tb_category_brand b on a.id=b.brand_id where b.category_id=#{cid}")
    List<Brand> selectBrandsByCid(Long cid);
}
