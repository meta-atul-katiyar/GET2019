

// query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.

SELECT Z.ID, Z.zip, C.cityName, S.stateName FROM (((zips AS Z NATURAL JOIN zipCity AS ZC) LEFT OUTER JOIN cities as C ON ZC.cityId = C.ID)
LEFT OUTER JOIN 
(cityState AS CS LEFT OUTER JOIN states AS S ON CS.stateId = S.ID)  ON CS.CityId = ZC.cityId)
ORDER BY S.stateName, C.cityName