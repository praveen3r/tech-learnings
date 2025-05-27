def updated_runs_column(df):
    return df.withColumn("updated_runs", col("runs") * 10)

def updated_runs_column1(df):
    return df.withColumn("UPDATED_RUNS1", col("runs") * 10)