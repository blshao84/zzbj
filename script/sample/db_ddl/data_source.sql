/*
 Navicat Premium Data Transfer

 Source Server         : SCI
 Source Server Type    : PostgreSQL
 Source Server Version : 90602
 Source Host           : localhost:5432
 Source Catalog        : bct
 Source Schema         : data_source

 Target Server Type    : PostgreSQL
 Target Server Version : 90602
 File Encoding         : 65001

 Date: 28/12/2020 14:21:30
*/


-- ----------------------------
-- Sequence structure for party_tuple_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "data_source"."party_tuple_id_seq";
CREATE SEQUENCE "data_source"."party_tuple_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for contract_number_process
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."contract_number_process";
CREATE TABLE "data_source"."contract_number_process" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "contract" jsonb NOT NULL,
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for event_report
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."event_report";
CREATE TABLE "data_source"."event_report" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "event" jsonb NOT NULL,
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for event_report_history
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."event_report_history";
CREATE TABLE "data_source"."event_report_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "event_report" jsonb NOT NULL,
  "operation_date" date,
  "receive_status" bool,
  "send_status" bool,
  "version" int4
)
;

-- ----------------------------
-- Table structure for master_agreement
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."master_agreement";
CREATE TABLE "data_source"."master_agreement" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "attachment" varchar(255) COLLATE "pg_catalog"."default",
  "counter_party_code" varchar(255) COLLATE "pg_catalog"."default",
  "counter_party_name" varchar(255) COLLATE "pg_catalog"."default",
  "counter_party_type" varchar(255) COLLATE "pg_catalog"."default",
  "file_party" varchar(255) COLLATE "pg_catalog"."default",
  "industry_code" varchar(255) COLLATE "pg_catalog"."default",
  "master_agreement_id" varchar(255) COLLATE "pg_catalog"."default",
  "master_agreement_no" varchar(255) COLLATE "pg_catalog"."default",
  "master_version" varchar(255) COLLATE "pg_catalog"."default",
  "party_capital" numeric(19,2),
  "party_identity" varchar(255) COLLATE "pg_catalog"."default",
  "remark" varchar(255) COLLATE "pg_catalog"."default",
  "signing_date" date
)
;

-- ----------------------------
-- Table structure for master_agrmt
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."master_agrmt";
CREATE TABLE "data_source"."master_agrmt" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "master" jsonb NOT NULL,
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for master_agrmt_product
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."master_agrmt_product";
CREATE TABLE "data_source"."master_agrmt_product" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "product" jsonb NOT NULL,
  "archive" bool
)
;

-- ----------------------------
-- Table structure for option_confirmation
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."option_confirmation";
CREATE TABLE "data_source"."option_confirmation" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "optionconfirm" jsonb NOT NULL,
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for option_termination
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."option_termination";
CREATE TABLE "data_source"."option_termination" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "option" jsonb NOT NULL,
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for other_report
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."other_report";
CREATE TABLE "data_source"."other_report" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "other" jsonb NOT NULL,
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for party_tuple
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."party_tuple";
CREATE TABLE "data_source"."party_tuple" (
  "id" int4 NOT NULL DEFAULT nextval('"data_source".party_tuple_id_seq'::regclass),
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "email" varchar(255) COLLATE "pg_catalog"."default",
  "mobile" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "telephone" varchar(255) COLLATE "pg_catalog"."default",
  "title" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for performance_guarantee_agrmt
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."performance_guarantee_agrmt";
CREATE TABLE "data_source"."performance_guarantee_agrmt" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "performance" jsonb NOT NULL,
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for periodic_report_isda
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."periodic_report_isda";
CREATE TABLE "data_source"."periodic_report_isda" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "isda" jsonb NOT NULL,
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for periodic_report_nafmii
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."periodic_report_nafmii";
CREATE TABLE "data_source"."periodic_report_nafmii" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "nafmii" jsonb NOT NULL,
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for periodic_report_quarter
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."periodic_report_quarter";
CREATE TABLE "data_source"."periodic_report_quarter" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "quarter" jsonb NOT NULL,
  "archive" bool
)
;

