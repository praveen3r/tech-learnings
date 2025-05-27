#union - schema not matching, add missing colum

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data1 = [(1, "Sachin"), (2, "Dravid"), (3, "Yuvraj")]
schema1 = ["id", "name"]

data2 = [(1, "HR"), (2, "IT")]
schema2 = ["id", "department"]

df1 = spark.createDataFrame(data1, schema1)
df2 = spark.createDataFrame(data2,schema2 )

df = df1.join(df2, on="id", how="inner") #all matching rows
df.show()

---------------------------------------------------------------------------------------------------------------------

#left join

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data1 = [(1, "Sachin"), (2, "Dravid"), (3, "Yuvraj")]
schema1 = ["id", "name"]

data2 = [(1, "HR"), (2, "IT")]
schema2 = ["id", "department"]

df1 = spark.createDataFrame(data1, schema1)
df2 = spark.createDataFrame(data2,schema2 )

df = df1.join(df2, on="id", how="left") #non matching matching rows from left
df.show()

---------------------------------------------------------------------------------------------------------------------

#right join

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()


data1 = [(1, "Sachin"), (2, "Dravid"), (3, "Yuvraj")]
schema1 = ["id", "name"]

data2 = [(1, "HR"), (2, "IT"), (4, "Finance")]
schema2 = ["id", "department"]

df1 = spark.createDataFrame(data1, schema1)
df2 = spark.createDataFrame(data2,schema2 )

df = df1.join(df2, on="id", how="right") #non matching matching rows from right
df.show()

---------------------------------------------------------------------------------------------------------------------

#full join

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data1 = [(1, "Sachin"), (2, "Dravid"), (3, "Yuvraj")]
schema1 = ["id", "name"]

data2 = [(1, "HR"), (2, "IT"), (4, "Finance")]
schema2 = ["id", "department"]

df1 = spark.createDataFrame(data1, schema1)
df2 = spark.createDataFrame(data2,schema2 )

df = df1.join(df2, on="id", how="full") #non matching matching rows from both
df.show()

---------------------------------------------------------------------------------------------------------------------

#left semi join

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data1 = [(1, "Sachin"), (2, "Dravid"), (3, "Yuvraj")]
schema1 = ["id", "name"]

data2 = [(1, "HR"), (2, "IT"), (4, "Finance")]
schema2 = ["id", "department"]

df1 = spark.createDataFrame(data1, schema1)
df2 = spark.createDataFrame(data2,schema2 )

df = df1.join(df2, on="id", how="leftsemi") #matching rows but columns from left
df.show()

---------------------------------------------------------------------------------------------------------------------

#left semi join

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data1 = [(1, "Sachin"), (2, "Dravid"), (3, "Yuvraj")]
schema1 = ["id", "name"]

data2 = [(1, "HR"), (2, "IT"), (4, "Finance")]
schema2 = ["id", "department"]

df1 = spark.createDataFrame(data1, schema1)
df2 = spark.createDataFrame(data2,schema2 )

df = df1.join(df2, on="id", how="leftanti") #non matching rows but columns from left
df.show()

---------------------------------------------------------------------------------------------------------------------

#self join

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1, "Sachin", None), (2, "Dravid", 1), (3, "Yuvraj", 1), (4, "Saurav", 1)]
schema = ["emp_id", "name", "mgr_id"]


df = spark.createDataFrame(data, schema)

emp = df.alias("emp")
mgr = df.alias("mgr")

df1 = emp.join(
    mgr,
    col("emp.mgr_id") == col("mgr.emp_id"),
    how="left"
).select(
    col("emp.emp_id"),
    col("emp.name").alias("employee_name"),
    col("mgr.name").alias("manager_name")
)

df1.show()

---------------------------------------------------------------------------------------------------------------------

#self join to get manager's manager

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data = [(1, "Sachin", None), (2, "Dravid", 1), (3, "Yuvraj", 1), (4, "Saurav", 2)]
schema = ["emp_id", "name", "mgr_id"]


df = spark.createDataFrame(data, schema)

emp = df.alias("emp")
mgr = df.alias("mgr")
mgr2 = df.alias("mgr2")

df1 = (emp
   .join(mgr, col("emp.mgr_id") == col("mgr.emp_id"),how="left")
   .join(mgr2, col("mgr.mgr_id") == col("mgr2.emp_id"), "left")
   .select(
    col("emp.emp_id"),
        col("emp.name").alias("employee_name"),
        col("mgr.name").alias("manager_name"),
        col("mgr2.name").alias("managers_manager_name")
    ))

df1.show()

---------------------------------------------------------------------------------------------------------------------

#join on different columns

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data1 = [(1, "Sachin"), (2, "Dravid"), (3, "Yuvraj")]
schema1 = ["emp_id", "name"]

data2 = [(1, "HR"), (2, "IT"), (4, "Finance")]
schema2 = ["id", "department"]

df1 = spark.createDataFrame(data1, schema1)
df2 = spark.createDataFrame(data2,schema2 )

df = df1.join(df2, on=col("emp_id") == col("id"), how="inner") 
df.show()

---------------------------------------------------------------------------------------------------------------------

#multiple join cdtn

from pyspark.sql import SparkSession
from pyspark.sql.functions import when, col, lit


# Initialize Spark session
spark = SparkSession.builder.appName("TestColType").getOrCreate()

data1 = [(1, "Sachin", "HR"), (2, "Dravid","IT"), (3, "Yuvraj","Finance")]
schema1 = ["id", "name", "dept"]

data2 = [(1, "HR"), (2, "IT"), (4, "Finance")]
schema2 = ["id", "dept"]

df1 = spark.createDataFrame(data1, schema1).alias("df1")
df2 = spark.createDataFrame(data2,schema2 ).alias("df2")

df = df1.join(df2, on=(col("df1.id") == col("df2.id")) & (col("df1.dept") == col("df2.dept")), how="inner") 
df.show()

