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

-----------------------------------------------------------------------------------

# Skip holidays using pd.bdate_range()

import pandas as pd

holidays = pd.to_datetime(['2024-12-25', '2025-01-01'])

# Business days in Jan 2025 excluding weekends and holidays
dates = pd.bdate_range(start='2025-01-01', end='2025-01-10', holidays=holidays)
print(dates)

-----------------------------------------------------------------------------------

# Using CustomBusinessDay to define your own calendar

import pandas as pd

from pandas.tseries.offsets import CustomBusinessDay

my_holidays = pd.to_datetime(['2025-01-01', '2025-01-15'])  # New Year & Pongal
my_bday = CustomBusinessDay(holidays=my_holidays)

pd.date_range(start='2025-01-01', periods=5, freq=my_bday)

-----------------------------------------------------------------------------------

# Check if a date is a holiday

import pandas as pd

date = pd.to_datetime('2025-01-01')
print(date in my_holidays)  # True

-----------------------------------------------------------------------------------

# National holiday calendars (like US, India)

import pandas as pd

import holidays

indian_holidays = holidays.India(years=2025)

'2025-01-26' in indian_holidays   # True (Republic Day)
indian_holidays['2025-10-02']     # "Mahatma Gandhi Jayanti"

-----------------------------------------------------------------------------------

# Apply holiday logic in your DataFrame
import pandas as pd

df['Date'] = pd.to_datetime(df['Date'])
df['IsHoliday'] = df['Date'].isin(indian_holidays)
df[df['IsHoliday']]  # filter holidays

-----------------------------------------------------------------------------------

# Business Calendar (Excludes Weekends & Holidays)
import pandas as pd
from pandas.tseries.offsets import CustomBusinessDay

my_holidays = pd.to_datetime([
    '2025-01-01',  # New Year
    '2025-01-26',  # Republic Day
    '2025-03-14',  # Holi
    '2025-08-15',  # Independence Day
    '2025-10-02',  # Gandhi Jayanti
    '2025-10-24',  # Diwali
    '2025-12-25'   # Christmas
])

# Create a frequency object that excludes weekends and holidays
my_bday = CustomBusinessDay(holidays=my_holidays)

# Generate all business days in April 2025
calendar = pd.date_range(start='2025-04-01', end='2025-04-30', freq=my_bday)
print(calendar)

# Create empty DataFrame with business calendar as index
df = pd.DataFrame(index=calendar)
df['Work'] = 'Scheduled'

print(df.head())

# use it in time series

df = pd.DataFrame({'Sales': [100]*10}, index=pd.date_range('2025-04-01', periods=10, freq=my_bday))

df['NextWorkDay'] = df.index + my_bday


-----------------------------------------------------------------------------------
import pandas as pd
import holidays

indian_holidays = holidays.India(years=2025)
auto_holidays = pd.to_datetime(list(indian_holidays.keys()))

my_bday = CustomBusinessDay(holidays=auto_holidays)

-----------------------------------------------------------------------------------

# Localize naive timestamps (tz_localize)

import pandas as pd

# Naive datetime
df = pd.DataFrame({
    'Time': pd.date_range('2025-06-29 10:00', periods=3, freq='H')
})

# Localize to IST (Asia/Kolkata)
df['Time_IST'] = df['Time'].dt.tz_localize('Asia/Kolkata')
print(df)

-----------------------------------------------------------------------------------

# Convert to another timezone (tz_convert)

import pandas as pd

# Naive datetime
df = pd.DataFrame({
    'Time': pd.date_range('2025-06-29 10:00', periods=3, freq='H')
})

# Localize to IST (Asia/Kolkata)
df['Time_IST'] = df['Time'].dt.tz_localize('Asia/Kolkata')
print(df)

df['Time_UTC'] = df['Time_IST'].dt.tz_convert('UTC')

# or another region

df['Time_US'] = df['Time_IST'].dt.tz_convert('America/New_York')

