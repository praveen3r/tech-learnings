from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestJSON").getOrCreate()

df_spark = spark.read.json(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\Test.json')

df_spark.printSchema()
df_spark.show()

----------------------------------------------------------------------------------------------------------------------------------------------
# multiple JSON objects in a file

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestJSON").getOrCreate()

df_spark = spark.read.json(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\TestMultiObject.json')

df_spark.printSchema()
df_spark.show()

----------------------------------------------------------------------------------------------------------------------------------------------
# multiline array of JSON objects in a file

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestJSON").getOrCreate()

df_spark = spark.read.json(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\TestMultiLine.json', multiLine=True)

df_spark.printSchema()
df_spark.show()

----------------------------------------------------------------------------------------------------------------------------------------------
# Reading from path all json
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestJSON").getOrCreate()

df_spark = spark.read.json(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\*.json', multiLine=True)

df_spark.printSchema()
df_spark.show()

----------------------------------------------------------------------------------------------------------------------------------------------
# with Schema
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestJSON").getOrCreate()

# Define the schema
schema = StructType([
    StructField("name", StringType(), True),
    StructField("age", IntegerType(), True)
])

df_spark = spark.read.json(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\*.json', multiLine=True, schema=schema)

df_spark.printSchema()
df_spark.show()