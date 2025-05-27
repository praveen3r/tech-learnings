
from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import count, sum, avg, min, max

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.groupBy("department").agg(count("*").alias("employee_count"))

df1.show()

df.printSchema()

--------------------------------------------------------------------------------

# sum

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import count, sum, avg, min, max

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.groupBy("department").agg(sum("salary").alias("Total_Salary"))

df1.show()

df.printSchema()

-------------------------------------------------------------------------------------------

# avg

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import count, sum, avg, min, max

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.groupBy("department").agg(avg("salary").alias("Avg_Salary"))

df1.show()

df.printSchema()

-------------------------------------------------------------------------------------------

# min

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import count, sum, avg, min, max

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.groupBy("department").agg(min("salary").alias("Min_Salary"))

df1.show()

df.printSchema()

-------------------------------------------------------------------------------------------

# max

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import count, sum, avg, min, max

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.groupBy("department").agg(max("salary").alias("Max_Salary"))

df1.show()

df.printSchema()

-------------------------------------------------------------------------------------------

# combine

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import count, sum, avg, min, max

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.groupBy("department").agg(min("salary").alias("Min_Salary"),max("salary").alias("Max_Salary"))

df1.show()

df.printSchema()

-------------------------------------------------------------------------------------------

# keep original rows and calculate aggregates

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import count, sum, avg, min, max
from pyspark.sql.window import Window

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

windowSpec = Window.partitionBy("department")

df1 = df.withColumn("total_dept_salary", sum("salary").over(windowSpec)).show()

df1.show()

df.printSchema()
