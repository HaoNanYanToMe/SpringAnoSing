package com.prism.springas.dao;

import com.prism.springas.utils.BasePage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;


import java.util.List;
/*
	数据持久化-基本简单用例[增删改查]操作*/
@Mapper
@Component("baseDAO")
public interface BaseDAO {

	/*
		==========================================================
		======>>表名信息：药品信息(DRUGINFO)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表DRUGINFO
		==========================================================
	*/

	/*
		->药品信息表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> DRUGINFO_SelectPage(@Param("bp") BasePage bp);


	/*
		->药品信息表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  DRUGINFO.ID =  #{bp.byOneCondition}")
	BasePage DRUGINFO_SelectByOne(@Param("bp") BasePage bp);


	/*
		->药品信息表 -- 创建数据
	*/
	@Insert(" INSERT INTO  DRUGINFO (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int DRUGINFO_InsertData(@Param("bp") BasePage bp);


	/*
		->药品信息表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int DRUGINFO_UpdateData(@Param("bp") BasePage bp);


	/*
		->药品信息表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int DRUGINFO_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：药品分类管理信息(DTINFO)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表DTINFO
		==========================================================
	*/

	/*
		->药品分类管理信息表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> DTINFO_SelectPage(@Param("bp") BasePage bp);


	/*
		->药品分类管理信息表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  DTINFO.ID =  #{bp.byOneCondition}")
	BasePage DTINFO_SelectByOne(@Param("bp") BasePage bp);


	/*
		->药品分类管理信息表 -- 创建数据
	*/
	@Insert(" INSERT INTO  DTINFO (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int DTINFO_InsertData(@Param("bp") BasePage bp);


	/*
		->药品分类管理信息表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int DTINFO_UpdateData(@Param("bp") BasePage bp);


	/*
		->药品分类管理信息表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int DTINFO_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：HETARA规则引擎表(HETARAENGINE)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表HETARAENGINE
		==========================================================
	*/

	/*
		->HETARA规则引擎表表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> HETARAENGINE_SelectPage(@Param("bp") BasePage bp);


	/*
		->HETARA规则引擎表表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  HETARAENGINE.ID =  #{bp.byOneCondition}")
	BasePage HETARAENGINE_SelectByOne(@Param("bp") BasePage bp);


	/*
		->HETARA规则引擎表表 -- 创建数据
	*/
	@Insert(" INSERT INTO  HETARAENGINE (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int HETARAENGINE_InsertData(@Param("bp") BasePage bp);


	/*
		->HETARA规则引擎表表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int HETARAENGINE_UpdateData(@Param("bp") BasePage bp);


	/*
		->HETARA规则引擎表表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int HETARAENGINE_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：HETARA规则表(HETARARULES)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表HETARARULES
		==========================================================
	*/

	/*
		->HETARA规则表表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> HETARARULES_SelectPage(@Param("bp") BasePage bp);


	/*
		->HETARA规则表表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  HETARARULES.ID =  #{bp.byOneCondition}")
	BasePage HETARARULES_SelectByOne(@Param("bp") BasePage bp);


	/*
		->HETARA规则表表 -- 创建数据
	*/
	@Insert(" INSERT INTO  HETARARULES (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int HETARARULES_InsertData(@Param("bp") BasePage bp);


	/*
		->HETARA规则表表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int HETARARULES_UpdateData(@Param("bp") BasePage bp);


	/*
		->HETARA规则表表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int HETARARULES_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：菜单信息管理表(SYSMENU)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表SYSMENU
		==========================================================
	*/

	/*
		->菜单信息管理表表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> SYSMENU_SelectPage(@Param("bp") BasePage bp);


	/*
		->菜单信息管理表表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  SYSMENU.ID =  #{bp.byOneCondition}")
	BasePage SYSMENU_SelectByOne(@Param("bp") BasePage bp);


	/*
		->菜单信息管理表表 -- 创建数据
	*/
	@Insert(" INSERT INTO  SYSMENU (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int SYSMENU_InsertData(@Param("bp") BasePage bp);


	/*
		->菜单信息管理表表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int SYSMENU_UpdateData(@Param("bp") BasePage bp);


	/*
		->菜单信息管理表表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int SYSMENU_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：系统用户表(SYSUSER)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表SYSUSER
		==========================================================
	*/

	/*
		->系统用户表表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> SYSUSER_SelectPage(@Param("bp") BasePage bp);


	/*
		->系统用户表表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  SYSUSER.ID =  #{bp.byOneCondition}")
	BasePage SYSUSER_SelectByOne(@Param("bp") BasePage bp);


	/*
		->系统用户表表 -- 创建数据
	*/
	@Insert(" INSERT INTO  SYSUSER (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int SYSUSER_InsertData(@Param("bp") BasePage bp);


	/*
		->系统用户表表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int SYSUSER_UpdateData(@Param("bp") BasePage bp);


	/*
		->系统用户表表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int SYSUSER_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：用户权限信息管理表(SYSROLE)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表SYSROLE
		==========================================================
	*/

	/*
		->用户权限信息管理表表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> SYSROLE_SelectPage(@Param("bp") BasePage bp);


	/*
		->用户权限信息管理表表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  SYSROLE.ID =  #{bp.byOneCondition}")
	BasePage SYSROLE_SelectByOne(@Param("bp") BasePage bp);


	/*
		->用户权限信息管理表表 -- 创建数据
	*/
	@Insert(" INSERT INTO  SYSROLE (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int SYSROLE_InsertData(@Param("bp") BasePage bp);


	/*
		->用户权限信息管理表表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int SYSROLE_UpdateData(@Param("bp") BasePage bp);


	/*
		->用户权限信息管理表表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int SYSROLE_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：菜单及权限信息关联表(SYSROLEMENU)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表SYSROLEMENU
		==========================================================
	*/

	/*
		->菜单及权限信息关联表表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> SYSROLEMENU_SelectPage(@Param("bp") BasePage bp);


	/*
		->菜单及权限信息关联表表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  SYSROLEMENU.ID =  #{bp.byOneCondition}")
	BasePage SYSROLEMENU_SelectByOne(@Param("bp") BasePage bp);


	/*
		->菜单及权限信息关联表表 -- 创建数据
	*/
	@Insert(" INSERT INTO  SYSROLEMENU (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int SYSROLEMENU_InsertData(@Param("bp") BasePage bp);


	/*
		->菜单及权限信息关联表表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int SYSROLEMENU_UpdateData(@Param("bp") BasePage bp);


	/*
		->菜单及权限信息关联表表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int SYSROLEMENU_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：数据表仓库(TABLEFOLDER)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表TABLEFOLDER
		==========================================================
	*/

	/*
		->数据表仓库表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> TABLEFOLDER_SelectPage(@Param("bp") BasePage bp);


	/*
		->数据表仓库表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  TABLEFOLDER.ID =  #{bp.byOneCondition}")
	BasePage TABLEFOLDER_SelectByOne(@Param("bp") BasePage bp);


	/*
		->数据表仓库表 -- 创建数据
	*/
	@Insert(" INSERT INTO  TABLEFOLDER (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int TABLEFOLDER_InsertData(@Param("bp") BasePage bp);


	/*
		->数据表仓库表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int TABLEFOLDER_UpdateData(@Param("bp") BasePage bp);


	/*
		->数据表仓库表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int TABLEFOLDER_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：供应商(SUPPLIER)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表SUPPLIER
		==========================================================
	*/

	/*
		->供应商表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> SUPPLIER_SelectPage(@Param("bp") BasePage bp);


	/*
		->供应商表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  SUPPLIER.ID =  #{bp.byOneCondition}")
	BasePage SUPPLIER_SelectByOne(@Param("bp") BasePage bp);


	/*
		->供应商表 -- 创建数据
	*/
	@Insert(" INSERT INTO  SUPPLIER (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int SUPPLIER_InsertData(@Param("bp") BasePage bp);


	/*
		->供应商表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int SUPPLIER_UpdateData(@Param("bp") BasePage bp);


	/*
		->供应商表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int SUPPLIER_DeleteData(@Param("bp") BasePage bp);

	/*
		==========================================================
		======>>表名信息：日志记录(LOGINFO)
		======>>生成时间:Mon May 20 14:07:48 CST 2019
		======>>编辑人:@YanHaoNan
		======>>备注:生成表LOGINFO
		==========================================================
	*/

	/*
		->日志记录表 -- 根据条件查询数据（含分页及自选指定Columns）
	*/
	@Select(" ${bp.parseSQL} ")
	List<BasePage> LOGINFO_SelectPage(@Param("bp") BasePage bp);


	/*
		->日志记录表 -- 根据条件查询数据（根据ID指定查询）
	*/
	@Select(" SELECT ${bp.columns}  FROM ${bp.tables} WHERE  1 = 1  AND  LOGINFO.ID =  #{bp.byOneCondition}")
	BasePage LOGINFO_SelectByOne(@Param("bp") BasePage bp);


	/*
		->日志记录表 -- 创建数据
	*/
	@Insert(" INSERT INTO  LOGINFO (  ${bp.insertKeys}  )  VALUES   ${bp.insertVals} ")
	int LOGINFO_InsertData(@Param("bp") BasePage bp);


	/*
		->日志记录表 -- 编辑修改数据
	*/
	@Update(" UPDATE  ${bp.tables }  SET  ${bp.updateCols}  WHERE 1 = 1  ${bp.condition} ")
	int LOGINFO_UpdateData(@Param("bp") BasePage bp);


	/*
		->日志记录表 -- 删除数据（暴力删除）
	*/
	@Delete(" DELETE  ${bp.needDelTables}  FROM  ${bp.tables}  WHERE 1 = 1  ${bp.condition} ")
	int LOGINFO_DeleteData(@Param("bp") BasePage bp);

}