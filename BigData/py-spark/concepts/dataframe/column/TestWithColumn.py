---------------------------------------------------------------------------------------------

# Change column type

from pyspark.sql import SparkSession
from pyspark.sql.types import IntegerType
from pyspark.sql.functions import col

# Initialize Spark session
spark = SparkSession.builder.appName("TestWithColumn").getOrCreate()

data = [(1, '1000'), (2, '2000'), (3, '3000')]
schema = ['id', 'Salary']
df = spark.createDataFrame(data,schema )

df.printSchema()

df = df.withColumn("Salary", df["Salary"].cast(IntegerType()))

# or

df = df.withColumn("Salary", col("Salary").cast(IntegerType()))

df.printSchema()

---------------------------------------------------------------------------------------------

# update column values

from pyspark.sql import SparkSession
from pyspark.sql.types import IntegerType
from pyspark.sql.functions import col

# Initialize Spark session
spark = SparkSession.builder.appName("TestWithColumn").getOrCreate()

data = [(1, '1000'), (2, '2000'), (3, '3000')]
schema = ['id', 'Salary']
df = spark.createDataFrame(data,schema )

df.show()

df = df.withColumn("id", col("id") * 2)

df.show()

---------------------------------------------------------------------------------------------

# Create new column 

from pyspark.sql import SparkSession
from pyspark.sql.types import IntegerType
from pyspark.sql.functions import col, lit

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

data = [(1, '1000'), (2, '2000'), (3, '3000')]
schema = ['id', 'Salary']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.withColumn('Country', lit('India'))
df1.show()

df2 = df1.withColumn('id_new', col("id") * 2)
df2.show()

---------------------------------------------------------------------------------------------

# Rename existing column 

from pyspark.sql import SparkSession


# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

data = [(1, '1000'), (2, '2000'), (3, '3000')]
schema = ['id', 'Salary']
df = spark.createDataFrame(data, schema)

df.show()

df1 = df.withColumnRenamed('Salary', 'Salary_New')
df1.show()