-----------------------------------------------------------------------------------

# DatetimeIndex with timezone

import pandas as pd

idx = pd.date_range('2025-06-29', periods=3, freq='H', tz='Asia/Kolkata')
df = pd.DataFrame({'Event': ['Start', 'Mid', 'End']}, index=idx)

-----------------------------------------------------------------------------------

# Check or remove timezones

import pandas as pd

# Naive datetime
df = pd.DataFrame({
    'Time': pd.date_range('2025-06-29 10:00', periods=3, freq='H')
})

# Localize to IST (Asia/Kolkata)
df['Time_IST'] = df['Time'].dt.tz_localize('Asia/Kolkata')

# Check timezone
df['Time_IST'].dt.tz

# Remove timezone (make it naive again)
df['Time_Naive'] = df['Time_IST'].dt.tz_localize(None)

-----------------------------------------------------------------------------------

# List all valid timezones

import pandas as pd
import pytz

for tz in pytz.all_timezones[:5]:
    print(tz)

-----------------------------------------------------------------------------------

# Using Python's datetime.now() with timezone

from datetime import datetime
import pytz

# Set local timezone (e.g., Asia/Kolkata)
local_tz = pytz.timezone('Asia/Kolkata')

# Get current time in that zone
now_local = datetime.now(local_tz)
print(now_local)

-----------------------------------------------------------------------------------

# Using Pandas with timezone-aware timestamp

import pandas as pd

now_local = pd.Timestamp.now(tz='Asia/Kolkata')
print(now_local)

-----------------------------------------------------------------------------------

# Compare with UTC

now_utc = pd.Timestamp.utcnow().tz_localize('UTC')
now_in_ist = now_utc.tz_convert('Asia/Kolkata')

print("UTC:", now_utc)
print("IST:", now_in_ist)

-----------------------------------------------------------------------------------

# Automatically detect system local timezone

from datetime import datetime
from zoneinfo import ZoneInfo

# Automatically detect system time zone (if supported)
dt = datetime.now().astimezone()
print(dt)

-----------------------------------------------------------------------------------

# Lag using shift(1)

import pandas as pd

df = pd.DataFrame({
    'Date': pd.date_range('2025-06-25', periods=5, freq='D'),
    'Runs': [100, 120, 80, 150, 90]
})
df.set_index('Date', inplace=True)

df['Prev_Runs'] = df['Runs'].shift(1)

-----------------------------------------------------------------------------------

# Lead using shift(-1)

import pandas as pd

df = pd.DataFrame({
    'Date': pd.date_range('2025-06-25', periods=5, freq='D'),
    'Runs': [100, 120, 80, 150, 90]
})
df.set_index('Date', inplace=True)

df['Next_Runs'] = df['Runs'].shift(-1)

-----------------------------------------------------------------------------------

# Running delta / comparison

import pandas as pd

df = pd.DataFrame({
    'Date': pd.date_range('2025-06-25', periods=5, freq='D'),
    'Runs': [100, 120, 80, 150, 90]
})
df.set_index('Date', inplace=True)

df['Change'] = df['Runs'] - df['Prev_Runs']

-----------------------------------------------------------------------------------

# Time-based shift (using freq)

import pandas as pd

df = pd.DataFrame({
    'Date': pd.date_range('2025-06-25', periods=5, freq='D'),
    'Runs': [100, 120, 80, 150, 90]
})
df.set_index('Date', inplace=True)

df_shifted = df.shift(1, freq='D')  # shift index by 1 day


----------------------------------------------------------------------------------

# Lag across groups (groupby + shift)

df = pd.DataFrame({
    'Player': ['Sachin']*3 + ['Dravid']*3,
    'Date': pd.date_range('2025-06-25', periods=3).tolist() * 2,
    'Runs': [100, 120, 130, 80, 70, 95]
})

df['Prev_Runs'] = df.groupby('Player')['Runs'].shift(1)



















