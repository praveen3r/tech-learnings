from pyspark.sql import SparkSession
from pyspark.sql.functions import lit

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

#type(spark)

df_spark = spark.read.option('header','true').csv('C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\Test1.csv',inferSchema=True)

#drop null values in any column in any row
df_spark.na.drop().show();

#how = any or all
df_spark.na.drop(how='any').show();

#Threshold = 2, atleast 2 non null values should be present
df_spark.na.drop(how='any', thresh=2).show();

#remove any row that has any null value in salary column
df_spark.na.drop(how='any',subset=['Salary']).show()

#fill the missing values
#value has to be column compatible
df_spark.na.fill(999).show()

#Specific column
df_spark.na.fill(999,'Salary').show()

#Multiple column
df_spark.na.fill(999,['Salary','Experience']).show()