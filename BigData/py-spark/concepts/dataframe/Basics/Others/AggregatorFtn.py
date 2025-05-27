from pyspark.sql import SparkSession
from pyspark.sql.functions import sum,col,max,min

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

#type(spark)

df_spark = spark.read.option('header','true').csv('C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\Test2.csv',inferSchema=True)

# total salary for each name
df_spark.groupBy("Name").agg(sum("Salary").alias("Total_Salary")).show()

# count of rows for name
df_spark.groupBy("Name").count().show()

# sum of all salaries
df_spark.select(sum("Salary").alias("Total_Salary")).show()

# Max salary for each name
df_spark.groupBy("Name").agg(max("Salary").alias("Total_Salary")).show()

# Min salary for each name
df_spark.groupBy("Name").agg(min("Salary").alias("Total_Salary")).show()