from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

data = [(1, 'Sachin'), (2, 'Dravid')]

# Define a StructType schema
schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("name", StringType(), True)
])

df = spark.createDataFrame(data,schema= schema)

df_spark = df.write.option('header','true').csv('C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\tmp')

#type(df_spark)
------------------------------------------------------------------------------------------------------------------------------------------------

#with mode

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

data = [(1, 'Sachin'), (2, 'Dravid')]

# Define a StructType schema
schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("name", StringType(), True)
])

df = spark.createDataFrame(data,schema= schema)

df.write.mode("overwrite").option('header','true').csv(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\tmp')

#type(df_spark)