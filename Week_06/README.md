用户表   
CREATE TABLE user(
    id int(10) NOT NULL PRIMARY KEY,
    name varchar(30) NOT NULL COMMENT "姓名",
    gender tinyint(4) DEFAULT NULL COMMENT '性别,
    age tinyint(2) NOT NULL COMMENT "年龄",
    phone bigint NOT NULL COMMENT "手机号",
    nickname varchar(30) DEFAULT NULL COMMENT "用户昵称",
    certificate_no varchar(32) NOT NULL COMMENT "证件号码"
    date_create datetime DEFAULT NULL COMMENT "创建时间",
    date_update datetime DEFAULT NULL COMMENT "更新时间",
    test_flag tinyint(1) DEFAULT NULL COMMENT '是否是测试',
    city varchar(128) DEFAULT NULL COMMENT '城市’,
    deleted tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标 0->未删除，1->删除',
    
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


商品信息
CREATE TABLE manage(
    id int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    province_name varchar(10) NOT NULL COMMENT '省份名称',
   province_code varchar(10) NOT NULL COMMENT '省份code',
   city_code varchar(10) NOT NULL COMMENT '城市code',
   city_name varchar(20) NOT NULL COMMENT '城市名称',
   create_user_name varchar(20) DEFAULT NULL COMMENT '创建者名称',
   create_user_id varchar(20) DEFAULT NULL COMMENT '创建者id',
   update_user_id varchar(20) DEFAULT NULL COMMENT '更新用户ID',
   update_user_name varchar(20) DEFAULT NULL COMMENT '更新用户名',
    date_create datetime DEFAULT NULL COMMENT "创建时间",
    date_update datetime DEFAULT NULL COMMENT "更新时间",
    name varchar(50) NOT NULL COMMENT "商品名称",
   effective_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
   expire_time timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '结束时间',
    discount decimal(10, 6) NOT NULL COMMENT '折扣比例',
    original_price bigint(10) NOT NULL COMMENT "原价",
    discount_price bigint(10) NOT NULL COMMENT "折扣价",
    description varchar(200) NOT NULL COMMENT "商品描述",
    test_flag int(2) DEFAULT '0' COMMENT '测试标志：0非测试，1测试',
    deleted tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标 0->未删除，1->删除',
    status tinyint(2) NOT NULL DEFAULT 0 COMMENT "商品状态 0审核中/1已通过"
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


用户购买记录
CREATE TABLE customer_order (
    id int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
    amount bigint(20) NOT NULL DEFAULT '0' COMMENT '支付金额 分',
    date_create timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
    date_update timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改日期',
    order_code varchar(32) DEFAULT '' COMMENT '支付单号',
    status tinyint(2) NOT NULL default 0 COMMENT "订单状态,
    user_id varchar(20) DEFAULT NULL COMMENT '用户id',
   channel_name varchar(20) DEFAULT NULL COMMENT '支付渠道,
   start_pay_time timestamp NULL DEFAULT NULL COMMENT '发起支付时间',
   pay_time timestamp NULL DEFAULT NULL COMMENT '支付成功时间',
   refund_time timestamp NULL DEFAULT NULL COMMENT '退款时间',
   test_flag tinyint(1) NOT NULL DEFAULT '0' COMMENT '测试标 0->非测试，1->测试',
    deleted tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标 0->未删除，1->删除',
    manage_id bigint NOT NULL COMMENT "关联商品",
    count int NOT NULL COMMENT "购买数量",
    snapshoot_id bigint NOT NULL COMMENT "快照ID"
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



记录用户购买商品时候的快照
CREATE TABLE user_customer_order (
    id int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    date_create timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    date_update timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    order_code varchar(32) DEFAULT '' COMMENT '支付单号',
    user_id varchar(20) DEFAULT NULL COMMENT '用户id',
    manage_id bigint NOT NULL COMMENT "关联商品",
    count int NOT NULL COMMENT "购买数量",
    user_phone bigint NOT NULL COMMENT "手机号",
    user_address varchar(50) NOT NULL COMMENT "住址",
    manage_name varchar(50) NOT NULL COMMENT "商品名称",
    product_original_price bigint(10) NOT NULL COMMENT "原价",
    product_discount_price bigint(10) NOT NULL COMMENT "折扣价",
    status int(11) NOT NULL DEFAULT '0' COMMENT '订单状态,
    close_status int(11) DEFAULT NULL COMMENT '订单子状态,
    refundable_status int(2) DEFAULT NULL COMMENT '可退款状态,1,可退款;0,不可退款'
    test_flag int(2) DEFAULT '0' COMMENT '测试标志：0非测试，1测试',
    deleted tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标 0->未删除，1->删除',
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
