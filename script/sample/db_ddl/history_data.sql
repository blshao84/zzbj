/*
 Navicat Premium Data Transfer

 Source Server         : SCI
 Source Server Type    : PostgreSQL
 Source Server Version : 90602
 Source Host           : localhost:5432
 Source Catalog        : bct
 Source Schema         : history_data

 Target Server Type    : PostgreSQL
 Target Server Version : 90602
 File Encoding         : 65001

 Date: 28/12/2020 14:21:42
*/


-- ----------------------------
-- Table structure for contract_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."contract_history";
CREATE TABLE "history_data"."contract_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "contract" jsonb NOT NULL,
  "exec_id" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Table structure for event_report_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."event_report_history";
CREATE TABLE "history_data"."event_report_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "event_report" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for isda_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."isda_history";
CREATE TABLE "history_data"."isda_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "isda" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for master_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."master_history";
CREATE TABLE "history_data"."master_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "exec_id" varchar(255) COLLATE "pg_catalog"."default",
  "master" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for master_product_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."master_product_history";
CREATE TABLE "history_data"."master_product_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "product" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for nafmii_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."nafmii_history";
CREATE TABLE "history_data"."nafmii_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "nafmii" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for option_confirmation_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."option_confirmation_history";
CREATE TABLE "history_data"."option_confirmation_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "report" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for option_termination_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."option_termination_history";
CREATE TABLE "history_data"."option_termination_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "report" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for other_report_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."other_report_history";
CREATE TABLE "history_data"."other_report_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "report" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for performance_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."performance_history";
CREATE TABLE "history_data"."performance_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "performance" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for quarter_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."quarter_history";
CREATE TABLE "history_data"."quarter_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "quarter" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for sac_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."sac_history";
CREATE TABLE "history_data"."sac_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "sac" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for sup_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."sup_history";
CREATE TABLE "history_data"."sup_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "sup" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for swap_confirmation_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."swap_confirmation_history";
CREATE TABLE "history_data"."swap_confirmation_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "swapconfirm" jsonb NOT NULL
)
;

-- ----------------------------
-- Table structure for swap_termination_history
-- ----------------------------
DROP TABLE IF EXISTS "history_data"."swap_termination_history";
CREATE TABLE "history_data"."swap_termination_history" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "update_time" timestamp(6),
  "biz_id" varchar(255) COLLATE "pg_catalog"."default",
  "swap" jsonb NOT NULL
)
;

-- ----------------------------
-- Primary Key structure for table contract_history
-- ----------------------------
ALTER TABLE "history_data"."contract_history" ADD CONSTRAINT "contract_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table event_report_history
-- ----------------------------
ALTER TABLE "history_data"."event_report_history" ADD CONSTRAINT "event_report_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table isda_history
-- ----------------------------
ALTER TABLE "history_data"."isda_history" ADD CONSTRAINT "isda_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table master_history
-- ----------------------------
ALTER TABLE "history_data"."master_history" ADD CONSTRAINT "master_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table master_product_history
-- ----------------------------
ALTER TABLE "history_data"."master_product_history" ADD CONSTRAINT "master_product_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table nafmii_history
-- ----------------------------
ALTER TABLE "history_data"."nafmii_history" ADD CONSTRAINT "nafmii_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table option_confirmation_history
-- ----------------------------
ALTER TABLE "history_data"."option_confirmation_history" ADD CONSTRAINT "option_confirmation_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table option_termination_history
-- ----------------------------
ALTER TABLE "history_data"."option_termination_history" ADD CONSTRAINT "option_termination_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table other_report_history
-- ----------------------------
ALTER TABLE "history_data"."other_report_history" ADD CONSTRAINT "other_report_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table performance_history
-- ----------------------------
ALTER TABLE "history_data"."performance_history" ADD CONSTRAINT "performance_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table quarter_history
-- ----------------------------
ALTER TABLE "history_data"."quarter_history" ADD CONSTRAINT "quarter_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sac_history
-- ----------------------------
ALTER TABLE "history_data"."sac_history" ADD CONSTRAINT "sac_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table sup_history
-- ----------------------------
ALTER TABLE "history_data"."sup_history" ADD CONSTRAINT "sup_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table swap_confirmation_history
-- ----------------------------
ALTER TABLE "history_data"."swap_confirmation_history" ADD CONSTRAINT "swap_confirmation_history_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table swap_termination_history
-- ----------------------------
ALTER TABLE "history_data"."swap_termination_history" ADD CONSTRAINT "swap_termination_history_pkey" PRIMARY KEY ("id");
