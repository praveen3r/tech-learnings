from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType,TimestampType,DoubleType

# Initialize Spark session
spark = SparkSession.builder.appName("TestParquest").getOrCreate()

schema = StructType([
    StructField("registration_dttm", TimestampType(), True),
    StructField("id", IntegerType(), True),
    StructField("first_name", StringType(), True),
    StructField("last_name", StringType(), True),
    StructField("email", StringType(), True),
    StructField("gender", StringType(), True),
    StructField("ip_address", StringType(), True),
    StructField("cc", StringType(), True),
    StructField("country", StringType(), True),
    StructField("birthdate", StringType(), True),
    StructField("salary", DoubleType(), True),
    StructField("title", StringType(), True),
    StructField("comments", StringType(), True)
])

df = spark.read.schema(schema).parquet(path='C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\userData1.parquet')

# df = spark.read.format('parquet').options(header=True,inferSchema=True).load('C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\userData1.parquet')
# Print the schema
df.printSchema()

# Show a few rows
df.show(5, truncate=False)

# Print the row count
print("Row count:", df.count())

----------------------------------------------------------------------------------------------------------------------------------------------
