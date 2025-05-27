from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestParquet").getOrCreate()

data = [(1, 'Sachin'), (2, 'Dravid')]

# Define a StructType schema
schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("name", StringType(), True)
])

df = spark.createDataFrame(data,schema= schema)

df.write.mode("overwrite").parquet(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\tmp')

------------------------------------------------------------------------------------------------------------------------------------------------

