#!/bin/bash
set -e

# This script is used to drop and recreate the meta-data tables

sudo docker exec -it postgres psql -f /mnt/schema-drop-postgresql.sql -U egor -d fusiondb
sudo docker exec -it postgres psql -f /mnt/schema-postgresql.sql -U egor -d fusiondb
