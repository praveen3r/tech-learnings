from pyspark.sql import SparkSession

# Start Spark session
spark = SparkSession.builder.appName("Test").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

input_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\json_input"
output_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\csv_output"
checkpoint_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\checkpoint"

# Read streaming JSON data
df = spark.readStream.format("json").load(input_dir)

# Write to CSV (correct chaining, no extra .format!)
query = df.writeStream \
    .outputMode("append") \
    .format("csv") \
    .option("path", output_dir) \
    .option("checkpointLocation", checkpoint_dir) \
    .start()

query.awaitTermination()
