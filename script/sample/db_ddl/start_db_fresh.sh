#!/bin/bash
cat create_trans.sql | psql -U postgres
sleep 5
cat trans-schemas.sql | psql -U trans
sleep 5
cat commerce_model.sql | psql -U trans
sleep 5
cat data_source.sql | psql -U trans
sleep 5
cat history_data.sql | psql -U trans
