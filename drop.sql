ALTER TABLE BUS DROP FOREIGN KEY FK_BUS_DRIVER_ID
ALTER TABLE TRAIN DROP FOREIGN KEY FK_TRAIN_DRIVER_ID
ALTER TABLE PASSENGER DROP FOREIGN KEY FK_PASSENGER_VENTRA_ID
ALTER TABLE PASSENGER DROP FOREIGN KEY FK_PASSENGER_BUS_ID
ALTER TABLE PASSENGER DROP FOREIGN KEY FK_PASSENGER_TRAIN_ID
ALTER TABLE bus_stations DROP FOREIGN KEY FK_bus_stations_station_id
ALTER TABLE bus_stations DROP FOREIGN KEY FK_bus_stations_bus_id
ALTER TABLE train_stations DROP FOREIGN KEY FK_train_stations_train_id
ALTER TABLE train_stations DROP FOREIGN KEY FK_train_stations_station_id
DROP TABLE BUS
DROP TABLE TRAIN
DROP TABLE VENTRA
DROP TABLE STATION
DROP TABLE DRIVER
DROP TABLE PASSENGER
DROP TABLE bus_stations
DROP TABLE train_stations
