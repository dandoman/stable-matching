export PGPASSWORD=dev
psql -U dev -d dev -h localhost -f ./src/main/resources/db/nuke.db
psql -U dev -d dev -h localhost -f ./src/main/resources/db/create-tables.db