import pandas as pd


df = pd.read_csv('C:\Workspace\Learn\projects\BigData\pandas\data\survey_results_public.csv')  

pd.set_option('display.max_rows', None)      
pd.set_option('display.max_columns', None)  

print(df)