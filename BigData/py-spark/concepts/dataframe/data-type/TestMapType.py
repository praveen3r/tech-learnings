from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, MapType, StringType, IntegerType
from pyspark.sql.functions import col

# Create Spark session
spark = SparkSession.builder.appName("MapType").getOrCreate()

data = [(1, {"Sachin": 100, "Dravid": 85}),
    (2, {"Shewag": 92, "Ganguly": 82}),
    (3, {"Yuvraj": 99, "Kohli": 96})]

schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("scores", MapType(StringType(), IntegerType()), True)
])

df = spark.createDataFrame(data, schema)

df.show(truncate=False)
df.printSchema()

----------------------------------------------------------------------------------------------

# access specific properties

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, MapType, StringType, IntegerType
from pyspark.sql.functions import col

# Create Spark session
spark = SparkSession.builder.appName("MapType").getOrCreate()

data = [(1, {"Sachin": 100, "Dravid": 85}),
    (2, {"Sachin": 92, "Dravid": 82}),
    (3, {"Sachin": 99, "Dravid": 96})]

schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("scores", MapType(StringType(), IntegerType()), True)
])

df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.withColumn("Sachin_score", col("scores")["Sachin"])

df1.show()

-----------------------------------------------------------------------------------------

#explode

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, MapType, StringType, IntegerType
from pyspark.sql.functions import col, explode

# Create Spark session
spark = SparkSession.builder.appName("MapType").getOrCreate()

data = [(1, {"Sachin": 100, "Dravid": 85}),
    (2, {"Sachin": 92, "Dravid": 82}),
    (3, {"Sachin": 99, "Dravid": 96})]

schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("scores", MapType(StringType(), IntegerType()), True)
])

df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.select("id", explode("scores").alias("player", "score"))

df1.show()

------------------------------------------------------------------------------------

# map keys and map values
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, MapType, StringType, IntegerType
from pyspark.sql.functions import col, map_keys, map_values

# Create Spark session
spark = SparkSession.builder.appName("MapType").getOrCreate()

data = [
    (1, {"Sachin": 100, "Dravid": 85}),
    (2, {"Sachin": 92, "Dravid": 82}),
    (3, {"Sachin": 99, "Dravid": 96})
]

schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("scores", MapType(StringType(), IntegerType()), True)
])

df = spark.createDataFrame(data, schema)
df.show(truncate=False)

df1 = df.withColumn("players", map_keys(col("scores")))
df1.show(truncate=False)

df2 = df.withColumn("players", map_values(col("scores")))
df2.show(truncate=False)

