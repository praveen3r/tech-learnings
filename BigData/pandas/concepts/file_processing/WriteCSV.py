import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df.to_csv('C:\Workspace\Learn\projects\BigData\pandas\data\Test.csv', index=False)

----------------------------------------------------------------------------------------------------

#Options You Can Use:
#Option	                   What It Does

sep=','	                 Specify delimiter (e.g., tab: sep='\t')
header=True	             Include column names
columns=[...]	         Choose specific columns
na_rep='NA'	             Replace NaNs with a string
encoding='utf-8'	     File encoding (for special characters)

----------------------------------------------------------------------------------------------------

# Write DataFrame to CSV with options

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df.to_csv(
    'C:\Workspace\Learn\projects\BigData\pandas\data\Test.csv',
    index=False,            # Don't write row index
    columns=['Name', 'Runs'],  # Export only selected columns
    na_rep='NA',            # Replace missing values with 'NA'
    encoding='utf-8',       # Handle special characters
    date_format='%d-%b-%Y'  # Format datetime (if present)
)

----------------------------------------------------------------------------------------------------

# Append to existing CSV

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df.to_csv('C:\Workspace\Learn\projects\BigData\pandas\data\Test.csv', mode='a', header=False, index=False)

# mode='a': append mode

# header=False: don’t write header again


----------------------------------------------------------------------------------------------------

# Export to Excel instead of CSV

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df.to_excel('players.xlsx', index=False)


----------------------------------------------------------------------------------------------------

# Save multiple DataFrames to one Excel file (different sheets)

import pandas as pd

df1 = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df2 = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test.xslx') as writer:
    df1.to_excel(writer, sheet_name='India', index=False)
    df2.to_excel(writer, sheet_name='Asia XI', index=False)


----------------------------------------------------------------------------------------------------

# Custom date formatting in CSV

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df['Date'] = pd.to_datetime(df['Date'])
df.to_csv('C:\Workspace\Learn\projects\BigData\pandas\data\Test.csv', date_format='%Y-%m-%d', index=False)


----------------------------------------------------------------------------------------------------

# Auto-name file using today’s date

import pandas as pd
from datetime import datetime

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid'],
    'Runs': [12000, 10000]
})

today_str = datetime.today().strftime('%Y%m%d')

filename = f"players_{today_str}.csv"

df.to_csv(filename, index=False)

----------------------------------------------------------------------------------------------------

# Export filtered rows

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

filtered_df = df[df['Runs'] > 10000]
filtered_df.to_csv('C:\Workspace\Learn\projects\BigData\pandas\data\Test.csv', index=False)

----------------------------------------------------------------------------------------------------

# Export to a zipped CSV file

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

compression_opts = dict(method='zip', archive_name='C:\Workspace\Learn\projects\BigData\pandas\data\Test.csv')
df.to_csv('players.zip', index=False, compression=compression_opts)

----------------------------------------------------------------------------------------------------

# Save only selected columns

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df.to_csv('C:\Workspace\Learn\projects\BigData\pandas\data\Test.csv', columns=['Name'], index=False)





