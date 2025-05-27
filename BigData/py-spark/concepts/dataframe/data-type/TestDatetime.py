from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", current_date())

df.show()

--------------------------------------------------------------------------------------------

#to_date

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date, to_date, lit

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-05-20"), "yyyy-MM-dd"))

df.show()

--------------------------------------------------------------------------------------------

#date_format

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date, to_date, lit, date_format

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-05-20"), "yyyy-MM-dd"))

df1 = df.withColumn("formatted_date", date_format("date", "MMM dd, yyyy"))

df1.show()

------------------------------------------------------------------------------------------

# year

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,year

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-05-20"), "yyyy-MM-dd"))

df.show()

df = df.withColumn("year", year("date"))

df.show()

------------------------------------------------------------------------------------------

# month

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,month,to_date,lit

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-05-20"), "yyyy-MM-dd"))

df.show()

df = df.withColumn("month", month("date"))

df.show()

------------------------------------------------------------------------------------------

# month in text format

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,month,to_date,lit,date_format

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-05-20"), "yyyy-MM-dd"))

df.show()

df = df.withColumn("month", date_format("date", "MMMM"))

df.show()

------------------------------------------------------------------------------------------

# full date with month in text format

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,month,to_date,lit,date_format

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-05-20"), "yyyy-MM-dd"))

df.show()

df = df.withColumn("month", date_format("date", "yyyy-MMMM-dd"))

df.show()

------------------------------------------------------------------------------------------

# dayofmonth

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,dayofmonth,to_date,lit

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-05-20"), "yyyy-MM-dd"))

df.show()

df = df.withColumn("dayofmonth", dayofmonth("date"))

df.show()

------------------------------------------------------------------------------------------

# date_add

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,date_add,to_date,lit

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-05-20"), "yyyy-MM-dd"))

df.show()

df = df.withColumn("date_add", date_add("date", 10))

df.show()

------------------------------------------------------------------------------------------

# date_sub

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,date_sub,to_date,lit

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-05-20"), "yyyy-MM-dd"))

df.show()

df = df.withColumn("date_sub", date_sub("date", 5))

df.show()

------------------------------------------------------------------------------------------

# datediff

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,datediff,to_date,lit,col

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-03-20"), "yyyy-MM-dd"))

df = df.withColumn("today", current_date())

df.show()

df = df.withColumn("days_diff", datediff(col("today"), col("date")))

df.show()

------------------------------------------------------------------------------------------

# months_between

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,months_between,to_date,lit,col

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-03-20"), "yyyy-MM-dd"))

df = df.withColumn("today", current_date())

df.show()

df = df.withColumn("months_between", months_between(col("today"), col("date")))

df.show()

------------------------------------------------------------------------------------------

# filter by date

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,months_between,to_date,lit,col

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date", to_date(lit("2025-03-20"), "yyyy-MM-dd"))

df = df.withColumn("today", current_date())

df.show()

df.filter(col("date") > "2025-02-20").show()

----------------------------------------------------------------------------------------------

# current_timestamp

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,months_between,current_timestamp,lit,col

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date_time_now", current_timestamp())

df.show(truncate=False)


------------------------------------------------------------------------------------------

# to_timestamp

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_date,months_between,to_timestamp,lit,col

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

df = df.withColumn("date_time", to_timestamp(lit("2024-05-20 14:35:00"), "yyyy-MM-dd HH:mm:ss"))

df.show()

---------------------------------------------------------------------------------------------------------

# date_format - format timestamp

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_timestamp,months_between,to_timestamp,lit,col,date_format

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

# df = df.withColumn("date_time", to_timestamp(lit("2024-05-20 14:35:00"), "yyyy-MM-dd HH:mm:ss"))

df = df.withColumn("date_time",current_timestamp())

df = df.withColumn("formatted_ts", date_format("date_time", "yyyy-MM-dd mm:HH:ss:SSS"))

df.show(truncate=False)

--------------------------------------------------------------------------------------------------------------

# hour

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_timestamp,months_between,to_timestamp,lit,col,date_format,hour

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

# df = df.withColumn("date_time", to_timestamp(lit("2024-05-20 14:35:00"), "yyyy-MM-dd HH:mm:ss"))

df = df.withColumn("date_time",current_timestamp())

df = df.withColumn("housr", hour("date_time"))

df.show(truncate=False)

--------------------------------------------------------------------------------------------------------------

# hour

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_timestamp,months_between,to_timestamp,lit,col,date_format,minute

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

# df = df.withColumn("date_time", to_timestamp(lit("2024-05-20 14:35:00"), "yyyy-MM-dd HH:mm:ss"))

df = df.withColumn("date_time",current_timestamp())

df = df.withColumn("minute", minute("date_time"))

df.show(truncate=False)

--------------------------------------------------------------------------------------------------------------

# hour

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_timestamp,months_between,to_timestamp,lit,col,date_format,second

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

# df = df.withColumn("date_time", to_timestamp(lit("2024-05-20 14:35:00"), "yyyy-MM-dd HH:mm:ss"))

df = df.withColumn("date_time",current_timestamp())

df = df.withColumn("minute", second("date_time"))

df.show(truncate=False)

--------------------------------------------------------------------------------------------------------------

# extract millisecond

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_timestamp,months_between,to_timestamp,lit,col,date_format,second

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

# df = df.withColumn("date_time", to_timestamp(lit("2024-05-20 14:35:00"), "yyyy-MM-dd HH:mm:ss"))

df = df.withColumn("date_time",current_timestamp())

df = df.withColumn("millisecond", date_format("date_time", "SSS").cast("int"))

df.show(truncate=False)

--------------------------------------------------------------------------------------------------------------

# filter timestamp

from pyspark.sql import SparkSession
from pyspark.sql.functions import current_timestamp,months_between,to_timestamp,lit,col,date_format,second

spark = SparkSession.builder.appName("TestDateTime").getOrCreate()

df = spark.range(2)

# df = df.withColumn("date_time", to_timestamp(lit("2024-05-20 14:35:00"), "yyyy-MM-dd HH:mm:ss"))

df = df.withColumn("date_time",current_timestamp())

df1 = df.filter(col("date_time") > lit("2025-05-21 14:00:00").cast("timestamp"))

df.show(truncate=False)