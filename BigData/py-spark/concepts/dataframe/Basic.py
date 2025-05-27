from pyspark.sql import SparkSession

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

spark.createDataFrame([('Alice', 1)]).show()

--------------------------------------------------------------------------------------

from pyspark.sql import SparkSession

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

data = [{'name': 'Alice', 'age': 1}]

spark.createDataFrame(data).show()

--------------------------------------------------------------------------------------

from pyspark.sql import SparkSession

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

data = [(1, 'Sachin'), (2, 'Dravid')]

df.show()

--------------------------------------------------------------------------------------

# list all methods
dir(spark)

# docs
help(spark.createDataFrame)

--------------------------------------------------------------------------------------

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

data = [(1, 'Sachin'), (2, 'Dravid')]

    StructField("id", IntegerType(), True),
    StructField("name", StringType(), True)
])


df.show()

--------------------------------------------------------------------------------------

#nested struct type

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestNested") \
    .getOrCreate()

schema =  StructType([
    StructField("id", IntegerType(), True),
    StructField("name", StructType([
        StructField("first", StringType(), True),
        StructField("last", StringType(), True)
    ]), True),
    StructField("salary", FloatType(), True)
])

data = [
    (1, {"first": "Sachin", "last": "Tendulkar"}, 55000.0),
    (2, {"first": "Rahul", "last": "Dravid"}, 62000.0),
    (3, {"first": "Saurav", "last": "Ganguly"}, 70000.0)
]


# or

data = [
    (1, ("Sachin","Tendulkar"), 55000.0),
    (2, ("Rahul","Dravid"), 62000.0),
    (3, ("Saurav","Ganguly"), 70000.0)
]

df = spark.createDataFrame(data, schema)

df.show(truncate=False)

display(df)

df.printSchema()

--------------------------------------------------------------------------------------

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestBasic") \
    .getOrCreate()

df = spark.range(100)

df.show()

df1 = df.sample(False, 0.1, 22)

df1.show()

df.sample(False, 0.1, 22).show()

------------------------------------------------------------------------

from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("TestCollect").getOrCreate()

df = spark.range(5)  

rows = df.collect()

for row in rows:
    print(row)

------------------------------------------------------------------------------

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, StringType, IntegerType

spark = SparkSession.builder.appName("CollectExample").getOrCreate()

data = [
    (1,"Sachin", 1000),
    (2,"Rahul", 1100),
    (3,"Yuvraj", 900)
]

# Define schema
schema = StructType([
    StructField("id", StringType(), True),
    StructField("name", StringType(), True),
    StructField("runs", IntegerType(), True)
])

df = spark.createDataFrame(data, schema)

df.show()

rows = df.collect()

print(rows[0])
print(rows[0][1])

for row in rows:
    print(f"Id: {row['id']}, name: {row['name']}, Runs: {row['runs']}")
