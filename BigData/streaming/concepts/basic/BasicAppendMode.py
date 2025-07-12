from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("AppendMode").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

# Read new lines from text files
lines = spark.readStream.format("text").load("path_to_dir")

# Just show new lines
query = lines.writeStream \
    .format("console") \
    .outputMode("append") \
    .start()

query.awaitTermination()
