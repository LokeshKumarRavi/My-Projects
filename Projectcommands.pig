
pig -x local

projectjson = load '/home/lokesh/Documents/A-Final Project/Census Data/sample.dat' using JsonLoader('Age:INT, Education:chararray, MaritalStatus:chararray, Gender:chararray, TaxFilerStatus:chararray, Income:DOUBLE, Parents:chararray, CountryOfBirth:chararray, Citizenship:chararray, WeeksWorked:INT');

dump projectjson;


pig 

projectjson = load '/home/lokesh/Documents/A-Final Project/Census Data/sample.dat' using JsonLoader('Age:INT, Education:chararray, MaritalStatus:chararray, Gender:chararray, TaxFilerStatus:chararray, Income:DOUBLE, Parents:chararray, CountryOfBirth:chararray, Citizenship:chararray, WeeksWorked:INT');

dump projectjson;

store projectjson into '/home/lokesh/Documents/A-Final Project/sample.dat' using PigStorage (',');



Hive

create database project;

use project;

add jar /usr/local/hive/hcatalog/share/hcatalog/hive-hcatalog-core-1.2.1.jar;

create external table census (Age int, Education string, MaritalStatus string, Gender string, TaxFilerStatus string, Income double, Parents string, CountryofBirth string, Citizenship string, WeeksWorked int) row format serde 'org.apache.hive.hcatalog.data.JsonSerDe';

desc census;

hive> load data local inpath '/home/magesh/Documents/Mainproject/sample.dat' overwrite into table census;

select * from census;

select count(*) from census;

