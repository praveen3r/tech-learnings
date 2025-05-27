from pyspark.sql import SparkSession
from pyspark.sql.functions import col

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

#type(spark)

df_spark = spark.read.option('header','true').csv('C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\Test1.csv',inferSchema=True)

#find salary less than or equal to 500000
df_spark.filter("Salary<=500000").show()

#find salary less than or equal to 500000 and show name and age
df_spark.filter("Salary<=500000").select('Name','Age').show()

#multiple cdtn
df_spark.filter("(Salary<=500000) AND (Age<=50)").select('Name','Age').show()

# or 
# 
# using col

df_spark.filter((col("Salary") <= 500000) & (col("Age") <= 50)).select("Name", "Age").show()

#Inverse operation (not operator)
df_spark.filter("NOT (Salary <= 500000)").select('Name', 'Age').show()

#or

df_spark.filter(~(col("Salary") <= 500000)).select("Name", "Age").show()
