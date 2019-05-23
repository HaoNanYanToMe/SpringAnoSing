/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3852
 Source Schema         : drug

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 21/05/2019 11:59:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for druginfo
-- ----------------------------
DROP TABLE IF EXISTS `druginfo`;
CREATE TABLE `druginfo`  (
  `ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `VERSION` int(11) NULL DEFAULT NULL COMMENT '版本',
  `ISDELETE` int(11) NULL DEFAULT NULL COMMENT '是否显示',
  `DATETIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `STOCK` int(11) NULL DEFAULT NULL COMMENT '药品库存',
  `SUPPLIER` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供货商编号',
  `TID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '药品分类编号',
  `UID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提交人',
  `PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经销商电话',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of druginfo
-- ----------------------------
INSERT INTO `druginfo` VALUES ('43d7cf9d7e824a46b6f84c358daa37e2', 3, 0, '2019-05-21 11:40:39', '2019-05-21 11:40:39', '1', 2, '1', '9da5c93ef9f946f49387da3aec708cbf', NULL, '1');
INSERT INTO `druginfo` VALUES ('63d67c3ba5f1418da887a01bccd6d19e', 4, 0, '2019-05-21 11:17:06', '2019-05-21 11:17:06', 'A', 2, '老王', 'b4a7e47f8e3e4507961e8d40e58e03af', NULL, NULL);
INSERT INTO `druginfo` VALUES ('fc6b6b6cb82e4d649825b6974387185a', 2, 0, '2019-05-21 11:29:26', '2019-05-21 11:29:26', '999感冒灵', 111, '999', '9da5c93ef9f946f49387da3aec708cbf', NULL, '12333');

-- ----------------------------
-- Table structure for dtinfo
-- ----------------------------
DROP TABLE IF EXISTS `dtinfo`;
CREATE TABLE `dtinfo`  (
  `ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `VERSION` int(11) NULL DEFAULT NULL COMMENT '版本',
  `ISDELETE` int(11) NULL DEFAULT NULL COMMENT '是否显示',
  `DATETIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  `UID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后操作人',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '药品分类管理信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dtinfo
-- ----------------------------
INSERT INTO `dtinfo` VALUES ('9da5c93ef9f946f49387da3aec708cbf', 0, 0, '2019-05-20 17:49:00', '2019-05-20 17:49:00', '感冒药', NULL);
INSERT INTO `dtinfo` VALUES ('b4a7e47f8e3e4507961e8d40e58e03af', 0, 0, '2019-05-20 17:57:59', '2019-05-20 17:57:59', '处方药', NULL);
INSERT INTO `dtinfo` VALUES ('e81d59b1b45b4f279f63ed88dcbb0a31', 1, 0, '2019-05-21 10:23:49', '2019-05-21 10:23:49', 'A', NULL);

-- ----------------------------
-- Table structure for loginfo
-- ----------------------------
DROP TABLE IF EXISTS `loginfo`;
CREATE TABLE `loginfo`  (
  `ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `VERSION` int(11) NULL DEFAULT NULL COMMENT '版本',
  `ISDELETE` int(11) NULL DEFAULT NULL COMMENT '是否显示',
  `DATETIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `LOGS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作内容',
  `TYPE` int(11) NULL DEFAULT NULL COMMENT '操作类型(0-登录1-新增2-修改3-删除)',
  `UID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后操作人',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of loginfo
-- ----------------------------
INSERT INTO `loginfo` VALUES ('1e3af63d3dba4d4fba68db8d47478393', 0, 0, '2019-05-21 11:52:07', '2019-05-21 11:52:07', '超级管理员登录系统', 0, '4d098ae060b54b1baf0d6d8d77b39563');
INSERT INTO `loginfo` VALUES ('e932a2f4513d415eb7612c3bd73bd7d3', 0, 0, '2019-05-21 11:52:16', '2019-05-21 11:52:16', '删除药品分类:undefined成功', 3, '4d098ae060b54b1baf0d6d8d77b39563');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `VERSION` int(11) NULL DEFAULT NULL COMMENT '版本',
  `ISDELETE` int(11) NULL DEFAULT NULL COMMENT '是否显示',
  `DATETIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `UID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后操作人',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '供应商' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sysmenu
-- ----------------------------
DROP TABLE IF EXISTS `sysmenu`;
CREATE TABLE `sysmenu`  (
  `ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键编号',
  `VERSION` int(11) NULL DEFAULT NULL COMMENT '版本',
  `ISDELETE` int(11) NULL DEFAULT NULL COMMENT '是否显示',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `CONTENT` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单简介',
  `ICON` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单ICON',
  `PID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级菜单编号',
  `ISLOCKED` int(11) NULL DEFAULT NULL COMMENT '是否锁定菜单',
  `CODE` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可用数据权限',
  `PATH` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由path',
  `TITLE` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由title',
  `COMPONENT` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由文件路径',
  `ISPARENT` int(11) NULL DEFAULT NULL COMMENT '菜单是否为父级',
  `SORT` int(11) NULL DEFAULT NULL COMMENT '序列号',
  `DATETIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单信息管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysmenu
-- ----------------------------
INSERT INTO `sysmenu` VALUES ('2517ff73b74246658f48597655858610', 2, 0, '2019-05-20 16:50:24', 'durg_index', '药品库', NULL, 'ada0213d04fa42469145765fcaf37718', 0, 'DRUGINFO', 'drugPage', '药品库', 'drug/drugIndex', 1, 2, '2019-05-20 16:50:24');
INSERT INTO `sysmenu` VALUES ('36f3ac95d2e44418bacba1f5d13815d0', 2, 0, '2019-05-20 16:59:01', 'supplier_index', '经销商管理', NULL, 'ada0213d04fa42469145765fcaf37718', 1, 'SUPPLIER', 'supplierPage', '经销商管理', 'drug/supplierIndex', 1, 3, '2019-05-20 16:59:01');
INSERT INTO `sysmenu` VALUES ('582ffb3d0ae846e5b902506ae1533f5e', 8, 0, '2019-01-31 14:37:23', 'role_index', '权限管理', 'md-paper-plane', 'fa638b3f211940e39ed06e9983524b9e', 0, 'sysUser,sysRole,sysMenu,SYSROLEMENU,SYSROLE,SYSUSER,SYSMENU,TABLEFOLDER', 'rolePage', '系统权限管理', 'roles/roleIndex', 1, 3, '2019-01-31 14:37:23');
INSERT INTO `sysmenu` VALUES ('8f9334858e7048a9b8609e93a42cee05', 1, 0, '2019-05-20 16:52:27', 'drugType_index', '药品分类管理', NULL, 'ada0213d04fa42469145765fcaf37718', 0, 'DTINFO', 'drugTypePage', '药品分类管理', 'drug/drugTypeIndex', 1, NULL, '2019-05-20 16:52:27');
INSERT INTO `sysmenu` VALUES ('922d46e1550f40fb9cbe27fd8d532dcf', 3, 0, '2019-02-03 14:19:12', 'user_index', '用户管理', 'md-person', 'fa638b3f211940e39ed06e9983524b9e', 0, 'sysUser,sysRole,sysMenu,SYSROLEMENU,SYSROLE,SYSUSER,SYSMENU,TABLEFOLDER', 'userPage', '系统用户管理', 'roles/userIndex', 1, 4, '2019-02-03 14:19:12');
INSERT INTO `sysmenu` VALUES ('ada0213d04fa42469145765fcaf37718', 4, 0, '2019-05-20 16:48:28', 'DrugBase', '药品管理', NULL, '-1', 0, 'LOGINFO,DTINFO,DRUGINFO', '/drug', '药品管理', 'Main', 0, 2, '2019-05-20 16:48:28');
INSERT INTO `sysmenu` VALUES ('c9ad393976944d6a8be9ddb52e21d26d', 5, 0, '2019-01-31 17:16:56', 'dataSource_index', '管理数据源信息，提供给菜单用以数据表的访问权限配置', 'logo-octocat', 'fa638b3f211940e39ed06e9983524b9e', 0, 'sysRole,sysMenu,SYSROLEMENU,SYSROLE,SYSUSER,HETARAENGINE,SYSMENU,TABLEFOLDER', 'dataSourcePage', '数据源管理', 'roles/dataSourceIndex', 1, 1, '2019-01-31 17:16:56');
INSERT INTO `sysmenu` VALUES ('cf90548fdf144483b6dca1c57ad31d5f', 7, 0, '2019-01-31 14:29:32', 'menu_index', '菜单管理', 'logo-windows', 'fa638b3f211940e39ed06e9983524b9e', 0, 'sysUser,sysRole,sysMenu,SYSROLEMENU,SYSROLE,SYSUSER,SYSMENU,TABLEFOLDER', 'menuPage', '系统菜单管理', 'roles/menuIndex', 1, 2, '2019-01-31 14:29:32');
INSERT INTO `sysmenu` VALUES ('f66264126b314dd0b544fe5627a1a135', 1, 0, '2019-05-21 10:27:59', 'log_index', '系统日志管理', NULL, 'fa638b3f211940e39ed06e9983524b9e', 0, 'LOGINFO', 'logPage', '系统日志管理', 'roles/logIndex', 1, 5, '2019-05-21 10:27:59');
INSERT INTO `sysmenu` VALUES ('fa638b3f211940e39ed06e9983524b9e', 9, 0, '2019-01-31 11:01:53', 'BaseTools', '系统权限', 'md-settings', '-1', 0, 'sysUser,sysRole,sysMenu,SYSROLEMENU,SYSROLE,SYSUSER,SYSMENU,TABLEFOLDER', '/roles', '系统设置', 'Main', 0, 1, '2019-01-31 11:01:53');

-- ----------------------------
-- Table structure for sysrole
-- ----------------------------
DROP TABLE IF EXISTS `sysrole`;
CREATE TABLE `sysrole`  (
  `ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `VERSION` int(11) NULL DEFAULT NULL COMMENT '版本',
  `ISDELETE` int(11) NULL DEFAULT NULL COMMENT '是否显示',
  `DATETIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `NOTE` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限简介',
  `ICON` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限ICON',
  `ISLOCK` int(11) NULL DEFAULT NULL COMMENT '是否禁用锁定',
  `PID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级权限编号',
  `ISTOP` int(11) NULL DEFAULT NULL COMMENT '是否为顶级权限',
  `SORT` int(11) NULL DEFAULT NULL COMMENT '权限序列号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户权限信息管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysrole
-- ----------------------------
INSERT INTO `sysrole` VALUES ('9614475f90184fdab6549e1331055843', 1, 0, '2019-05-20 16:44:34', '2019-05-20 16:44:34', '普通用户', '普通用户', NULL, 0, '-1', 0, 2);
INSERT INTO `sysrole` VALUES ('b5942a6c590546e59fcf4bd51b6a7c0f', 9, 0, '2019-02-13 11:10:24', '2019-02-13 11:10:24', '超级管理员', '系统超级管理员2', NULL, 0, '-1', 0, 0);

-- ----------------------------
-- Table structure for sysrolemenu
-- ----------------------------
DROP TABLE IF EXISTS `sysrolemenu`;
CREATE TABLE `sysrolemenu`  (
  `ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `VERSION` int(11) NULL DEFAULT NULL COMMENT '版本',
  `ISDELETE` int(11) NULL DEFAULT NULL COMMENT '是否显示',
  `DATETIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `RID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应权限编号',
  `ADDS` int(11) NULL DEFAULT NULL COMMENT '增',
  `DEL` int(11) NULL DEFAULT NULL COMMENT '删',
  `EDIT` int(11) NULL DEFAULT NULL COMMENT '改',
  `SEL` int(11) NULL DEFAULT NULL COMMENT '查',
  `EXPORTS` int(11) NULL DEFAULT NULL COMMENT '导出',
  `SORT` int(11) NULL DEFAULT NULL COMMENT '序号',
  `MID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应菜单编号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单及权限信息关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysrolemenu
-- ----------------------------
INSERT INTO `sysrolemenu` VALUES ('16c555830f184b28af5256e23e9430f7', 0, 0, '2019-02-15 17:30:42', '2019-02-15 17:30:42', 'b5942a6c590546e59fcf4bd51b6a7c0f', 1, 1, 1, 1, 1, NULL, 'cf90548fdf144483b6dca1c57ad31d5f');
INSERT INTO `sysrolemenu` VALUES ('308529c86d104320a263a051f34966d6', 0, 0, '2019-05-20 17:04:33', '2019-05-20 17:04:33', 'b5942a6c590546e59fcf4bd51b6a7c0f', 1, 1, 1, 1, 1, NULL, 'ada0213d04fa42469145765fcaf37718');
INSERT INTO `sysrolemenu` VALUES ('6401d34109114e9787b872984709bbf2', 0, 0, '2019-02-13 11:11:38', '2019-02-13 11:11:38', 'b5942a6c590546e59fcf4bd51b6a7c0f', 1, 1, 1, 1, 1, NULL, '582ffb3d0ae846e5b902506ae1533f5e');
INSERT INTO `sysrolemenu` VALUES ('71af890b9ca34b2c891f556e7e9e1d2e', 0, 0, '2019-05-21 10:35:47', '2019-05-21 10:35:47', 'b5942a6c590546e59fcf4bd51b6a7c0f', 1, 1, 1, 1, 1, NULL, 'f66264126b314dd0b544fe5627a1a135');
INSERT INTO `sysrolemenu` VALUES ('71cd2ff9cc2c411a82359f3afbaaa496', 0, 0, '2019-02-13 11:11:38', '2019-02-13 11:11:38', 'b5942a6c590546e59fcf4bd51b6a7c0f', 1, 1, 1, 1, 1, NULL, 'fa638b3f211940e39ed06e9983524b9e');
INSERT INTO `sysrolemenu` VALUES ('9432097224994314a4467ac7f14353a2', 0, 0, '2019-05-20 17:04:42', '2019-05-20 17:04:42', '9614475f90184fdab6549e1331055843', 1, 1, 1, 1, 1, NULL, 'ada0213d04fa42469145765fcaf37718');
INSERT INTO `sysrolemenu` VALUES ('a95a4700297b433fa3ee0d477bfe7c6f', 0, 0, '2019-02-15 17:30:42', '2019-02-15 17:30:42', 'b5942a6c590546e59fcf4bd51b6a7c0f', 1, 1, 1, 1, 1, NULL, '922d46e1550f40fb9cbe27fd8d532dcf');
INSERT INTO `sysrolemenu` VALUES ('b40cffe2e1e4483791e6e7db2fea34d9', 0, 0, '2019-05-20 17:04:33', '2019-05-20 17:04:33', 'b5942a6c590546e59fcf4bd51b6a7c0f', 1, 1, 1, 1, 1, NULL, '2517ff73b74246658f48597655858610');
INSERT INTO `sysrolemenu` VALUES ('b6f949014c6e4905a5f39d94a395800f', 0, 0, '2019-05-20 17:04:42', '2019-05-20 17:04:42', '9614475f90184fdab6549e1331055843', 1, 1, 1, 1, 1, NULL, '8f9334858e7048a9b8609e93a42cee05');
INSERT INTO `sysrolemenu` VALUES ('ba1ccd6ed2824e62869a73a413b6ba6f', 0, 0, '2019-05-20 17:04:33', '2019-05-20 17:04:33', 'b5942a6c590546e59fcf4bd51b6a7c0f', 1, 1, 1, 1, 1, NULL, '8f9334858e7048a9b8609e93a42cee05');
INSERT INTO `sysrolemenu` VALUES ('d00b1a9c7b2540a3863c08d54e451151', 0, 0, '2019-02-15 17:30:42', '2019-02-15 17:30:42', 'b5942a6c590546e59fcf4bd51b6a7c0f', 1, 1, 1, 1, 1, NULL, 'c9ad393976944d6a8be9ddb52e21d26d');
INSERT INTO `sysrolemenu` VALUES ('d5e1e8345b7d4ffbad01dd923a7b8b29', 0, 0, '2019-05-20 17:04:42', '2019-05-20 17:04:42', '9614475f90184fdab6549e1331055843', 1, 1, 1, 1, 1, NULL, '2517ff73b74246658f48597655858610');

-- ----------------------------
-- Table structure for sysuser
-- ----------------------------
DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser`  (
  `ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `VERSION` int(11) NULL DEFAULT NULL COMMENT '版本',
  `ISDELETE` int(11) NULL DEFAULT NULL COMMENT '是否显示',
  `DATETIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `EMAIL` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户登陆邮箱',
  `PASSWORD` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二级管理密码',
  `NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',
  `RID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户权限',
  `PHONE` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '座机号',
  `MOBILE` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `LASTIP` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登陆IP',
  `TYPE` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型',
  `AVATAR` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `NOTE` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户备注',
  `OPENID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户openId',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sysuser
-- ----------------------------
INSERT INTO `sysuser` VALUES ('4d098ae060b54b1baf0d6d8d77b39563', 82, 0, '2019-05-21 11:52:07', '2019-01-21 16:21:16', 'admin', 'c4ca4238a0b923820dcc509a6f75849b', '超级管理员', 'b5942a6c590546e59fcf4bd51b6a7c0f', '0', '15801047470', '127.0.0.1', NULL, NULL, '系统开发超级管理员1', NULL);
INSERT INTO `sysuser` VALUES ('6fd7c36982124b96a0ec4b1af1c51236', 2, 0, '2019-05-20 18:13:15', '2019-05-20 18:13:15', 'yangliang', 'c4ca4238a0b923820dcc509a6f75849b', '杨亮', '9614475f90184fdab6549e1331055843', '111', '1111', NULL, NULL, NULL, '11', NULL);

-- ----------------------------
-- Table structure for tablefolder
-- ----------------------------
DROP TABLE IF EXISTS `tablefolder`;
CREATE TABLE `tablefolder`  (
  `ID` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `VERSION` int(11) NULL DEFAULT NULL COMMENT '版本',
  `ISDELETE` int(11) NULL DEFAULT NULL COMMENT '是否显示',
  `DATETIME` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `CODE` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表唯一编码',
  `NAME` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名称',
  `NOTE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表简要介绍',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据表仓库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tablefolder
-- ----------------------------
INSERT INTO `tablefolder` VALUES ('08ab41d45ea849bab6f8a7080aa7cd72', 0, 0, '2019-05-20 16:54:31', '2019-05-20 16:54:31', 'DRUGINFO', '药品库', '药品库');
INSERT INTO `tablefolder` VALUES ('0ff8ab65155f4d40a921dcf91ae68c9e', 0, 0, '2019-01-31 11:52:08', '2019-01-31 11:52:08', 'sysMenu', '系统管理拓展接口', '系统管理拓展接口');
INSERT INTO `tablefolder` VALUES ('1662f87e64fc459d9770fc331f0e5a53', 0, 0, '2019-01-31 11:46:45', '2019-01-31 11:46:45', 'TABLEFOLDER', '数据源仓库', '数据源仓库');
INSERT INTO `tablefolder` VALUES ('1a4ba8b449d54d4eac9026503beb5556', 0, 0, '2019-05-20 16:56:58', '2019-05-20 16:56:58', 'SUPPLIER', '经销商', '经销商');
INSERT INTO `tablefolder` VALUES ('27684b87d6ea4c5ebe0edd046b96254f', 0, 0, '2019-05-20 16:56:09', '2019-05-20 16:56:09', 'DTINFO', '药品分类库', '药品分类库');
INSERT INTO `tablefolder` VALUES ('7332e876520445149ef4cb7206a9e322', 0, 0, '2019-01-31 11:50:47', '2019-01-31 11:50:47', 'SYSROLEMENU', '系统权限菜单绑定', '系统权限菜单绑定');
INSERT INTO `tablefolder` VALUES ('73a43cfc8e2c4e9d9f9255b97cbf7603', 0, 0, '2019-01-31 11:49:38', '2019-01-31 11:49:38', 'SYSUSER', '系统用户表', '系统用户表');
INSERT INTO `tablefolder` VALUES ('773c120f674346768fde6a124dd1ba0e', 0, 0, '2019-01-31 11:47:34', '2019-01-31 11:47:34', 'SYSMENU', '系统菜单', '系统菜单');
INSERT INTO `tablefolder` VALUES ('9c3474e816d74a22951be3e283ffa191', 0, 0, '2019-01-31 11:49:54', '2019-01-31 11:49:54', 'SYSROLE', '系统权限表', '系统权限表');
INSERT INTO `tablefolder` VALUES ('b797fe9669dd407aaac67fe42d33e4b8', 2, 0, '2019-02-03 14:20:04', '2019-02-03 14:20:04', 'sysRole', '用户权限相关拓展接口', '用户权限相关拓展接口');
INSERT INTO `tablefolder` VALUES ('cc0ffc54cd9d41c985a0500182df6720', 0, 0, '2019-05-21 10:26:29', '2019-05-21 10:26:29', 'LOGINFO', '日志管理表', '日志管理表');

SET FOREIGN_KEY_CHECKS = 1;
