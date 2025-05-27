from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestJSON").getOrCreate()

data =  [{"name": "Sachin","age": 53},{"name": "Dravid","age": 51} ]

df = spark.createDataFrame(data)

df.write.mode("overwrite").json(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\tmp')

------------------------------------------------------------------------------------------------------------------------------------------------

#multiline also acccept

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestJSON").getOrCreate()

data =  [
         {"name": "Sachin","age": 53},
         {"name": "Dravid","age": 51},
          {"name": "Saurav","age": 55} ]

df = spark.createDataFrame(data)

df.write.mode("overwrite").json(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\tmp')

------------------------------------------------------------------------------------------------------------------------------------------------

#With schema

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestJSON").getOrCreate()

data =  [
         {"name": "Sachin","age": 53},
         {"name": "Dravid","age": 51},
          {"name": "Saurav","age": 55} ]

schema = StructType([
    StructField("name", StringType(), True),
    StructField("age", IntegerType(), True)
])

df = spark.createDataFrame(data, schema=schema)

df.write.mode("overwrite").json(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\tmp')
