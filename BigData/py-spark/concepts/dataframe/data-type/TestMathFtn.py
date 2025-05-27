# abs - Absolute value

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, abs, round, ceil, floor, sqrt, pow, log, exp

spark = SparkSession.builder.appName("TestMathFunction").getOrCreate()

data = [(99.0,), (-39.2,)]
schema = ["number"]

df = spark.createDataFrame(data, schema)
df.select(
    col("number"),
    abs(col("number")).alias("abs_number")).show()

------------------------------------------------------------------------------------------

# round - Round to nearest int or decimal

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, abs, round, ceil, floor, sqrt, pow, log, exp

spark = SparkSession.builder.appName("TestMathFunction").getOrCreate()

data = [(99.0,), (-39.2,), (79.7,)]
schema = ["number"]

df = spark.createDataFrame(data, schema)
df.select(
    col("number"),
    round(col("number")).alias("round_number")).show()

------------------------------------------------------------------------------------------

# ceil - Smallest int ≥ number

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, abs, round, ceil, floor, sqrt, pow, log, exp

spark = SparkSession.builder.appName("TestMathFunction").getOrCreate()

data = [(99.0,), (-39.2,), (79.7,)]
schema = ["number"]

df = spark.createDataFrame(data, schema)
df.select(
    col("number"),
    ceil(col("number")).alias("ceil_number")).show()

------------------------------------------------------------------------------------------

# floor - Largest int ≤ number

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, abs, round, ceil, floor, sqrt, pow, log, exp

spark = SparkSession.builder.appName("TestMathFunction").getOrCreate()

data = [(99.0,), (-39.2,), (79.7,)]
schema = ["number"]

df = spark.createDataFrame(data, schema)
df.select(
    col("number"),
    floor(col("number")).alias("floor_number")).show()

------------------------------------------------------------------------------------------

# sqrt - Square root

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, abs, round, ceil, floor, sqrt, pow, log, exp

spark = SparkSession.builder.appName("TestMathFunction").getOrCreate()

data = [(99.0,), (-39.2,), (79.7,)]
schema = ["number"]

df = spark.createDataFrame(data, schema)
df.select(
    col("number"),
    sqrt(col("number")).alias("sqrt_number")).show()

------------------------------------------------------------------------------------------

# pow - Power of a number

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, abs, round, ceil, floor, sqrt, pow, log, exp

spark = SparkSession.builder.appName("TestMathFunction").getOrCreate()

data = [(99.0,), (-39.2,), (79.7,)]
schema = ["number"]

df = spark.createDataFrame(data, schema)
df.select(
    col("number"),
    pow(col("number"), 2).alias("pow_number")).show()

------------------------------------------------------------------------------------------

# log - Natural log

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, abs, round, ceil, floor, sqrt, pow, log, exp

spark = SparkSession.builder.appName("TestMathFunction").getOrCreate()

data = [(99.0,), (-39.2,), (79.7,)]
schema = ["number"]

df = spark.createDataFrame(data, schema)
df.select(
    col("number"),
    log(col("number")).alias("log_number")).show()

------------------------------------------------------------------------------------------

# exp - Exponential

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, abs, round, ceil, floor, sqrt, pow, log, exp

spark = SparkSession.builder.appName("TestMathFunction").getOrCreate()

data = [(99.0,), (-39.2,), (79.7,)]
schema = ["number"]

df = spark.createDataFrame(data, schema)
df.select(
    col("number"),
    exp(col("number")).alias("exp_number")).show()