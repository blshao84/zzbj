/*
 Navicat Premium Data Transfer

 Source Server         : SCI
 Source Server Type    : PostgreSQL
 Source Server Version : 90602
 Source Host           : localhost:5432
 Source Catalog        : bct
 Source Schema         : commerce_model

 Target Server Type    : PostgreSQL
 Target Server Version : 90602
 File Encoding         : 65001

 Date: 28/12/2020 15:19:30
*/


-- ----------------------------
-- Sequence structure for attachment_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "commerce_model"."attachment_id_seq";
CREATE SEQUENCE "commerce_model"."attachment_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for base_element_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "commerce_model"."base_element_id_seq";
CREATE SEQUENCE "commerce_model"."base_element_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for receive_history_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "commerce_model"."receive_history_id_seq";
CREATE SEQUENCE "commerce_model"."receive_history_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for send_history_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "commerce_model"."send_history_id_seq";
CREATE SEQUENCE "commerce_model"."send_history_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for structure_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "commerce_model"."structure_id_seq";
CREATE SEQUENCE "commerce_model"."structure_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for task_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "commerce_model"."task_id_seq";
CREATE SEQUENCE "commerce_model"."task_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS "commerce_model"."attachment";
CREATE TABLE "commerce_model"."attachment" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT nextval('"commerce_model".attachment_id_seq'::regclass),
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "attachment_id" varchar(255) COLLATE "pg_catalog"."default",
  "attachment_name" varchar(255) COLLATE "pg_catalog"."default",
  "attachment_path" varchar(255) COLLATE "pg_catalog"."default",
  "field" varchar(255) COLLATE "pg_catalog"."default",
  "status" bool
)
;

-- ----------------------------
-- Table structure for base_element
-- ----------------------------
DROP TABLE IF EXISTS "commerce_model"."base_element";
CREATE TABLE "commerce_model"."base_element" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT nextval('"commerce_model".base_element_id_seq'::regclass),
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "code" varchar(255) COLLATE "pg_catalog"."default",
  "data_type" varchar(255) COLLATE "pg_catalog"."default",
  "default_value" varchar(255) COLLATE "pg_catalog"."default",
  "element_description" varchar(255) COLLATE "pg_catalog"."default",
  "element_name" varchar(255) COLLATE "pg_catalog"."default",
  "filter_class" varchar(255) COLLATE "pg_catalog"."default",
  "ods_name" varchar(255) COLLATE "pg_catalog"."default",
  "ods_schema" varchar(255) COLLATE "pg_catalog"."default",
  "ods_table_name" varchar(255) COLLATE "pg_catalog"."default",
  "parent_id" varchar(255) COLLATE "pg_catalog"."default",
  "required" bool,
  "rounding" int4,
  "source_name" varchar(255) COLLATE "pg_catalog"."default",
  "sort" int4,
  "status" varchar(3) COLLATE "pg_catalog"."default",
  "use_associate" bool,
  "value_remark" varchar(1000) COLLATE "pg_catalog"."default",
  "value_verification" varchar(255) COLLATE "pg_catalog"."default",
  "excel_range" varchar(255) COLLATE "pg_catalog"."default",
  "is_list" bool,
  "list_flag" bool,
  "excel_sheet" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "commerce_model"."base_element"."value_remark" IS '代码取值';
COMMENT ON COLUMN "commerce_model"."base_element"."excel_range" IS 'excel单元格';

-- ----------------------------
-- Table structure for receive_history
-- ----------------------------
DROP TABLE IF EXISTS "commerce_model"."receive_history";
CREATE TABLE "commerce_model"."receive_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT nextval('"commerce_model".receive_history_id_seq'::regclass),
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "result" bool,
  "zip_path" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for report_base_config
-- ----------------------------
DROP TABLE IF EXISTS "commerce_model"."report_base_config";
CREATE TABLE "commerce_model"."report_base_config" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "receiver_code" varchar(255) COLLATE "pg_catalog"."default",
  "sender_code" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for send_history
