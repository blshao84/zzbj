#!/bin/bash
pm2 delete all
docker stop bct-postgresql
sleep 5
docker run --rm --name bct-postgresql -e POSTGRES_USER=trans -e POSTGRES_PASSWORD=kEaLJ9ZERLLN -e POSTGRES_DB=trans -p 5432:5432 -d postgres:9-alpine -c max_connections=300
sleep 5
cd ./db_ddl
cat trans-schemas.sql | docker exec -i bct-postgresql psql -U trans
sleep 5
cat commerce_model.sql | docker exec -i bct-postgresql psql -U trans
sleep 5
cat data_source.sql | docker exec -i bct-postgresql psql -U trans
sleep 5
cat history_data.sql | docker exec -i bct-postgresql psql -U trans
cd ../db_dml
sleep 5
cat base_element.sql | docker exec -i bct-postgresql psql -U trans
sleep 5
cat report_base_config.sql | docker exec -i bct-postgresql psql -U trans
sleep 5
cat structure.sql | docker exec -i bct-postgresql psql -U trans
sleep 5
cd ..
pwd
pm2 start trans.config.js
