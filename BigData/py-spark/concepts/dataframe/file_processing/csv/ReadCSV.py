from pyspark.sql import SparkSession

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

#type(spark)

df_spark = spark.read.option('header','true').csv('C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\Test.csv')

#type(df_spark)

df_spark.show()

------------------------------------------------------------------------------------------------------------------------------------------------

from pyspark.sql import SparkSession

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

df_spark = spark.read.option('header','true').format('csv').load('C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\Test.csv')

df_spark.show()

------------------------------------------------------------------------------------------------------------------------------------------------

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

# Define the schema
schema = StructType([
    StructField("name", StringType(), True),
    StructField("age", IntegerType(), True)
])

df_spark = spark.read.csv(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\Test.csv', header=True, schema=schema)

df_spark.show()