-- ----------------------------
-- Table structure for periodic_report_sac
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."periodic_report_sac";
CREATE TABLE "data_source"."periodic_report_sac" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "sac" jsonb NOT NULL,
  "archive" bool
)
;

-- ----------------------------
-- Table structure for sup_agrmt
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."sup_agrmt";
CREATE TABLE "data_source"."sup_agrmt" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "sup" jsonb NOT NULL,
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "archive" bool
)
;

-- ----------------------------
-- Table structure for swap_confirmation
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."swap_confirmation";
CREATE TABLE "data_source"."swap_confirmation" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "swapconfirm" jsonb NOT NULL,
  "archive" bool
)
;

-- ----------------------------
-- Table structure for swap_termination
-- ----------------------------
DROP TABLE IF EXISTS "data_source"."swap_termination";
CREATE TABLE "data_source"."swap_termination" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "process_instance_id" varchar(255) COLLATE "pg_catalog"."default",
  "swap" jsonb NOT NULL,
  "archive" bool
)
;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "data_source"."party_tuple_id_seq"
OWNED BY "data_source"."party_tuple"."id";
SELECT setval('"data_source"."party_tuple_id_seq"', 2, false);

-- ----------------------------
-- Primary Key structure for table contract_number_process
-- ----------------------------
ALTER TABLE "data_source"."contract_number_process" ADD CONSTRAINT "contract_number_process_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table event_report
-- ----------------------------
ALTER TABLE "data_source"."event_report" ADD CONSTRAINT "event_report_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table event_report_history
-- ----------------------------
ALTER TABLE "data_source"."event_report_history" ADD CONSTRAINT "event_report_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table master_agreement
-- ----------------------------
ALTER TABLE "data_source"."master_agreement" ADD CONSTRAINT "master_agreement_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table master_agrmt
-- ----------------------------
ALTER TABLE "data_source"."master_agrmt" ADD CONSTRAINT "master_agrmt_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table master_agrmt_product
-- ----------------------------
ALTER TABLE "data_source"."master_agrmt_product" ADD CONSTRAINT "master_agrmt_product_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table option_confirmation
-- ----------------------------
ALTER TABLE "data_source"."option_confirmation" ADD CONSTRAINT "option_confirmation_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table option_termination
-- ----------------------------
ALTER TABLE "data_source"."option_termination" ADD CONSTRAINT "option_termination_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table other_report
-- ----------------------------
ALTER TABLE "data_source"."other_report" ADD CONSTRAINT "other_report_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table party_tuple
-- ----------------------------
ALTER TABLE "data_source"."party_tuple" ADD CONSTRAINT "party_tuple_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table performance_guarantee_agrmt
-- ----------------------------
ALTER TABLE "data_source"."performance_guarantee_agrmt" ADD CONSTRAINT "performance_guarantee_agrmt_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table periodic_report_isda
-- ----------------------------
ALTER TABLE "data_source"."periodic_report_isda" ADD CONSTRAINT "periodic_report_isda_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table periodic_report_nafmii
-- ----------------------------
ALTER TABLE "data_source"."periodic_report_nafmii" ADD CONSTRAINT "periodic_report_nafmii_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table periodic_report_quarter
-- ----------------------------
ALTER TABLE "data_source"."periodic_report_quarter" ADD CONSTRAINT "periodic_report_quarter_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table periodic_report_sac
-- ----------------------------
ALTER TABLE "data_source"."periodic_report_sac" ADD CONSTRAINT "periodic_report_sac_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sup_agrmt
-- ----------------------------
ALTER TABLE "data_source"."sup_agrmt" ADD CONSTRAINT "sup_agrmt_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table swap_confirmation
-- ----------------------------
ALTER TABLE "data_source"."swap_confirmation" ADD CONSTRAINT "swap_confirmation_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table swap_termination
-- ----------------------------
ALTER TABLE "data_source"."swap_termination" ADD CONSTRAINT "swap_termination_pkey" PRIMARY KEY ("id");