-- ----------------------------
DROP TABLE IF EXISTS "commerce_model"."send_history";
CREATE TABLE "commerce_model"."send_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT nextval('"commerce_model".send_history_id_seq'::regclass),
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "result" bool,
  "zip_path" varchar(255) COLLATE "pg_catalog"."default",
  "operation_date" date,
  "version" int4
)
;

-- ----------------------------
-- Table structure for structure
-- ----------------------------
DROP TABLE IF EXISTS "commerce_model"."structure";
CREATE TABLE "commerce_model"."structure" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT nextval('"commerce_model".structure_id_seq'::regclass),
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "agreement_name" varchar(255) COLLATE "pg_catalog"."default",
  "code" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for task_config
-- ----------------------------
DROP TABLE IF EXISTS "commerce_model"."task_config";
CREATE TABLE "commerce_model"."task_config" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT nextval('"commerce_model".task_id_seq'::regclass),
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "execute" bool,
  "param" varchar(255) COLLATE "pg_catalog"."default",
  "script_type" varchar(255) COLLATE "pg_catalog"."default",
  "code" varchar(255) COLLATE "pg_catalog"."default",
  "task_name" varchar(255) COLLATE "pg_catalog"."default",
  "trans_step" varchar(255) COLLATE "pg_catalog"."default",
  "sort" int4
)
;

-- ----------------------------
-- Function structure for random_string
-- ----------------------------
DROP FUNCTION IF EXISTS "commerce_model"."random_string"(int4);
CREATE OR REPLACE FUNCTION "commerce_model"."random_string"(int4)
  RETURNS "pg_catalog"."text" AS $BODY$
   select array_to_string(array(select substring('0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz' FROM (ceil(random()*62))::int FOR 1) FROM generate_series(1, $1)), '');
$BODY$
  LANGUAGE sql VOLATILE
  COST 100;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "commerce_model"."attachment_id_seq"
OWNED BY "commerce_model"."attachment"."id";
SELECT setval('"commerce_model"."attachment_id_seq"', 3, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "commerce_model"."base_element_id_seq"
OWNED BY "commerce_model"."base_element"."id";
SELECT setval('"commerce_model"."base_element_id_seq"', 5, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "commerce_model"."receive_history_id_seq"
OWNED BY "commerce_model"."receive_history"."id";
SELECT setval('"commerce_model"."receive_history_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "commerce_model"."send_history_id_seq"
OWNED BY "commerce_model"."send_history"."id";
SELECT setval('"commerce_model"."send_history_id_seq"', 2, false);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "commerce_model"."structure_id_seq"
OWNED BY "commerce_model"."structure"."id";
SELECT setval('"commerce_model"."structure_id_seq"', 14, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "commerce_model"."task_id_seq"
OWNED BY "commerce_model"."task_config"."id";
SELECT setval('"commerce_model"."task_id_seq"', 2, false);

-- ----------------------------
-- Primary Key structure for table attachment
-- ----------------------------
ALTER TABLE "commerce_model"."attachment" ADD CONSTRAINT "attachment_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table base_element
-- ----------------------------
ALTER TABLE "commerce_model"."base_element" ADD CONSTRAINT "base_element_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table receive_history
-- ----------------------------
ALTER TABLE "commerce_model"."receive_history" ADD CONSTRAINT "receive_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table report_base_config
-- ----------------------------
ALTER TABLE "commerce_model"."report_base_config" ADD CONSTRAINT "report_base_config_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table send_history
-- ----------------------------
ALTER TABLE "commerce_model"."send_history" ADD CONSTRAINT "send_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table structure
-- ----------------------------
ALTER TABLE "commerce_model"."structure" ADD CONSTRAINT "structure_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table task_config
-- ----------------------------
ALTER TABLE "commerce_model"."task_config" ADD CONSTRAINT "task_pkey" PRIMARY KEY ("id");
