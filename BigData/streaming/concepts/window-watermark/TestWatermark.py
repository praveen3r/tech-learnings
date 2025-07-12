from pyspark.sql.types import StructType, StructField, StringType, TimestampType
from pyspark.sql import SparkSession
from pyspark.sql.functions import window


spark = SparkSession.builder.appName("WindowWithWatermark").config("spark.sql.shuffle.partitions", "4").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

input_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\json_input"
output_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\csv_output"
checkpoint_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\checkpoint"

schema = StructType([
    StructField("user", StringType()),
    StructField("action", StringType()),
    StructField("event_time", TimestampType())  #
])

df = spark.readStream.schema(schema).format("json").load(input_dir)

aggregated = df.withWatermark("event_time", "10 minutes") \
    .groupBy(
        window("event_time", "5 minutes"),
        "action"
    ).count()

query = aggregated.writeStream \
    .outputMode("append") \
    .option("checkpointLocation", checkpoint_dir) \
    .format("console") \
    .start()

query.awaitTermination()

--------------------------------------------------------------------------------

# Sliding Time Windows

from pyspark.sql.types import StructType, StructField, StringType, TimestampType
from pyspark.sql import SparkSession
from pyspark.sql.functions import window


spark = SparkSession.builder.appName("WindowWithWatermark").config("spark.sql.shuffle.partitions", "4").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

input_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\json_input"
output_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\csv_output"
checkpoint_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\checkpoint"

schema = StructType([
    StructField("user", StringType()),
    StructField("action", StringType()),
    StructField("event_time", TimestampType())  #
])

df = spark.readStream.schema(schema).format("json").load(input_dir)

aggregated = df.withWatermark("event_time", "10 minutes") \
    .groupBy(
       window("event_time", "10 minutes", "5 minutes")
        "action"
    ).count()

query = aggregated.writeStream \
    .outputMode("append") \
    .option("checkpointLocation", checkpoint_dir) \
    .format("console") \
    .start()

query.awaitTermination()

--------------------------------------------------------------------------------

# Session Windows (Spark 3.2+)

from pyspark.sql.types import StructType, StructField, StringType, TimestampType
from pyspark.sql import SparkSession
from pyspark.sql.functions import window
from pyspark.sql.functions import session_window


spark = SparkSession.builder.appName("WindowWithWatermark").config("spark.sql.shuffle.partitions", "4").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

input_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\json_input"
output_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\csv_output"
checkpoint_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\checkpoint"

schema = StructType([
    StructField("user", StringType()),
    StructField("action", StringType()),
    StructField("event_time", TimestampType())  #
])

df = spark.readStream.schema(schema).format("json").load(input_dir)

aggregated = df.groupBy(session_window("event_time", "15 minutes")).count()

query = aggregated.writeStream \
    .outputMode("append") \
    .option("checkpointLocation", checkpoint_dir) \
    .format("console") \
    .start()

query.awaitTermination()

--------------------------------------------------------------------------------------------------

# Cumulative (Running) Windows


# Not built-in in streaming, but possible using foreachBatch and storing state.

# Example in batch mode:


from pyspark.sql.functions import sum
w = Window.partitionBy("user").orderBy("event_time").rowsBetween(Window.unboundedPreceding, 0)
df.withColumn("running_total", sum("amount").over(w))




