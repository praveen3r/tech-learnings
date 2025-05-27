from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import approx_count_distinct

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(approx_count_distinct("salary")).show()


--------------------------------------------------------------------------------

# avg 

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import avg

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(avg("salary")).show()

--------------------------------------------------------------------------------

# collect_list

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import collect_list

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(collect_list("salary")).show(truncate=False)

--------------------------------------------------------------------------------

# collect_set

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import collect_set

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(collect_set("salary")).show(truncate=False)

--------------------------------------------------------------------------------

# countDistinct

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import countDistinct

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(countDistinct("salary")).show(truncate=False)

--------------------------------------------------------------------------------

# count

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import count

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(count("salary")).show(truncate=False)

--------------------------------------------------------------------------------

# first - first non null value

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import first

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(first("salary")).show(truncate=False)

--------------------------------------------------------------------------------

# last - last non null value

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import last

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(last("salary")).show(truncate=False)

--------------------------------------------------------------------------------

# max 

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import max

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(max("salary")).show(truncate=False)

--------------------------------------------------------------------------------

# min  

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import min 

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(min("salary")).show(truncate=False)


--------------------------------------------------------------------------------

# sum   

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import sum  

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(sum("salary")).show(truncate=False)



--------------------------------------------------------------------------------

# sumDistinct   

from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, FloatType
from pyspark.sql.functions import sumDistinct  

# Create SparkSession
spark = SparkSession.builder \
    .appName("TestAggregate") \
    .getOrCreate()

data = [("HR", 100000), ("IT", 200000),("Finance", 130000), ("HR", 150000), ("IT", 300000)]

schema = ["department", "salary"]


df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df.select(sumDistinct("salary")).show(truncate=False)