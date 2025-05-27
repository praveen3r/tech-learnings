from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("TestRDD").getOrCreate()

data = [("Sachin", 1000), ("Rahul", 850), ("Yuvraj", 400)]
rdd = spark.sparkContext.parallelize(data)

print(rdd.collect())

---------------------------------------------------------------------------------------------

#RDD to dataframe

---------------------------------------------------------------------------------------------

#Map

from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("TestRDD").getOrCreate()

data = [("Sachin", 1000), ("Rahul", 850), ("Yuvraj", 400)]
rdd = spark.sparkContext.parallelize(data)

rdd1 = rdd.map(lambda x: (x[0].upper(), x[1])) #change existing element
print(rdd1.collect())

rdd2 = rdd.map(lambda x: x + (x[0].upper(),)) #Add new element
print(rdd2.collect())

---------------------------------------------------------------------------------------------

#FlatMap

from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("TestRDD").getOrCreate()

data = ["Hello world", "Jai Shriram"]

rdd = spark.sparkContext.parallelize(data)

rdd1 = rdd.flatMap(lambda line: line.split(" "))

print(rdd1.collect())

for line in rdd1.collect():
    print(line)
