-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Extract date parts

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Year'] = df['Debut'].dt.year
df['Month'] = df['Debut'].dt.month
df['Day'] = df['Debut'].dt.day
df['Weekday'] = df['Debut'].dt.day_name()

print(df)

-----------------------------------------------------------------------------------

# Filter by date

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

print(df[df['Debut'] > '1995-01-01'])

-----------------------------------------------------------------------------------

# Add or subtract dates

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['25 Years Later'] = df['Debut'] + pd.DateOffset(years=25)

#or

df['NextMonth'] = df['Debut'] + pd.DateOffset(months=1)

print(df)

-----------------------------------------------------------------------------------

# Current date and time

print(pd.Timestamp.now())

print(pd.Timestamp.today())

-----------------------------------------------------------------------------------

# Custom format for display

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Formatted'] = df['Debut'].dt.strftime('%d-%b-%Y')  # e.g., 15-Nov-1989

print(df)

-----------------------------------------------------------------------------------

# Working with time (hour, minute, second)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Hour'] = df['Debut'].dt.hour
df['Minute'] = df['Debut'].dt.minute


print(df)

-----------------------------------------------------------------------------------

# Time differences

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['YearsSinceDebut'] = pd.Timestamp.now().year - df['Debut'].dt.year

#or

df['DaysSinceDebut'] = (pd.Timestamp.today() - df['Debut']).dt.days


-----------------------------------------------------------------------------------

# Add Time Zone Info

import pandas as pd

df = pd.DataFrame({
    'Event': ['Start', 'Middle', 'End'],
    'Timestamp': ['2022-01-01 10:00', '2022-01-02 14:30', '2022-01-03 18:45']
})

df['Timestamp_IST'] = df['Timestamp'].dt.tz_localize('Asia/Kolkata')
df['Timestamp_UTC'] = df['Timestamp_IST'].dt.tz_convert('UTC')

print(df)

-----------------------------------------------------------------------------------

# Create a date range

import pandas as pd

date_range = pd.date_range(start='2022-01-01', end='2022-01-10', freq='D')
print(date_range)

# Other options for frequency: 'H' (hour), 'W' (week), 'M' (month end), 'MS' (month start)


-----------------------------------------------------------------------------------

# Create a time series DataFrame

import pandas as pd

ts = pd.Series([100, 105, 110], index=pd.date_range('2022-01-01', periods=3, freq='D'))

print(ts)

-----------------------------------------------------------------------------------

# Resampling (e.g., daily to monthly)

import pandas as pd

ts = pd.Series(
    [10, 15, 20, 25, 30, 35, 40],
    index=pd.date_range('2022-01-01', periods=7, freq='D')
)

monthly_avg = ts.resample('M').mean()

print(monthly_avg)

-----------------------------------------------------------------------------------

# Filtering using date ranges

import pandas as pd

df = pd.DataFrame({
    'Event': ['Start', 'Middle', 'End'],
    'Timestamp': ['2022-01-01 10:00', '2022-01-02 14:30', '2022-01-03 18:45']
})

print(df[df['Timestamp'] > '2022-01-02'])

-----------------------------------------------------------------------------------

# Set Timestamp as index

import pandas as pd

df = pd.DataFrame({
    'Event': ['Start', 'Middle', 'End'],
    'Timestamp': ['2022-01-01 10:00', '2022-01-02 14:30', '2022-01-03 18:45']
})

df.set_index('Timestamp', inplace=True)

print(df)

-----------------------------------------------------------------------------------

# when set as an index, filter by date

import pandas as pd

df = pd.DataFrame({
    'Date': ['2023-01-01', '2023-01-02', '2023-01-03'],
    'Sales': [100, 150, 200]
})

df['Date'] = pd.to_datetime(df['Date'])

df.set_index('Date', inplace=True)

# ✅ Get single row by date
print(df.loc['2023-01-02'])

# ✅ Get range of dates
print(df.loc['2023-01-01':'2023-01-03'])

-----------------------------------------------------------------------------------

# when set as an index,Resample data (e.g., to monthly or weekly)

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']
})

# Convert Debut to datetime
df['Debut'] = pd.to_datetime(df['Debut'])

# Set Debut as index
df.set_index('Debut', inplace=True)

# Add some numeric column to resample
df['Dummy'] = [1, 1, 1]

# Resample: daily, weekly, monthly
print("Daily Sum:\n", df.resample('D').sum())
print("\nWeekly Sum:\n", df.resample('W').sum())
print("\nMonthly Mean:\n", df.resample('M').mean())

# Only numeric columns can be aggregated using .sum(), .mean(), etc.



-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)

-----------------------------------------------------------------------------------

# Convert to datetime

import pandas as pd

df = pd.DataFrame({
    'Name': ['Sachin', 'Dravid', 'Sehwag'],
    'Debut': ['1989-11-15', '1996-06-20', '1999-04-01']  # as string
})

df['Debut'] = pd.to_datetime(df['Debut'])

print(df)