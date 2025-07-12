from pyspark.sql import SparkSession
from pyspark.sql.types import StructType, StructField, IntegerType, StringType

try:
    schema = StructType([
        StructField("name", StringType()),
        StructField("age", IntegerType())
    ])

    # Start Spark session
    spark = SparkSession.builder.appName("Test").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    input_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\json_input"
    output_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\csv_output"
    checkpoint_dir = r"C:\Workspace\Learn\projects\BigData\streaming\concepts\data\checkpoint"

    # Read streaming JSON data
    df = spark.readStream.schema(schema).format("json").load(input_dir)

    # Write to CSV (correct chaining, no extra .format!)
    query = df.writeStream \
        .outputMode("append") \
        .format("csv") \
        .option("path", output_dir) \
        .option("checkpointLocation", checkpoint_dir) \
        .start()

    query.awaitTermination()
except Exception as e:
    print(f"Unexpected error: {e}")

--------------------------------------------------------------------------------------------------------

# Use foreachBatch for Custom Error Handling in Batches

def process_batch(df, batch_id):
    try:
        print(f"Processing batch {batch_id}")
        df.show()  # Or write to file, DB, etc.
        # Simulated logic
        if df.count() == 0:
            raise ValueError("Empty batch")

    except Exception as e:
        print(f"Error in batch {batch_id}: {e}")
        # Optional: log error to file or send alert

--------------------------------------------------------------------------------------------------------

# Use foreachBatch for Custom Error Handling in Batches

def process_batch(df, batch_id):
    try:
        print(f"Processing batch {batch_id}")
        df.show()  # Or write to file, DB, etc.
        # Simulated logic
        if df.count() == 0:
            raise ValueError("Empty batch")

    except Exception as e:
        print(f"Error in batch {batch_id}: {e}")
        # Optional: log error to file or send alert

query = df.writeStream \
    .foreachBatch(process_batch) \
    .option("checkpointLocation", checkpoint_dir) \
    .start()

--------------------------------------------------------------------------------------------------------

# Check for Empty DataFrame in Each Batch

if df.isEmpty():
    print("No data in batch")
    return

--------------------------------------------------------------------------------------------------------

# Handle File Processing Failures (I/O Errors)

try:
    shutil.move(src, dest)
except FileNotFoundError:
    print("File not found, skipping")
except Exception as e:
    print("Error moving file:", e)

--------------------------------------------------------------------------------------------------------

# Nested try in PySpark

def process_batch(df, batch_id):
    try:
        print(f"Processing batch {batch_id}")

        # Outer-level streaming logic (e.g., filtering, writing to output)
        if df.rdd.isEmpty():
            print("No records in this batch")
            return

        # Nested try block for risky operations (e.g., file move, DB write)
        try:
            # Example: risky code
            print("Doing risky work...")
            df.show()
            # Raise manually to test
            # raise ValueError("Simulated failure in inner block")

        except Exception as inner_e:
            print(f"⚠️ Inner error: {inner_e}")
            # Log, send alert, continue to next batch

    except Exception as outer_e:
        print(f"❌ Outer error in batch {batch_id}: {outer_e}")
        # Optional: Stop streaming or escalate

