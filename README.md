spring A.S
====
    更专注于业务层及复杂SQL的开发的Spring boot框架


* 融合graphql的理念，不必再为修改几个字段就大费周章重新部署
* 现在对于这些，你只需前端入参便可一步到位,极大程度减少后台代码业务量,将重复性无意义的包袱通通甩掉
* SQL引擎简化业务层开发所需时间，提升业务开发效率
* 全项目架构简洁轻便，提升代码开发效率

###  **A.S入门-如何运行我的Spring-A.S项目?** 

* 准备pdm数据文件(框架会提供一个test.pdm文件供您测试使用,后期就需要您自行准备了哦)
* 运行test.generate.generateTest文件生成对应的config/dao及sql文件
     * 将生成的BaseTableCfg.java文件复制粘贴至src.main.java.com.prism.springas.utils文件目录下(您也可以将已有的文件增加.bat后缀留做备份文件)
     * 将生成的BaseDao.java文件复制粘贴至src.main.java.com.prism.springas.dao文件目录下(您也可以将已有的文件增加.bat后缀留做备份文件)
     * 将生成的可执行sql文件打开后复制语句在sql工具内执行查询创建库表
 * 打开src.main.resource.application.yml文件修改对应的数据库连接配置信息
 * 打开src.main.java.SpringasApplication.java文件,右键运行
 * 启动成功! **恭喜您,您已经完成了Spring A.S的前期准备工作流程** ~


### A.S进阶-Spring-A.S使用手册

* api层:底层数据交换映射层,主要与DAO层做数据交互
     * impl:BaseApi的实现类,初步封装了简单的数据逻辑,以简化schema业务层的调用
     * tools:BaseApi核心配置类以及DAO层映射核心代码
 * controller层:前台与后台数据交换层(对外数据交互接口层),主要与schema层做数据交互
     * config:controller核心配置类/schema层映射核心代码及sqlEngine对前台JSON数据的校验及处理
 * dao层:mapper层,Mybatis数据交互层
     * BaseDAO:通过test.generate.generateTest执行后的源生DAO.java文件
     * exPand :拓展dao包
         * xxExDAO:BaseDAO(源生DAO)无法实现的复杂逻辑SQL
         * 拓展DAO层命名规范：xxx(业务名称)+ExDAO【不强制,仅做建议】
 * schema层:核心业务逻辑处理层,主要从API层获取数据并为Controller层提供数据
     * BaseSchema:基础业务逻辑层(核心业务类)
     * exPand :拓展schema包
          * xxExSchema:BaseSchema(源生DAO)无法实现的复杂业务逻辑
          * 拓展Schema层命名规范：xxx(业务名称)+ExSchema【不强制,仅做建议】
 * tools层:插件工具层(--目前只有比较简单的tools插件,后期版本会以拓展包形式发布提供给您使用,敬请关注。)
 * utils层:核心工具层,为框架提供核心工具类
     * cache:缓存工具类(目前相对简陋一些,仅以支持框架为基础)
     * pdmHelper:pdm-核心代码生成工具类
     * **sqlEngine**:*框架核心SQL引擎工具类
     * **BaseCoreCfg**：拓展DAO及Schema核心配置类(Ver1.1会优化为注解实现,进一步提升开发效率,相关更新敬请关注！)
     * **BasePage**:*核心实体映射类
     * **BaseTableCfg**：**pdm生成工具生成的核心源生表配置类(sqlEngine相关连表表名信息查询及表全查询字段功能)
     * **BasicConfigUtil**:yml配置中的全局配参字段
 * **SpringasApplication**:spring boot框架启动类


### Spring A.S注意事项及常见问题

* 我应该如何配置我的拓展dao和schema业务类?
     * ver1.0版本请您打开com.prism.springas.util.BaseCoreCfg
     * 1.将您的拓展DAO及Schema通过@Autowired自动注入
     * 2.在parseRefObject方法中配置您的拓展类名称(*唯一标识)
     *  **具体代码详参com.prism.springas.util.BaseCoreCfg给出的测试用例** 
* sqlEngine应该如何使用和配置？
     * 您可以打开src.test.java.com.prism.springas路径,下面的3个测试类将通过实际代码为您演示sqlEngine的使用
     * apiTests:API层接口测试
     * schemaTests:SCHEMA层接口(方法)测试
     * testThreadJunit:针对schema层在多线程下的更新及查询接口(方法)测试
* pdm数据字段规范？
     * 为了您的正常使用,建议您在设计表名及字段时使用大写英文字母(*由pdm生成的所有相关配置均为大写)
     * 表内核心字段:
         * ID:主键,varchar(128),请注意勾选pk选项,否则生成代码时会报错(*A.S全部主键均为UUID,还请注意)*核心字段！
         * VERSION:数据版本号,int,必须要有的字段,*乐观锁核心匹配字段!
         * CREATETIME：数据生成时间(首次创建时间),datetime,可选字段
         * DATATIME:数据最后更新时间,datetime,可选字段
         * ISDELETE:数据软删除状态,int,可选字段(如果您用到了数据软删除,建议您在设计表时加上该字段)

### sqlEngine(ver 1.0)-SQL引擎使用说明(Schema业务逻辑层)

