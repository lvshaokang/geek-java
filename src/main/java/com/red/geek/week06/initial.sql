-- 基于电商交易场景（用户、商品、订单），设计一套简单的表结构，提交DDL的SQL文件到Github

-- 用户表
CREATE TABLE IF NOT EXISTS t_user
(
    `id`          int(11)             NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(16)         NOT NULL COMMENT '用户名',
    `password`    varchar(16)         NOT NULL COMMENT '密码',
    `phoneNumber` varchar(15)         NOT NULL COMMENT '手机号',
    `is_deleted`  tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除（0:不删除 1：删除） 默认0',
    `create_time` datetime            NOT NULL COMMENT '创建时间',
    `update_time` datetime            NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;;

-- 商品表
CREATE TABLE IF NOT EXISTS `t_product`
(
    `id`          int(11)             NOT NULL AUTO_INCREMENT COMMENT 'id',
    `name`        varchar(16)         NOT NULL COMMENT '名称',
    `description` varchar(1024)       NULL COMMENT '描述',
    `price`       decimal(10, 2)      NOT NULL COMMENT '价格',
    `inventory`   int(11)             NOT NULL COMMENT '库存',
    `is_deleted`  tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除（0:不删除 1：删除） 默认0',
    `create_time` datetime            NOT NULL COMMENT '创建时间',
    `update_time` datetime            NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 订单主表
CREATE TABLE IF NOT EXISTS `t_order_main`
(
    `id`             int(11)             NOT NULL AUTO_INCREMENT COMMENT 'id',
    `order_id`       bigint(30)          NOT NULL COMMENT '订单编号',
    `user_id`        int(11)             NOT NULL COMMENT '用户id',
    `order_status`   tinyint(4)          NOT NULL COMMENT '订单状态',
    `order_price`    decimal(10, 2)      NOT NULL COMMENT '订单金额',
    `is_deleted`     tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除（0:不删除 1：删除） 默认0',
    `create_time`    datetime            NOT NULL COMMENT '创建时间',
    `update_time`    datetime            NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 订单详情表
CREATE TABLE IF NOT EXISTS `t_order_detail`
(
    `id`             int(11)             NOT NULL AUTO_INCREMENT COMMENT 'id',
    `order_id`       bigint(30)          NOT NULL COMMENT '订单编号',
    `product_id`     int(11)             NOT NULL COMMENT '商品id',
    `product_num`    int(11)             NOT NULL COMMENT '商品数量',
    `is_deleted`     tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '逻辑删除（0:不删除 1：删除） 默认0',
    `create_time`    datetime            NOT NULL COMMENT '创建时间',
    `update_time`    datetime            NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


