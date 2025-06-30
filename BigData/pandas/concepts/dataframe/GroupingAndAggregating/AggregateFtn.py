# Aggregate with groupby() + single function

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Sachin', 'Afridi'],
    'Runs': [12000, 10000, 8500, 5000, 6000]
})

df_new = df.groupby('Team')['Runs'].sum()

print(df_new)

-----------------------------------------------------------------------------------

# Multiple aggregations with agg()

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Sachin', 'Afridi'],
    'Runs': [12000, 10000, 8500, 5000, 6000]
})

df_new = df.groupby('Team')['Runs'].agg(['sum', 'mean', 'max'])

print(df_new)

-----------------------------------------------------------------------------------

# Aggregations on multiple columns

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Sachin', 'Afridi'],
    'Runs': [12000, 10000, 8500, 5000, 6000]
})

df_new = df.groupby('Team').agg({
    'Runs': ['sum', 'mean'],
    'Player': 'count'
})

print(df_new)

-----------------------------------------------------------------------------------

# Apply different aggregations to different columns

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Sachin', 'Afridi'],
    'Runs': [12000, 10000, 8500, 5000, 6000]
})

df_new = df.agg({
    'Runs': ['min', 'max'],
    'Team': 'nunique'
})

print(df_new)

-----------------------------------------------------------------------------------

# Aggregate without grouping (whole column)

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Sachin', 'Afridi'],
    'Runs': [12000, 10000, 8500, 5000, 6000]
})

df['Runs'].sum()      # Total runs
df['Runs'].mean()     # Average
df['Player'].count()  # Count of non-null names

-----------------------------------------------------------------------------------

# Custom Aggregation Function

import pandas as pd

df = pd.DataFrame({
    'Match': [1, 2, 3, 4, 5],
    'Runs': [50, 80, 120, 60, 90]
})

def runs_range(x):
    return x.max() - x.min()

df_new = df['Runs'].agg(runs_range)

# or

df_new = df.groupby('Match')['Runs'].agg(runs_range)

print(df_new)

-----------------------------------------------------------------------------------

# Cumulative Aggregations (cumsum, cummax, etc.)

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Sachin', 'Afridi'],
    'Runs': [12000, 10000, 8500, 5000, 6000]
})

df_new = df['CumulativeRuns'] = df['Runs'].cumsum()
df_new1 = df['MaxSoFar'] = df['Runs'].cummax()

print(df_new)
print(df_new1)

-----------------------------------------------------------------------------------

# Using .transform() in groupby (row-wise aggregation)

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Sachin', 'Afridi'],
    'Runs': [12000, 10000, 8500, 5000, 6000]
})

df['AvgRunsPerGroup'] = df.groupby('Match')['Runs'].transform('mean')

print(df_new)

-----------------------------------------------------------------------------------

# Simple .apply() on group

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Afridi', 'Sanga'],
    'Runs': [12000, 10000, 8500, 7000, 11000]
})

def average_plus_bonus(group):
    avg = group['Runs'].mean()
    group['Bonus'] = avg * 0.1
    return group

df_grouped = df.groupby('Team').apply(average_plus_bonus)

print(df_grouped)

-----------------------------------------------------------------------------------

# Use .apply() to return a summary row per group

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Sehwag', 'Sachin', 'Afridi'],
    'Runs': [12000, 10000, 8500, 5000, 6000]
})

def group_summary(group):
    return pd.Series({
        'TotalRuns': group['Runs'].sum(),
        'AverageRuns': group['Runs'].mean(),
        'MaxRunGetter': group.loc[group['Runs'].idxmax(), 'Player']
    })

summary = df.groupby('Team').apply(group_summary)

print(summary)

-----------------------------------------------------------------------------------

# Use lambda inside groupby().apply()

import pandas as pd

df = pd.DataFrame({
    'Team': ['India', 'India', 'Asia XI', 'Asia XI'],
    'Player': ['Sachin', 'Dravid', 'Afridi', 'Sanga'],
    'Runs': [12000, 10000, 7000, 11000]
})

# Compute % of team total runs for each player

df['Run%'] = df.groupby('Team')['Runs'].apply(lambda x: x / x.sum() * 100)

print(df_new)

-----------------------------------------------------------------------------------

# describe - quick statistical summary

import pandas as pd

df = pd.DataFrame({
    'Player': ['Sachin', 'Dravid', 'Sehwag'],
    'Runs': [12000, 10000, 8500],
    'Matches': [300, 250, 240]
})

summary = df.describe()
print(summary)

