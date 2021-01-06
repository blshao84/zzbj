#!/bin/bash
sleep 5
cat base_element.sql | psql -U trans
sleep 5
cat report_base_config.sql | psql -U trans
sleep 5
cat structure.sql | psql -U trans