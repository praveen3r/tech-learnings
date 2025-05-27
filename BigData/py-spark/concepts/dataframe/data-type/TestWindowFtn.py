from pyspark.sql import SparkSession
from pyspark.sql.window import Window
from pyspark.sql.functions import row_number, rank, dense_rank, col

spark = SparkSession.builder.appName("RankingFunctions").getOrCreate()

data = [("HR", 100000), ("IT", 200000),("HR", 130000), ("HR", 130000), ("IT", 200000), ("IT", 300000)]
df = spark.createDataFrame(data, ["dept", "salary"])

window = Window.partitionBy("dept").orderBy(col("salary").desc())

df.withColumn("row_number", row_number().over(window)).show()

---------------------------------------------------------------------------------------------------------

# rank

from pyspark.sql import SparkSession
from pyspark.sql.window import Window
from pyspark.sql.functions import row_number, rank, dense_rank, col

spark = SparkSession.builder.appName("RankingFunctions").getOrCreate()

data = [("HR", 100000), ("IT", 200000),("HR", 130000), ("HR", 130000), ("IT", 200000), ("IT", 300000)]
df = spark.createDataFrame(data, ["dept", "salary"])

window = Window.partitionBy("dept").orderBy(col("salary").desc())

df.withColumn("rank", rank().over(window)).show()

---------------------------------------------------------------------------------------------------------

# dense_rank

from pyspark.sql import SparkSession
from pyspark.sql.window import Window
from pyspark.sql.functions import row_number, rank, dense_rank, col

spark = SparkSession.builder.appName("RankingFunctions").getOrCreate()

data = [("HR", 100000), ("IT", 200000),("HR", 130000), ("HR", 130000), ("IT", 200000), ("IT", 300000)]
df = spark.createDataFrame(data, ["dept", "salary"])

window = Window.partitionBy("dept").orderBy(col("salary").desc())

df.withColumn("dense_rank", dense_rank().over(window)).show()