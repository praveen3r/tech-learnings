from pyspark.sql import SparkSession

# Initialize Spark session
spark = SparkSession.builder.appName("HelloWorld").getOrCreate()

# Create a simple DataFrame
data = [("Hello, World!",)]
df = spark.createDataFrame(data, ["Message"])

# Show DataFrame content
df.show()

# Stop Spark session
spark.stop()