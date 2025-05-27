from pyspark.sql import SparkSession


# Initialize Spark session
spark = SparkSession.builder.appName("TestArrayType").getOrCreate()

data = [(1, [1,2]), (2, [3,4]), (3, [5,6])]
schema = ['id', 'numbers']
df = spark.createDataFrame(data, schema)

df.show()
df.printSchema

--------------------------------------------------------------------------------------------------

# with structtype

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, ArrayType

# Initialize Spark session
spark = SparkSession.builder.appName("TestArrayType").getOrCreate()

# Define schema using StructType
schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("numbers", ArrayType(IntegerType(), True), True)
])

# Sample data
data = [(1, [1, 2]), (2, [3, 4]), (3, [5, 6])]

# Create DataFrame with the schema
df = spark.createDataFrame(data, schema)

# Show DataFrame and schema
df.show()
df.printSchema()

--------------------------------------------------------------------------------------------------

#create new column with first value in array


from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, ArrayType
from pyspark.sql.functions import col

# Initialize Spark session
spark = SparkSession.builder.appName("TestArrayType").getOrCreate()

# Define schema using StructType
schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("numbers", ArrayType(IntegerType(), True), True)
])

# Sample data
data = [(1, [1, 2]), (2, [3, 4]), (3, [5, 6])]

# Create DataFrame with the schema
df = spark.createDataFrame(data, schema)

# Show DataFrame and schema
df.show()

df1 = df.withColumn("first_number", col("numbers")[0])

df1.show()

--------------------------------------------------------------------------------------------------

#create array with column values

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, array


# Initialize Spark session
spark = SparkSession.builder.appName("TestArrayType").getOrCreate()

data = [(1, 2), (2, 3), (3, 4)]
schema = ['id1', 'id2']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.withColumn("Combined", array(col("id1"),col("id2")))

df1.show()

--------------------------------------------------------------------------------------------------

#explode

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, array, explode


spark = SparkSession.builder.appName("TestArrayType").getOrCreate()

# Define schema using StructType
schema = StructType([
    StructField("id", IntegerType(), True),
    StructField("numbers", ArrayType(IntegerType(), True), True)
])

# Sample data
data = [(1, [1, 2]), (2, [3, 4]), (3, [5, 6])]

# Create DataFrame with the schema
df = spark.createDataFrame(data, schema)

# Show DataFrame and schema
df.show()

df1 = df.withColumn("number", explode("numbers"))

df1.show()

--------------------------------------------------------------------------------------------------

#split

from pyspark.sql.functions import split,col

data = [(1, "1,2"), (2, "3,4"), (3, "5,6")]
schema = ["id", "num"]

df = spark.createDataFrame(data, schema)

df.show()

df1 = df.withColumn("numbers", split(col("num"), ",")) # creates array

df1.show()

--------------------------------------------------------------------------------------------------

# array_contains

from pyspark.sql.functions import split, col, array_contains

data = [(1, [1, 2]), (2, [3, 4]), (3, [5, 6])]

schema = ["id", "num"]

df = spark.createDataFrame(data, schema)

df.show()

df1 = df.withColumn("IsContains", array_contains(col("num"), 3))

# df1 = df.filter(array_contains(col("num_contains"), 3))

df1.show()