from pyspark.sql import SparkSession

# Create SparkSession
spark = SparkSession.builder \
    .appName("StreamingHelloWorld") \
    .getOrCreate()

# Set log level to reduce console noise
spark.sparkContext.setLogLevel("ERROR")

# Read streaming data from a directory
# You can simulate a stream by copying new .txt files into this folder
stream_df = spark.readStream \
    .format("text") \
    .load(r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data")

# Simply print the incoming lines
query = stream_df.writeStream \
    .outputMode("append") \
    .format("console") \
    .start()

# Wait for the termination
query.awaitTermination()