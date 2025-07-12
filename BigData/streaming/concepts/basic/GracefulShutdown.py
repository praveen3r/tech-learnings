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

# Graceful shutdown logic
def shutdown_handler(signum, frame):
    print("\n⚠️ Caught termination signal. Stopping query gracefully...")
    query.stop()
    print("✅ Streaming query stopped.")
    sys.exit(0)

# Register signal handlers
signal.signal(signal.SIGINT, shutdown_handler)   # Ctrl+C
signal.signal(signal.SIGTERM, shutdown_handler)  # kill command

print("ℹ️ Streaming started. Press Ctrl+C to stop.")
query.awaitTermination()

-----------------------------------------------------------------------------------------------------------

# simulate in jupyter notebook

import time
from pyspark.sql.types import StructType, StructField, StringType, TimestampType
from pyspark.sql import SparkSession
from pyspark.sql.functions import window
from threading import Thread


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

# Simulate shutdown after 10 seconds using a thread
def simulate_shutdown():
    time.sleep(10)
    print("🛑 Simulating graceful shutdown...")
    query.stop()

Thread(target=simulate_shutdown).start()

print("ℹ️ Streaming started. Press Ctrl+C to stop.")
query.awaitTermination()