from pyspark.sql import SparkSession
from pyspark.sql.functions import split, explode

spark = SparkSession.builder.appName("UpdateMode").getOrCreate()
spark.sparkContext.setLogLevel("ERROR")

lines = spark.readStream.format("text").load(r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data")
words = lines.select(explode(split(lines.value, " ")).alias("word"))
word_counts = words.groupBy("word").count()

query = word_counts.writeStream.outputMode("update").format("console").start()
query.awaitTermination()
