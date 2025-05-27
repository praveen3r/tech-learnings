# select columns

from pyspark.sql import SparkSession
from pyspark.sql.functions import col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1, '1000', 30), (2, '2000', 31), (3, '3000', 32)]
schema = ['id', 'Salary', 'age']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.select(col('id'),col('age'))
df1.show()

----------------------------------------------------------------------------------

#nested objects

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

df = spark.createDataFrame(data, schema)

df.show(truncate=False)

df1 = df.select(col('id'),col('name.first'))
df1.show()

----------------------------------------------------------------------------

#when and otherwise

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1, '10000000', 30), (2, '200000', 31), (3, '3000', 32)]
schema = ['id', 'Salary', 'age']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.withColumn("classify", 
    when(col("salary") >= 1000000, "Super rich")
    .when(col("salary") >= 100000, "Rich")
    .when(col("salary") >= 10000, "Middle class")
    .otherwise("Very poor")
)

df1.show()

-------------------------------------------------------------------------

#alias

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1, '10000000', 30), (2, '200000', 31), (3, '3000', 32)]
schema = ['id', 'Salary', 'age']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.select(col('id').alias('id_new'))
)df1.show()
#or

df2 = df.select(
    col("id").alias("id_new"),
    col("salary").alias("salary_new")
)
df2.show()

-------------------------------------------------------------------------------

#sort

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1, '10000000', 30), (2, '200000', 31), (3, '3000', 32)]
schema = ['id', 'Salary', 'age']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.sort(col("salary").desc()).show()
df1.show()

# or

df2 = df.orderBy(col("salary").desc()).show()
df2.show()

--------------------------------------------------------------

#cast

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [("1",), ("2",), ("3",)]
df = spark.createDataFrame(data, ["num_str"])

df1 = df.withColumn("num_int", col("num_str").cast("int"))
df1.show()

-----------------------------------------------------------------------------

#like

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1, '10000000', 'SE'), (2, '200000', 'SSE'), (3, '3000', 'SSSE')]
schema = ['id', 'Salary', 'Designation']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.filter(col("Designation").like("%SSE%"))
df1.show()

-----------------------------------------------------------------------------------------
#filter

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1,'Sachin' ,'10000000', 30), (2,'Rahul' ,'200000', 31), (3,'Yuvaraj', '3000', 32)]
schema = ['id','name','Salary', 'age']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.filter(col("age") > 30)
df1.show()

df2 = df.filter((col("age") > 29) & (col("name").like("S%")))
df2.show()

df.filter((col("age") > 30) | (col("name").like("S%"))).show()

df.filter(~(col("age") == 30)).show() #not operator




-------------------------------------------------------------------------------

#where


from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1,'Sachin' ,'10000000', 30), (2,'Rahul' ,'200000', 31), (3,'Yuvaraj', '3000', 32)]
schema = ['id','name','Salary', 'age']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.where(col("age") > 30)
df1.show()

df2 = df.where((col("age") > 29) & (col("name").like("S%")))
df2.show()

df.where((col("age") > 30) | (col("name").like("S%"))).show()

df.where(~(col("age") == 30)).show() #not operator

----------------------------------------------------------------------------------

#dropDuplicates

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1,'Sachin' ,'10000000', 30), (2,'Rahul' ,'200000', 31), (3,'Yuvaraj', '3000', 32),(1,'Sachin' ,'10000000', 30)]
schema = ['id','name','Salary', 'age']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.dropDuplicates()
df1.show()

df.dropDuplicates(["id"]).show()

---------------------------------------------------------------------------------------------------------------------

#union - schema must match

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1,'Sachin' ,'10000000', 30), (2,'Rahul' ,'200000', 31), (3,'Yuvaraj', '3000', 32),(1,'Sachin' ,'10000000', 30)]
schema = ['id','name','Salary', 'age']
df = spark.createDataFrame(data, schema)

data1 = [(1,'Shewag' ,'10000000', 30), (2,'Rahul' ,'200000', 31)]
df1 = spark.createDataFrame(data1, schema)

df2 = df1.union(df);
df2.show()

df2.dropDuplicates(["id"]).show()

---------------------------------------------------------------------------------------------------------------------


# pivot

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [('Sachin' ,'2004', 1000), ('Rahul' ,'2005', 1100), ('Sachin', '2005', 1200),('Sachin' ,'2004', 500),('Saurav' ,'2006', 500)]
schema = ['name','year', 'runs']
df = spark.createDataFrame(data, schema)

df.show()

#count
df1 = df.groupBy("name").pivot("year",['2004','2005']).count()
df1.show()

#sum of runs
df2 = df.groupBy("name").pivot("year",['2004','2005']).sum("runs")
df2.show()

#dynamic years
years = [row["year"] for row in df.select("year").distinct().collect()]

df3 = df.groupBy("name").pivot("year",years).sum("runs")
df3.show()

#diff syntax

df4 = df.groupBy("name").pivot("year",years).agg(sum("runs")) # year and runs data type must match
df4.show()
---------------------------------------------------------------------------------------------------------------------


# unpivot

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [
    ("Sachin", 1500, 1200, None),
    ("Rahul", None, 1100, None),
    ("Saurav", None, None, 500)
]
schema = ['name','2004','2005','2006']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.selectExpr(
    "name",
    "stack(3, '2004', `2004`, '2005', `2005`, '2006', `2006`) as (year, runs)"
)

df1.show()

---------------------------------------------------------------------------------------------------------------------


# unpivot

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [
    ("Sachin", 1500, 1200, None),
    ("Rahul", None, 1100, None),
    ("Saurav", None, None, 500)
]
schema = ['name','2004','2005','2006']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.selectExpr(
    "name",
    "stack(3, '2004', `2004`, '2005', `2005`, '2006', `2006`) as (year, runs)"
)

df1.show()

---------------------------------------------------------------------------------------------------------------------


# fill null values

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [
    ("Sachin", 1500, 1200, None),
    ("Rahul", None, 1100, None),
    ("Saurav", None, None, 500)
]
schema = ['name','2004','2005','2006']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.fillna(0)
df1.show()

df2 = df.fillna({'2004':0}) #specific columns
df2.show()


---------------------------------------------------------------------------------------------------------------------


# transform values

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

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

def updated_runs_column(df):
    return df.withColumn("updated_runs", col("runs") * 10)

df1 = df.transform(updated_runs_column)
df1.show()

---------------------------------------------------------------------------------------------------------------------


# transform values

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit
from TestTransforms import updated_runs_column, updated_runs_column1


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

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

df1 = df.transform(updated_runs_column)
df1.show()

df.transform(updated_runs_column).transform(updated_runs_column1).show()

---------------------------------------------------------------------------------------------------------------------


# udf

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit
from TESTDF import performance_udf, performance1, performance_udf1


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [
    (1,"Sachin", 1000),
    (2,"Rahul", 1100),
    (3,"Yuvraj", 400)
]

# Define schema
schema = StructType([
    StructField("id", StringType(), True),
    StructField("name", StringType(), True),
    StructField("runs", IntegerType(), True)
])

df = spark.createDataFrame(data, schema)
df.show()

df1 = df.withColumn("performance", performance_udf(col("runs")))
df1.show()

df2 = df.withColumn("performance", performance1(col("runs")))
df2.show()

df3 = df.withColumn("performance", performance_udf(col("runs")))
df3.show()