* SELECT相关方法
     * getSelById(String id):根据ID检索数据的匹配条件
     * getSelTable(String tables):需要查询的数据表(支持多表,多个间以','隔开)
         * 注意:连表表名需要从BaseTableCfg获取,*且对应关联表必须在(如：//=对应关联表：SPORTSINFO,TEACHERINFO,TYPEINFO0)中!
         * 等效于: select * from a a left join b on a.id = b.id
     * getSelCols(String tables):指定需要查询的数据字段(多个间以','隔开)
         * tables-查询符合入参值的数据表全字段
         * 等效于：select a.* from a 
     * getSelCols(String tables,String cols):指定需要查询的数据字段(多个间以','隔开)
         * tables-查询符合入参值的数据表全字段
         * cols-查询符合入参值的字段,数据格式为 table_colname(数据表名_数据列名) / table_colname#alias(数据表名_数据列名#别名)
         * 等效于: select a.*,b.name AS 'bname' from a a left join b on a.id = b.id
     * getPage(Integer pageNo,Integer pageSize):数据分页
         * pageNo:当前第X页
         * pageSize:每页Y条
         * 等效于:select * from a where 1=1 limit x,y
     * getSort(String keys,String sortTypes):执行数据排序(多个间以','隔开)
         * keys:需要执行排序的字段
         * sortTypes：需要的排序类型,*sortTypes值需要与keys值一一对应
             * sortTypes允许的参数如下:
                 * 0 : 正常倒叙排序            order by a DESC
                 * 1 : 根据汉语拼音正序排序     order by CONVERT(a) USING GBK ASC
                 * 2 : 正常正叙排序            order by ASC
                 * 3 : 根据汉语拼音倒叙排序     order by CONVERT(a) USING GBK DESC
     * getWhereAnd(String key,String condition,Object val)/getWhereOr(String key,String condition,Object val):数据查询条件(and/or)
         * key:执行查询的数据字段,格式为：table_Cols(表名_列名)
         * condition:参数匹配条件(sqlEngineEnum)
             * EQ:等于
             * LIKE:模糊查询(使用时需要自行指定模糊查询条件,如'%老刘')
             * GT:大于
             * GTEQ:大于等于
             * LT:小于
             * LTEQ:小于等于
             * NEQ:不等于
             * NOTIN:不包含于(使用时,多个值需要以','隔开,如'1,2,3,4'..)
             * IN:包含于(使用时,多个值需要以','隔开,如'1,2,3,4'..)
             * ISNULL:为空(使用时,val入参为"n"即可)
             * NOTNULL:不为空(使用时,val入参为"n"即可)
             * BET:在a...b区间(使用时,val入参格式如下:'08:00:00**,**09:00:00',等效于查询8点-9点内产生的数据)
         * val:对应数据查段查询值(请严格参照上述表格格式进行入参,否则数据不会正常返回(报错))
     * getCount():计算数据总条数(total值)
 * DELETE相关方法
     * getDelTables(String tables):需要执行删除的数据表
     * getDeleteById(String id):以ID主键作为删除条件执行删除
     * getNeedDelTable(String tables):指定需要删除的数据表(多表复合删除专属方法)
     * **同样的,DELETE如果需要根据指定条件批量删除数据时,可以使用getWhereAnd/getWhereOr来指定删除条件^_^**
     * **请注意一点:getWhereAnd/getWhereOr与getDeleteById并不共存,sqlEngine会以最后的调用的方法为最终标准执行!**
 * INSERT相关方法
     * getAddData(String key,Object val):需要入库的字段及其对应值
         * key:入库字段(直接使用列名即可,如NAME,ID等)
         * val:入库值
 * UPDATE相关方法
     * getUpdateTables(String tables):需要执行更新的数据主表
     * getUpdateCols(String colKey,Object colValue):需要执行更新的字段及字段值
         * colKey:需要执行更新的字段
         * colValue:需要执行更新的字段值
     * getUpdateWhereAnd(String key,String condition,Object val)/getUpdateWhereOr(String key,String condition,Object val):数据更新条件(and/or)
         * 具体使用可参考**getWhereAnd/getWhereOr**
     * getUpdCurrentVersion(String tableName,Integer value)：数据版本验证/需要配合getUpdateById使用(*不适用于批量更新)
         * tableName:需要执行校验的数据表表名
         * value:当前数据版本
     * getUpdateById(String id):需要执行更新的数据主键ID
 * FETCH批量录入相关方法
     * getAddFetchCols(String cols):需要执行批量录入的数据列(ID/ISDELETE/VERSION/CREATETIME/DATETIME除外),多个列名间以','隔开
     * getAddFetchVals(List<BasePage fetchList):需要执行批量录入的数据值List

 **开发进度(版本更新日志)** 
Version 0.X:  更新时间:2018-03-28
 
版本功能:
* PDM自生成相关代码
* 完成了A.S框架的底层初步搭建

Version 1.0:  更新时间:2019-01-08
 
版本功能:
* 优化PDM自生成相关代码
* SQL引擎提出,进一步简化开发逻辑(*现版本仅支持Mysql数据库)
* 优化异常抛出,更加精准定位exception异常点位,提升bug修复及代码维护的效率
* 进一步提升了SQL引擎的数据安全性(2019-01-09)


 **PS** 
如果您有什么好的建议和意见可以直接评论给我，感谢您的支持~
Ver 2.0预计更新时间为1月16日~