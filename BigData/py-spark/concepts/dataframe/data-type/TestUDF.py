from pyspark.sql.functions import udf
from pyspark.sql.types import StringType


def performance(runs):
    return "High" if runs > 800 else "Low"

performance_udf = udf(performance, StringType())

performance_udf1 = udf(lambda runs: "High" if runs > 800 else "Low", StringType())

@udf(returnType=StringType())
def performance1(runs: int) -> str:
    return "High" if runs > 800 else "Low"
