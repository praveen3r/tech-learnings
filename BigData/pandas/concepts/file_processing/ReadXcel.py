import pandas as pd

df = pd.read_excel('C:\Workspace\Learn\projects\BigData\pandas\data\players.xlsx')
print(df)

--------------------------------------------------------------------------

# Parameters You Can Use:

Parameter	            Purpose
-----------           ------------

sheet_name=0	    Sheet index or name (e.g., 'Sheet1')
usecols='A:C'	    Read specific columns
nrows=5	            Read only the first 5 rows
skiprows=1	        Skip the first row
header=None	        If the file has no header row
dtype=str	        Force all columns to be strings

--------------------------------------------------------------------------

# Read a Specific Sheet by Name

import pandas as pd

df = pd.read_excel('C:\Workspace\Learn\projects\BigData\pandas\data\players.xlsx', sheet_name='India')

print(df)

--------------------------------------------------------------------------

# Read All Sheets at Once

import pandas as pd

sheets = pd.read_excel('C:\Workspace\Learn\projects\BigData\pandas\data\players.xlsx', sheet_name=None)

# Access individual sheets
df_india = sheets['India']
df_asia = sheets['Asia XI']

print(df_india)
print(df_asia)

--------------------------------------------------------------------------

# Read multiple Excel files from a folder and combine them

import pandas as pd
import glob

files = glob.glob('C:\Workspace\Learn\projects\BigData\pandas\data\*.xlsx')

df_list = [pd.read_excel(file) for file in files]

combined_df = pd.concat(df_list, ignore_index=True)

--------------------------------------------------------------------------

# Read and merge multiple sheets from one Excel file

import pandas as pd

xls = pd.ExcelFile('players.xlsx')  

dfs = [xls.parse(sheet_name) for sheet_name in xls.sheet_names]

combined_df = pd.concat(dfs, ignore_index=True)


--------------------------------------------------------------------------

# Read only specific columns or rows

import pandas as pd


df = pd.read_excel('C:\Workspace\Learn\projects\BigData\pandas\data\players.xlsx', usecols=['Name', 'Runs'], nrows=10)

--------------------------------------------------------------------------

# Read Excel with missing headers

import pandas as pd

df = pd.read_excel('C:\Workspace\Learn\projects\BigData\pandas\data\players.xlsx', header=None)  # No header row

print(df)

--------------------------------------------------------------------------

# Filter while reading

import pandas as pd

df = pd.read_excel('C:\Workspace\Learn\projects\BigData\pandas\data\players.xlsx')
df_filtered = df[df['Runs'] > 10000]

print(df_filtered)

--------------------------------------------------------------------------

# Auto-load the latest Excel file

import os
import glob

list_of_files = glob.glob('C:\Workspace\Learn\projects\BigData\pandas\data\*.xlsx')  
latest_file = max(list_of_files, key=os.path.getctime)

df = pd.read_excel(latest_file)

--------------------------------------------------------------------------

# Auto-load the latest Excel file

import pandas as pd

df = pd.read_excel('C:\Workspace\Learn\projects\BigData\pandas\data\players.xlsx', sheet_name='India')

print(df)