from pyspark.sql import SparkSession

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

data = [(1, 'Sachin Ramesh Tendulkar'), (2, 'Rahul Dravid'), (3, 'Saurav Ganguly')]
schema = ['id', 'name']
df = spark.createDataFrame(data,schema )

df.show(n=4,truncate=False,vertical=False)

df.show(n=4,truncate=False,vertical=True)
