#trim

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, length, upper, lower, trim, ltrim, rtrim, concat_ws, regexp_replace, substring

spark = SparkSession.builder.appName("TestStringFunction").getOrCreate()

data = [("Sachin", ), ("Saurav", ),("  Dravid",)]
schema = ["name"]

df = spark.createDataFrame(data, schema)
df.select(
    col("name"),
    trim(col("name")).alias("Trimmed_Name")).show()

----------------------------------------------------------------------------------------------

# upper

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, length, upper, lower, trim, ltrim, rtrim, concat_ws, regexp_replace, substring

spark = SparkSession.builder.appName("TestStringFunction").getOrCreate()

data = [("Sachin", ), ("Saurav", ),("  Dravid",)]
schema = ["name"]

df = spark.createDataFrame(data, schema)
df.select(
    col("name"),
    upper(col("name")).alias("upper_Name")).show()


----------------------------------------------------------------------------------------------

# length

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, length, upper, lower, trim, ltrim, rtrim, concat_ws, regexp_replace, substring

spark = SparkSession.builder.appName("TestStringFunction").getOrCreate()

data = [("Sachin", ), ("Saurav", ),("  Dravid",)]
schema = ["name"]

df = spark.createDataFrame(data, schema)
df.select(
    col("name"),
    length(col("name")).alias("length_Name")).show()

----------------------------------------------------------------------------------------------

# lower

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, length, upper, lower, trim, ltrim, rtrim, concat_ws, regexp_replace, substring

spark = SparkSession.builder.appName("TestStringFunction").getOrCreate()

data = [("Sachin", ), ("Saurav", ),("  DRAVID",)]
schema = ["name"]

df = spark.createDataFrame(data, schema)
df.select(
    col("name"),
    lower(col("name")).alias("lower_Name")).show()

----------------------------------------------------------------------------------------------

# ltrim - left trim

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, length, upper, lower, trim, ltrim, rtrim, concat_ws, regexp_replace, substring

spark = SparkSession.builder.appName("TestStringFunction").getOrCreate()

data = [("Sachin", ), ("Saurav", ),("  Dravid",)]
schema = ["name"]

df = spark.createDataFrame(data, schema)
df.select(
    col("name"),
    ltrim(col("name")).alias("ltrim_Name")).show()

----------------------------------------------------------------------------------------------

# rtrim - right trim

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, length, upper, lower, trim, ltrim, rtrim, concat_ws, regexp_replace, substring

spark = SparkSession.builder.appName("TestStringFunction").getOrCreate()

data = [("Sachin", ), ("Saurav", ),("Dravid  ",)]
schema = ["name"]

df = spark.createDataFrame(data, schema)
df.select(
    col("name"),
    rtrim(col("name")).alias("rtrim_Name")).show()

----------------------------------------------------------------------------------------------

# substring

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, length, upper, lower, trim, ltrim, rtrim, concat_ws, regexp_replace, substring

spark = SparkSession.builder.appName("TestStringFunction").getOrCreate()

data = [("Sachin", ), ("Saurav", ),("Dravid  ",)]
schema = ["name"]

df = spark.createDataFrame(data, schema)
df.select(
    col("name"),
    substring(col("name"), 1, 3).alias("substring_Name")).show()

----------------------------------------------------------------------------------------------

# Concat

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, length, upper, lower, trim, ltrim, rtrim, concat_ws, regexp_replace, substring

spark = SparkSession.builder.appName("TestStringFunction").getOrCreate()

data = [("Sachin","Tendulkar" ), ("Saurav", "Ganguly"),("Rahul ","Dravid")]
schema = ["first_name","last_name"]

df = spark.createDataFrame(data, schema)
df.select(
    col("first_name"),
    col("last_name"),
    concat_ws("-", col("first_name"), col("last_name")).alias("Concat_Name")).show()

----------------------------------------------------------------------------------------------

# regexp_replace

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, length, upper, lower, trim, ltrim, rtrim, concat_ws, regexp_replace, substring

spark = SparkSession.builder.appName("TestStringFunction").getOrCreate()

data = [("Sachin123", ), ("Saurav456", ),("789Dravid",)]
schema = ["name"]

df = spark.createDataFrame(data, schema)

#remove digits

df.select(
    col("name"),
    regexp_replace(col("name"), "[0-9]", "").alias("regexp_replace_Name")).show()

