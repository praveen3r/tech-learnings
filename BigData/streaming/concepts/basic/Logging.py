import logging
import time
from pyspark.sql.types import StructType, StructField, StringType, TimestampType
from pyspark.sql import SparkSession
from pyspark.sql.functions import window
from threading import Thread

import os

# Create log directory if it doesn't exist
log_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\log"
os.makedirs(log_dir, exist_ok=True)

# Set up logging to file
log_file = os.path.join(log_dir, "spark_streaming_app.log")
logger = logging.getLogger("spark_streaming_app")
logger.setLevel(logging.DEBUG)

# Avoid duplicate logs if logger already has handlers
if not logger.hasHandlers():
    file_handler = logging.FileHandler(log_file)
    formatter = logging.Formatter('%(asctime)s - %(levelname)s - %(message)s')
    file_handler.setFormatter(formatter)
    logger.addHandler(file_handler)

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
    logger.info("Received shutdown signal. Stopping stream...")
    query.stop()
    logger.info("Streaming stopped cleanly.")
    
Thread(target=simulate_shutdown).start()

logger.info("Streaming started. Waiting for data...")
query.awaitTermination()