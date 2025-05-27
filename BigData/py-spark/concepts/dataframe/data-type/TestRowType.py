from pyspark.sql import SparkSession, Row

spark = SparkSession.builder.appName("RowExample").getOrCreate()

data = [
    Row(id=1, name="Sachin"),
    Row(id=2, name="Dravid"),
    Row(id=3, name="Yuvraj")
]

df = spark.createDataFrame(data)
df.show()

---------------------------------------------------------------------------------------------------

#using dot notation

from pyspark.sql import SparkSession, Row

spark = SparkSession.builder.appName("RowExample").getOrCreate()

person = Row(id=1, name="Sachin")
print(person.id)
print(person.name)

df = spark.createDataFrame(data)
df.show()

--------------------------------------------------------------------------------

# Nested row

from pyspark.sql import SparkSession, Row

spark = SparkSession.builder.appName("RowExample").getOrCreate()

data = [
    Row(id=1, person=Row(name="Sachin", runs=100)),
    Row(id=2, person=Row(name="Dravid", runs=90))
]

df = spark.createDataFrame(data)
df.show()

------------------------------------------------------------------------------------------

# Nested row

from pyspark.sql import SparkSession, Row

spark = SparkSession.builder.appName("RowExample").getOrCreate()

person = Row("name", "runs")

data = [
    Row(id=1, info=person("Sachin", 100)),
    Row(id=2, info=person("Dravid", 90))
]

df = spark.createDataFrame(data)
df.show()

df.select("info.name", "info.runs").show()


