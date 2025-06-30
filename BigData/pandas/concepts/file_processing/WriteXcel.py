import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df.to_excel('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', index=False)

---------------------------------------------------------------------------------------------------

# Common Options:

Option	                            What it Does
index=False	                    Don’t write row index
sheet_name='Sheet1'	            Specify sheet name (default is 'Sheet1')
startrow=2	                    Start writing from the 3rd row
engine='openpyxl'	            Required for .xlsx format (default)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Add Formatting (Optional with xlsxwriter)

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='xlsxwriter') as writer:
    df.to_excel(writer, sheet_name='Runs', index=False)
    workbook  = writer.book
    worksheet = writer.sheets['Runs']
    format1 = workbook.add_format({'num_format': '#,##0', 'bold': True})
    worksheet.set_column('B:B', 12, format1)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Export to Excel with today’s date in filename

import pandas as pd
from datetime import datetime

today = datetime.today().strftime('%Y%m%d')

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df.to_excel(f'C:\Workspace\Learn\projects\BigData\pandas\data\players_{today}.xlsx', index=False)

---------------------------------------------------------------------------------------------------

# Append to an existing Excel file (without overwriting other sheets)

from openpyxl import load_workbook
import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl', mode='a', if_sheet_exists='new') as writer:
    df.to_excel(writer, sheet_name='NewSheet', index=False)

# mode='a': append mode

# if_sheet_exists='new': prevent overwrite
---------------------------------------------------------------------------------------------------

# Write filtered data to Excel

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

filtered_df = df[df['Runs'] > 10000]
filtered_df.to_excel('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', index=False)
---------------------------------------------------------------------------------------------------

# Auto-name Excel file with date and time

import pandas as pd
from datetime import datetime

now = datetime.now().strftime('%Y-%m-%d_%H-%M')
filename = f"C:\Workspace\Learn\projects\BigData\pandas\data\Test1_{now}.xlsx"

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df.to_excel(filename, index=False)


---------------------------------------------------------------------------------------------------

# Export multiple DataFrames into one file with formatting

import pandas as pd

df1 = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

df2 = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xslx', engine='xlsxwriter') as writer:
    df1.to_excel(writer, sheet_name='India', index=False)
    df2.to_excel(writer, sheet_name='World XI', index=False)
    
    # Format a column in sheet
    workbook  = writer.book
    worksheet = writer.sheets['India']
    format1 = workbook.add_format({'bg_color': '#D7E4BC', 'bold': True})
    worksheet.set_column('A:A', 20, format1)  # Format Name column

---------------------------------------------------------------------------------------------------

# Include chart in Excel (optional, bonus)

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xslx', engine='xlsxwriter') as writer:
    df.to_excel(writer, sheet_name='Data', index=False)
    workbook = writer.book
    worksheet = writer.sheets['Data']

    chart = workbook.add_chart({'type': 'column'})
    chart.add_series({'values': '=Data!$B$2:$B$4', 'name': 'Runs'})
    worksheet.insert_chart('D2', chart)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)

---------------------------------------------------------------------------------------------------

# Writing Multiple Sheets

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500]
})

with pd.ExcelWriter('C:\Workspace\Learn\projects\BigData\pandas\data\Test1.xlsx', engine='openpyxl') as writer:
    df.to_excel(writer, sheet_name='India', index=False)
    df.to_excel(writer, sheet_name='Asia XI', index=False)


