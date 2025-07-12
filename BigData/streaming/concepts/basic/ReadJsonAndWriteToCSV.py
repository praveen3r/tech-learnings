from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType

schema = StructType([
    StructField("name", StringType()),
    StructField("age", IntegerType())
])

# Start Spark session
spark = SparkSession.builder.appName("Test").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

input_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\json_input"
output_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\csv_output"
checkpoint_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\checkpoint"

# Read streaming JSON data
df = spark.readStream.schema(schema).format("json").load(input_dir)

# Write to CSV (correct chaining, no extra .format!)
query = df.writeStream \
    .outputMode("append") \
    .format("csv") \
    .option("path", output_dir) \
    .option("checkpointLocation", checkpoint_dir) \
    .start()

query.awaitTermination()

------------------------------------------------------------------------------------

# Flattening Nested JSON

# input json 

{"id": 1, "name": {"first": "Alice", "last": "Wong"}, "age": 25}
{"id": 2, "name": {"first": "Bob", "last": "Singh"}, "age": 30}

# code

from pyspark.sql import SparkSession
from pyspark.sql.functions import col

spark = SparkSession.builder.appName("FlattenNestedJSON").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

input_dir = r"C:\spark-stream-test\nested_json_input"
output_dir = r"C:\spark-stream-test\nested_csv_output"
checkpoint_dir = r"C:\spark-stream-test\nested_checkpoint"

# Read JSON input
df = spark.readStream.format("json").load(input_dir)

# Flatten nested fields
flat_df = df.select(
    col("id"),
    col("name.first").alias("first_name"),
    col("name.last").alias("last_name"),
    col("age")
)

# Write to CSV
query = flat_df.writeStream \
    .format("csv") \
    .option("path", output_dir) \
    .option("checkpointLocation", checkpoint_dir) \
    .outputMode("append") \
    .start()

query.awaitTermination()

---------------------------------------------------------------------------------------


# Combine All CSVs into One (Post-Processing)

import pandas as pd
import glob

# Path to Spark output CSVs
csv_files = glob.glob(r"C:\spark-stream-test\nested_csv_output\*.csv")

# Combine them
combined = pd.concat((pd.read_csv(f) for f in csv_files), ignore_index=True)

# Save as a single file
combined.to_csv(r"C:\spark-stream-test\final_output.csv", index=False)

---------------------------------------------------------------------------------------


# malformed JSON records into a "bad records" folder 

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType

# Define expected schema
schema = StructType([
    StructField("id", IntegerType()),
    StructField("name", StringType()),
    StructField("age", IntegerType())
])

# Start Spark session
spark = SparkSession.builder.appName("TestWithBadRecords").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

# Paths
input_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\json_input"
output_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\csv_output"
checkpoint_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\checkpoint"
bad_records_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\bad_records"

# Read streaming JSON with bad record capture
df = spark.readStream \
    .schema(schema) \
    .option("badRecordsPath", bad_records_dir) \
    .format("json") \
    .load(input_dir)

# Write to CSV
query = df.writeStream \
    .outputMode("append") \
    .format("csv") \
    .option("path", output_dir) \
    .option("checkpointLocation", checkpoint_dir) \
    .start()

query.awaitTermination()

------------------------------------------------------------------------------------------------------

# Archive Processed Files

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType

schema = StructType([
    StructField("id", IntegerType()),
    StructField("name", StringType()),
    StructField("age", IntegerType())
])

spark = SparkSession.builder.appName("StreamingWithCleanSource").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

input_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\json_input"
output_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\csv_output"
checkpoint_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\checkpoint"
archive_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\json_archive"

# Read streaming data with cleanSource=archive
df = spark.readStream \
    .schema(schema) \
    .format("json") \
    .option("cleanSource", "archive") \
    .option("sourceArchiveDir", archive_dir) \
    .load(input_dir)

# Write to CSV
query = df.writeStream \
    .outputMode("append") \
    .format("csv") \
    .option("path", output_dir) \
    .option("checkpointLocation", checkpoint_dir) \
    .start()

query.awaitTermination()

------------------------------------------------------------------------------------------------------

# write to multiple sink

# One source
df = spark.readStream.schema(schema).format("json").load(input_dir)

# Sink 1: Write to CSV
csv_query = df.writeStream \
    .outputMode("append") \
    .format("csv") \
    .option("path", output_dir) \
    .option("checkpointLocation", checkpoint_dir + "/csv") \
    .start()

# Sink 2: Write to console
console_query = df.writeStream \
    .outputMode("append") \
    .format("console") \
    .option("truncate", False) \
    .start()

# Await both
csv_query.awaitTermination()
console_query.awaitTermination()

------------------------------------------------------------------------------

# Debug Streaming Behavior

def debug_batch(df, batch_id):
    print(f"=== Batch {batch_id} ===")
    df.show()

df.writeStream.foreachBatch(debug_batch).start()

------------------------------------------------------------------------------

# Debug Streaming Behavior



