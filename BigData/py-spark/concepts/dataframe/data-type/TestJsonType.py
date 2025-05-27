from pyspark.sql import SparkSession
from pyspark.sql.functions import from_json, col
from pyspark.sql.types import StructType, StructField, StringType, IntegerType,MapType

spark = SparkSession.builder.appName("TestJson").getOrCreate()

data = [(1, '{"name":"Sachin","runs":1000}'),
        (2, '{"name":"Rahul","runs":850}')]

schema = ["id", "data"]

df = spark.createDataFrame(data, schema)

df.show(truncate=False)

schema1 = MapType(StringType(), StringType())

df1 = df.withColumn("new_data", from_json(col("data"), schema1))

df1.show(truncate=False)
df1.printSchema()

df2 = df1.select("id", col("new_data")["name"].alias("name"), col("new_data")["runs"].alias("runs"))
df2.show()

-------------------------------------------------------------------------------------------------

# convert to structtype

from pyspark.sql import SparkSession
from pyspark.sql.functions import from_json, col
from pyspark.sql.types import StructType, StructField, StringType, IntegerType,MapType

spark = SparkSession.builder.appName("TestJson").getOrCreate()

data = [(1, '{"name":"Sachin","runs":1000}'),
        (2, '{"name":"Rahul","runs":850}')]

schema = ["id", "data"]

df = spark.createDataFrame(data, schema)

df.show(truncate=False)

schema1 = StructType([
    StructField("name", StringType(), True),
    StructField("runs", IntegerType(), True)
])

df1 = df.withColumn("new_data", from_json(col("data"), schema1))

df1.show(truncate=False)
df1.printSchema()

df2 = df1.select(
    "id",
    col("new_data.name").alias("name"),
    col("new_data.runs").alias("runs")
)
df2.show()

-------------------------------------------------------------------------------------------------

# convert to json

from pyspark.sql import SparkSession
from pyspark.sql.functions import to_json, col, struct
from pyspark.sql.types import StructType, StructField, StringType, IntegerType,MapType

spark = SparkSession.builder.appName("TestJson").getOrCreate()

data = [
    (1, "Sachin", 1000),
    (2, "Rahul", 850)
]

schema = ["id", "name", "runs"]

df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.withColumn("data", struct("name", "runs"))

df2 = df1.withColumn("json_data", to_json(col("data")))

df2.select("id", "json_data").show(truncate=False)

------------------------------------------------------------------------------------------------

# json_tuple

from pyspark.sql import SparkSession
from pyspark.sql.functions import to_json, col, struct,json_tuple
from pyspark.sql.types import StructType, StructField, StringType, IntegerType,MapType

spark = SparkSession.builder.appName("TestJson").getOrCreate()

data = [
    (1, '{"name":"Sachin","runs":"1000"}'),
    (2, '{"name":"Rahul","runs":"850"}')
]

schema = ["id", "json_data"]

df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.select("id", json_tuple("json_data", "name", "runs").alias("name", "runs"))

df1.show()

------------------------------------------------------------------------------------------------

# get_json_object

from pyspark.sql import SparkSession
from pyspark.sql.functions import to_json, col, struct,json_tuple, get_json_object
from pyspark.sql.types import StructType, StructField, StringType, IntegerType,MapType

spark = SparkSession.builder.appName("TestJson").getOrCreate()

data = [
    (1, '{"name":"Sachin","runs":1000, "team":{"country":"India"}}'),
    (2, '{"name":"Rahul","runs":850, "team":{"country":"India"}}')
]
schema = ["id", "json_data"]

# Create DataFrame
df = spark.createDataFrame(data, schema)

df1 = df.select(
    "id",
    get_json_object("json_data", "$.name").alias("name"),
    get_json_object("json_data", "$.runs").alias("runs"),
    get_json_object("json_data", "$.team.country").alias("country")
)

df1.show()
