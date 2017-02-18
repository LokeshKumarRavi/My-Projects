
pig -x local

projectjson = load '/home/lokesh/Documents/A-Final Project/Census Data/sample.dat' using JsonLoader('Age:INT, Education:chararray, MaritalStatus:chararray, Gender:chararray, TaxFilerStatus:chararray, Income:DOUBLE, Parents:chararray, CountryOfBirth:chararray, Citizenship:chararray, WeeksWorked:INT');

1.Educational wise grouping:

gn = group projectjson by Gender;

gen = foreach gn generate group, COUNT(projectjson.Gender);

ed = group projectjson by Education;

edu = foreach ed generate group, COUNT(projectjson.Gender);

Output:

( Children,452)
( 9th grade,56)
( 10th grade,81)
( 11th grade,68)
( 5th or 6th grade,21)
( 7th and 8th grade,81)
( Less than 1st grade,14)
( High school graduate,483)
( 12th grade no diploma,18)
( 1st 2nd 3rd or 4th grade,16)
( Doctorate degree(PhD EdD),15)
( Bachelors degree(BA AB BS),206)
( Some college but no degree,295)
( Associates degree-academic program,50)
( Associates degree-occup /vocational,56)
( Masters degree(MA MS MEng MEd MSW MBA),68)
( Prof school degree (MD DDS DVM LLB JD),20)


!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


How many immigration people done by education in us.
----------------------------------------------------

projectjson = load '/home/lokesh/Documents/A-Final Project/Census Data/sample.dat' using JsonLoader('Age:INT, Education:chararray, MaritalStatus:chararray, Gender:chararray, TaxFilerStatus:chararray, Income:DOUBLE, Parents:chararray, CountryOfBirth:chararray, Citizenship:chararray, WeeksWorked:INT');


                                                                                                                                                                         
 counted = filter projectjson by Education == ' Children';


 countryof  = group counted by Citizenship;                                
 
 dump countryof;

 coun  = foreach  countryof  generate group, COUNT(counted.CountryOfBirth);

 dump coun;


Input(s):
Successfully read 2000 records from: "/home/lokesh/Documents/A-Final Project/Census Data/sample.dat"

Output(s):
Successfully stored 5 records in: "file:/tmp/temp-867412661/tmp-1404589122"

Counters:
Total records written : 5
Total bytes written : 0
Spillable Memory Manager spill count : 0
Total bags proactively spilled: 0
Total records proactively spilled: 0

Job DAG:
job_local1374845347_0002


2017-02-14 19:56:42,308 [main] INFO  org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.MapReduceLauncher - Success!
2017-02-14 19:56:42,309 [main] INFO  org.apache.hadoop.conf.Configuration.deprecation - io.bytes.per.checksum is deprecated. Instead, use dfs.bytes-per-checksum
2017-02-14 19:56:42,310 [main] INFO  org.apache.hadoop.conf.Configuration.deprecation - fs.default.name is deprecated. Instead, use fs.defaultFS
2017-02-14 19:56:42,310 [main] INFO  org.apache.hadoop.conf.Configuration.deprecation - mapred.job.tracker is deprecated. Instead, use mapreduce.jobtracker.address
2017-02-14 19:56:42,310 [main] WARN  org.apache.pig.data.SchemaTupleBackend - SchemaTupleBackend has already been initialized
2017-02-14 19:56:42,392 [main] INFO  org.apache.hadoop.mapreduce.lib.input.FileInputFormat - Total input paths to process : 1
2017-02-14 19:56:42,392 [main] INFO  org.apache.pig.backend.hadoop.executionengine.util.MapRedUtil - Total input paths to process : 1
( Native- Born in the United States,1769)
( Foreign born- Not a citizen of U S ,135)
( Native- Born abroad of American Parent(s),20)
( Foreign born- U S citizen by naturalization,64)
( Native- Born in Puerto Rico or U S Outlying,12)
grunt> 



