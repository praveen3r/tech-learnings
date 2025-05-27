from pyspark.sql import SparkSession
from pyspark.sql.functions import lit

# Initialize Spark session
spark = SparkSession.builder.appName("TestCSV").getOrCreate()

#type(spark)

df_spark = spark.read.option('header','true').csv('C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\Test.csv')

#type(df_spark)

df_spark.show()

# show only first 3 rows
df_spark.head(3)

# show schema
df_spark.printSchema()

# derive schema dynamically
df_spark = spark.read.option('header','true').csv('C:\\Workspace\\Learn\\projects\\BigData\\py-spark\\concepts\\sample_files\\Test.csv',inferSchema=True)

# show schema
df_spark.printSchema()

# show columns
df_spark.columns

#pick any column
df_spark.select('Name')

#pick first column and show
df_spark.select('Name').show()

#pick Multiple column and show
df_spark.select('Name','Age').show()

#column types
df_spark.dtypes

#Describe
df_spark.describe()

#Describe and show
df_spark.describe().show()

#adding new columns
df_spark.withColumn('Age after 2 years', df_spark['Age']+2).show()

# adding new columns with hardcoded value
df_spark.withColumn('Fixed Age', lit('30')).show()

#drop columns
df_newspark.drop('Age after 2 years')

#rename column
df_newspark.withColumnRenamed('Age', 'New Age').show()

